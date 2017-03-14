/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �Զ�����ģ��CRUD Form
 * ��������: �Զ�����ģ��CRUD Form
 * ������¼: 2012/06/07
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT0203Form extends BaseForm {
  	
	/** mapid*/
	protected String[] mapid;
	/** ssn_list */
	protected String[] ssn_select_list1;
	/** dmx_list */
	protected String[] dmx_select_list1;
	/** ibm_list */
	protected String[] ibm_select_list1;
	/** cx_list */
	protected String[] cx_select_list1;
	/** real_kpi_list*/
	protected String[] real_kpi_list;
	
	/** ssn_type_list*/
	protected String[] ssn_type_list;
	
	/**Ĭ��KPI*/
	protected String syscoding;
	/** real_ssn_list_ssn*/
	protected String[] real_ssn_list_ssn;
	/** real_ssn_list_type*/
	protected String[] real_ssn_list_type;
	
	/** ģ������ */
	protected Integer rtId;

	/** ģ������ */
	protected String rtName;

	/** ʱ������ */
	protected String rtDateType;

	/** ģ����ʵ���� */
	protected String rtRealName;

	/** ģ���ϴ�ʱ�� */
	protected String rtUploadTime;

	/** ģ������ */
	protected String rtType;
	
	
	protected Integer rtmId;
	
	/** ģ��λ����� */
	protected Integer rtNumber;

	/** �洢���к� */
	protected String rtmSsn;

	/** KPI */
	protected String rtmKpi;
	
	/** Word�ĵ�����ͼƬλ�� */
	protected Integer rtmImgNumber;
	
	protected String mode;
	/**
	 * ģ������ȡ��
	 *
	 * @return rtId ģ������
	 */
	public Integer getRtId() {
		return rtId;
	}
	/**
	 * ģ������ȡ��
	 *
	 * @return rtName ģ������
	 */
	public String getRtName() {
		return rtName;
	}
	/**
	 * ʱ������ȡ��
	 *
	 * @return rtDateType ʱ������
	 */
	public String getRtDateType() {
		return rtDateType;
	}
	/**
	 * ģ����ʵ����ȡ��
	 *
	 * @return rtRealName ģ����ʵ����
	 */
	public String getRtRealName() {
		return rtRealName;
	}
	/**
	 * ģ���ϴ�ʱ��ȡ��
	 *
	 * @return rtUploadTime ģ���ϴ�ʱ��
	 */
	public String getRtUploadTime() {
		return rtUploadTime;
	}
	/**
	 * ģ������ȡ��
	 *
	 * @return rtType ģ������
	 */
	public String getRtType() {
		return rtType;
	}
	/**
	 * ģ�������趨
	 *
	 * @param rtId ģ������
	 */
	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}
	/**
	 * ģ�������趨
	 *
	 * @param rtName ģ������
	 */
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}
	/**
	 * ʱ�������趨
	 *
	 * @param rtDateType ʱ������
	 */
	public void setRtDateType(String rtDateType) {
		this.rtDateType = rtDateType;
	}
	/**
	 * ģ����ʵ�����趨
	 *
	 * @param rtRealName ģ����ʵ����
	 */
	public void setRtRealName(String rtRealName) {
		this.rtRealName = rtRealName;
	}
	/**
	 * ģ���ϴ�ʱ���趨
	 *
	 * @param rtUploadTime ģ���ϴ�ʱ��
	 */
	public void setRtUploadTime(String rtUploadTime) {
		this.rtUploadTime = rtUploadTime;
	}
	/**
	 * ģ�������趨
	 *
	 * @param rtType ģ������
	 */
	public void setRtType(String rtType) {
		this.rtType = rtType;
	}
	//
	public String getFingerPrint() {
		//
		return null;
	}

	/**
	 * rtmIdȡ��
	 *
	 * @return rtmId rtmId
	 */
	public Integer getRtmId() {
		return rtmId;
	}
	/**
	 * ģ��λ�����ȡ��
	 *
	 * @return rtNumber ģ��λ�����
	 */
	public Integer getRtNumber() {
		return rtNumber;
	}
	/**
	 * �洢���к�ȡ��
	 *
	 * @return rtmSsn �洢���к�
	 */
	public String getRtmSsn() {
		return rtmSsn;
	}
	/**
	 * KPIȡ��
	 *
	 * @return rtmKpi KPI
	 */
	public String getRtmKpi() {
		return rtmKpi;
	}
	/**
	 * Word�ĵ�����ͼƬλ��ȡ��
	 *
	 * @return rtmImgNumber Word�ĵ�����ͼƬλ��
	 */
	public Integer getRtmImgNumber() {
		return rtmImgNumber;
	}
	/**
	 * rtmId�趨
	 *
	 * @param rtmId rtmId
	 */
	public void setRtmId(Integer rtmId) {
		this.rtmId = rtmId;
	}
	/**
	 * ģ��λ������趨
	 *
	 * @param rtNumber ģ��λ�����
	 */
	public void setRtNumber(Integer rtNumber) {
		this.rtNumber = rtNumber;
	}
	/**
	 * �洢���к��趨
	 *
	 * @param rtmSsn �洢���к�
	 */
	public void setRtmSsn(String rtmSsn) {
		this.rtmSsn = rtmSsn;
	}
	/**
	 * KPI�趨
	 *
	 * @param rtmKpi KPI
	 */
	public void setRtmKpi(String rtmKpi) {
		this.rtmKpi = rtmKpi;
	}
	/**
	 * Word�ĵ�����ͼƬλ���趨
	 *
	 * @param rtmImgNumber Word�ĵ�����ͼƬλ��
	 */
	public void setRtmImgNumber(Integer rtmImgNumber) {
		this.rtmImgNumber = rtmImgNumber;
	}

	/**
	 * ssn_listȡ��
	 *
	 * @return ssn_select_list1 ssn_list
	 */
	public String[] getSsn_select_list1() {
		return ssn_select_list1;
	}
	/**
	 * dmx_listȡ��
	 *
	 * @return dmx_select_list1 dmx_list
	 */
	public String[] getDmx_select_list1() {
		return dmx_select_list1;
	}
	/**
	 * ibm_listȡ��
	 *
	 * @return ibm_select_list1 ibm_list
	 */
	public String[] getIbm_select_list1() {
		return ibm_select_list1;
	}
	/**
	 * cx_listȡ��
	 *
	 * @return cx_select_list1 cx_list
	 */
	public String[] getCx_select_list1() {
		return cx_select_list1;
	}
	/**
	 * ssn_list�趨
	 *
	 * @param ssn_select_list1 ssn_list
	 */
	public void setSsn_select_list1(String[] ssn_select_list1) {
		this.ssn_select_list1 = ssn_select_list1;
	}
	/**
	 * dmx_list�趨
	 *
	 * @param dmx_select_list1 dmx_list
	 */
	public void setDmx_select_list1(String[] dmx_select_list1) {
		this.dmx_select_list1 = dmx_select_list1;
	}
	/**
	 * ibm_list�趨
	 *
	 * @param ibm_select_list1 ibm_list
	 */
	public void setIbm_select_list1(String[] ibm_select_list1) {
		this.ibm_select_list1 = ibm_select_list1;
	}
	/**
	 * cx_list�趨
	 *
	 * @param cx_select_list1 cx_list
	 */
	public void setCx_select_list1(String[] cx_select_list1) {
		this.cx_select_list1 = cx_select_list1;
	}
	/**
	 * real_kpi_listȡ��
	 *
	 * @return real_kpi_list real_kpi_list
	 */
	public String[] getReal_kpi_list() {
		return real_kpi_list;
	}
	/**
	 * real_kpi_list�趨
	 *
	 * @param real_kpi_list real_kpi_list
	 */
	public void setReal_kpi_list(String[] real_kpi_list) {
		this.real_kpi_list = real_kpi_list;
	}
	/**
	 * real_ssn_list_ssnȡ��
	 *
	 * @return real_ssn_list_ssn real_ssn_list_ssn
	 */
	public String[] getReal_ssn_list_ssn() {
		return real_ssn_list_ssn;
	}
	/**
	 * real_ssn_list_typeȡ��
	 *
	 * @return real_ssn_list_type real_ssn_list_type
	 */
	public String[] getReal_ssn_list_type() {
		return real_ssn_list_type;
	}
	/**
	 * real_ssn_list_ssn�趨
	 *
	 * @param real_ssn_list_ssn real_ssn_list_ssn
	 */
	public void setReal_ssn_list_ssn(String[] real_ssn_list_ssn) {
		this.real_ssn_list_ssn = real_ssn_list_ssn;
	}
	/**
	 * real_ssn_list_type�趨
	 *
	 * @param real_ssn_list_type real_ssn_list_type
	 */
	public void setReal_ssn_list_type(String[] real_ssn_list_type) {
		this.real_ssn_list_type = real_ssn_list_type;
	}
	/**
	 * Ĭ��KPIȡ��
	 *
	 * @return syscoding Ĭ��KPI
	 */
	public String getSyscoding() {
		return syscoding;
	}
	/**
	 * Ĭ��KPI�趨
	 *
	 * @param syscoding Ĭ��KPI
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}
	/**
	 * ssn_type_listȡ��
	 *
	 * @return ssn_type_list ssn_type_list
	 */
	public String[] getSsn_type_list() {
		return ssn_type_list;
	}
	/**
	 * ssn_type_list�趨
	 *
	 * @param ssn_type_list ssn_type_list
	 */
	public void setSsn_type_list(String[] ssn_type_list) {
		this.ssn_type_list = ssn_type_list;
	}
	/**
	 * mapidȡ��
	 *
	 * @return mapid mapid
	 */
	public String[] getMapid() {
		return mapid;
	}
	/**
	 * mapid�趨
	 *
	 * @param mapid mapid
	 */
	public void setMapid(String[] mapid) {
		this.mapid = mapid;
	}
	/**
	 * modeȡ��
	 *
	 * @return mode mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * mode�趨
	 *
	 * @param mode mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	
}
