/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.smr.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.smr.form.IGSMR0303Form;
import com.deliverik.infogovernor.smr.form.IGSMR0701Form;
import com.deliverik.infogovernor.smr.form.IGSMR0703Form;
import com.deliverik.infogovernor.smr.form.IGSMR0704Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;

/**
 * 不定期报表填报业务DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSMR07DTO extends BaseDTO implements Serializable{
	
	/** 用户信息 */
	protected User user;

	/** 不定期报表发起Form */
	protected IGSMR0701Form igSMR0701Form;
	
	/** 发起页面不定期报表列表 */
	protected List<IG380Info> ig380List;
	
	/** 不定期报表查询结果*/
	protected Map<String,List<AnnualReportVW>> map_arq;
	
	/** 不定期报表一级审批查询结果*/
	protected Map<String,List<AnnualReportVW>> map_first;
	
	/** 不定期报表二级审批查询结果*/
	protected List<RegulatoryReportInstanceInfo> second_list;
	
	/** 填报查看form*/
	protected IGSMR0703Form IGSMR0703Form;
	
	/** 定时提醒form*/
	protected IGSMR0303Form igSMR0303Form;
	
	/** 填报查看查询结果*/
	protected Map<String,List<AnnualReportVW>> map_see;
	
	/** 不定期报表定时提醒查询结果*/
	protected RemindConfigureInfo rc;
	
	/** 一季度定时提醒查询结果*/
	protected RemindConfigureInfo rc1;
	
	/** 二季度定时提醒查询结果*/
	protected RemindConfigureInfo rc2;
	
	/** 三季度定时提醒查询结果*/
	protected RemindConfigureInfo rc3;
	
	/** 四季度定时提醒查询结果*/
	protected RemindConfigureInfo rc4;
	
	/** 实例ID */
	private	Integer instanceID;
		
	/** 不定期报表审批form*/
	private IGSMR0704Form igSMR0704Form;
	
	/** 不定期报表列表 */
	protected List<BatchExamineVW> lst_Report;
	
	/**
	 *用户信息取得
	 */
	public User getUser() {
		return user;
	}

	/**
	 *用户信息设定
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 *不定期报表发起Form取得
	 */
	public IGSMR0701Form getIgSMR0701Form() {
		return igSMR0701Form;
	}

	/**
	 *不定期报表发起Form设定
	 */
	public void setIgSMR0701Form(IGSMR0701Form igSMR0701Form) {
		this.igSMR0701Form = igSMR0701Form;
	}

	/**
	 *发起页面不定期报表列表取得
	 */
	public List<IG380Info> getIg380List() {
		return ig380List;
	}

	/**
	 *发起页面不定期报表列表设定
	 */
	public void setIg380List(List<IG380Info> ig380List) {
		this.ig380List = ig380List;
	}

	/**
	 *不定期报表查询结果取得
	 */
	public Map<String, List<AnnualReportVW>> getMap_arq() {
		return map_arq;
	}

	/**
	 *不定期报表查询结果设定
	 */
	public void setMap_arq(Map<String, List<AnnualReportVW>> map_arq) {
		this.map_arq = map_arq;
	}

	/**
	 *不定期报表一级审批查询结果取得
	 */
	public Map<String, List<AnnualReportVW>> getMap_first() {
		return map_first;
	}

	/**
	 *不定期报表一级审批查询结果设定
	 */
	public void setMap_first(Map<String, List<AnnualReportVW>> map_first) {
		this.map_first = map_first;
	}

	/**
	 *不定期报表二级审批查询结果取得
	 */
	public List<RegulatoryReportInstanceInfo> getSecond_list() {
		return second_list;
	}

	/**
	 *不定期报表二级审批查询结果设定
	 */
	public void setSecond_list(List<RegulatoryReportInstanceInfo> second_list) {
		this.second_list = second_list;
	}

	/**
	 *填报查看form取得
	 */
	public IGSMR0703Form getIGSMR0703Form() {
		return IGSMR0703Form;
	}

	/**
	 *填报查看form设定
	 */
	public void setIGSMR0703Form(IGSMR0703Form IGSMR0703Form) {
		this.IGSMR0703Form = IGSMR0703Form;
	}

	/**
	 *定时提醒form取得
	 */
	public IGSMR0303Form getIgSMR0303Form() {
		return igSMR0303Form;
	}

	/**
	 *定时提醒form设定
	 */
	public void setIgSMR0303Form(IGSMR0303Form igSMR0303Form) {
		this.igSMR0303Form = igSMR0303Form;
	}

	/**
	 *填报查看查询结果取得
	 */
	public Map<String, List<AnnualReportVW>> getMap_see() {
		return map_see;
	}

	/**
	 *填报查看查询结果设定
	 */
	public void setMap_see(Map<String, List<AnnualReportVW>> map_see) {
		this.map_see = map_see;
	}

	/**
	 *不定期报表定时提醒查询结果取得
	 */
	public RemindConfigureInfo getRc() {
		return rc;
	}

	/**
	 *不定期报表定时提醒查询结果设定
	 */
	public void setRc(RemindConfigureInfo rc) {
		this.rc = rc;
	}

	/**
	 *一季度定时提醒查询结果取得
	 */
	public RemindConfigureInfo getRc1() {
		return rc1;
	}

	/**
	 *一季度定时提醒查询结果设定
	 */
	public void setRc1(RemindConfigureInfo rc1) {
		this.rc1 = rc1;
	}

	/**
	 *二季度定时提醒查询结果取得
	 */
	public RemindConfigureInfo getRc2() {
		return rc2;
	}

	/**
	 *二季度定时提醒查询结果设定
	 */
	public void setRc2(RemindConfigureInfo rc2) {
		this.rc2 = rc2;
	}

	/**
	 *三季度定时提醒查询结果取得
	 */
	public RemindConfigureInfo getRc3() {
		return rc3;
	}

	/**
	 *三季度定时提醒查询结果设定
	 */
	public void setRc3(RemindConfigureInfo rc3) {
		this.rc3 = rc3;
	}

	/**
	 *四季度定时提醒查询结果取得
	 */
	public RemindConfigureInfo getRc4() {
		return rc4;
	}

	/**
	 *四季度定时提醒查询结果设定
	 */
	public void setRc4(RemindConfigureInfo rc4) {
		this.rc4 = rc4;
	}

	/**
	 *实例ID取得
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 *实例ID设定
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}



	/**
	 *不定期报表审批form取得
	 */
	public IGSMR0704Form getIgSMR0704Form() {
		return igSMR0704Form;
	}

	/**
	 *不定期报表审批form设定
	 */
	public void setIgSMR0704Form(IGSMR0704Form igSMR0704Form) {
		this.igSMR0704Form = igSMR0704Form;
	}

	/**
	 *不定期报表列表取得
	 */
	public List<BatchExamineVW> getLst_Report() {
		return lst_Report;
	}

	/**
	 *不定期报表列表设定
	 */
	public void setLst_Report(List<BatchExamineVW> lst_Report) {
		this.lst_Report = lst_Report;
	}

}
