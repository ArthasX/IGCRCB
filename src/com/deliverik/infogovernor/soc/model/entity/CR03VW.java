/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import org.apache.commons.lang.StringUtils;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;

/**
  * 概述: cr03表页面展示封装类
  * 功能描述: cr03表页面展示封装类
  * 创建记录: 2013/07/15 王省
  */
@SuppressWarnings("serial")
@Entity
@IdClass(CR03VWPK.class)
public class CR03VW implements Serializable,Cloneable, CR03VWInfo {
	
	/** 最大采集时间 */
	protected String maxctime;
	
	/** 最小采集时间 */
	@Id
	protected String minctime;
	
	@Id
	protected String ip;
	
	/** 分区表名 */
	protected String tablename;

	/** 主机标识 */
	@Id
	protected String host;
	
	/** 状态 */
	protected String status;
	
	/** 类型 */
	@Id
	protected Integer type;
	
//	/** 显示时间 */
//	@Transient
//	protected String maxshowtime;
//	
//	@Transient
//	protected String minshowtime;
	
	/** 模型名 */
	protected String imptypename;
	
	/** 脚本名 */
	@Id
	protected String servername;

	/**
	 * 分区表名取得
	 *
	 * @return 分区表名
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * 分区表名设定
	 *
	 * @param tablename 分区表名
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * 主机标识取得
	 *
	 * @return 主机标识
	 */
	public String getHost() {
		return host;
	}

	/**
	 * 主机标识设定
	 *
	 * @param host 主机标识
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态设定
	 * @param status 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 类型取得
	 * @return 类型
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 类型设定
	 * @param type 类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 显示时间取得
	 * @return 显示时间
	 */
	public String getShowtime(String time) {
		String showtime = "";
		if(StringUtils.isNotEmpty(time)){
			try{
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				showtime = d2.format(d1.parse(time));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return showtime;
	}

	
	public String getMaxctime() {
		String showtime = "";
		if(StringUtils.isNotEmpty(maxctime)){
			try{
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				showtime = d2.format(d1.parse(maxctime));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return showtime;
	}

	public void setMaxctime(String maxctime) {
		this.maxctime = maxctime;
	}

	public String getMinctime() {
		return this.minctime;
	}

	public void setMinctime(String minctime) {
		this.minctime = minctime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMaxshowtime() {
		return getShowtime(maxctime);
	}

//	public void setMaxshowtime(String maxshowtime) {
//		this.maxshowtime = maxshowtime;
//	}

	public String getMinshowtime() {
		return getShowtime(minctime);
	}

//	public void setMinshowtime(String minshowtime) {
//		this.minshowtime = minshowtime;
//	}


	public String getImptypename() {
		return imptypename;
	}

	public void setImptypename(String imptypename) {
		this.imptypename = imptypename;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
	
}