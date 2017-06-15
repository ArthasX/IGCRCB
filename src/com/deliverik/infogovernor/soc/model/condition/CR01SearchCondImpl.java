/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.model.condition;

import javax.persistence.Id;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:采集结果查询条件实现 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 * 更新说明 增加查询条件采集命令
 */
public class CR01SearchCondImpl implements CR01SearchCond{

	/** 分区表明 */
	protected String tablename;
	
	/** 设备标识 */
	protected String host;
	
	/** 采集时间 */
	protected String collecttime;
	
	/** 采集命令*/
	protected String command;
	
	/** 平台IP */
	protected String ip;
	
	/** server名 */
	protected String servername;
	
	/** server类型 */
	protected String servertype;

	/**
	 * 分区表名取得
	 * @return 分区表明
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * 分区表名设定
	 * @param tablename 分区表名
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * 设备标识取得
	 * @return 设备标识
	 */
	public String getHost() {
		return host;
	}

	/**
	 * 设备标识设定
	 * @param host 设备标识
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * 采集时间取得
	 *
	 * @return 采集时间
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * 采集时间设定
	 *
	 * @param collecttime 采集时间
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * 采集命令取得
	 *
	 * @return command 采集命令
	 */
	
	public String getCommand() {
		return command;
	}

	/**
	 * 采集命令设定
	 *
	 * @param command 采集命令
	 */
	
	public void setCommand(String command) {
		this.command = command;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getServertype() {
		return servertype;
	}

	public void setServertype(String servertype) {
		this.servertype = servertype;
	}
	
}
