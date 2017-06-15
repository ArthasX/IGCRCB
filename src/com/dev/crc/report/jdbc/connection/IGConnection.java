/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.jdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 数据库连接对象接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGConnection {

	/**
	 * 取得当前连接
	 * @return 数据库连接对象
	 */
	public IGConnection getCon();
	
	/**
	 * 获取连接对象
	 * @return 连接对象
	 */
	public Connection getConnection();
	
	/**
	 * 释放资源
	 */
	public void release();
	
	/**
	 * 当前连接是否空闲
	 * @return
	 */
	public boolean isLeisure();
	
	/**
	 * 关闭数据库连接
	 * @throws SQLException 数据库连接关闭异常
	 */
	public void close() throws SQLException;
}
