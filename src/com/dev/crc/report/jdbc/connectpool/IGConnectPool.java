/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.jdbc.connectpool;

import java.sql.SQLException;

import com.dev.crc.report.jdbc.connection.IGConnection;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 连接池对象接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGConnectPool {

	/**
	 * 获取连接对象
	 * @return 连接对象
	 * @throws ClassNotFoundException driver加载失败
	 * @throws SQLException 创建连接异常
	 * @throws InterruptedException 线程异常
	 */
	public IGConnection getCon() throws ClassNotFoundException,SQLException,InterruptedException;
	
	/**
	 * 释放多余连接
	 * 连接使用处于空闲状态，需要释放掉多余的连接
	 * 规则为：保留最小连接数量，将其与的连接全部关闭
	 */
	public void release() throws SQLException;
	
	/**
	 * 关闭连接池
	 * 规则：不保留任何连接，全部关闭
	 */
	public void close() throws SQLException;
}
