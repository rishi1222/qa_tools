package cat.page;

import cat.pageobject.Dashboard;
import cat.pageobject.ExecuteSqlQueries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kaporis on 14/03/2018.
 */
public class ResetCaseState extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(ResetCaseState.class);


    public void setValueofCaseId(String caseId) {
        ExecuteSqlQueries.setCaseId(caseId);
        LOGGER.info("Set the value of case ID");
    }

    public void setStateofGivenCaseId(List<List<String>> tableNames) {
        Connection conn = null;
        LOGGER.info("Delete the Case ID  form Tables " + tableNames);
        try {
            for (List<String> tableName : tableNames) {


                if (conn == null) {
                    conn = dbConnect();
                }
                ExecuteSqlQueries.deleteFromTablesToSetInitialStateofCase(conn, tableName.get(0));
            }

            ExecuteSqlQueries.resetCaseStatus(conn);
            ExecuteSqlQueries.uptdateTimeStamp(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        close();
    }


    public void refreshTheDatabase(List<List<String>> tableNames) {
        Connection conn = null;
        LOGGER.info("Delete the Case ID  form Tables " + tableNames);
        try {
            for (List<String> tableName : tableNames) {


                if (conn == null) {
                    conn = dbConnect();
                }
                ExecuteSqlQueries.deleteFromTablesToSetInitialStateofCase(conn, tableName.get(0));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        close();

    }


    public void setsTheStateOfCaseToSegmentPreparationState(String caseId) {
        Connection conn = null;
        try {
            if (conn == null) {
                conn = dbConnect();
            }
            ExecuteSqlQueries.setCaseStatusToSegmentPreparation(conn, caseId);
            ExecuteSqlQueries.uptdateTimeStamp(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //driver.navigate().refresh();
        close();
    }


    public void checkCaseAndSegmentStatus(String caseId, String caseStatus, String segmentStatus) {
        untilJqueryIsDone();
        Connection conn = null;
        try {
            if (conn == null) {

                conn = dbConnect();
            }
            String status_id = ExecuteSqlQueries.checkCaseStatus(caseId, conn);
            found(status_id, caseStatus);
            String segment_status_id = ExecuteSqlQueries.checkSegmentStatus(caseId, conn);
            found(segment_status_id, segmentStatus);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        close();
    }
}
