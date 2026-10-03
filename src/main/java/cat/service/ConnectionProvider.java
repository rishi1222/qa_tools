package cat.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import oracle.jdbc.pool.OracleDataSource;


import java.sql.*;

/**
 * Created by kaporis on 26/02/2018.
 */
public class ConnectionProvider {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionProvider.class);


    private Connection conn;
    private String dbhost;
    private String dbport;
    private String database;
    private String username;
    private String password;
    private String tns;

    public ConnectionProvider(String host, String port, String db, String user, String pw) throws Exception {
        dbhost = host;
        database = db;
        username = user;
        password = pw;
        dbport = port;
    }

    public ConnectionProvider(String tnsname, String user, String pw, String tnsnameFile) throws Exception {
        tns = tnsname;
        username = user;
        password = pw;

        System.setProperty("oracle.net.tns_admin", tnsnameFile);
    }

    public Connection connect() throws Exception {
        // Get connection
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String l_url = "jdbc:oracle:thin:@" + dbhost + ":" + dbport + ":" + database;
        System.out.println(l_url);
        conn = DriverManager.getConnection("jdbc:oracle:thin:@//" + dbhost + ":" + dbport + "/" + database, username, password);
        conn.setAutoCommit(true);
        return conn;
    }

    public Connection connect(String tnsname) throws Exception {
        // Get connection
        //LOGGER.info("jdbc:oracle:thin:@" + dbhost + ":" + dbport + ":" + database + " User=>" + username + " PW => " + password);
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        String l_url = "jdbc:oracle:thin:@//" + dbhost + ":" + dbport + "/" + database;
        System.out.println(l_url);
        OracleDataSource ods = new OracleDataSource();
        ods.setUser(username);
        ods.setPassword(password);
        ods.setURL(l_url);

        conn = ods.getConnection();
        conn.setAutoCommit(true);
        return conn;
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to close connection", e);
        }
    }

}