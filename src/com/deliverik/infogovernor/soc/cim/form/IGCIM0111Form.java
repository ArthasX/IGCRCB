/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置源数据比较版本form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM0111Form extends BaseForm{

	/** 设备主键 */
	protected Integer eiid;
	
	/** 分区表名 */
	protected String tablenames;
	
	/**采集文件名*/
	protected String host;
	
	/** 平台IP */
	protected String ip;
	
	/** server类型 */
	protected String type;
	
	protected String servername;
	
	/**
	 * 设备主键取得
	 * @return 设备主键
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设备主键设定
	 * @param eiid 设备主键
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 分区表名取得
	 * @return 分区表名
	 */
	public String getTablenames() {
		return tablenames;
	}

	/**
	 * 分区表名设定
	 * @param tablenames 分区表名
	 */
	public void setTablenames(String tablenames) {
		this.tablenames = tablenames;
	}

	/**
	 * 采集文件名取得
	 *
	 * @return host 采集文件名
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * 采集文件名设定
	 *
	 * @param host 采集文件名
	 */
	
	public void setHost(String host) {
		this.host = host;
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

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
}
