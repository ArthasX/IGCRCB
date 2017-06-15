/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 采集结果表主键
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CR01PK extends BasePK implements Serializable{

	/** 设备标识 */
	protected String host;
	
	/** 采集时间 */
	protected String collecttime;
	
	/** 采集命令 */
	protected String command;
	
	/** 采集结果顺序 */
	protected Integer cdataorder;
	
	/** 平台IP */
	protected String ip;
	
	/** server名 */
	protected String servername;
	
	/** server类型 */
	protected String servertype;
	
	/**
	 * 构造方法
	 */
	public CR01PK(){
		
	}

	public CR01PK(String host, String collecttime, String command,
			Integer cdataorder, String ip, String servername, String servertype) {
		super();
		this.host = host;
		this.collecttime = collecttime;
		this.command = command;
		this.cdataorder = cdataorder;
		this.ip = ip;
		this.servername = servername;
		this.servertype = servertype;
	}



	/**
	 * 主机标识取得
	 * @return 主机标识
	 */
	public String getHost() {
		return host;
	}

	/**
	 * 主机i标识设定
	 * @param host 主机标识
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * 采集时间取得
	 * @return 采集时间
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * 采集时间设定
	 * @param collecttime 采集时间
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * 采集命令取得
	 * @return 采集命令
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * 采集命令设定
	 * @param command 采集命令
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * 采集结果顺序取得
	 * @return 采集结果顺序
	 */
	public Integer getCdataorder() {
		return cdataorder;
	}

	/**
	 * 采集结果顺序设定
	 * @param cdataorder 采集结果顺序
	 */
	public void setCdataorder(Integer cdataorder) {
		this.cdataorder = cdataorder;
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
