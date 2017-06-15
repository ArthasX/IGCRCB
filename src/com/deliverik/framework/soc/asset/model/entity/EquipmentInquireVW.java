/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;


/**
 * 概述:3D机房支持IP查询视图 
 * 功能描述：3D机房支持IP查询视图 
 * 创建人：赵梓廷
 * 创建记录： 2013-01-31
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
public class EquipmentInquireVW implements Serializable, Cloneable,EquipmentInquireVWInfo {
	
	@Id
	/**设备主键*/
	protected Integer eiid;
	/**类型名称*/
	protected String ename;
	
	/**设备名称*/
	protected String einame;

	/**设备编号*/
	protected String eilabel;
	
	/**业务系统*/
	protected String businesssys;
	
	/**IP地址*/
	protected String ip;
	
	/**型号*/
	protected String pattern;
	
	/**机柜中位置*/
	protected String site ;
	
	/**所属机柜*/
	protected String computerContainer ;
	
	/**所属机柜Id*/
	protected Integer computerContainerId ;
	
	/**所属机房Id*/
	protected Integer computerroomId;

	/**所属机房*/
	protected String computerroom;
	/**
	 *所属机柜Id取得
	 * @return 所属机柜Id
	 */
	public Integer getComputerContainerId() {
		return computerContainerId;
	}
	/**
	 * 所属机柜Id设定
	 *
	 * @param computerContainerId 所属机柜Id
	 */
	public void setComputerContainerId(Integer computerContainerId) {
		this.computerContainerId = computerContainerId;
	}

	/**
	 *设备主键取得
	 * @return 设备主键
	 */
	public Integer getEiid() {
		return eiid;
	}
	/**
	 * 设备主键设定
	 *
	 * @param eiid 设备主键
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**
	 *类型名称取得
	 * @return 类型名称
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * 类型名称设定
	 *
	 * @param ename 类型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	/**
	 *设备名称取得
	 * @return 设备名称
	 */
	public String getEiname() {
		return einame;
	}
	/**
	 * 设备名称设定
	 *
	 * @param einame 设备名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
	/**
	 *业务系统取得
	 * @return 业务系统
	 */
	public String getBusinesssys() {
		return businesssys;
	}
	
	/**
	 * 业务系统设定
	 *
	 * @param businesssys 业务系统
	 */
	public void setBusinesssys(String businesssys) {
		this.businesssys = businesssys;
	}
	
	/**
	 *IP地址取得
	 * @return IP地址
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * IP地址设定
	 *
	 * @param ip IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 *型号取得
	 * @return 型号
	 */
	public String getPattern() {
		return pattern;
	}
	
	/**
	 * 型号设定
	 *
	 * @param pattern 型号
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	/**
	 *机柜中位置取得
	 * @return 机柜中位置
	 */
	public String getSite() {
		return site;
	}
	/**
	 * 机柜中位置设定
	 *
	 * @param site 机柜中位置
	 */
	public void setSite(String site) {
		this.site = site;
	}
	/**
	 *所属机柜取得
	 * @return 所属机柜
	 */
	public String getComputerContainer() {
		return computerContainer;
	}
	/**
	 * 所属机柜设定
	 *
	 * @param computerContainer 所属机柜
	 */
	public void setComputerContainer(String computerContainer) {
		this.computerContainer = computerContainer;
	}
	/**
	 *所属机房取得
	 * @return 所属机房
	 */
	public String getComputerroom() {
		return computerroom;
	}
	/**
	 * 所属机房设定
	 *
	 * @param computerroom 所属机房
	 */
	public void setComputerroom(String computerroom) {
		this.computerroom = computerroom;
	}
    /**
     * 设备编号取得
     *
     * @return eilabel 设备编号
     */
    public String getEilabel() {
        return eilabel;
    }
    /**
     * 所属机房Id取得
     *
     * @return computerroomId 所属机房Id
     */
    public Integer getComputerroomId() {
        return computerroomId;
    }
    /**
     * 设备编号设定
     *
     * @param eilabel 设备编号
     */
    public void setEilabel(String eilabel) {
        this.eilabel = eilabel;
    }
    /**
     * 所属机房Id设定
     *
     * @param computerroomId 所属机房Id
     */
    public void setComputerroomId(Integer computerroomId) {
        this.computerroomId = computerroomId;
    }
	
	
}
