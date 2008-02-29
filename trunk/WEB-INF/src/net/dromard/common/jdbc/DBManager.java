package net.dromard.common.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBManager {
	private DriverManagerDataSource dataSource;
    private Connection jdbcConnection;
    private Statement statement;
    
    public DBManager(String jdbcDriver, String databaseUrl, String databaseUsername, String databasePassword) throws Exception {
		dataSource = new DriverManagerDataSource(jdbcDriver, databaseUrl, databaseUsername, databasePassword);
	}
	 
    private Statement getStatement() throws Exception {
    	if (jdbcConnection != null && statement != null) {
    		commitAndClose();
    	}
    	if (jdbcConnection == null) {
    		jdbcConnection = dataSource.getConnection();
    	}
    	statement = jdbcConnection.createStatement(); 
        return statement;
    }

    public void commitAndClose() throws Exception {
    	try {
        	jdbcConnection.commit();
            jdbcConnection.close();
    	} finally {
    		jdbcConnection = null;
    		statement = null;
    	}
    }

    public void rollbackAndClose() throws Exception {
    	try {
        	jdbcConnection.rollback();
            jdbcConnection.close();
    	} finally {
    		jdbcConnection = null;
    	}
    }

    /**
     * Execute a SQL Update.
     * @param query SQL query to run in DataBase
     * @return First Object of result.
     * @throws Exception if there are a problem during reading of file or in SQL query
     */
    public int executeUpdate(final String query) throws Exception {
        Statement stmt = getStatement();
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(query);
            rollbackAndClose();
            throw ex;
        }
    }

    /**
     * Execute a SQL query and return first object (ie SELECT COUNT).
     * @param query SQL query to run in DataBase
     * @return First Object of result.
     * @throws Exception if there are a problem during reading of file or in SQL query
     */
    public Object executeScalar(final String query) throws Exception {
        Object retval = null;

        // Attempt to recognize the date to format them to DB specific needs
        String computedQuery = null;

        Statement stmt = getStatement();
        ResultSet result;
        try {
            result = stmt.executeQuery(computedQuery);
            
            if (result != null && result.next()) {
            	retval = result.getObject(1);
            }
            commitAndClose();
            return retval;
        } catch (SQLException ex) {
            System.out.println(computedQuery);
            rollbackAndClose();
            throw ex;
        }
    }

    /**
     * Execute a SQL query.
     * @param query SQL query to run in DataBase.
     * @throws Exception if there are a problem during reading of file or in SQL query
     */
    public ResultSet executeQuery(final String query) throws Exception {
        Statement stmt = getStatement();
        try {
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(query);
            rollbackAndClose();
            throw ex;
        }
    }

    public String oracleQueryParser(String query) {
        Pattern pattern = Pattern.compile("('[1-2][0-9]{3}-[0-1][0-9]-[0-3][1-9]')");
        Matcher matcher = pattern.matcher(query);
        query = matcher.replaceAll("TO_DATE($1, 'YYYY-MM-DD')");

        Pattern pattern2 = Pattern.compile("; *$");
        Matcher matcher2 = pattern2.matcher(query);
        return matcher2.replaceAll("");
    }
    
    /**
     * Execute a SQL query.
     * @param query SQL query to run in DataBase.
     * @return The query result in an ArrayList (lines) og String[] (columns).
     * @see #printQueryResult(ArrayList)
     * @throws Exception if there are a problem during reading of file or in SQL query
     */
    public List<String[]> getQueryResult(final String query) throws Exception {
        ResultSet resultset = executeQuery(query);
        List<String[]> result = new ArrayList<String[]>();

        // If there is something ...
        if (resultset.next()) {
            // Get The MetaData
            ResultSetMetaData meta = resultset.getMetaData();
            // Get column count
            int nbColumn = meta.getColumnCount();
            String[] line = new String[nbColumn];
            // Put Columns into result
            for (int col = 1; col <= nbColumn; ++col) {
                line[col - 1] = meta.getColumnName(col);
            }
            result.add(line);

            do {
                // Put result of each columns into line
                line = new String[nbColumn];
                for (int col = 1; col <= nbColumn; ++col) {
                    line[col - 1] = resultset.getString(col);
                }
                result.add(line);
            } while (resultset.next());

            return result;
        }
        return null;
    }

    /**
     * Print the result of {@link #executeSelect(String)}.
     * @param queryResult The query result
     */
    public static void printQueryResult(final List<String[]> queryResult) {
        String separator = " | ";
        for (int l = 0; l < queryResult.size(); ++l) {
            String[] columns = queryResult.get(l);
            int c = 0;
            for (; c < columns.length - 1; ++c) {
                System.out.print(columns[c] + separator);
            }
            System.out.print(columns[c]);
            System.out.print("\n");
        }
    }

    /**
     * Create database structure an populate init data.
     * @param stmt a jdbc statement to use
     * @param filePath full path of file to be run.
     * @param continueOnError   indicates without the script execution is stopped when an error occurs.
     * @throws Exception if there are a problem during reading of file or in SQL query
     */
    public void executeQueries(final String filePath, final boolean continueOnError) throws Exception {
    	Statement stmt = getStatement();
        BufferedReader fichier = null;
        String str = null;
        String query = "";
        fichier = new BufferedReader(new FileReader(filePath));

        while ((str = fichier.readLine()) != null) {
            if (!str.trim().startsWith("--")) {
                query += str;
            }
            if (query.trim().endsWith(";")) {
                try {
                    query = query.trim();
                    query = query.substring(0, query.length() - 1);
                    stmt.execute(query);
                } catch (SQLException ex) {
                    System.err.println(query);
                    System.err.println(ex.getMessage());
                    if (!continueOnError) {
                        throw ex;
                    }
                }
                query = "";
            }
        }
    }
}
