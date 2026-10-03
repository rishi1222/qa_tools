package cat.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kaporis on 26/02/2018.
 */
public class ExecuteSqlQueries extends PageObjectBaseClass {

    public ExecuteSqlQueries(WebDriver driver) {
        super(driver);
    }
    /*
    To setup cases in different cases
    SELECT * FROM CAT_CASE_VISIBILITY;
    SELECT * FROM CAT_CASE_COMMENTS WHERE CASE_ID = 'AutoQA-case-0015';
    UPDATE CAT_CASES SET STATE_ID = 9 WHERE CASE_ID ='AutoQA-case-0001';
    INSERT INTO CAT_CASE_VISIBILITY VALUES ('AutoQA-case-0001',4,7599,1);
     */

//    public ExecuteSqlQueries(WebDriver driver) {
//        super(driver);
//    }

    private static final Logger LOGGER = LogManager.getLogger(ExecuteSqlQueries.class);

    private static String caseId;
    private static String sql = "Select * FROM SLDT_OWNER.CAT_ACCESS";

    public static void setCaseToInitialState(Connection conn, String testCase) throws Exception {
        getAllResultsFromTable(conn, testCase);
    }

    public static void setCaseId(String caseId) {
        ExecuteSqlQueries.caseId = caseId;
    }

    private static String getCaseId() {
        return caseId;
    }

    public static void deleteFromTablesToSetInitialStateofCase(Connection conn, String tableName) throws SQLException {
        System.out.println(tableName);
        String sql = "SELECT * FROM SLDT_OWNER." + tableName + " WHERE CASE_ID ='" + getCaseId() + "'";


        if (!(tableName.equalsIgnoreCase("CAT_SEGMENT_USER_TAG") || tableName.equalsIgnoreCase("CAT_TRADES") || tableName.equalsIgnoreCase("CAT_SEGMENT_VISIBILITY") || tableName.equalsIgnoreCase("CAT_SEGMENT_EMAIL") || tableName.equalsIgnoreCase("CAT_ATTACHMENTS") )) {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                try {
                    LOGGER.info("Case Id '" + getCaseId() + "' exits in the table " + tableName);
                    executeDeleteRecord(conn, tableName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                LOGGER.info("Case Id " + "'" + getCaseId() + "'" + " does not exits in the table " + tableName);
            }
            preparedStatement.close();
            resultSet.close();
            conn.commit();
        } else {
            deleteForeignKeyRecord(conn, tableName);
        }

    }

    private static void executeDeleteRecord(Connection conn, String tableName) throws SQLException {

        String deleteQuery = "DELETE FROM SLDT_OWNER." + tableName + " WHERE CASE_ID =" + "'" + getCaseId() + "'";

        LOGGER.info(deleteQuery);
        PreparedStatement deleteRecord = conn.prepareStatement(deleteQuery);
        deleteRecord.executeUpdate();
        deleteRecord.close();
        conn.commit();
        LOGGER.info("Record deleted from table " + tableName);

    }

    public static void uptdateTimeStamp(Connection conn) throws SQLException {
        String updateTimeStamp = "UPDATE SLDT_OWNER.CAT_CASES SET UPDATE_TS= SYSTIMESTAMP - INTERVAL '60' DAY where CASE_ID =" + "'" + getCaseId() + "'";
        PreparedStatement updateTimeStampCase = conn.prepareStatement(updateTimeStamp);
        updateTimeStampCase.execute();
        updateTimeStampCase.close();
        conn.commit();
        LOGGER.info("Timestamp for all records updated in table CAT_CASES ");

    }

    private static void deleteForeignKeyRecord(Connection conn, String tableName) throws SQLException {

        switch (tableName) {
            case "CAT_SEGMENT_USER_TAG":
                String checkIfSegmentIDForienKeyRelationExits = "SELECT * FROM SLDT_OWNER." + tableName + " WHERE SEGMENT_ID IN (SELECT ID FROM SLDT_OWNER.CAT_SEGMENT_STATUS WHERE CASE_ID =" + "'" + getCaseId() + "')";
                String cleanSegmentUserTag = "DELETE FROM SLDT_OWNER." + tableName + " WHERE SEGMENT_ID IN (SELECT ID FROM SLDT_OWNER.CAT_SEGMENT_STATUS WHERE CASE_ID =" + "'" + getCaseId() + "')";
                PreparedStatement checkSegmentIDForeignKeyRelation = conn.prepareStatement(checkIfSegmentIDForienKeyRelationExits);
                ResultSet segmentIdresultSet = checkSegmentIDForeignKeyRelation.executeQuery();
                if (segmentIdresultSet.next()) {
                    LOGGER.info(cleanSegmentUserTag);
                    PreparedStatement deleteRecordWithForeignKeyConstraint1 = conn.prepareStatement(cleanSegmentUserTag);
                    deleteRecordWithForeignKeyConstraint1.executeUpdate();
                    conn.commit();
                    deleteRecordWithForeignKeyConstraint1.close();
                    LOGGER.info("Record with foreign key deleted from table " + tableName);
                }
                checkSegmentIDForeignKeyRelation.close();
                segmentIdresultSet.close();
                break;


            case "CAT_SEGMENT_EMAIL":
                String checkIfSegmentIDForienKeyRelation = "SELECT * FROM SLDT_OWNER." + tableName + " WHERE SEGMENT_COMMENT_ID IN (SELECT ID FROM SLDT_OWNER.CAT_SEGMENT_COMMENTS WHERE CASE_ID =" + "'" + getCaseId() + "')";
                String cleanSegmentUserEmail = "DELETE FROM SLDT_OWNER." + tableName + " WHERE SEGMENT_COMMENT_ID IN (SELECT ID FROM SLDT_OWNER.CAT_SEGMENT_COMMENTS WHERE CASE_ID =" + "'" + getCaseId() + "')";
                PreparedStatement checkSegmentIDForeignKeyEmail = conn.prepareStatement(checkIfSegmentIDForienKeyRelation);
                ResultSet segmentIdEmailResultSet = checkSegmentIDForeignKeyEmail.executeQuery();
                if (segmentIdEmailResultSet.next()) {
                    LOGGER.info(cleanSegmentUserEmail);
                    PreparedStatement deleteRecordWithForeignKeyConstraint1 = conn.prepareStatement(cleanSegmentUserEmail);
                    deleteRecordWithForeignKeyConstraint1.executeUpdate();
                    conn.commit();
                    deleteRecordWithForeignKeyConstraint1.close();
                    LOGGER.info("Record with foreign key deleted from table " + tableName);
                }
                checkSegmentIDForeignKeyEmail.close();
                segmentIdEmailResultSet.close();
                break;

            case "CAT_ATTACHMENTS":
                String checkIfCaseAttachmentKeyExits = "SELECT * FROM SLDT_OWNER." + tableName + " WHERE CASE_COMMENT_ID IN (SELECT ID FROM SLDT_OWNER.CAT_CASE_COMMENTS WHERE CASE_ID =" + "'" + getCaseId() + "')";
                String checkIfSegmentAttachmentKeyExits = "SELECT * FROM SLDT_OWNER." + tableName + " WHERE SEGMENT_COMMENT_ID IN (SELECT ID FROM SLDT_OWNER.CAT_SEGMENT_COMMENTS WHERE CASE_ID =" + "'" + getCaseId() + "')";
                String cleanCaseAttachment = "DELETE FROM SLDT_OWNER." + tableName + " WHERE CASE_COMMENT_ID IN (SELECT ID FROM SLDT_OWNER.CAT_CASE_COMMENTS WHERE CASE_ID =" + "'" + getCaseId() + "')";
                String cleanSegmentAttachment = "DELETE FROM SLDT_OWNER." + tableName + " WHERE SEGMENT_COMMENT_ID IN (SELECT ID FROM SLDT_OWNER.CAT_SEGMENT_COMMENTS WHERE CASE_ID =" + "'" + getCaseId() + "')";
                PreparedStatement checkIfCaseAttachmentKey = conn.prepareStatement(checkIfCaseAttachmentKeyExits);
                ResultSet attchmentKeyResultSet = checkIfCaseAttachmentKey.executeQuery();
                PreparedStatement checkIfSegmentAttachmentKey = conn.prepareStatement(checkIfSegmentAttachmentKeyExits);
                ResultSet attchmentSegmentKeyResultSet = checkIfSegmentAttachmentKey.executeQuery();
                if (attchmentKeyResultSet.next() ) {
                    LOGGER.info(cleanCaseAttachment);
                    PreparedStatement deleteRecordWithForeignKeyConstraint1 = conn.prepareStatement(cleanCaseAttachment);
                    deleteRecordWithForeignKeyConstraint1.executeUpdate();
                    conn.commit();
                    deleteRecordWithForeignKeyConstraint1.close();
                    LOGGER.info("Record with foreign key deleted from table " + tableName);
                } else if (attchmentSegmentKeyResultSet.next()){
                LOGGER.info(cleanSegmentAttachment);
                PreparedStatement deleteRecordWithForeignKeyConstraint1 = conn.prepareStatement(cleanSegmentAttachment);
                deleteRecordWithForeignKeyConstraint1.executeUpdate();
                conn.commit();
                deleteRecordWithForeignKeyConstraint1.close();
                LOGGER.info("Record with foreign key deleted from table " + tableName);
            }
                checkIfCaseAttachmentKey.close();
                checkIfCaseAttachmentKey.close();
                break;

            case "CAT_SEGMENT_VISIBILITY":
                String checkICaseIDfForeinKeyRelationExits = "SELECT * FROM SLDT_OWNER." + tableName + " WHERE SEGMENT_ID IN (SELECT ID FROM SLDT_OWNER. CAT_SEGMENT_STATUS WHERE CASE_ID =" + "'" + getCaseId() + "')";
                String cleanCaseVisibility = "DELETE FROM SLDT_OWNER." + tableName + " WHERE SEGMENT_ID IN (SELECT ID FROM SLDT_OWNER. CAT_SEGMENT_STATUS WHERE CASE_ID =" + "'" + getCaseId() + "')";;
                PreparedStatement checkCaseIDForeignKeyRelation = conn.prepareStatement(checkICaseIDfForeinKeyRelationExits);
                ResultSet caseIDresultSet = checkCaseIDForeignKeyRelation.executeQuery();
                if (caseIDresultSet.next()) {
                    LOGGER.info(cleanCaseVisibility);
                    PreparedStatement deleteRecordWithForeignKeyConstraint = conn.prepareStatement(cleanCaseVisibility);
                    deleteRecordWithForeignKeyConstraint.executeUpdate();
                    conn.commit();
                    deleteRecordWithForeignKeyConstraint.close();
                    LOGGER.info("Record with foreign key deleted from table " + tableName);
                }
                checkCaseIDForeignKeyRelation.close();
                caseIDresultSet.close();
                break;
            case "CAT_TRADES":
                String checkIfSegmentIDExits = "SELECT * FROM SLDT_OWNER.CAT_TRADES  WHERE CASE_ID ='" + getCaseId() + "'" + "AND SEGMENT_ID IS NOT NULL";
                String setSegmentIdToNull = "UPDATE SLDT_OWNER.CAT_TRADES SET SEGMENT_ID = NULL WHERE CASE_ID ='" + getCaseId() + "'";
                PreparedStatement checkForSegmentID = conn.prepareStatement(checkIfSegmentIDExits);
                ResultSet segmentIdNotNull = checkForSegmentID.executeQuery();
                if (segmentIdNotNull.next()) {
                    LOGGER.info(setSegmentIdToNull);
                    PreparedStatement setSegmentIdToNullForeignKeyConstraint = conn.prepareStatement(setSegmentIdToNull);
                    setSegmentIdToNullForeignKeyConstraint.executeUpdate();
                    conn.commit();
                    setSegmentIdToNullForeignKeyConstraint.close();
                    LOGGER.info("Record with foreign key deleted from table " + tableName);
                }

        }


    }

    public static void resetCaseStatus(Connection conn) throws SQLException {
        String resetCaseState = "UPDATE SLDT_OWNER.CAT_CASES SET STATE_ID = 1, IS_CRITICAL = NULL WHERE CASE_ID =" + "'" + getCaseId() + "'";
        PreparedStatement resetCaseStatus = conn.prepareStatement(resetCaseState);
        resetCaseStatus.execute();
        resetCaseStatus.close();
        conn.commit();
    }

    public static void setCaseStatusToSegmentPreparation(Connection conn, String caseId) throws SQLException {
        String resetCaseState = "UPDATE SLDT_OWNER.CAT_CASES SET STATE_ID = 1, IS_CRITICAL = NULL WHERE CASE_ID =" + "'" + caseId + "'";
        PreparedStatement resetCaseStatus = conn.prepareStatement(resetCaseState);
        resetCaseStatus.execute();
        resetCaseStatus.close();
        conn.commit();
    }


    private static void getAllResultsFromTable(Connection conn, String testCase) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        iterateRecordsReturnedInResultSet(resultSet);
    }

    private static void iterateRecordsReturnedInResultSet(ResultSet resultset) throws SQLException {
        while (resultset.next()) {
            System.out.println(resultset.getString(1));
        }
    }

    public static String checkCaseStatus(String caseId, Connection conn) throws SQLException {
        String getCurrentCaseStatus = "SELECT STATE_ID FROM SLDT_OWNER.CAT_CASES WHERE CASE_ID =" + "'" + caseId + "'";
        PreparedStatement getCurrentCaseStatusId = conn.prepareStatement(getCurrentCaseStatus);
        ResultSet resultSet = getCurrentCaseStatusId.executeQuery();
        String status_id = null;
        while (resultSet.next()) {
            status_id = resultSet.getString("STATE_ID");
        }
        getCurrentCaseStatusId.close();
        return status_id;
    }

    public static String checkSegmentStatus(String caseId, Connection conn) throws SQLException {
        String getCurrentCaseStatus = "SELECT STATE_ID FROM SLDT_OWNER.CAT_SEGMENT_STATUS WHERE CASE_ID =" + "'" + caseId + "'";
        PreparedStatement getCurrentCaseStatusId = conn.prepareStatement(getCurrentCaseStatus);
        ResultSet resultSet = getCurrentCaseStatusId.executeQuery();
        String status_id = null;
        while (resultSet.next()) {
            status_id = resultSet.getString("STATE_ID");
        }
        getCurrentCaseStatusId.close();
        return status_id;
    }

    public static String getCaseNameWithSegmentId(String caseId, Connection conn) throws SQLException {
        String getCurrentCaseStatus = "SELECT ID FROM SLDT_OWNER.CAT_SEGMENT_STATUS WHERE CASE_ID like" + "'%" + caseId + "%'";
        PreparedStatement getCurrentCaseStatusId = conn.prepareStatement(getCurrentCaseStatus);
        ResultSet resultSet = getCurrentCaseStatusId.executeQuery();
        String segment_id = null;
        while (resultSet.next()) {
            segment_id = resultSet.getString("ID");
        }
        getCurrentCaseStatusId.close();
        return caseId + "-" + segment_id;
    }
}
