/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.form.IGSMR0101Form;
import com.deliverik.infogovernor.smr.form.IGSMR0601Form;
import com.deliverik.infogovernor.smr.form.IGSMR0602Form;
import com.deliverik.infogovernor.smr.form.IGSMR0603Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;

/**
 * ����:���� 
 * ��������������
 * �����ˣ�����͢
 * ������¼�� 2013-08-07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR06DTO extends BaseDTO {

	/** �û���Ϣ */
	protected User user;
	
	/** ��������Form */
	protected IGSMR0601Form igSMR0601Form;
	
	/** �����߰�Form */
	protected IGSMR0602Form igSMR0602Form;
		
	/** �����߰�Form */
	protected IGSMR0603Form igSMR0603Form;
	/** ���������Ϣ */
	protected ApproveSuggestionInfo approveSuggestionInfo;
	
	/** ���������Ϣ���� */
	protected List<ApproveSuggestionInfo> lstApproveSuggestionInfo;
	
	/** ������ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_arq;
	
	/** ����һ��������ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_first;
	
	/** ��������������ѯ���*/
	protected List<RegulatoryReportInstanceInfo> second_list;
	
	/** ��鿴��ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_see;
	
	/** �����б� */
	protected List<BatchExamineVW> lst_Report;
	
	/** ʵ��ID */
	private	Integer instanceID;
	
	/**
	 * ���������Ϣ����ȡ��
	 *
	 * @return lstApproveSuggestionInfo ���������Ϣ����
	 */
	public List<ApproveSuggestionInfo> getLstApproveSuggestionInfo() {
		return lstApproveSuggestionInfo;
	}

	/**
	 * ���������Ϣ�����趨
	 *
	 * @param lstApproveSuggestionInfo ���������Ϣ����
	 */
	public void setLstApproveSuggestionInfo(
			List<ApproveSuggestionInfo> lstApproveSuggestionInfo) {
		this.lstApproveSuggestionInfo = lstApproveSuggestionInfo;
	}

	/**
	 * ���������Ϣȡ��
	 *
	 * @return approveSuggestionInfo ���������Ϣ
	 */
	public ApproveSuggestionInfo getApproveSuggestionInfo() {
		return approveSuggestionInfo;
	}

	/**
	 * ���������Ϣ�趨
	 *
	 * @param approveSuggestionInfo ���������Ϣ
	 */
	public void setApproveSuggestionInfo(ApproveSuggestionInfo approveSuggestionInfo) {
		this.approveSuggestionInfo = approveSuggestionInfo;
	}

	/**
	 * �û���Ϣȡ��
	 * 
	 * @return �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * 
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ��������Formȡ��
	 * 
	 * @return �걨����Form
	 */
	public IGSMR0601Form getIgSMR0601Form() {
		return igSMR0601Form;
	}

	/**
	 * ��������Form�趨
	 * 
	 * @param igSMR0101Form �걨����Form
	 */
	public void setIgSMR0601Form(IGSMR0601Form igSMR0601Form) {
		this.igSMR0601Form = igSMR0601Form;
	}
	
	/**
	 * ������ѯ���ȡ��
	 * 
	 * @return ������ѯ���
	 */
	public Map<String, List<AnnualReportVW>> getMap_arq() {
		return map_arq;
	}

	
	/**
	 * ������ѯ����趨
	 * 
	 * @param arqMap ������ѯ���
	 */
	public void setMap_arq(Map<String, List<AnnualReportVW>> map_arq) {
		this.map_arq = map_arq;
	}
	
	/**
	 * ����һ��������ѯ���ȡ��
	 * 
	 * @return ����һ��������ѯ���
	 */
	public Map<String, List<AnnualReportVW>> getMap_first() {
		return map_first;
	}

	/**
	 * ����һ��������ѯ����趨
	 * 
	 * @param map_first ����һ��������ѯ���
	 */
	public void setMap_first(Map<String, List<AnnualReportVW>> map_first) {
		this.map_first = map_first;
	}
	/**
	 * ��������������ѯ���ȡ��
	 * 
	 * @return ���걨����������ѯ���
	 */
	public List<RegulatoryReportInstanceInfo> getSecond_list() {
		return second_list;
	}

	/**
	 * ���걨����������ѯ����趨
	 * 
	 * @param second_list ��������������ѯ���
	 */
	public void setSecond_list(List<RegulatoryReportInstanceInfo> second_list) {
		this.second_list = second_list;
	}
	/**
	 * ��鿴��ѯ���ȡ��
	 * 
	 * @return ��鿴��ѯ���
	 */
	public Map<String, List<AnnualReportVW>> getMap_see() {
		return map_see;
	}

	/**
	 * ��鿴��ѯ����趨
	 * 
	 * @param list_rri ��鿴��ѯ���
	 */
	public void setMap_see(Map<String, List<AnnualReportVW>> map_see) {
		this.map_see = map_see;
	}
	/**
	 * �����߰�Formȡ��
	 * 
	 * @return �����߰�Form
	 */
	public IGSMR0602Form getIgSMR0602Form() {
		return igSMR0602Form;
	}
	/**
	 * �����߰�Form�趨
	 * 
	 * @param igSMR0602Form �����߰�Form
	 */
	public void setIgSMR0602Form(IGSMR0602Form igSMR0602Form) {
		this.igSMR0602Form = igSMR0602Form;
	}
	/**
	 * �����б�ȡ��
	 * 
	 * @return �����б�
	 */
	public List<BatchExamineVW> getLst_Report() {
		return lst_Report;
	}

	/**
	 * �����б��趨
	 * 
	 * @param lst_Report �����б�
	 */
	public void setLst_Report(List<BatchExamineVW> lst_Report) {
		this.lst_Report = lst_Report;
	}
	/**
	 * ʵ��IDȡ��
	 * 
	 * @return ʵ��ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * ʵ��ID�趨
	 * 
	 * @param instanceID ʵ��ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}
	/**
	 * �����߰�Formȡ��
	 * 
	 * @return �����߰�Form
	 */
	public IGSMR0603Form getIgSMR0603Form() {
		return igSMR0603Form;
	}
	/**
	 * �����߰�Form�趨
	 * 
	 * @param igSMR0603Form �����߰�Form
	 */
	public void setIgSMR0603Form(IGSMR0603Form igSMR0603Form) {
		this.igSMR0603Form = igSMR0603Form;
	}
	
	
}
