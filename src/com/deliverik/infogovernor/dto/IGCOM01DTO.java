package com.deliverik.infogovernor.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserSearchCond;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.aim.form.IGAIM0150Form;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.form.IGCOM0101Form;
import com.deliverik.infogovernor.form.IGCOM0201Form;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.vo.IGCOM04032VO;


/**
 * 登录业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCOM01DTO extends BaseDTO implements Serializable{

	protected IGAIM0150Form igaim0150Form;
	
	protected UserSearchCond userSearchCond;

	protected User user;
	
	protected List<UserRoleInfo> userRoleInfoList;
	
	protected IGCOM0101Form iGCOM0101Form;
	
	protected List<ProcessInHandVWInfo> pihListDesc ;
	
	protected List<ProcessInHandVWInfo> pihListAsc ;
	
	protected List<ProcessInHandVWInfo> pihGroupListDesc ;
	
	protected List<ProcessInHandVWInfo> pihGroupListAsc ;
	
	private List<IGCOM04032VO> knvoList;
	
	private List<IGCOM04032VO> appKnList;
	
	private List<String> noticeList;
	
	private String riliString;	//日历html
	
	private boolean showKnflag;//是否存在未显示的知识
	
	private IGCOM0201Form igcom0201Form;
	
	/** 用户权限 */
	private UserPermission userPermission;
	
	/** 首页URL */
	private String homepage;
	
	/** 首页类型 */
	private String usertype;
	
	/** 个人检查工作正序 */
	private List<RiskCheckResult> lst_RiskCheckResult_Asc;
	
	/** 个人检查工作倒序 */
	private List<RiskCheckResult> lst_RiskCheckResult_Desc;
	
	/** 相关检查工作正序 */
	private List<RiskCheckResult> lst_RiskCheckResultGroup_Asc;
	
	/** 相关检查工作倒序 */
	private List<RiskCheckResult> lst_RiskCheckResultGroup_Desc;
	
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


	/**
	 * 中止的流程倒序
	 */
	protected List<ProcessInHandVWInfo> processInHandDiscontinueDesc ;
	/**
	 * 中止的流程正序
	 */
	protected List<ProcessInHandVWInfo> processInHandDiscontinueAsc ;
	
	/** 业务系统可用性 */
	protected List<BussinessAvailval> lst_BussinessAvailval;
	
	/** Oracle告警 */
	protected List<CRM06Info> lst_CRM06Info;

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

	/**
	 * 
	 * @return 
	 */
	public UserSearchCond getUserSearchCond() {
	    return this.userSearchCond;
	}

	/**
	 * 
	 * @param user_id 
	 */
	public void setUserSearchCond(UserSearchCond userSearchCond) {
	    this.userSearchCond = userSearchCond;
	}

	/**
	 * 
	 * @return 
	 */
	public User getUser() {
	    return user;
	}

	/**
	 * 
	 * @param user
	 */
	public void setUser(User user) {
	    this.user = user;
	}
	
	public List<UserRoleInfo> getUserRoleInfoList() {
		return userRoleInfoList;
	}

	public void setUserRoleInfoList(List<UserRoleInfo> userRoleInfoList) {
		this.userRoleInfoList = userRoleInfoList;
	}

	public IGCOM0101Form getIGCOM0101Form() {
		return iGCOM0101Form;
	}

	public void setIGCOM0101Form(IGCOM0101Form form) {
		iGCOM0101Form = form;
	}

	public List<ProcessInHandVWInfo> getPihListDesc() {
		return pihListDesc;
	}

	public void setPihListDesc(List<ProcessInHandVWInfo> pihListDesc) {
		this.pihListDesc = pihListDesc;
	}

	public List<ProcessInHandVWInfo> getPihListAsc() {
		return pihListAsc;
	}

	public void setPihListAsc(List<ProcessInHandVWInfo> pihListAsc) {
		this.pihListAsc = pihListAsc;
	}

	public List<ProcessInHandVWInfo> getPihGroupListDesc() {
		return pihGroupListDesc;
	}

	public void setPihGroupListDesc(List<ProcessInHandVWInfo> pihGroupListDesc) {
		this.pihGroupListDesc = pihGroupListDesc;
	}

	public List<ProcessInHandVWInfo> getPihGroupListAsc() {
		return pihGroupListAsc;
	}

	public void setPihGroupListAsc(List<ProcessInHandVWInfo> pihGroupListAsc) {
		this.pihGroupListAsc = pihGroupListAsc;
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

	public List<String> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<String> noticeList) {
		this.noticeList = noticeList;
	}

	public String getRiliString() {
		return riliString;
	}

	public void setRiliString(String riliString) {
		this.riliString = riliString;
	}

	public IGCOM0201Form getIgcom0201Form() {
		return igcom0201Form;
	}

	public void setIgcom0201Form(IGCOM0201Form igcom0201Form) {
		this.igcom0201Form = igcom0201Form;
	}

	public List<IGCOM04032VO> getAppKnList() {
		return appKnList;
	}

	public void setAppKnList(List<IGCOM04032VO> appKnList) {
		this.appKnList = appKnList;
	}

	/**
	 * 用户权限取得
	 * 
	 * @return 用户权限
	 */
	public UserPermission getUserPermission() {
		return userPermission;
	}

	/**
	 * 用户权限设定
	 * 
	 * @param userPermission 用户权限
	 */
	public void setUserPermission(UserPermission userPermission) {
		this.userPermission = userPermission;
	}

	/**
	 * 首页URL取得
	 * 
	 * @return 首页URL
	 */
	public String getHomepage() {
		return homepage;
	}

	/**
	 * 首页URL设定
	 * 
	 * @param homepage 首页URL
	 */
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	/**
	 * 首页类型取得
	 * 
	 * @return 首页类型
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * 首页类型设定
	 * 
	 * @param usertype 首页类型
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	
	/** SOC新增 2013/01/31 **/
	/**
	 * 流程内容检索结果
	 */
	protected List<IG677Info> processRecordInfoList;
	/**
	 * 流程内容检索结果取得
	 *
	 * @return processRecordInfoList 流程内容检索结果
	 */
	public List<IG677Info> getProcessRecordInfoList() {
		return processRecordInfoList;
	}
	/**
	 * 流程内容检索结果设定
	 *
	 * @param processRecordInfoList 流程内容检索结果
	 */
	public void setProcessRecordInfoList(List<IG677Info> processRecordInfoList) {
		this.processRecordInfoList = processRecordInfoList;
	}

	/**
	 * 流程内容检索结果
	 */
	protected List<IG677Info> processRecordInfoListAsc;
	/**
	 * 流程内容检索结果取得
	 *
	 * @return processRecordInfoListAsc 流程内容检索结果
	 */
	public List<IG677Info> getProcessRecordInfoListAsc() {
		return processRecordInfoListAsc;
	}
	/**
	 * 流程内容检索结果设定
	 *
	 * @param processRecordInfoListAsc 流程内容检索结果
	 */
	public void setProcessRecordInfoListAsc(List<IG677Info> processRecordInfoListAsc) {
		this.processRecordInfoListAsc = processRecordInfoListAsc;
	}

	/**
	 * 获取全部流程 
	 * 创建 by yangliang 2010/12/01
	 */
	protected List<IG677Info> processRecordInfoALLList;
	/**
	 * 获取全部流程取得
	 *
	 * @return processRecordInfoALLList 获取全部流程
	 */
	public List<IG677Info> getProcessRecordInfoALLList() {
		return processRecordInfoALLList;
	}
	/**
	 * 获取全部流程
	 *
	 * @param processRecordInfoALLList 获取全部流程
	 */
	public void setProcessRecordInfoALLList(List<IG677Info> processRecordInfoALLList) {
		this.processRecordInfoALLList = processRecordInfoALLList;
	}

	/**
	 * 获取全部流程排序
	 * 创建 by yangliang 2010/12/01
	 */
	protected List<IG677Info> processRecordInfoALLListAsc;
	
	/**
	 * 获取全部流程排序取得
	 *
	 * @return processRecordInfoALLListAsc 获取全部流程排序
	 */
	public List<IG677Info> getProcessRecordInfoALLListAsc() {
		return processRecordInfoALLListAsc;
	}
	/**
	 * 获取全部流程排序设定
	 *
	 * @param processRecordInfoALLListAsc 获取全部流程排序
	 */
	public void setProcessRecordInfoALLListAsc(
			List<IG677Info> processRecordInfoALLListAsc) {
		this.processRecordInfoALLListAsc = processRecordInfoALLListAsc;
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

	/**
	 * igaim0150Form取得
	 * @return igaim0150Form igaim0150Form
	 */
	public IGAIM0150Form getIgaim0150Form() {
		return igaim0150Form;
	}

	/**
	 * igaim0150Form设定
	 * @param igaim0150Form igaim0150Form
	 */
	public void setIgaim0150Form(IGAIM0150Form igaim0150Form) {
		this.igaim0150Form = igaim0150Form;
	}
	
}