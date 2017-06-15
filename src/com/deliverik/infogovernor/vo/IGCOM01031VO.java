package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
public class IGCOM01031VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * �����е����̵���
	 */
	protected List<ProcessInHandVWInfo> processInHandDesc ;
	/**
	 * �����е���������
	 */
	protected List<ProcessInHandVWInfo> processInHandAsc ;
	
	/**
	 * �����е����̵���
	 */
	protected List<ProcessInHandVWInfo> processInHandGroupDesc ;
	/**
	 * �����е���������
	 */
	protected List<ProcessInHandVWInfo> processInHandGroupAsc ;
	
	/**
	 * ��ֹ�����̵���
	 */
	protected List<ProcessInHandVWInfo> processInHandDiscontinueDesc ;
	/**
	 * ��ֹ����������
	 */
	protected List<ProcessInHandVWInfo> processInHandDiscontinueAsc ;

	
	
	protected List<CopyReadUserInfo>  culistAsc;
	
	protected List<CopyReadUserInfo>  culistDesc;
	private List<IGCOM04032VO> knvoList;
	
	private List<IGCOM04032VO> appKnList;
	
	private List<String> noticeList;
	
	private String dayplans;
	
	private boolean showKnflag;//�Ƿ����δ��ʾ��֪ʶ
	
	private String year;
	
	private String month;
	
	private String backyear;
	
	private String backmonth;
	
	private String afteryear;
	
	private String aftermonth;
	
	/** �Ƿ������ҳ��ܱ���tableȨ��*/
	private boolean islimit;
	
	/** ҵ��ϵͳ������ */
	protected List<BussinessAvailval> lst_BussinessAvailval;
	
	/** Oracle�澯 */
	protected List<CRM06Info> lst_CRM06Info;
	
	/** ���˼�鹤������ */
	private List<RiskCheckResult> lst_RiskCheckResult_Asc;
	
	/** ���˼�鹤������ */
	private List<RiskCheckResult> lst_RiskCheckResult_Desc;
	
	/** ��ؼ�鹤������ */
	private List<RiskCheckResult> lst_RiskCheckResultGroup_Asc;
	
	/** ��ؼ�鹤������ */
	private List<RiskCheckResult> lst_RiskCheckResultGroup_Desc;
	
	/** ϵͳ��ǰʱ�� */
	private String riskChecktime;
	
	/**
	 * ϵͳ��ǰʱ���ȡ
	 * 
	 * @return ϵͳ��ǰʱ��
	 */
	public String getRiskChecktime() {
		return riskChecktime;
	}

	/**
	 * ϵͳ��ǰʱ������
	 * 
	 * @param riskChecktime ϵͳ��ǰʱ��
	 */
	public void setRiskChecktime(String riskChecktime) {
		this.riskChecktime = riskChecktime;
	}

	/**
	 * ���˼�鹤�������ȡ
	 * 
	 * @return ��鹤������
	 */
	public List<RiskCheckResult> getLst_RiskCheckResult_Asc() {
		return lst_RiskCheckResult_Asc;
	}

	/**
	 * ���˼�鹤����������
	 * 
	 * @param lst_RiskCheckResult_Asc ��鹤������
	 */
	public void setLst_RiskCheckResult_Asc(
			List<RiskCheckResult> lst_RiskCheckResult_Asc) {
		this.lst_RiskCheckResult_Asc = lst_RiskCheckResult_Asc;
	}

	/**
	 * ���˼�鹤�������ȡ
	 * 
	 * @return ���˼�鹤������
	 */
	public List<RiskCheckResult> getLst_RiskCheckResult_Desc() {
		return lst_RiskCheckResult_Desc;
	}

	/**
	 * ���˼�鹤����������
	 * 
	 * @param lst_RiskCheckResult_Desc ���˼�鹤������
	 */
	public void setLst_RiskCheckResult_Desc(
			List<RiskCheckResult> lst_RiskCheckResult_Desc) {
		this.lst_RiskCheckResult_Desc = lst_RiskCheckResult_Desc;
	}

	/**
	 * ��ؼ�鹤�������ȡ
	 * 
	 * @return ��ؼ�鹤������
	 */
	public List<RiskCheckResult> getLst_RiskCheckResultGroup_Asc() {
		return lst_RiskCheckResultGroup_Asc;
	}

	/**
	 * ��ؼ�鹤����������
	 * 
	 * @param lst_RiskCheckResultGroup_Asc ��ؼ�鹤������
	 */
	public void setLst_RiskCheckResultGroup_Asc(
			List<RiskCheckResult> lst_RiskCheckResultGroup_Asc) {
		this.lst_RiskCheckResultGroup_Asc = lst_RiskCheckResultGroup_Asc;
	}

	/**
	 * ��ؼ�鹤�������ȡ
	 * 
	 * @return ��ؼ�鹤������
	 */
	public List<RiskCheckResult> getLst_RiskCheckResultGroup_Desc() {
		return lst_RiskCheckResultGroup_Desc;
	}

	/**
	 * ��ؼ�鹤����������
	 * 
	 * @param lst_RiskCheckResultGroup_Desc ��ؼ�鹤������
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
	 * ҵ��ϵͳ������ȡ��
	 * @return ҵ��ϵͳ������
	 */
	public List<BussinessAvailval> getLst_BussinessAvailval() {
		return lst_BussinessAvailval;
	}

	/**
	 * ҵ��ϵͳ�������趨
	 * @param lst_BussinessAvailval ҵ��ϵͳ������
	 */
	public void setLst_BussinessAvailval(
			List<BussinessAvailval> lst_BussinessAvailval) {
		this.lst_BussinessAvailval = lst_BussinessAvailval;
	}

	/**
	 * Oracle�澯ȡ��
	 * @return Oracle�澯
	 */
	public List<CRM06Info> getLst_CRM06Info() {
		return lst_CRM06Info;
	}

	/**
	 * Oracle�澯�趨
	 * @param lst_CRM06Info Oracle�澯
	 */
	public void setLst_CRM06Info(List<CRM06Info> lst_CRM06Info) {
		this.lst_CRM06Info = lst_CRM06Info;
	}
	
}
