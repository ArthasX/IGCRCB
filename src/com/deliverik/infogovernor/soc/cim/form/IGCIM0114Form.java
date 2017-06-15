/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 采集查询命令详细对比Form
 * 功能描述: 采集查询命令详细对比Form
 * 创建记录: zhangnan 2013-6-6
 * 修改记录: 
 */
public class IGCIM0114Form extends BaseForm{

	private static final long serialVersionUID = -3488451147077991287L;

	/**命令*/
	protected String keys;
	
	/**表名字*/
	protected String tablenames;
	
	/**对象名字*/
	protected String host;
	
	/**采集时间*/
	protected String collecttime;
	
	/** 平台IP */
	protected String ip;
	
	/** server类型 */
	protected String type;
	
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
	
	public String getTablenames() {
		return tablenames;
	}

	/**
	 * 表名字设定
	 *
	 * @param tablename 表名字
	 */
	
	public void setTablenames(String tablenames) {
		this.tablenames = tablenames;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
