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
public class CR03VWPK extends BasePK implements Serializable {

	/** 采集时间 */
	protected Integer type;

	/** 分区表名 */
	protected String ip;
	
	/** 主机标识 */
	protected String host;
	
	/** 代表采集时间 */
	protected String minctime;
	
	/** 脚本名 */
	protected String servername;
	
	

	/**
	 * 构造函数
	 */
	public CR03VWPK() {

	}

	public CR03VWPK(Integer type, String ip, String host, String minctime,
			String servername) {
		super();
		this.type = type;
		this.ip = ip;
		this.host = host;
		this.minctime = minctime;
		this.servername = servername;
	}



	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getMinctime() {
		return minctime;
	}


	public void setMinctime(String minctime) {
		this.minctime = minctime;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
}