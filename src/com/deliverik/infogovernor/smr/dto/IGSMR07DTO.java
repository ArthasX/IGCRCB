/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * �����ڱ����ҵ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSMR07DTO extends BaseDTO implements Serializable{
	
	/** �û���Ϣ */
	protected User user;

	/** �����ڱ�����Form */
	protected IGSMR0701Form igSMR0701Form;
	
	/** ����ҳ�治���ڱ����б� */
	protected List<IG380Info> ig380List;
	
	/** �����ڱ����ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_arq;
	
	/** �����ڱ���һ��������ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_first;
	
	/** �����ڱ������������ѯ���*/
	protected List<RegulatoryReportInstanceInfo> second_list;
	
	/** ��鿴form*/
	protected IGSMR0703Form IGSMR0703Form;
	
	/** ��ʱ����form*/
	protected IGSMR0303Form igSMR0303Form;
	
	/** ��鿴��ѯ���*/
	protected Map<String,List<AnnualReportVW>> map_see;
	
	/** �����ڱ���ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc;
	
	/** һ���ȶ�ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc1;
	
	/** �����ȶ�ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc2;
	
	/** �����ȶ�ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc3;
	
	/** �ļ��ȶ�ʱ���Ѳ�ѯ���*/
	protected RemindConfigureInfo rc4;
	
	/** ʵ��ID */
	private	Integer instanceID;
		
	/** �����ڱ�������form*/
	private IGSMR0704Form igSMR0704Form;
	
	/** �����ڱ����б� */
	protected List<BatchExamineVW> lst_Report;
	
	/**
	 *�û���Ϣȡ��
	 */
	public User getUser() {
		return user;
	}

	/**
	 *�û���Ϣ�趨
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 *�����ڱ�����Formȡ��
	 */
	public IGSMR0701Form getIgSMR0701Form() {
		return igSMR0701Form;
	}

	/**
	 *�����ڱ�����Form�趨
	 */
	public void setIgSMR0701Form(IGSMR0701Form igSMR0701Form) {
		this.igSMR0701Form = igSMR0701Form;
	}

	/**
	 *����ҳ�治���ڱ����б�ȡ��
	 */
	public List<IG380Info> getIg380List() {
		return ig380List;
	}

	/**
	 *����ҳ�治���ڱ����б��趨
	 */
	public void setIg380List(List<IG380Info> ig380List) {
		this.ig380List = ig380List;
	}

	/**
	 *�����ڱ����ѯ���ȡ��
	 */
	public Map<String, List<AnnualReportVW>> getMap_arq() {
		return map_arq;
	}

	/**
	 *�����ڱ����ѯ����趨
	 */
	public void setMap_arq(Map<String, List<AnnualReportVW>> map_arq) {
		this.map_arq = map_arq;
	}

	/**
	 *�����ڱ���һ��������ѯ���ȡ��
	 */
	public Map<String, List<AnnualReportVW>> getMap_first() {
		return map_first;
	}

	/**
	 *�����ڱ���һ��������ѯ����趨
	 */
	public void setMap_first(Map<String, List<AnnualReportVW>> map_first) {
		this.map_first = map_first;
	}

	/**
	 *�����ڱ������������ѯ���ȡ��
	 */
	public List<RegulatoryReportInstanceInfo> getSecond_list() {
		return second_list;
	}

	/**
	 *�����ڱ������������ѯ����趨
	 */
	public void setSecond_list(List<RegulatoryReportInstanceInfo> second_list) {
		this.second_list = second_list;
	}

	/**
	 *��鿴formȡ��
	 */
	public IGSMR0703Form getIGSMR0703Form() {
		return IGSMR0703Form;
	}

	/**
	 *��鿴form�趨
	 */
	public void setIGSMR0703Form(IGSMR0703Form IGSMR0703Form) {
		this.IGSMR0703Form = IGSMR0703Form;
	}

	/**
	 *��ʱ����formȡ��
	 */
	public IGSMR0303Form getIgSMR0303Form() {
		return igSMR0303Form;
	}

	/**
	 *��ʱ����form�趨
	 */
	public void setIgSMR0303Form(IGSMR0303Form igSMR0303Form) {
		this.igSMR0303Form = igSMR0303Form;
	}

	/**
	 *��鿴��ѯ���ȡ��
	 */
	public Map<String, List<AnnualReportVW>> getMap_see() {
		return map_see;
	}

	/**
	 *��鿴��ѯ����趨
	 */
	public void setMap_see(Map<String, List<AnnualReportVW>> map_see) {
		this.map_see = map_see;
	}

	/**
	 *�����ڱ���ʱ���Ѳ�ѯ���ȡ��
	 */
	public RemindConfigureInfo getRc() {
		return rc;
	}

	/**
	 *�����ڱ���ʱ���Ѳ�ѯ����趨
	 */
	public void setRc(RemindConfigureInfo rc) {
		this.rc = rc;
	}

	/**
	 *һ���ȶ�ʱ���Ѳ�ѯ���ȡ��
	 */
	public RemindConfigureInfo getRc1() {
		return rc1;
	}

	/**
	 *һ���ȶ�ʱ���Ѳ�ѯ����趨
	 */
	public void setRc1(RemindConfigureInfo rc1) {
		this.rc1 = rc1;
	}

	/**
	 *�����ȶ�ʱ���Ѳ�ѯ���ȡ��
	 */
	public RemindConfigureInfo getRc2() {
		return rc2;
	}

	/**
	 *�����ȶ�ʱ���Ѳ�ѯ����趨
	 */
	public void setRc2(RemindConfigureInfo rc2) {
		this.rc2 = rc2;
	}

	/**
	 *�����ȶ�ʱ���Ѳ�ѯ���ȡ��
	 */
	public RemindConfigureInfo getRc3() {
		return rc3;
	}

	/**
	 *�����ȶ�ʱ���Ѳ�ѯ����趨
	 */
	public void setRc3(RemindConfigureInfo rc3) {
		this.rc3 = rc3;
	}

	/**
	 *�ļ��ȶ�ʱ���Ѳ�ѯ���ȡ��
	 */
	public RemindConfigureInfo getRc4() {
		return rc4;
	}

	/**
	 *�ļ��ȶ�ʱ���Ѳ�ѯ����趨
	 */
	public void setRc4(RemindConfigureInfo rc4) {
		this.rc4 = rc4;
	}

	/**
	 *ʵ��IDȡ��
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 *ʵ��ID�趨
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}



	/**
	 *�����ڱ�������formȡ��
	 */
	public IGSMR0704Form getIgSMR0704Form() {
		return igSMR0704Form;
	}

	/**
	 *�����ڱ�������form�趨
	 */
	public void setIgSMR0704Form(IGSMR0704Form igSMR0704Form) {
		this.igSMR0704Form = igSMR0704Form;
	}

	/**
	 *�����ڱ����б�ȡ��
	 */
	public List<BatchExamineVW> getLst_Report() {
		return lst_Report;
	}

	/**
	 *�����ڱ����б��趨
	 */
	public void setLst_Report(List<BatchExamineVW> lst_Report) {
		this.lst_Report = lst_Report;
	}

}
