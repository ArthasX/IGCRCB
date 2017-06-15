/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
 * ����: ��������޸�Form
 * ��������: 
 * ������¼: 2012/06/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT0205Form extends BaseForm implements SOC0205Info{
	
	/**ҳ��select*/
	protected String selRmYear;
	protected String selRmQuarter;
	protected String selRmMonth;
	protected String selTemplate;
	
	/**��¼��������*/
	protected String dateType;
	/**����0 �޸�1*/
	protected String mode;

	
	/**id*/
	protected Integer rmId;

	/** �������� */
	protected String rmName;

	/** �� */
	protected String rmYear;

	/** ���� */
	protected String rmQuarter;
	/**ģ������ȡ��*/
	protected String rtName;
	
	/** �� */
	protected String rmMonth;

	/** ����ʱ�� */
	protected String createDate;
	/**ģ�����*/
	protected String rtId;
	
	/** ���� */
	protected String rmDateType;
	/** ���һ�� */
	protected String rmLastDay;
	
	/** ����IDS */
	protected String[] anIds;
	
	/**ȷ��ɾ����*/
	protected String isDel;
	/**
	 * rmIdȡ��
	 *
	 * @return rmId rmId
	 */
	public Integer getRmId() {
		return rmId;
	}
	/**
	 * rmId�趨
	 *
	 * @param rmId rmId
	 */
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}
	/**
	 * ��������ȡ��
	 *
	 * @return rmName ��������
	 */
	public String getRmName() {
		return rmName;
	}
	/**
	 * ���������趨
	 *
	 * @param rmName ��������
	 */
	public void setRmName(String rmName) {
		this.rmName = rmName;
	}
	/**
	 * ��ȡ��
	 *
	 * @return rmYear ��
	 */
	public String getRmYear() {
		return rmYear;
	}
	/**
	 * ���趨
	 *
	 * @param rmYear ��
	 */
	public void setRmYear(String rmYear) {
		this.rmYear = rmYear;
	}
	/**
	 * ����ȡ��
	 *
	 * @return rmQuarter ����
	 */
	public String getRmQuarter() {
		return rmQuarter;
	}
	/**
	 * �����趨
	 *
	 * @param rmQuarter ����
	 */
	public void setRmQuarter(String rmQuarter) {
		this.rmQuarter = rmQuarter;
	}
	/**
	 * ��ȡ��
	 *
	 * @return rmMonth ��
	 */
	public String getRmMonth() {
		return rmMonth;
	}
	/**
	 * ���趨
	 *
	 * @param rmMonth ��
	 */
	public void setRmMonth(String rmMonth) {
		this.rmMonth = rmMonth;
	}
	/**
	 * ����ʱ��ȡ��
	 *
	 * @return createDate ����ʱ��
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * ����ʱ���趨
	 *
	 * @param createDate ����ʱ��
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * ģ�����ȡ��
	 *
	 * @return rtId ģ�����
	 */
	public String getRtId() {
		return rtId;
	}
	/**
	 * ģ������趨
	 *
	 * @param rtId ģ�����
	 */
	public void setRtId(String rtId) {
		this.rtId = rtId;
	}
	/**
	 * ����0�޸�1ȡ��
	 *
	 * @return mode ����0�޸�1
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * ����0�޸�1�趨
	 *
	 * @param mode ����0�޸�1
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * ��¼��������ȡ��
	 *
	 * @return dateType ��¼��������
	 */
	public String getDateType() {
		return dateType;
	}
	/**
	 * ��¼���������趨
	 *
	 * @param dateType ��¼��������
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	/**
	 * ҳ��selectȡ��
	 *
	 * @return selRmYear ҳ��select
	 */
	public String getSelRmYear() {
		return selRmYear;
	}
	/**
	 * selRmQuarterȡ��
	 *
	 * @return selRmQuarter selRmQuarter
	 */
	public String getSelRmQuarter() {
		return selRmQuarter;
	}
	/**
	 * selRmMonthȡ��
	 *
	 * @return selRmMonth selRmMonth
	 */
	public String getSelRmMonth() {
		return selRmMonth;
	}
	/**
	 * selTemplateȡ��
	 *
	 * @return selTemplate selTemplate
	 */
	public String getSelTemplate() {
		return selTemplate;
	}
	/**
	 * ҳ��select�趨
	 *
	 * @param selRmYear ҳ��select
	 */
	public void setSelRmYear(String selRmYear) {
		this.selRmYear = selRmYear;
	}
	/**
	 * selRmQuarter�趨
	 *
	 * @param selRmQuarter selRmQuarter
	 */
	public void setSelRmQuarter(String selRmQuarter) {
		this.selRmQuarter = selRmQuarter;
	}
	/**
	 * selRmMonth�趨
	 *
	 * @param selRmMonth selRmMonth
	 */
	public void setSelRmMonth(String selRmMonth) {
		this.selRmMonth = selRmMonth;
	}
	/**
	 * selTemplate�趨
	 *
	 * @param selTemplate selTemplate
	 */
	public void setSelTemplate(String selTemplate) {
		this.selTemplate = selTemplate;
	}
	//
	public String getLastAnnexationDate() {
		//
		return null;
	}
	//
	public SOC0207TB getReportTemplateTB() {
		//
		return null;
	}
	//
	public String getFingerPrint() {
		//
		return null;
	}
	/**
	 * ����ȡ��
	 *
	 * @return rmDateType ����
	 */
	public String getRmDateType() {
		return rmDateType;
	}
	/**
	 * �����趨
	 *
	 * @param rmDateType ����
	 */
	public void setRmDateType(String rmDateType) {
		this.rmDateType = rmDateType;
	}
	/**
	 * ���һ��ȡ��
	 *
	 * @return rmLastDay ���һ��
	 */
	public String getRmLastDay() {
		return rmLastDay;
	}
	/**
	 * ���һ���趨
	 *
	 * @param rmLastDay ���һ��
	 */
	public void setRmLastDay(String rmLastDay) {
		this.rmLastDay = rmLastDay;
	}
	/**
	 * ģ������ȡ��ȡ��
	 *
	 * @return rtName ģ������ȡ��
	 */
	public String getRtName() {
		return rtName;
	}
	/**
	 * ģ������ȡ���趨
	 *
	 * @param rtName ģ������ȡ��
	 */
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}
	/**
	 * ����IDSȡ��
	 *
	 * @return anIds ����IDS
	 */
	public String[] getAnIds() {
		return anIds;
	}
	/**
	 * ����IDS�趨
	 *
	 * @param anIds ����IDS
	 */
	public void setAnIds(String[] anIds) {
		this.anIds = anIds;
	}
	/**
	 * ȷ��ɾ����ȡ��
	 *
	 * @return isDel ȷ��ɾ����
	 */
	public String getIsDel() {
		return isDel;
	}
	/**
	 * ȷ��ɾ�����趨
	 *
	 * @param isDel ȷ��ɾ����
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.rpt.model.ReportManageInfo#getRaStr()
	 */
	public String getRaStr() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.infogovernor.rpt.model.ReportManageInfo#getRmSuffix()
	 */
	public String getRmSuffix() {
		// TODO Auto-generated method stub
		return null;
	}
	
}