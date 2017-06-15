/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.dut.form.IGDUT0101Form;
import com.deliverik.infogovernor.dut.form.IGDUT0102Form;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;

import com.deliverik.framework.user.model.User;

/**
 * 值班检查管理DTO
 *
 */
@SuppressWarnings("serial")
public class IGDUT01DTO extends BaseDTO implements Serializable {
	
	//-----------------------------------------------------------值班检查管理查询列表----------------------------------------------------------------------

	/** 值班检查查询条件 */
	protected DutyAuditDefSearchCond dutyAuditDefSearchCond;
	
	/** 值班检查信息Form */
	protected IGDUT0102Form igDUT0102Form;
	
	/** 值班检查项设定Form */
	protected IGDUT0101Form igDUT0101Form;
	
	/**值班检查信息对象*/
	protected DutyAuditDef dutyAuditDef;

	/** 值班检查信息检索结果集 */
	protected List<DutyAuditDef> dutyAuditList;
	
	/** 值班检查设定检索结果集 */
	protected List<DutyAuditTime> dutyAudit2List;
	
	/** 当前登录用户 */
	protected User user;
	
	
	
	/**
	 * 当前登录用户取得
	 * @return 值班检查设定Form
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 当前登录用户设定
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 值班检查设定Form取得
	 * @return 值班检查设定Form
	 */
	public IGDUT0101Form getIgDUT0101Form() {
		return igDUT0101Form;
	}
    
	/**
	 * 值班检查信息取得
	 * @return 值班检查信息
	 */
	public DutyAuditDef getDutyAuditDef() {
		return dutyAuditDef;
	}
    /**
     * 值班检查信息设置
     * @param dutyAuditDef
     */
	public void setDutyAuditDef(DutyAuditDef dutyAuditDef) {
		this.dutyAuditDef = dutyAuditDef;
	}

	/**
	 * 值班检查设定Form设定
	 * @param igDUT0101Form 值班检查设定Form
	 */
	public void setIgDUT0101Form(IGDUT0101Form igDUT0101Form) {
		this.igDUT0101Form = igDUT0101Form;
	}
    
	/**
	 * 值班检查设定检索结果集取得
	 * @return 值班检查设定检索结果集
	 */
	public List<DutyAuditTime> getDutyAudit2List() {
		return dutyAudit2List;
	}
    
	/**
	 * 值班检查设定检索结果集设定
	 * @param dutyAuditList 值班检查设定检索结果集
	 */
	public void setDutyAudit2List(List<DutyAuditTime> dutyAudit2List) {
		this.dutyAudit2List = dutyAudit2List;
	}

	/** 分页用DTO */
	protected PagingDTO pagingDto;

	/** 值班检查信息最大检索件数 */
	protected int maxSearchCount;

	
	/**
	 * 值班检查查询条件取得
	 * @return 值班检查查询条件
	 */
	public DutyAuditDefSearchCond getDutyAuditDefSearchCond() {
		return dutyAuditDefSearchCond;
	}

	/**
	 * 值班检查查询条件设定
	 * @param dutyAuditDefSearchCond 值班检查查询条件
	 */
	public void setDutyAuditDefSearchCond(
			DutyAuditDefSearchCond dutyAuditDefSearchCond) {
		this.dutyAuditDefSearchCond = dutyAuditDefSearchCond;
	}

	/**
	 * 值班检查信息Form取得
	 * @return 值班检查信息Form
	 */
	public IGDUT0102Form getIgDUT0102Form() {
		return igDUT0102Form;
	}

	/**
	 * 值班检查信息Form设定
	 * @param igDUT0102Form 值班检查信息Form
	 */
	public void setIgDUT0102Form(IGDUT0102Form igDUT0102Form) {
		this.igDUT0102Form = igDUT0102Form;
	}

	/**
	 * 值班检查信息检索结果集取得
	 * @return 值班检查信息检索结果集
	 */
	public List<DutyAuditDef> getDutyAuditList() {
		return dutyAuditList;
	}

	/**
	 * 值班检查信息检索结果集设定
	 * @param dutyAuditList 值班检查信息检索结果集
	 */
	public void setDutyAuditList(List<DutyAuditDef> dutyAuditList) {
		this.dutyAuditList = dutyAuditList;
	}

	/**
	 * 分页用DTO取得
	 * @return 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 值班检查信息最大检索件数取得
	 * @return 值班检查信息最大检索件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 值班检查信息最大检索件数设定
	 * @param maxSearchCount 值班检查信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

}
