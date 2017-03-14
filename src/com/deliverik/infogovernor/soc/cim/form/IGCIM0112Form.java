/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 采集查询之单命令详细查询Form
 * 功能描述: 采集查询之单命令详细查询Form
 * 创建记录: yanglongquan 2013-5-31
 * 修改记录: 
 */
public class IGCIM0112Form extends BaseForm{

	private static final long serialVersionUID = -3488451147077991287L;

	/**命令*/
	protected String keys;
	
	/**表名字*/
	protected String tablename;
	
	/**对象名字*/
	protected String host;
	
	/**采集时间*/
	protected String collecttime;
	
	/** server类型 */
	protected String type;
	
	/** 平台IP */
	protected String ip;
	
	protected String servername;
	
	

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * 命令取得
	 *
	 * @return keys 命令
	 */
	
	public String getKeys() {
		return keys;
	}

	/**
	 * 命令设定
	 *
	 * @param keys 命令
	 */
	
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * 表名字取得
	 *
	 * @return tablename 表名字
	 */
	
	public String getTablename() {
		return tablename;
	}

	/**
	 * 表名字设定
	 *
	 * @param tablename 表名字
	 */
	
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * 对象名字取得
	 *
	 * @return host 对象名字
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * 对象名字设定
	 *
	 * @param host 对象名字
	 */
	
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * 采集时间取得
	 *
	 * @return collecttime 采集时间
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
	 * 类型取得
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 类型设定
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 平台ip取得
	 * @return
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * 平台ip设定
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
	
}
