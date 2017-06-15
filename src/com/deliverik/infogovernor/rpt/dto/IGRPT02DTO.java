/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.form.IGRPT0201Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0202Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0203Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0204Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0205Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0207Form;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;

/**
 * ����: 
 * ��������: 
 * ������¼: 2012/04/27
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT02DTO extends BaseDTO{
	
	/** �Զ��屨�� ���� */
	protected List<SOC0204Info> reportCustomLinkList_Pref;
	
	/** �Զ��屨�� ���� */
	protected List<SOC0204Info> reportCustomLinkList_Cap;

	/**
	 * �Զ��屨������ȡ��
	 *
	 * @return reportCustomLinkList_Pref �Զ��屨������
	 */
	public List<SOC0204Info> getReportCustomLinkList_Pref() {
		return reportCustomLinkList_Pref;
	}

	/**
	 * �Զ��屨������ȡ��
	 *
	 * @return reportCustomLinkList_Cap �Զ��屨������
	 */
	public List<SOC0204Info> getReportCustomLinkList_Cap() {
		return reportCustomLinkList_Cap;
	}

	/**
	 * �Զ��屨�������趨
	 *
	 * @param reportCustomLinkList_Pref �Զ��屨������
	 */
	public void setReportCustomLinkList_Pref(
			List<SOC0204Info> reportCustomLinkList_Pref) {
		this.reportCustomLinkList_Pref = reportCustomLinkList_Pref;
	}

	/**
	 * �Զ��屨�������趨
	 *
	 * @param reportCustomLinkList_Cap �Զ��屨������
	 */
	public void setReportCustomLinkList_Cap(
			List<SOC0204Info> reportCustomLinkList_Cap) {
		this.reportCustomLinkList_Cap = reportCustomLinkList_Cap;
	}

	/**ReportManageList*/
	protected List<SOC0205Info> soc0205List;
	
	/**ReportTemplateMappingList*/
	protected List<SOC0206Info> soc0206List;
	
	/**dmx codeDetail*/
	protected List<CodeDetail> dmx_list=new ArrayList<CodeDetail>();
	/**ibm codeDetail*/
	protected List<CodeDetail> ibm_list=new ArrayList<CodeDetail>();
	/**cx codeDetail*/
	protected List<CodeDetail> cx_list=new ArrayList<CodeDetail>();
	/**��ô洢ID*/
	protected List<MonitorObjectInfo> monitorObjectList=new ArrayList<MonitorObjectInfo>();
	
	/** �Զ������������ */
	protected SOC0207SearchCond soc0207SearchCond;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	/** ģ����������form */
	protected IGRPT0201Form iGRPT0201Form;
	/** ģ���ѯform */
	protected IGRPT0202Form iGRPT0202Form;
	/**�����ѯɾ��Form */
	protected IGRPT0204Form iGRPT0204Form;
	/**�����ѯɾ��Form */
	protected IGRPT0203Form iGRPT0203Form;
	
	protected List<SOC0207Info> reportTemplateList;
	
	/**���������޸�*/
	protected IGRPT0205Form igrpt0205Form;

	/**���渽��Form*/
	protected IGRPT0207Form igrpt0207Form;
	/**��ǰ�û�*/
	protected User curUser;
	/**���ӱ���*/
	List<SOC0202Info> raInfoList;
	/**��������*/
	protected String reportName;
	/**
	 * reportTemplateListȡ��
	 *
	 * @return reportTemplateList reportTemplateList
	 */
	public List<SOC0207Info> getReportTemplateList() {
		return reportTemplateList;
	}

	/**
	 * reportTemplateList�趨
	 *
	 * @param reportTemplateList reportTemplateList
	 */
	public void setReportTemplateList(List<SOC0207Info> reportTemplateList) {
		this.reportTemplateList = reportTemplateList;
	}

	/**
	 * iGRPT0201Formȡ��
	 *
	 * @return iGRPT0201Form iGRPT0201Form
	 */
	public IGRPT0201Form getIGRPT0201Form() {
		return iGRPT0201Form;
	}

	/**
	 * iGRPT0201Form�趨
	 *
	 * @param form iGRPT0201Form
	 */
	public void setIGRPT0201Form(IGRPT0201Form form) {
		iGRPT0201Form = form;
	}

	/**
	 * �Զ������������ȡ��
	 *
	 * @return soc0207SearchCond �Զ������������
	 */
	public SOC0207SearchCond getSoc0207SearchCond() {
		return soc0207SearchCond;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return maxSearchCount ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 *
	 * @return pagingDto ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * �Զ�������������趨
	 *
	 * @param soc0207SearchCond �Զ������������
	 */
	public void setSoc0207SearchCond(
			SOC0207SearchCond soc0207SearchCond) {
		this.soc0207SearchCond = soc0207SearchCond;
	}

	/**
	 * �����������趨
	 *
	 * @param maxSearchCount ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTO�趨
	 *
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * messageListȡ��
	 *
	 * @return messageList messageList
	 */
	public List<ActionMessage> getMessageList() {
		return messageList;
	}

	/**
	 * messageList�趨
	 *
	 * @param messageList messageList
	 */
	public void setMessageList(List<ActionMessage> messageList) {
		this.messageList = messageList;
	}

	/**
	 * ��ô洢IDȡ��
	 *
	 * @return monitorObjectList ��ô洢ID
	 */
	public List<MonitorObjectInfo> getMonitorObjectList() {
		return monitorObjectList;
	}

	/**
	 * ��ô洢ID�趨
	 *
	 * @param monitorObjectList ��ô洢ID
	 */
	public void setMonitorObjectList(List<MonitorObjectInfo> monitorObjectList) {
		this.monitorObjectList = monitorObjectList;
	}

	/**
	 * ���������޸�ȡ��
	 *
	 * @return igrpt0205Form ���������޸�
	 */
	public IGRPT0205Form getIgrpt0205Form() {
		return igrpt0205Form;
	}

	/**
	 * ���������޸��趨
	 *
	 * @param igrpt0205Form ���������޸�
	 */
	public void setIgrpt0205Form(IGRPT0205Form igrpt0205Form) {
		this.igrpt0205Form = igrpt0205Form;
	}

	/**
	 * iGRPT0202Formȡ��
	 *
	 * @return iGRPT0202Form iGRPT0202Form
	 */
	public IGRPT0202Form getIGRPT0202Form() {
		return iGRPT0202Form;
	}

	/**
	 * iGRPT0202Form�趨
	 *
	 * @param form iGRPT0202Form
	 */
	public void setIGRPT0202Form(IGRPT0202Form form) {
		iGRPT0202Form = form;
	}

	/**
	 * dmxcodeDetailȡ��
	 *
	 * @return dmx_list dmxcodeDetail
	 */
	public List<CodeDetail> getDmx_list() {
		return dmx_list;
	}

	/**
	 * ibmcodeDetailȡ��
	 *
	 * @return ibm_list ibmcodeDetail
	 */
	public List<CodeDetail> getIbm_list() {
		return ibm_list;
	}

	/**
	 * cxcodeDetailȡ��
	 *
	 * @return cx_list cxcodeDetail
	 */
	public List<CodeDetail> getCx_list() {
		return cx_list;
	}

	/**
	 * dmxcodeDetail�趨
	 *
	 * @param dmx_list dmxcodeDetail
	 */
	public void setDmx_list(List<CodeDetail> dmx_list) {
		this.dmx_list = dmx_list;
	}

	/**
	 * ibmcodeDetail�趨
	 *
	 * @param ibm_list ibmcodeDetail
	 */
	public void setIbm_list(List<CodeDetail> ibm_list) {
		this.ibm_list = ibm_list;
	}

	/**
	 * cxcodeDetail�趨
	 *
	 * @param cx_list cxcodeDetail
	 */
	public void setCx_list(List<CodeDetail> cx_list) {
		this.cx_list = cx_list;
	}

	/**
	 * ReportTemplateMappingListȡ��
	 *
	 * @return soc0206List SOC0206List
	 */
	public List<SOC0206Info> getSoc0206List() {
		return soc0206List;
	}

	/**
	 * ReportTemplateMappingList�趨
	 *
	 * @param soc0206List SOC0206List
	 */
	public void setSoc0206List(
			List<SOC0206Info> soc0206List) {
		this.soc0206List = soc0206List;
	}

	/**
	 * �����ѯɾ��Formȡ��
	 *
	 * @return iGRPT0204Form �����ѯɾ��Form
	 */
	public IGRPT0204Form getIGRPT0204Form() {
		return iGRPT0204Form;
	}

	/**
	 * �����ѯɾ��Form�趨
	 *
	 * @param form iGRPT0204Form
	 */
	public void setIGRPT0204Form(IGRPT0204Form form) {
		iGRPT0204Form = form;
	}

	/**
	 * ���渽��Formȡ��
	 *
	 * @return igrpt0207Form ���渽��Form
	 */
	public IGRPT0207Form getIgrpt0207Form() {
		return igrpt0207Form;
	}

	/**
	 * ���渽��Form�趨
	 *
	 * @param igrpt0207Form ���渽��Form
	 */
	public void setIgrpt0207Form(IGRPT0207Form igrpt0207Form) {
		this.igrpt0207Form = igrpt0207Form;
	}

	/**
	 * ��ǰ�û�ȡ��
	 *
	 * @return curUser ��ǰ�û�
	 */
	public User getCurUser() {
		return curUser;
	}

	/**
	 * ��ǰ�û��趨
	 *
	 * @param curUser ��ǰ�û�
	 */
	public void setCurUser(User curUser) {
		this.curUser = curUser;
	}

	/**
	 * ���ӱ���ȡ��
	 *
	 * @return raInfoList ���ӱ���
	 */
	public List<SOC0202Info> getRaInfoList() {
		return raInfoList;
	}

	/**
	 * ���ӱ����趨
	 *
	 * @param raInfoList ���ӱ���
	 */
	public void setRaInfoList(List<SOC0202Info> raInfoList) {
		this.raInfoList = raInfoList;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return reportName ��������
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * ���������趨
	 *
	 * @param reportName ��������
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/**
	 * ReportManageListȡ��
	 *
	 * @return soc0205List SOC0205List
	 */
	public List<SOC0205Info> getSoc0205List() {
		return soc0205List;
	}

	/**
	 * ReportManageList�趨
	 *
	 * @param soc0205List SOC0205List
	 */
	public void setSoc0205List(List<SOC0205Info> soc0205List) {
		this.soc0205List = soc0205List;
	}

	/**
	 * �����ѯɾ��Formȡ��
	 *
	 * @return iGRPT0203Form �����ѯɾ��Form
	 */
	public IGRPT0203Form getIGRPT0203Form() {
		return iGRPT0203Form;
	}

	/**
	 * �����ѯɾ��Form�趨
	 *
	 * @param form iGRPT0203Form
	 */
	public void setIGRPT0203Form(IGRPT0203Form form) {
		iGRPT0203Form = form;
	}


	
}
