/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.form.IGSMR0302Form;
import com.deliverik.infogovernor.smr.form.IGSMR0303Form;
import com.deliverik.infogovernor.smr.form.IGSMR0304Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.ReportHistorySearchVW;

/**
 * 概述:我的填报（年报）查询 
 * 功能描述：我的填报（年报）查询 
 * 创建人：赵梓廷
 * 创建记录： 2013-07-25
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR03DTO extends BaseDTO {

	/** 用户信息 */
	protected User user;
	
	/** 年报查询结果*/
	protected Map<String,List<AnnualReportVW>> map_arq;
	
	/** 年报一级审批查询结果*/
	protected Map<String,List<AnnualReportVW>> map_first;
	
	/** 年报二级审批查询结果*/
	protected List<RegulatoryReportInstanceInfo> second_list;
	
	/** 填报查看form*/
	protected IGSMR0302Form igSMR0302Form;
	
	/** 定时提醒form*/
	protected IGSMR0303Form igSMR0303Form;
	
	/** 填报查看查询结果*/
	protected Map<String,List<AnnualReportVW>> map_see;
	
	/** 年报定时提醒查询结果*/
	protected RemindConfigureInfo rc;
	
	/** 一季度定时提醒查询结果*/
	protected RemindConfigureInfo rc1;
	
	/** 二季度定时提醒查询结果*/
	protected RemindConfigureInfo rc2;
	
	/** 三季度定时提醒查询结果*/
	protected RemindConfigureInfo rc3;
	
	/** 四季度定时提醒查询结果*/
	protected RemindConfigureInfo rc4;
	
	/** 首页点击更多查询结果*/
	protected Map<String,List<AnnualReportVW>> map_more;
	
	/** 通用查询form*/
	protected IGSMR0304Form igsmr0304Form;
	
	protected int maxSearchCount;
	protected PagingDTO pagingDto;
	
	/** 通用查询结果*/
	protected List<ReportHistorySearchVW> list_rhs;
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
		
	
	/**
	 * 年报查询结果取得
	 * 
	 * @return 年报查询结果
	 */
	public Map<String, List<AnnualReportVW>> getMap_arq() {
		return map_arq;
	}

	
	/**
	 * 年报查询结果设定
	 * 
	 * @param arqMap 年报查询结果
	 */
	public void setMap_arq(Map<String, List<AnnualReportVW>> map_arq) {
		this.map_arq = map_arq;
	}	

	
	/**
	 * 年报一级审批查询结果取得
	 * 
	 * @return 年报一级审批查询结果
	 */
	public Map<String, List<AnnualReportVW>> getMap_first() {
		return map_first;
	}

	/**
	 * 年报一级审批查询结果设定
	 * 
	 * @param first_list 年报一级审批查询结果
	 */
	public void setMap_first(Map<String, List<AnnualReportVW>> map_first) {
		this.map_first = map_first;
	}
	/**
	 * 年报二级审批查询结果取得
	 * 
	 * @return 年报二级审批查询结果
	 */
	public List<RegulatoryReportInstanceInfo> getSecond_list() {
		return second_list;
	}

	/**
	 * 年报二级审批查询结果设定
	 * 
	 * @param second_list 年报二级审批查询结果
	 */
	public void setSecond_list(List<RegulatoryReportInstanceInfo> second_list) {
		this.second_list = second_list;
	}
	
	/**
	 * 填报查看form取得
	 * 
	 * @return 填报查看form
	 */
	public IGSMR0302Form getIgSMR0302Form() {
		return igSMR0302Form;
	}
	
	/**
	 * 填报查看form设定
	 * 
	 * @param igSMR0302Form 填报查看form
	 */
	public void setIgSMR0302Form(IGSMR0302Form igSMR0302Form) {
		this.igSMR0302Form = igSMR0302Form;
	}
	/**
	 * 填报查看查询结果取得
	 * 
	 * @return 填报查看查询结果
	 */

	public Map<String, List<AnnualReportVW>> getMap_see() {
		return map_see;
	}

	/**
	 * 填报查看查询结果设定
	 * 
	 * @param list_rri 填报查看查询结果
	 */
	public void setMap_see(Map<String, List<AnnualReportVW>> map_see) {
		this.map_see = map_see;
	}
	/**
	 * 定时提醒form取得
	 * 
	 * @return 定时提醒form
	 */
	public IGSMR0303Form getIgSMR0303Form() {
		return igSMR0303Form;
	}
	/**
	 * 定时提醒form设定
	 * 
	 * @param igSMR0303Form 定时提醒form
	 */
	public void setIgSMR0303Form(IGSMR0303Form igSMR0303Form) {
		this.igSMR0303Form = igSMR0303Form;
	}

	public RemindConfigureInfo getRc() {
		return rc;
	}

	public void setRc(RemindConfigureInfo rc) {
		this.rc = rc;
	}

	public RemindConfigureInfo getRc1() {
		return rc1;
	}

	public void setRc1(RemindConfigureInfo rc1) {
		this.rc1 = rc1;
	}

	public RemindConfigureInfo getRc2() {
		return rc2;
	}

	public void setRc2(RemindConfigureInfo rc2) {
		this.rc2 = rc2;
	}

	public RemindConfigureInfo getRc3() {
		return rc3;
	}

	public void setRc3(RemindConfigureInfo rc3) {
		this.rc3 = rc3;
	}

	public RemindConfigureInfo getRc4() {
		return rc4;
	}

	public void setRc4(RemindConfigureInfo rc4) {
		this.rc4 = rc4;
	}

	public Map<String, List<AnnualReportVW>> getMap_more() {
		return map_more;
	}

	public void setMap_more(Map<String, List<AnnualReportVW>> map_more) {
		this.map_more = map_more;
	}

	public IGSMR0304Form getIgsmr0304Form() {
		return igsmr0304Form;
	}

	public void setIgsmr0304Form(IGSMR0304Form igsmr0304Form) {
		this.igsmr0304Form = igsmr0304Form;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<ReportHistorySearchVW> getList_rhs() {
		return list_rhs;
	}

	public void setList_rhs(List<ReportHistorySearchVW> list_rhs) {
		this.list_rhs = list_rhs;
	}

	
	
}
