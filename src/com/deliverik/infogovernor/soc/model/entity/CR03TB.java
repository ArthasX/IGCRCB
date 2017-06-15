/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;
import com.deliverik.infogovernor.soc.model.CR03Info;

/**
  * 概述: 配置原数据与主机关系表实体
  * 功能描述: 配置原数据与主机关系表实体
  * 创建记录: 2013/04/08
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(CR03PK.class)
@Table(name="CR03" )
public class CR03TB extends BaseEntity implements Serializable,Cloneable, CR03Info {
	
	@Id
	/** 采集时间 */
	protected String collecttime;
	
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
	protected Integer type;
	
	/** 显示时间 */
	@Transient
	protected String showtime;
	
	/** server名 */
	@Id
	protected String servername;
	


	/** 导入对象类型信息 */
	@ManyToOne
	@JoinColumn(name="type", referencedColumnName="impTypeid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0113TB soc0113TB;
	
	

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
	public String getShowtime() {
		if(StringUtils.isNotEmpty(collecttime)){
			try{
				SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
				SimpleDateFormat d2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				showtime = d2.format(d1.parse(collecttime));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return showtime;
	}

	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new CR03PK(type, ip, host,collecttime);
	}

	/**
	 * 导入对象类型信息取得
	 *
	 * @return soc0113TB 导入对象类型信息
	 */
	@Basic(optional=false)
	public SOC0113TB getSoc0113TB() {
		return soc0113TB;
	}

	/**
	 * 导入对象类型信息设定
	 *
	 * @param soc0113TB 导入对象类型信息
	 */
	public void setSoc0113TB(SOC0113TB soc0113TB) {
		this.soc0113TB = soc0113TB;
	}

	public String getCollecttime() {
		return collecttime;
	}

	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
	
}