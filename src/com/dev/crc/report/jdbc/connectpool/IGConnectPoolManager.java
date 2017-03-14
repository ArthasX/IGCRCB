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
 * Description: 连接池管理对象接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGConnectPoolManager {

	/**
	 * 获取连接
	 * @param sourceName 标识名称
	 * @return 连接对象
	 * @throws ClassNotFoundException 加载驱动类失败
	 * @throws SQLException 创建连接异常
	 * @throws InterruptedException 线程等待异常
	 */
	public IGConnection getCon(String sourceName) throws ClassNotFoundException,
			SQLException,InterruptedException;
	
	/**
	 * 还原数据库连接为初始状态（即保留最小连接数量）
	 * @throws SQLException
	 */
	public void release() throws SQLException;
}
