/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ��ѯ����
 * ��������: ��ѯ����
 * ������¼: 2012/05/28
 * �޸ļ�¼: 2012/05/31
 */
@SuppressWarnings("serial")
public class IGSYM1407Form extends BaseForm{
	// ��ѯ������ 
	/** ģʽ��1-5�� */
	private String mode;
	//1��
	/** �����ѯʱ�� */
	private String byday_date;
	//2��
	/** ���²�ѯʱ�� */
	private String bymouth_date;
	//3�նԱ�
	/** ����ԱȲ�ѯʱ�� */
	private String[] cds1;//select
	private String[] cms1;//select
	private String bycday_timeFrom;
	private String bycday_timeTo;
	//4�¶Ա�
	/** ���¶ԱȲ�ѯʱ�� */
	private String bycmouth_date;
	/** ����ԱȲ�ѯʱ�� */
	private String bycday_date;
	//5ͳ�Ʋ�ѯ
	/** ͳ�Ʋ�ѯ��ʼʱ�� */
	private String bycount_dateFrom;
	/** ͳ�Ʋ�ѯ����ʱ�� */
	private String bycount_dateTo;
	
	private String objectType;//��������
	
	//birt params
	
	/** �������� */
	private String[] objectName1;
	private String[] objectName2;
	private String[] objectName3;
	private String[] objectName4;
	private String[] objectName5;
	/** ��ѯ��ѡ��1 */
	private String[] checkbox1;
	/** ��ѯ��ѡ��1 */
	private String[] checkbox2;
	/** ��ѯ��ѡ��1 */
	private String[] checkbox3;
	/** �洢id */
	private String dataid;
	/** ���ڴ� */
	private String dateFrom;
	/** ���ڵ� */
	private String dateTo;
	/** ʱ��� */
	private String timeFrom;
	/** ʱ�䵽 */
	private String timeTo;
	/** ʱ������ */
	private String timetype;
	/** �Ƚ�����1 */
	private String CDate1;
	/** �Ƚ�����2 */
	private String CDate2;
	/** �Ƚ�����3 */
	private String CDate3;
	/** �Ƚ�����4 */
	private String CDate4;
	/** �Ƚ�����5 */
	private String CDate5;
	/** ������ */
	private String reportname;
	/** ����·�� */
	private String reportpath;
	/**���ڵ�����*/
	private String fatherName;
	private String rfdTitle;
	/**�Զ�������*/
	protected String rclCaType;
	private String reportpathTable;
	/**
	 * ��ѯ������ȡ��
	 *
	 * @return mode ��ѯ������
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * ��ѯ�������趨
	 *
	 * @param mode ��ѯ������
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * 1�찴���ȡ��
	 *
	 * @return byday_date 1�찴���
	 */
	public String getByday_date() {
		return byday_date;
	}
	/**
	 * 1�찴����趨
	 *
	 * @param byday_date 1�찴���
	 */
	public void setByday_date(String byday_date) {
		this.byday_date = byday_date;
	}
	/**
	 * 2�°��²�ȡ��
	 *
	 * @return bymouth_date 2�°��²�
	 */
	public String getBymouth_date() {
		return bymouth_date;
	}
	/**
	 * 2�°��²��趨
	 *
	 * @param bymouth_date 2�°��²�
	 */
	public void setBymouth_date(String bymouth_date) {
		this.bymouth_date = bymouth_date;
	}
	/**
	 * bycday_timeFromȡ��
	 *
	 * @return bycday_timeFrom bycday_timeFrom
	 */
	public String getBycday_timeFrom() {
		return bycday_timeFrom;
	}
	/**
	 * bycday_timeFrom�趨
	 *
	 * @param bycday_timeFrom bycday_timeFrom
	 */
	public void setBycday_timeFrom(String bycday_timeFrom) {
		this.bycday_timeFrom = bycday_timeFrom;
	}
	/**
	 * bycday_timeToȡ��
	 *
	 * @return bycday_timeTo bycday_timeTo
	 */
	public String getBycday_timeTo() {
		return bycday_timeTo;
	}
	/**
	 * bycday_timeTo�趨
	 *
	 * @param bycday_timeTo bycday_timeTo
	 */
	public void setBycday_timeTo(String bycday_timeTo) {
		this.bycday_timeTo = bycday_timeTo;
	}
	/**
	 * 4�¶ԱȰ��¶�ȡ��
	 *
	 * @return bycmouth_date 4�¶ԱȰ��¶�
	 */
	public String getBycmouth_date() {
		return bycmouth_date;
	}
	/**
	 * 4�¶ԱȰ��¶��趨
	 *
	 * @param bycmouth_date 4�¶ԱȰ��¶�
	 */
	public void setBycmouth_date(String bycmouth_date) {
		this.bycmouth_date = bycmouth_date;
	}
	/**
	 * 5ͳ�Ʋ�ѯͳ��ȡ��
	 *
	 * @return bycount_dateFrom 5ͳ�Ʋ�ѯͳ��
	 */
	public String getBycount_dateFrom() {
		return bycount_dateFrom;
	}
	/**
	 * 5ͳ�Ʋ�ѯͳ���趨
	 *
	 * @param bycount_dateFrom 5ͳ�Ʋ�ѯͳ��
	 */
	public void setBycount_dateFrom(String bycount_dateFrom) {
		this.bycount_dateFrom = bycount_dateFrom;
	}
	/**
	 * ͳ�Ʋ�ѯ����ʱ��ȡ��
	 *
	 * @return bycount_dateTo ͳ�Ʋ�ѯ����ʱ��
	 */
	public String getBycount_dateTo() {
		return bycount_dateTo;
	}
	/**
	 * ͳ�Ʋ�ѯ����ʱ���趨
	 *
	 * @param bycount_dateTo ͳ�Ʋ�ѯ����ʱ��
	 */
	public void setBycount_dateTo(String bycount_dateTo) {
		this.bycount_dateTo = bycount_dateTo;
	}
	/**
	 * �洢idȡ��
	 *
	 * @return dataid �洢id
	 */
	public String getDataid() {
		return dataid;
	}
	/**
	 * �洢id�趨
	 *
	 * @param dataid �洢id
	 */
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
	/**
	 * ���ڴ�ȡ��
	 *
	 * @return dateFrom ���ڴ�
	 */
	public String getDateFrom() {
		return dateFrom;
	}
	/**
	 * ���ڴ��趨
	 *
	 * @param dateFrom ���ڴ�
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	/**
	 * ���ڵ�ȡ��
	 *
	 * @return dateTo ���ڵ�
	 */
	public String getDateTo() {
		return dateTo;
	}
	/**
	 * ���ڵ��趨
	 *
	 * @param dateTo ���ڵ�
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	/**
	 * ʱ���ȡ��
	 *
	 * @return timeFrom ʱ���
	 */
	public String getTimeFrom() {
		return timeFrom;
	}
	/**
	 * ʱ����趨
	 *
	 * @param timeFrom ʱ���
	 */
	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}
	/**
	 * ʱ�䵽ȡ��
	 *
	 * @return timeTo ʱ�䵽
	 */
	public String getTimeTo() {
		return timeTo;
	}
	/**
	 * ʱ�䵽�趨
	 *
	 * @param timeTo ʱ�䵽
	 */
	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}
	/**
	 * ʱ������ȡ��
	 *
	 * @return timetype ʱ������
	 */
	public String getTimetype() {
		return timetype;
	}
	/**
	 * ʱ�������趨
	 *
	 * @param timetype ʱ������
	 */
	public void setTimetype(String timetype) {
		this.timetype = timetype;
	}
	/**
	 * ������ȡ��
	 *
	 * @return reportname ������
	 */
	public String getReportname() {
		return reportname;
	}
	/**
	 * �������趨
	 *
	 * @param reportname ������
	 */
	public void setReportname(String reportname) {
		this.reportname = reportname;
	}
	/**
	 * ����·��ȡ��
	 *
	 * @return reportpath ����·��
	 */
	public String getReportpath() {
		return reportpath;
	}
	/**
	 * ����·���趨
	 *
	 * @param reportpath ����·��
	 */
	public void setReportpath(String reportpath) {
		this.reportpath = reportpath;
	}
	/**
	 * birtparamsȡ��
	 *
	 * @return checkbox1 birtparams
	 */
	public String[] getCheckbox1() {
		return checkbox1;
	}
	/**
	 * birtparams�趨
	 *
	 * @param checkbox1 birtparams
	 */
	public void setCheckbox1(String[] checkbox1) {
		this.checkbox1 = checkbox1;
	}
	/**
	 * ��ѯ��ѡ��1ȡ��
	 *
	 * @return checkbox2 ��ѯ��ѡ��1
	 */
	public String[] getCheckbox2() {
		return checkbox2;
	}
	/**
	 * ��ѯ��ѡ��1�趨
	 *
	 * @param checkbox2 ��ѯ��ѡ��1
	 */
	public void setCheckbox2(String[] checkbox2) {
		this.checkbox2 = checkbox2;
	}
	/**
	 * ��ѯ��ѡ��1ȡ��
	 *
	 * @return checkbox3 ��ѯ��ѡ��1
	 */
	public String[] getCheckbox3() {
		return checkbox3;
	}
	/**
	 * ��ѯ��ѡ��1�趨
	 *
	 * @param checkbox3 ��ѯ��ѡ��1
	 */
	public void setCheckbox3(String[] checkbox3) {
		this.checkbox3 = checkbox3;
	}
	/**
	 * 3�նԱȰ����ȡ��
	 *
	 * @return cds1 3�նԱȰ����
	 */
	public String[] getCds1() {
		return cds1;
	}
	/**
	 * 3�նԱȰ�����趨
	 *
	 * @param cds1 3�նԱȰ����
	 */
	public void setCds1(String[] cds1) {
		this.cds1 = cds1;
	}
	/**
	 * cms1ȡ��
	 *
	 * @return cms1 cms1
	 */
	public String[] getCms1() {
		return cms1;
	}
	/**
	 * cms1�趨
	 *
	 * @param cms1 cms1
	 */
	public void setCms1(String[] cms1) {
		this.cms1 = cms1;
	}
	/**
	 * cDate1ȡ��
	 *
	 * @return cDate1 cDate1
	 */
	public String getCDate1() {
		return CDate1;
	}
	/**
	 * cDate1�趨
	 *
	 * @param date1 cDate1
	 */
	public void setCDate1(String date1) {
		CDate1 = date1;
	}
	/**
	 * cDate2ȡ��
	 *
	 * @return cDate2 cDate2
	 */
	public String getCDate2() {
		return CDate2;
	}
	/**
	 * cDate2�趨
	 *
	 * @param date2 cDate2
	 */
	public void setCDate2(String date2) {
		CDate2 = date2;
	}
	/**
	 * cDate3ȡ��
	 *
	 * @return cDate3 cDate3
	 */
	public String getCDate3() {
		return CDate3;
	}
	/**
	 * cDate3�趨
	 *
	 * @param date3 cDate3
	 */
	public void setCDate3(String date3) {
		CDate3 = date3;
	}
	/**
	 * cDate4ȡ��
	 *
	 * @return cDate4 cDate4
	 */
	public String getCDate4() {
		return CDate4;
	}
	/**
	 * cDate4�趨
	 *
	 * @param date4 cDate4
	 */
	public void setCDate4(String date4) {
		CDate4 = date4;
	}
	/**
	 * cDate5ȡ��
	 *
	 * @return cDate5 cDate5
	 */
	public String getCDate5() {
		return CDate5;
	}
	/**
	 * cDate5�趨
	 *
	 * @param date5 cDate5
	 */
	public void setCDate5(String date5) {
		CDate5 = date5;
	}
	
	public String getObjectType() {
		return objectType;
	}
	
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String[] getObjectName1() {
		return objectName1;
	}
	public void setObjectName1(String[] objectName1) {
		this.objectName1 = objectName1;
	}
	public String[] getObjectName2() {
		return objectName2;
	}
	public void setObjectName2(String[] objectName2) {
		this.objectName2 = objectName2;
	}
	public String[] getObjectName3() {
		return objectName3;
	}
	public void setObjectName3(String[] objectName3) {
		this.objectName3 = objectName3;
	}
	public String[] getObjectName4() {
		return objectName4;
	}
	public void setObjectName4(String[] objectName4) {
		this.objectName4 = objectName4;
	}
	public String[] getObjectName5() {
		return objectName5;
	}
	public void setObjectName5(String[] objectName5) {
		this.objectName5 = objectName5;
	}
	/**
	 * ���ڵ�����ȡ��
	 *
	 * @return fatherName ���ڵ�����
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * ���ڵ������趨
	 *
	 * @param fatherName ���ڵ�����
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * rfdTitleȡ��
	 *
	 * @return rfdTitle rfdTitle
	 */
	public String getRfdTitle() {
		return rfdTitle;
	}
	/**
	 * rfdTitle�趨
	 *
	 * @param rfdTitle rfdTitle
	 */
	public void setRfdTitle(String rfdTitle) {
		this.rfdTitle = rfdTitle;
	}
	/**
	 * �Զ�������ȡ��
	 *
	 * @return rclCaType �Զ�������
	 */
	public String getRclCaType() {
		return rclCaType;
	}
	/**
	 * �Զ��������趨
	 *
	 * @param rclCaType �Զ�������
	 */
	public void setRclCaType(String rclCaType) {
		this.rclCaType = rclCaType;
	}
	/**
	 * ����ԱȲ�ѯʱ��ȡ��
	 *
	 * @return bycday_date ����ԱȲ�ѯʱ��
	 */
	public String getBycday_date() {
		return bycday_date;
	}
	/**
	 * ����ԱȲ�ѯʱ���趨
	 *
	 * @param bycday_date ����ԱȲ�ѯʱ��
	 */
	public void setBycday_date(String bycday_date) {
		this.bycday_date = bycday_date;
	}
	public String getReportpathTable() {
		return reportpathTable;
	}
	public void setReportpathTable(String reportpathTable) {
		this.reportpathTable = reportpathTable;
	}

}