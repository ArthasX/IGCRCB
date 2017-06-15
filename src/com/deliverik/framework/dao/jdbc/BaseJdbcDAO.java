package com.deliverik.framework.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.deliverik.framework.utility.ResourceUtility;

public class BaseJdbcDAO extends AbstractJdbcDao {

	private static String db_url, db_password, db_userid, db_driver;
	
	public static final String JDBC_DAO_DB_URL = "JDBC_DAO_DB_URL";
	public static final String JDBC_DAO_DB_PASSWD = "JDBC_DAO_DB_PASSWD";
	public static final String JDBC_DAO_DB_UID = "JDBC_DAO_DB_UID";
	public static final String JDBC_DAO_DB_DRIVER = "JDBC_DAO_DB_DRIVER";

	protected Connection getConnection() throws DataAccessException {

		if (db_url == null) {
			db_url = ResourceUtility.getString(JDBC_DAO_DB_URL);
			db_userid = ResourceUtility.getString(JDBC_DAO_DB_UID);
			db_password = ResourceUtility.getString(JDBC_DAO_DB_PASSWD);
			db_driver = ResourceUtility.getString(JDBC_DAO_DB_DRIVER);
		}
		if((db_url==null)||(db_password==null)||(db_userid==null)||(db_driver==null))
			throw new DataAccessException("Illegal configuration of JDBC DAO.");
		
		try {
			Class.forName(db_driver);
			conn = DriverManager.getConnection(db_url, db_userid, db_password);
		} catch (ClassNotFoundException ex) {
			throw new DataAccessException(ex);
		} catch (SQLException sqle) {
			throw new DataAccessException(sqle);
		}
		
		return conn;
	}
	
	protected String trim(String str) {
		if (str != null && !str.equals("")) {
			return str.trim();
		}
		return null;
	}

}
