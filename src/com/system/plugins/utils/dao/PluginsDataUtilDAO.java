package com.system.plugins.utils.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

public class PluginsDataUtilDAO extends BaseHibernateDAOImpl<Object>{
	
	private Connection conn = null;
	
	private PreparedStatement pstmt = null; 
	/**
	 * 构造函数
	 */
	public PluginsDataUtilDAO(){
		super();
	}
	
	public void initConn() throws SQLException{
		conn = SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
	}

	/****
	 * 设置是否自动提交
	 * @param autoCommit
	 * @throws Exception
	 */
	public void setAutCommit(boolean autoCommit) throws Exception{
		conn.setAutoCommit(autoCommit);
	}
	
	/*****
	 * 提交
	 * @throws Exception
	 */
	public void commit() throws Exception{
		conn.commit();
	}
	
	/****
	 * 回滚数据
	 * @throws Exception
	 */
	public void rollback() throws Exception{
		conn.rollback();
	}
	
	/**
	 * 关闭数据库连接
	 * @throws SQLException
	 */
	public void close() throws SQLException{
		if(conn!=null){
			conn.close();
			conn = null;
		}
	}
	
	/***
	 * 执行SQL数据
	 * @param sql
	 * @param paramList
	 * @throws SQLException
	 */
	public void executeSQL(String sql,List<String[]> paramList,String[] columnTypes) throws SQLException{
		if(paramList==null||paramList.size()<1){
			return;
		}
		pstmt = conn.prepareStatement(sql);
		for(String[] params:paramList){
			for (int i = 0; i < params.length; i++) {
				if("INTEGER".equals(columnTypes[i])){
					pstmt.setInt(i+1,Integer.parseInt(params[i]));
				}else if("DOUBLE".equals(columnTypes[i])){
					pstmt.setDouble(i+1,Double.parseDouble(params[i]));
				}else{
					pstmt.setObject(i+1,params[i]);
				}
			}
			pstmt.addBatch(); 
		}
		pstmt.executeBatch();
		conn.commit();
		pstmt.clearBatch();
		pstmt.close();
		pstmt = null;
	}
	
	/***
	 * 执行SQL数据
	 * @param sql
	 * @param paramList
	 * @throws SQLException
	 */
	public void executeSQL(String sql,String[] values,String[] columnTypes) throws SQLException{
		if(values==null){
			return;
		}
		pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < values.length; i++) {
			if("INTEGER".equals(columnTypes[i])){
				pstmt.setInt(i+1,Integer.parseInt(values[i]));
			}else if("DOUBLE".equals(columnTypes[i])){
				pstmt.setDouble(i+1,Double.parseDouble(values[i]));
			}else{
				pstmt.setObject(i+1,values[i]);
			}
		}
		pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		pstmt = null;
	}
	
	/***
	 * 查询数据
	 * @param sql
	 * @param paramList
	 * @throws SQLException
	 */
	public int getCountData(String sql,String[] values,String[] columnTypes) throws SQLException{
		int retrunValue = 0;
		if(values==null){
			retrunValue = -1;
		}
		pstmt = conn.prepareStatement(sql);

		for (int i = 0; i < values.length; i++) {
			if("INTEGER".equals(columnTypes[i])){
				pstmt.setInt(i+1,Integer.parseInt(values[i]));
			}else if("DOUBLE".equals(columnTypes[i])){
				pstmt.setDouble(i+1,Double.parseDouble(values[i]));
			}else{
				pstmt.setObject(i+1,values[i]);
			}
		}
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			retrunValue = 1;
		}else{
			retrunValue = 0;
		}
		conn.commit();
		pstmt.close();
		pstmt = null;
		return retrunValue;
	}
}
