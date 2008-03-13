package net.dromard.movies.util;

import java.util.Properties;

import net.dromard.common.jdbc.DBManager;

/**
 * Class to access to database of type HSQL DB or Oracle accordingly to the specified jdbc driver.<br>
 */
public final class DBUtil {

    private static final String DB_LOAD_CREATE_SCHEMA = "db.load.create.schema";

	private static final String DB_LOAD_DATAS = "db.load.datas";

	/**
     * database driver class.
     */
    public static final String DRIVER_CLASS = "db.driver.classname";

    /**
     * Database URL.
     */
    public static final String URL = "db.url";

    /**
     * Database user.
     */
    public static final String USERNAME = "db.username";

    /**
     * Database user password.
     */
    public static final String PASSWORD = "db.password";

    /**
     * Prevent from instantiating this class.
     */
    private DBUtil() {
    }

    public static DBManager createDBManager() throws Exception {
    	Properties dbProp = getDBProperties();
        return new DBManager(dbProp.getProperty(DRIVER_CLASS), dbProp.getProperty(URL), dbProp.getProperty(USERNAME), dbProp.getProperty(PASSWORD));
    }
    
    /**
     * Intialize database structure and data.
     * @throws Exception sql exception throwed during initialisation of database.
     */
    public static void launch() throws Exception {
    	Properties dbProp = getDBProperties();
        DBManager dbManager = createDBManager();
        dbManager.executeQueries(getRootDir() + dbProp.getProperty(DB_LOAD_CREATE_SCHEMA), false);
        dbManager.executeQueries(getRootDir() + dbProp.getProperty(DB_LOAD_DATAS), false);
    
    }

    /**
     * @return Get the root dir of project
     */
    public static String getRootDir() {
        String rootDir = DBUtil.class.getResource(DBUtil.class.getName() + ".class").getFile();
        try {
            rootDir = java.net.URLDecoder.decode(rootDir, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootDir.substring(0, rootDir.indexOf("WEB-INF/") + 8);
    }
    
    /**
     * Load the database property file.
     * @return the database properties
     * @throws Exception if there are a problem during reading of file or in SQL query
     */
     private static Properties getDBProperties() throws Exception {
        Properties prop = new Properties();
        prop.load(DBUtil.class.getResourceAsStream("/db.properties"));
        return prop;
    }
}
