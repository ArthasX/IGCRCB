/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 采集数据信息表实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
@IdClass(CR01PK.class)
@SuppressWarnings("serial")
public class CR01VW extends BaseEntity implements CR01VWInfo{
	
	/** 设备标识 */
	@Id
	protected String host;
	
	/** 采集时间 */
	@Id
	protected String collecttime;
	
	/** 采集命令 */
	@Id
	protected String command;
	
	/** 采集结果顺序 */
	@Id
	protected Integer cdataorder;
	
	/** 采集结果 */
	protected String cdata;
	
	/** 保存时间 */
	protected String inserttime;
	
	/** 结果分类 */
	protected String category;
	
	/** 关键字 */
	protected String keys;
	
	/** 平台IP */
	@Id
	protected String ip;
	
	/** server名 */
	@Id
	protected String servername;
	
	/** server类型 */
	@Id
	protected String servertype;

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

	/**
	 * 采集结果取得
	 * @return 采集结果
	 */
	public String getCdata() {
		return cdata;
	}

	/**
	 * 采集结果设定
	 * @param cdata 采集结果
	 */
	public void setCdata(String cdata) {
		this.cdata = cdata;
	}

	/**
	 * 保存时间取得
	 * @return 保存时间
	 */
	public String getInserttime() {
		return inserttime;
	}

	/**
	 * 保存时间设定
	 * @param inserttime 保存时间
	 */
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
	
	/**
	 * 结果分类取得
	 * @return 结果分类
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 结果分类设定
	 * @param category 结果分类
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 关键字取得
	 * @return 关键字
	 */
	public String getKeys() {
		return keys;
	}

	/**
	 * 关键字设定
	 * @param keys 关键字
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return new CR01PK(host, collecttime, command, cdataorder, ip, servername, servertype);
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
