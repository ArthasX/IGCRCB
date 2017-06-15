/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.form.IGSMR0402Form;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;

/**
 * 年报审批业务DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSMR04DTO extends BaseDTO implements Serializable{
	
	/** 实例ID */
	private	Integer instanceID;
		
	/** 年报审批form*/
	private IGSMR0402Form igsmr0402Form;
	
	/** 年报列表 */
	protected List<BatchExamineVW> lst_Report;
	
	/** 用户信息 */
	protected User user;
	
	/**
	 * 实例ID取得
	 * 
	 * @return 实例ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * 实例ID设定
	 * 
	 * @param instanceID 实例ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}
		
	
	/**
	 * 年报列表取得
	 * 
	 * @return 年报列表
	 */
	public List<BatchExamineVW> getLst_Report() {
		return lst_Report;
	}

	/**
	 * 年报列表设定
	 * 
	 * @param lst_Report 年报列表
	 */
	public void setLst_Report(List<BatchExamineVW> lst_Report) {
		this.lst_Report = lst_Report;
	}
	
	/**
	 * 用户信息取得
	 * 
	 * @return 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * 
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public IGSMR0402Form getIgsmr0402Form() {
		return igsmr0402Form;
	}

	public void setIgsmr0402Form(IGSMR0402Form igsmr0402Form) {
		this.igsmr0402Form = igsmr0402Form;
	}
	
}