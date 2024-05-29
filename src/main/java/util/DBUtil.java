package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class DBUtil {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	public DBUtil() {
		getConnection();
	}
	
	private Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "hr");
			LOGGER.info("DB Connected...");
		} catch (SQLException e) {
			LOGGER.info("DB Connection cannot established");
		}
		return connection;
	}
	
	public void executeQuery(String query) {
		try {
			statement = connection.createStatement();
			statement.execute(query);
		}catch (SQLException e) {
			LOGGER.info("Statement Cannot Created");
		}
	}
	
	public ResultSet getResultSet() {
		try {
			resultSet = statement.getResultSet();
		} catch (SQLException e) {
			LOGGER.info("Result Set cannot parsed");
		}
		return resultSet;
	}
	
	public ResultSetMetaData getMetaData(ResultSet resultSet) {
		ResultSetMetaData resultSetMetaData = null;
		try {
			resultSetMetaData = resultSet.getMetaData();
		}catch (SQLException e) {
			LOGGER.info("Meta Data Cannot Parsed");
		}
		return resultSetMetaData;
	}
}
