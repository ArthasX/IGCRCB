/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.infogovernor.sdl.model.IncidentKpi;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_统计汇总_事件kpi信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@IdClass(IncidentKpiVWPK.class)
@Entity
//public class IncidentKpiVW extends BaseEntity implements Serializable, Cloneable, IncidentKpi {
public class IncidentKpiVW implements Serializable, Cloneable, IncidentKpi {
	
	/**类别ID */
	protected String typeId;
	
	/** 类别名称*/
	protected String typeName;
	@Id
	/**紧急程度*/
	protected String urgency;
	
	/**平均解决时间*/
	protected Float resolve;
	@Id
	/**类别层次码*/
	protected String syscoding;
	
	/**紧急程度名称*/
	protected String urgencyName;
	
	public Serializable getPK() {
		return typeId;
	}

	/**
	 * 获取类别ID
	 * @return 类别ID
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * 设置类别ID
	 * @param typeId 类别ID
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * 获取类别名称
	 * @return 类别名称
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 设置类别名称
	 * @param typeName 类别名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 获取紧急程度
	 * @return 紧急程度
	 */
	public String getUrgency() {
		return urgency;
	}

	/**
	 * 设置紧急程度
	 * @param urgency 紧急程度
	 */
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	/**
	 * 获取平均解决时间
	 * @return 平均解决时间
	 */
	public Float getResolve() {
		return resolve;
	}

	/**
	 * 设置平均解决时间
	 * @param resolve 平均解决时间
	 */
	public void setResolve(Float resolve) {
		this.resolve = resolve;
	}

	/**
	 * 获取类别层次码
	 * @return 类别层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * 设置类别层次码
	 * @param syscoding 类别层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * 获取紧急程度名称
	 * @return 紧急程度名称
	 */
	public String getUrgencyName() {
		return urgencyName;
	}

	/**
	 * 设置紧急程度名称
	 * @param urgencyName 紧急程度名称
	 */
	public void setUrgencyName(String urgencyName) {
		this.urgencyName = urgencyName;
	}
	
}
