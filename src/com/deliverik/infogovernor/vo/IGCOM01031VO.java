package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
public class IGCOM01031VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 处理中的流程倒序
	 */
	protected List<ProcessInHandVWInfo> processInHandDesc ;
	/**
	 * 处理中的流程正序
	 */
	protected List<ProcessInHandVWInfo> processInHandAsc ;
	
	/**
	 * 处理中的流程倒序
	 */
	protected List<ProcessInHandVWInfo> processInHandGroupDesc ;
	/**
	 * 处理中的流程正序
	 */
	protected List<ProcessInHandVWInfo> processInHandGroupAsc ;
	
	/**
	 * 中止的流程倒序
	 */
	protected List<ProcessInHandVWInfo> processInHandDiscontinueDesc ;
	/**
	 * 中止的流程正序
	 */
	protected List<ProcessInHandVWInfo> processInHandDiscontinueAsc ;

	
	
	protected List<CopyReadUserInfo>  culistAsc;
	
	protected List<CopyReadUserInfo>  culistDesc;
	private List<IGCOM04032VO> knvoList;
	
	private List<IGCOM04032VO> appKnList;
	
	private List<String> noticeList;
	
	private String dayplans;
	
	private boolean showKnflag;//是否存在未显示的知识
	
	private String year;
	
	private String month;
	
	private String backyear;
	
	private String backmonth;
	
	private String afteryear;
	
	private String aftermonth;
	
	/** 是否存在首页监管报表table权限*/
	private boolean islimit;
	
	/** 业务系统可用性 */
	protected List<BussinessAvailval> lst_BussinessAvailval;
	
	/** Oracle告警 */
	protected List<CRM06Info> lst_CRM06Info;
	
	/** 个人检查工作正序 */
	private List<RiskCheckResult> lst_RiskCheckResult_Asc;
	
	/** 个人检查工作倒序 */
	private List<RiskCheckResult> lst_RiskCheckResult_Desc;
	
	/** 相关检查工作正序 */
	private List<RiskCheckResult> lst_RiskCheckResultGroup_Asc;
	
	/** 相关检查工作倒序 */
	private List<RiskCheckResult> lst_RiskCheckResultGroup_Desc;
	
	/** 系统当前时间 */
	private String riskChecktime;
	
	/** 首页我的工作集合 */
	private List<Map<String,String>> myWorkItemList;
	
	/**
	 * 取得 首页我的工作集合
	 * 
	 * @return myWorkItemList 首页我的工作集合
	 */
	public List<Map<String, String>> getMyWorkItemList() {
		return myWorkItemList;
	}

	/**
	 * 设定 首页我的工作集合
	 * 
	 * @param myWorkItemList 首页我的工作集合
	 */
	public void setMyWorkItemList(List<Map<String, String>> myWorkItemList) {
		this.myWorkItemList = myWorkItemList;
	}

	/**
	 * 系统当前时间获取
	 * 
	 * @return 系统当前时间
	 */
	public String getRiskChecktime() {
		return riskChecktime;
	}

	/**
	 * 系统当前时间设置
	 * 
	 * @param riskChecktime 系统当前时间
	 */
	public void setRiskChecktime(String riskChecktime) {
		this.riskChecktime = riskChecktime;
	}

	/**
	 * 个人检查工作正序获取
	 * 
	 * @return 检查工作正序
	 */
	public List<RiskCheckResult> getLst_RiskCheckResult_Asc() {
		return lst_RiskCheckResult_Asc;
	}

	/**
	 * 个人检查工作正序设置
	 * 
	 * @param lst_RiskCheckResult_Asc 检查工作正序
	 */
	public void setLst_RiskCheckResult_Asc(
			List<RiskCheckResult> lst_RiskCheckResult_Asc) {
		this.lst_RiskCheckResult_Asc = lst_RiskCheckResult_Asc;
	}

	/**
	 * 个人检查工作倒序获取
	 * 
	 * @return 个人检查工作倒序
	 */
	public List<RiskCheckResult> getLst_RiskCheckResult_Desc() {
		return lst_RiskCheckResult_Desc;
	}

	/**
	 * 个人检查工作倒序设置
	 * 
	 * @param lst_RiskCheckResult_Desc 个人检查工作倒序
	 */
	public void setLst_RiskCheckResult_Desc(
			List<RiskCheckResult> lst_RiskCheckResult_Desc) {
		this.lst_RiskCheckResult_Desc = lst_RiskCheckResult_Desc;
	}

	/**
	 * 相关检查工作正序获取
	 * 
	 * @return 相关检查工作正序
	 */
	public List<RiskCheckResult> getLst_RiskCheckResultGroup_Asc() {
		return lst_RiskCheckResultGroup_Asc;
	}

	/**
	 * 相关检查工作正序设置
	 * 
	 * @param lst_RiskCheckResultGroup_Asc 相关检查工作正序
	 */
	public void setLst_RiskCheckResultGroup_Asc(
			List<RiskCheckResult> lst_RiskCheckResultGroup_Asc) {
		this.lst_RiskCheckResultGroup_Asc = lst_RiskCheckResultGroup_Asc;
	}

	/**
	 * 相关检查工作倒序获取
	 * 
	 * @return 相关检查工作倒序
	 */
	public List<RiskCheckResult> getLst_RiskCheckResultGroup_Desc() {
		return lst_RiskCheckResultGroup_Desc;
	}

	/**
	 * 相关检查工作倒序设置
	 * 
	 * @param lst_RiskCheckResultGroup_Desc 相关检查工作倒序
	 */
	public void setLst_RiskCheckResultGroup_Desc(
			List<RiskCheckResult> lst_RiskCheckResultGroup_Desc) {
		this.lst_RiskCheckResultGroup_Desc = lst_RiskCheckResultGroup_Desc;
	}

	public List<ProcessInHandVWInfo> getProcessInHandDiscontinueDesc() {
		return processInHandDiscontinueDesc;
	}
	public void setProcessInHandDiscontinueDesc(
			List<ProcessInHandVWInfo> processInHandDiscontinueDesc) {
		this.processInHandDiscontinueDesc = processInHandDiscontinueDesc;
	}
	public List<ProcessInHandVWInfo> getProcessInHandDiscontinueAsc() {
		return processInHandDiscontinueAsc;
	}
	public void setProcessInHandDiscontinueAsc(
			List<ProcessInHandVWInfo> processInHandDiscontinueAsc) {
		this.processInHandDiscontinueAsc = processInHandDiscontinueAsc;
	}
	public List<ProcessInHandVWInfo> getProcessInHandDesc() {
		return processInHandDesc;
	}
	public void setProcessInHandDesc(List<ProcessInHandVWInfo> processInHandDesc) {
		this.processInHandDesc = processInHandDesc;
	}
	public List<ProcessInHandVWInfo> getProcessInHandAsc() {
		return processInHandAsc;
	}
	public void setProcessInHandAsc(List<ProcessInHandVWInfo> processInHandAsc) {
		this.processInHandAsc = processInHandAsc;
	}
	
	public List<String> getNoticeList() {
		return noticeList;
	}
	public void setNoticeList(List<String> noticeList) {
		this.noticeList = noticeList;
	}
	public List<ProcessInHandVWInfo> getProcessInHandGroupDesc() {
		return processInHandGroupDesc;
	}
	public void setProcessInHandGroupDesc(
			List<ProcessInHandVWInfo> processInHandGroupDesc) {
		this.processInHandGroupDesc = processInHandGroupDesc;
	}
	public List<ProcessInHandVWInfo> getProcessInHandGroupAsc() {
		return processInHandGroupAsc;
	}
	public void setProcessInHandGroupAsc(
			List<ProcessInHandVWInfo> processInHandGroupAsc) {
		this.processInHandGroupAsc = processInHandGroupAsc;
	}
	public List<IGCOM04032VO> getKnvoList() {
		return knvoList;
	}
	public void setKnvoList(List<IGCOM04032VO> knvoList) {
		this.knvoList = knvoList;
	}
	public boolean isShowKnflag() {
		return showKnflag;
	}
	public void setShowKnflag(boolean showKnflag) {
		this.showKnflag = showKnflag;
	}
	public String getDayplans() {
		return dayplans;
	}
	public void setDayplans(String dayplans) {
		this.dayplans = dayplans;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		
		month =  String.valueOf((Integer.valueOf(month))<10?"0"+(Integer.valueOf(month)):(Integer.valueOf(month)));
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getBackyear() {
		if("01".equals(month)||"1".equals(month)){
			backyear = String.valueOf(Integer.valueOf(year)-1);
		}else{
			backyear = year;
		}
		return backyear;
	}
	public void setBackyear(String backyear) {
		this.backyear = backyear;
	}
	public String getBackmonth() {
		if("01".equals(month)||"1".equals(month)){
			backmonth = "12";
		}else{
			backmonth =  String.valueOf((Integer.valueOf(month)-1)<10?"0"+(Integer.valueOf(month)-1):(Integer.valueOf(month)-1));
		}
		return backmonth;
	}
	public void setBackmonth(String backmonth) {
		this.backmonth = backmonth;
	}
	public String getAfteryear() {
		if("12".equals(month)){
			afteryear = String.valueOf(Integer.valueOf(year)+1);
		}else{
			afteryear = year;
		}
		return afteryear;
	}
	public void setAfteryear(String afteryear) {
		this.afteryear = afteryear;
	}
	public String getAftermonth() {
		if("12".equals(month)){
			aftermonth = "01";
		}else{
			aftermonth =  String.valueOf((Integer.valueOf(month)+1)<10?"0"+(Integer.valueOf(month)+1):(Integer.valueOf(month)+1));
		}
		return aftermonth;
	}
	public void setAftermonth(String aftermonth) {
		this.aftermonth = aftermonth;
	}
	public List<IGCOM04032VO> getAppKnList() {
		return appKnList;
	}
	public void setAppKnList(List<IGCOM04032VO> appKnList) {
		this.appKnList = appKnList;
	}
	public List<CopyReadUserInfo> getCulistAsc() {
		return culistAsc;
	}
	public void setCulistAsc(List<CopyReadUserInfo> culistAsc) {
		this.culistAsc = culistAsc;
	}
	public List<CopyReadUserInfo> getCulistDesc() {
		return culistDesc;
	}
	public void setCulistDesc(List<CopyReadUserInfo> culistDesc) {
		this.culistDesc = culistDesc;
	}
	public boolean isIslimit() {
		return islimit;
	}
	public void setIslimit(boolean islimit) {
		this.islimit = islimit;
	}

	/**
	 * 业务系统可用性取得
	 * @return 业务系统可用性
	 */
	public List<BussinessAvailval> getLst_BussinessAvailval() {
		return lst_BussinessAvailval;
	}

	/**
	 * 业务系统可用性设定
	 * @param lst_BussinessAvailval 业务系统可用性
	 */
	public void setLst_BussinessAvailval(
			List<BussinessAvailval> lst_BussinessAvailval) {
		this.lst_BussinessAvailval = lst_BussinessAvailval;
	}

	/**
	 * Oracle告警取得
	 * @return Oracle告警
	 */
	public List<CRM06Info> getLst_CRM06Info() {
		return lst_CRM06Info;
	}

	/**
	 * Oracle告警设定
	 * @param lst_CRM06Info Oracle告警
	 */
	public void setLst_CRM06Info(List<CRM06Info> lst_CRM06Info) {
		this.lst_CRM06Info = lst_CRM06Info;
	}
	
}
