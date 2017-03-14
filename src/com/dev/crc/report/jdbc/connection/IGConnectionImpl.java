/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.deliverik.framework.utility.IGStringUtils;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 数据库连接对象实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGConnectionImpl implements IGConnection{
	
	/** 状态：空闲 */
	private static final String STATUS_LEISURE = "L";
	
	/** 状态：使用中 */
	private static final String STATUS_USING = "U";

	/** 连接对象 */
	protected Connection connection;
	
	/** 连接状态 */
	protected String status;
	
	/** 创建时间 */
	protected String createTime;
	
	/** 释放时间 */
	protected String releaseTime;
	
	/**
	 * 构造方法
	 * @param driver driver类路径
	 * @param url 连接URL
	 * @param username 用户名
	 * @param password 密码
	 */
	public IGConnectionImpl(String driver,String url ,String username,String password) 
			throws ClassNotFoundException,SQLException{
		//加载driver
		Class.forName(driver);
		//取得连接对象
		Connection conn = DriverManager.getConnection(url, username, password);
		//设置当前连接对象
		connection = conn;
		//设置状态为空闲
		status = STATUS_LEISURE;
		//设置创建时间
		createTime = IGStringUtils.getCurrentDateTime();
		//初始化释放时间为创建时间
		releaseTime = createTime;
	}
	
	/**
	 * 取得当前连接
	 * @return 数据库连接对象
	 */
	public IGConnection getCon(){
		//更改状态为使用中
		this.status = STATUS_USING;
		return this;
	}
	
	/**
	 * 获取连接对象
	 * @return 连接对象
	 */
	public Connection getConnection(){
		if(STATUS_USING.equals(status)){
			return this.connection;
		}else{
			return null;
		}
	}
	
	/**
	 * 释放资源
	 */
	public void release(){
		//更改状态为释放
		this.status = STATUS_LEISURE;
		//更新释放时间
		this.releaseTime = IGStringUtils.getCurrentDateTime();
	}
	
	/**
	 * 当前连接是否空闲
	 * @return
	 */
	public boolean isLeisure(){
		return STATUS_LEISURE.equals(status);
	}
	
	/**
	 * 关闭数据库连接
	 * @throws SQLException 数据库连接关闭异常
	 */
	public void close() throws SQLException{
		this.connection.close();
	}
}
