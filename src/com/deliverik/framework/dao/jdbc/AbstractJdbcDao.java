package com.deliverik.framework.dao.jdbc;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractJdbcDao {
	private int fetchSize = 500;
	private int queryTimeout = 120; /* seconds */
	private boolean closeQuietly = false;
	public Connection conn;

	abstract protected Connection getConnection() throws DataAccessException;

	protected void commit() throws DataAccessException {
		try {
			conn.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new DataAccessException(sqle);
		}
	}

	protected void rollback() throws DataAccessException {
		try {
			conn.rollback();
		} catch (SQLException sqle) {
			throw new DataAccessException(sqle);
		}
	}

	protected void releaseConnection() throws DataAccessException {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException sqle) {
			throw new DataAccessException(sqle);
		}
	}

	/**
	 * 
	 * @param sql
	 * @param queryParameters
	 * @throws SQLException
	 * 
	 */
	protected int executeUpdate(String sql, Object[] queryParameters)
			throws DataAccessException {
		Connection conn = null;

		int result = -1;

		// try
		// {
		conn = getConnection();
		result = executeUpdate(conn, sql, queryParameters);
		return result;
		// }
		// catch (SQLException ex)
		// {
		// throw new DataAccessException(
		// buildMessage(sql, queryParameters),
		// ex);
		// }
		// finally
		// {
		// close(conn, null, null);
		// }
	}

	/**
	 * 
	 * @param conn
	 * @param sql
	 * @param queryParameters
	 * @throws SQLException
	 * 
	 */
	protected int executeUpdate(Connection conn, String sql,
			Object[] queryParameters) throws DataAccessException {
		PreparedStatement ps = null;
		Statement stmt = null;

		int result = -1;

		try {
			// conn = getConnection();
			if (queryParameters == null) {
				stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);
			} else {
				ps = conn.prepareStatement(sql);
				setParameters(ps, queryParameters);
				result = ps.executeUpdate();
			}
			return result;
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DataAccessException(buildMessage(sql, queryParameters),
					ex);
		} finally {
			close(null, null, ps);
			close(null, null, stmt);
		}
	}

	protected int executeNotAutoCommit(String sql, Object[] queryParameters)
			throws DataAccessException {

		conn = getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DataAccessException(buildMessage(sql, queryParameters), e);
		}
		return executeUpdate(conn, sql, queryParameters);
	}

	/**
	 * 
	 * @param sql
	 * @param queryParameters
	 * @throws SQLException
	 * 
	 */
	protected int executeUpdateCallable(String sql, Object[] queryParameters)
			throws DataAccessException {
		Connection conn = null;
		CallableStatement cs = null;

		int result = -1;

		try {
			conn = getConnection();
			cs = conn.prepareCall(sql);
			setParameters(cs, queryParameters);
			result = cs.executeUpdate();
			return result;
		} catch (SQLException ex) {
			throw new DataAccessException(buildMessage(sql, queryParameters),
					ex);
		} finally {
			close(conn, null, null);
		}
	}

	/**
	 * 
	 * @param sql
	 * @param queryParameters
	 * @return a List containing zero or more {@link Row} objects
	 * 
	 */
	protected List<Row> executeQuery(String sql, Object[] queryParameters)
			throws DataAccessException {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		Connection conn = null;
		List<Row> rows = null;

		try {
			conn = getConnection();
			if (queryParameters == null) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
			} else {
				ps = conn.prepareStatement(sql);
				setParameters(ps, queryParameters);
				ps.setFetchDirection(ResultSet.FETCH_FORWARD);
				ps.setFetchSize(this.getFetchSize());
				ps.setQueryTimeout(this.getQueryTimeout());
				rs = ps.executeQuery();
			}

			rows = buildRows(rs);
			return rows;
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new DataAccessException(buildMessage(sql, queryParameters),
					ex);
		} finally {
			close(conn, rs, ps);
			close(conn, rs, stmt);
		}

	}

	protected int getFetchSize() {
		return fetchSize;
	}

	protected void setFetchSize(int size) {
		this.fetchSize = size;
	}

	protected List<Row> buildRows(ResultSet rs) throws SQLException {
		List<Row> rows = new LinkedList<Row>();

		while (rs.next()) {
			Row r = buildSingleRow(rs);
			rows.add(r);
		}

		return rows;
	}

	@SuppressWarnings("unchecked")
	protected Row buildSingleRow(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();

		int colCount = metaData.getColumnCount();
		IndexedMap map = new IndexedMapImpl(colCount);
		for (int colIndex = 1; colIndex < colCount; colIndex++) {
			String colName = metaData.getColumnName(colIndex).toUpperCase();
			// int colType =
			metaData.getColumnType(colIndex);
			Object colValue = rs.getObject(colIndex);
			map.put(colName, colValue);
		}
		return new Row(map);
	}

	protected boolean getCloseQuietly() {
		return closeQuietly;
	}

	protected void setCloseQuietly(boolean b) {
		closeQuietly = b;
	}

	protected void close(Connection c, ResultSet rs, Statement st)
			throws DataAccessException {
		Exception caught = null;

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ex) {
			caught = ex;
		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception ex) {
			caught = ex;
		}
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception ex) {
			caught = ex;
		}

		if ((!getCloseQuietly()) && (caught != null)) {
			throw new DataAccessException(caught);
		}
	}

	protected void setParameters(PreparedStatement ps, Object[] parameters)
			throws SQLException {
		for (int i = 0; i < parameters.length; i++) {
			int parameterIndex = i + 1;
			Object param = parameters[i];
			if (param == null) {
				ps.setString(parameterIndex, "");
				// throw new NullPointerException("parameters[" + i +
				// "] is null");
			} else if (param instanceof java.sql.Date) {
				java.sql.Date value = (java.sql.Date) param;
				ps.setDate(parameterIndex, value);

			} else if (param instanceof java.util.Date) {
				long time = ((java.util.Date) param).getTime();
				java.sql.Date value = new java.sql.Date(time);
				ps.setDate(parameterIndex, value);
			} else if (param instanceof java.util.Calendar) {
				Calendar c = (Calendar) param;
				java.sql.Date d = new java.sql.Date(c.getTime().getTime());
				ps.setDate(parameterIndex, d, c);
			} else if (param instanceof String) {
				ps.setString(parameterIndex, (String) param);
			} else if (param instanceof CharSequence) {
				String value = param.toString();
				ps.setString(parameterIndex, value);
			} else if (param instanceof char[]) {
				String value = new String((char[]) param);
				ps.setString(parameterIndex, value);
			} else if (param instanceof Character) {
				ps.setString(parameterIndex, String.valueOf(param));
			}
			// else if (param instanceof Enum)
			// {
			// Enum e = (Enum) param;
			// int value = e.ordinal();
			// ps.setInt(parameterIndex, value);
			// }
			else if (param instanceof Integer) {
				int value = ((Integer) param).intValue();
				ps.setInt(parameterIndex, value);
			} else if (param instanceof Short) {
				short value = ((Short) param).shortValue();
				ps.setShort(parameterIndex, value);
			} else if (param instanceof Long) {
				long value = ((Integer) param).longValue();
				ps.setLong(parameterIndex, value);
			} else if (param instanceof BigDecimal) {
				BigDecimal value = (BigDecimal) param;
				ps.setBigDecimal(parameterIndex, value);
			} else if (param instanceof java.sql.Ref) {
				Ref value = (Ref) param;
				ps.setRef(i, value);
			} else if (param instanceof Double) {
				double value = ((Double) param).doubleValue();
				ps.setDouble(parameterIndex, value);
			} else if (param instanceof Float) {
				float value = ((Float) param).floatValue();
				ps.setFloat(parameterIndex, value);
			} else if (param instanceof Boolean) {
				boolean value = ((Boolean) param).booleanValue();
				ps.setBoolean(parameterIndex, value);
			} else if (param instanceof java.sql.Array) {
				ps.setArray(parameterIndex, (java.sql.Array) param);
			} else if (param instanceof java.sql.Time) {
				ps.setTime(parameterIndex, (java.sql.Time) param);
			} else if (param instanceof java.sql.Timestamp) {
				ps.setTimestamp(parameterIndex, (java.sql.Timestamp) param);
			} else if (param instanceof java.net.URL) {
				// ps.setURL(parameterIndex, (java.net.URL) param);
				ps.setObject(parameterIndex, (java.net.URL) param);
			} else if (param instanceof byte[]) {
				ps.setBytes(parameterIndex, (byte[]) param);
			} else if (param instanceof Clob) {
				ps.setClob(parameterIndex, (Clob) param);
			} else if (param instanceof Byte) {
				byte value = ((Byte) param).byteValue();
				ps.setByte(parameterIndex, value);
			} else {
				throw new IllegalArgumentException(
						"unexpected parameter type: " + param.getClass());
			}
		}
	}

	protected String buildMessage(String sql, Object[] queryParameters) {
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		if (queryParameters.length > 0) {
			sb.append(",");
			for (int i = 0; i < queryParameters.length; i++) {
				Object o = queryParameters[i];
				sb.append(" [");
				sb.append(o);
				sb.append("] ");
			}
		}
		return sb.toString();
	}

	protected int getQueryTimeout() {
		return queryTimeout;
	}

	protected void setQueryTimeout(int value) {
		queryTimeout = value;
	}

	public String toString() {
		return "QueryTimeout=" + getQueryTimeout() + ",FetchSize="
				+ getFetchSize();
	}
}
