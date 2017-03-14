/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sdl.model.ChangeKpi;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_统计汇总_变更kpi信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class ChangeKpiVW implements Serializable, Cloneable, ChangeKpi {

	@Id
	/**类型ID */
	protected Integer typeId;
	
	/** 类型名称*/
	protected String typeName;

	/**成功子状态*/
	protected Integer success;
	
	/**存在问题子状态*/
	protected Integer problem;
	
	/**失败子状态*/
	protected Integer fail;
	
	public Serializable getPK() {
		return typeId;
	}

	/**
	 * 获取类型ID
	 * @return 类型ID
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * 设置类型ID
	 * @param typeId 类型ID
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * 获取类型ID
	 * @return 类型ID
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 设置类型ID
	 * @param typeId 类型ID
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	/**
	 * 获取成功子状态
	 * @return 成功子状态
	 */
	public Integer getSuccess() {
		return success;
	}

	/**
	 * 设置成功子状态
	 * @param success 成功子状态
	 */
	public void setSuccess(Integer success) {
		this.success = success;
	}


	/**
	 * 获取存在问题子状态
	 * @return 存在问题子状态
	 */
	public Integer getProblem() {
		return problem;
	}

	/**
	 * 设置存在问题子状态
	 * @param problem 存在问题子状态
	 */
	public void setProblem(Integer problem) {
		this.problem = problem;
	}


	/**
	 * 获取失败子状态
	 * @return 失败子状态
	 */
	public Integer getFail() {
		return fail;
	}

	/**
	 * 设置失败子状态
	 * @param fail 失败子状态
	 */
	public void setFail(Integer fail) {
		this.fail = fail;
	}
	
}
