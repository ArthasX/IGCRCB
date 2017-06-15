package com.deliverik.infogovernor.dto;

import java.io.Serializable;
import java.util.List;

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
 * ��¼ҵ����DTO
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
	
	private String riliString;	//����html
	
	private boolean showKnflag;//�Ƿ����δ��ʾ��֪ʶ
	
	private IGCOM0201Form igcom0201Form;
	
	/** �û�Ȩ�� */
	private UserPermission userPermission;
	
	/** ��ҳURL */
	private String homepage;
	
	/** ��ҳ���� */
	private String usertype;
	
	/** ���˼�鹤������ */
	private List<RiskCheckResult> lst_RiskCheckResult_Asc;
	
	/** ���˼�鹤������ */
	private List<RiskCheckResult> lst_RiskCheckResult_Desc;
	
	/** ��ؼ�鹤������ */
	private List<RiskCheckResult> lst_RiskCheckResultGroup_Asc;
	
	/** ��ؼ�鹤������ */
	private List<RiskCheckResult> lst_RiskCheckResultGroup_Desc;
	
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


	/**
	 * ��ֹ�����̵���
	 */
	protected List<ProcessInHandVWInfo> processInHandDiscontinueDesc ;
	/**
	 * ��ֹ����������
	 */
	protected List<ProcessInHandVWInfo> processInHandDiscontinueAsc ;
	
	/** ҵ��ϵͳ������ */
	protected List<BussinessAvailval> lst_BussinessAvailval;
	
	/** Oracle�澯 */
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
	 * �û�Ȩ��ȡ��
	 * 
	 * @return �û�Ȩ��
	 */
	public UserPermission getUserPermission() {
		return userPermission;
	}

	/**
	 * �û�Ȩ���趨
	 * 
	 * @param userPermission �û�Ȩ��
	 */
	public void setUserPermission(UserPermission userPermission) {
		this.userPermission = userPermission;
	}

	/**
	 * ��ҳURLȡ��
	 * 
	 * @return ��ҳURL
	 */
	public String getHomepage() {
		return homepage;
	}

	/**
	 * ��ҳURL�趨
	 * 
	 * @param homepage ��ҳURL
	 */
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	/**
	 * ��ҳ����ȡ��
	 * 
	 * @return ��ҳ����
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * ��ҳ�����趨
	 * 
	 * @param usertype ��ҳ����
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	
	/** SOC���� 2013/01/31 **/
	/**
	 * �������ݼ������
	 */
	protected List<IG677Info> processRecordInfoList;
	/**
	 * �������ݼ������ȡ��
	 *
	 * @return processRecordInfoList �������ݼ������
	 */
	public List<IG677Info> getProcessRecordInfoList() {
		return processRecordInfoList;
	}
	/**
	 * �������ݼ�������趨
	 *
	 * @param processRecordInfoList �������ݼ������
	 */
	public void setProcessRecordInfoList(List<IG677Info> processRecordInfoList) {
		this.processRecordInfoList = processRecordInfoList;
	}

	/**
	 * �������ݼ������
	 */
	protected List<IG677Info> processRecordInfoListAsc;
	/**
	 * �������ݼ������ȡ��
	 *
	 * @return processRecordInfoListAsc �������ݼ������
	 */
	public List<IG677Info> getProcessRecordInfoListAsc() {
		return processRecordInfoListAsc;
	}
	/**
	 * �������ݼ�������趨
	 *
	 * @param processRecordInfoListAsc �������ݼ������
	 */
	public void setProcessRecordInfoListAsc(List<IG677Info> processRecordInfoListAsc) {
		this.processRecordInfoListAsc = processRecordInfoListAsc;
	}

	/**
	 * ��ȡȫ������ 
	 * ���� by yangliang 2010/12/01
	 */
	protected List<IG677Info> processRecordInfoALLList;
	/**
	 * ��ȡȫ������ȡ��
	 *
	 * @return processRecordInfoALLList ��ȡȫ������
	 */
	public List<IG677Info> getProcessRecordInfoALLList() {
		return processRecordInfoALLList;
	}
	/**
	 * ��ȡȫ������
	 *
	 * @param processRecordInfoALLList ��ȡȫ������
	 */
	public void setProcessRecordInfoALLList(List<IG677Info> processRecordInfoALLList) {
		this.processRecordInfoALLList = processRecordInfoALLList;
	}

	/**
	 * ��ȡȫ����������
	 * ���� by yangliang 2010/12/01
	 */
	protected List<IG677Info> processRecordInfoALLListAsc;
	
	/**
	 * ��ȡȫ����������ȡ��
	 *
	 * @return processRecordInfoALLListAsc ��ȡȫ����������
	 */
	public List<IG677Info> getProcessRecordInfoALLListAsc() {
		return processRecordInfoALLListAsc;
	}
	/**
	 * ��ȡȫ�����������趨
	 *
	 * @param processRecordInfoALLListAsc ��ȡȫ����������
	 */
	public void setProcessRecordInfoALLListAsc(
			List<IG677Info> processRecordInfoALLListAsc) {
		this.processRecordInfoALLListAsc = processRecordInfoALLListAsc;
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

	/**
	 * igaim0150Formȡ��
	 * @return igaim0150Form igaim0150Form
	 */
	public IGAIM0150Form getIgaim0150Form() {
		return igaim0150Form;
	}

	/**
	 * igaim0150Form�趨
	 * @param igaim0150Form igaim0150Form
	 */
	public void setIgaim0150Form(IGAIM0150Form igaim0150Form) {
		this.igaim0150Form = igaim0150Form;
	}
	
}