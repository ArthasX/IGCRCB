/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 配置原数据与主机关系表实体主键
  * 功能描述: 配置原数据与主机关系表实体主键
  * 创建记录: 2013/04/08
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class CR03PK extends BasePK implements Serializable {

	/** 采集时间 */
	protected Integer type;

	/** 分区表名 */
	protected String ip;
	
	/** 主机标识 */
	protected String host;
	
	/**  */
	protected String collecttime;

	/**
	 * 构造函数
	 */
	public CR03PK() {

	}

	




	public CR03PK(Integer type, String ip, String host, String collecttime) {
		super();
		this.type = type;
		this.ip = ip;
		this.host = host;
		this.collecttime = collecttime;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCollecttime() {
		return collecttime;
	}

	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}
	
}