/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �����ѯ����Form
 * ��������: 
 * ������¼:����ȫ 2012/07/03
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT0302Form extends BaseForm{
	/**ʱ������*/
	protected String dateTypeSel;
	/**��*/
	protected String yearSel;
	/**��*/
	protected String quarterSel;
	/**��*/
	protected String monthSel;
	/**�洢����*/
	protected String mode;
	/**��������*/
	protected String objType;
	/**�洢����*/
	protected String storageName;
	/**ҵ��ϵͳ����*/
	protected String businessName;
	/**��������*/
	protected String hostName;
	/**���ݿ�����*/
	protected String dbName;
	/**VG����*/
	protected String vgName;
	/**FS����*/
	protected String fsName;
	/**TS����*/
	protected String tsName;
	/**������������*/
	protected String[] vgNameArr;
	/**�ļ�ϵͳ����*/
	protected String[] fsNameArr;
	/**��ռ�����*/
	protected String[] tsNameArr;
	/**�ʲ�id*/
	protected String eiid;
	/**��������*/
	protected String objName;
	//-----------
	/**ģ��·��*/
	protected String reportPath;
	/**ʱ������*/
	protected String timeType;
	/**ʱ��*/
	protected String dateTime;
	/**ģ������*/
	protected String templateName;
	/**�Զ�������*/
	protected String rclCaType;
	
	/**
	 * ʱ������ȡ��
	 *
	 * @return dateTypeSel ʱ������
	 */
	public String getDateTypeSel() {
		return dateTypeSel;
	}
	/**
	 * ʱ�������趨
	 *
	 * @param dateTypeSel ʱ������
	 */
	public void setDateTypeSel(String dateTypeSel) {
		this.dateTypeSel = dateTypeSel;
	}
	/**
	 * ��ȡ��
	 *
	 * @return yearSel ��
	 */
	public String getYearSel() {
		return yearSel;
	}
	/**
	 * ���趨
	 *
	 * @param yearSel ��
	 */
	public void setYearSel(String yearSel) {
		this.yearSel = yearSel;
	}
	/**
	 * ��ȡ��
	 *
	 * @return quarterSel ��
	 */
	public String getQuarterSel() {
		return quarterSel;
	}
	/**
	 * ���趨
	 *
	 * @param quarterSel ��
	 */
	public void setQuarterSel(String quarterSel) {
		this.quarterSel = quarterSel;
	}
	/**
	 * ��ȡ��
	 *
	 * @return monthSel ��
	 */
	public String getMonthSel() {
		return monthSel;
	}
	/**
	 * ���趨
	 *
	 * @param monthSel ��
	 */
	public void setMonthSel(String monthSel) {
		this.monthSel = monthSel;
	}
	/**
	 * �洢����ȡ��
	 *
	 * @return mode �洢����
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * �洢�����趨
	 *
	 * @param mode �洢����
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * ��������ȡ��
	 *
	 * @return objType ��������
	 */
	public String getObjType() {
		return objType;
	}
	/**
	 * ���������趨
	 *
	 * @param objType ��������
	 */
	public void setObjType(String objType) {
		this.objType = objType;
	}
	/**
	 * �洢����ȡ��
	 *
	 * @return storageName �洢����
	 */
	public String getStorageName() {
		return storageName;
	}
	/**
	 * �洢�����趨
	 *
	 * @param storageName �洢����
	 */
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return businessName ҵ��ϵͳ����
	 */
	public String getBusinessName() {
		return businessName;
	}
	/**
	 * ҵ��ϵͳ�����趨
	 *
	 * @param businessName ҵ��ϵͳ����
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	/**
	 * ��������ȡ��
	 *
	 * @return hostName ��������
	 */
	public String getHostName() {
		return hostName;
	}
	/**
	 * ���������趨
	 *
	 * @param hostName ��������
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	/**
	 * ��������ȡ��
	 *
	 * @return vgNameArr ��������
	 */
	public String[] getVgNameArr() {
		return vgNameArr;
	}
	/**
	 * ���������趨
	 *
	 * @param vgNameArr ��������
	 */
	public void setVgNameArr(String[] vgNameArr) {
		this.vgNameArr = vgNameArr;
	}
	/**
	 * �ļ�ϵͳ����ȡ��
	 *
	 * @return fsNameArr �ļ�ϵͳ����
	 */
	public String[] getFsNameArr() {
		return fsNameArr;
	}
	/**
	 * �ļ�ϵͳ�����趨
	 *
	 * @param fsNameArr �ļ�ϵͳ����
	 */
	public void setFsNameArr(String[] fsNameArr) {
		this.fsNameArr = fsNameArr;
	}
	/**
	 * ��ռ�����ȡ��
	 *
	 * @return tsNameArr ��ռ�����
	 */
	public String[] getTsNameArr() {
		return tsNameArr;
	}
	/**
	 * ��ռ������趨
	 *
	 * @param tsNameArr ��ռ�����
	 */
	public void setTsNameArr(String[] tsNameArr) {
		this.tsNameArr = tsNameArr;
	}
	/**
	 * ���ݿ�����ȡ��
	 *
	 * @return dbName ���ݿ�����
	 */
	public String getDbName() {
		return dbName;
	}
	/**
	 * ���ݿ������趨
	 *
	 * @param dbName ���ݿ�����
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	/**
	 * �ʲ�idȡ��
	 *
	 * @return eiid �ʲ�id
	 */
	public String getEiid() {
		return eiid;
	}
	/**
	 * �ʲ�id�趨
	 *
	 * @param eiid �ʲ�id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	/**
	 * ��������ȡ��
	 *
	 * @return objName ��������
	 */
	public String getObjName() {
		return objName;
	}
	/**
	 * ���������趨
	 *
	 * @param objName ��������
	 */
	public void setObjName(String objName) {
		this.objName = objName;
	}
	/**
	 * --------ȡ��
	 *
	 * @return reportPath --------
	 */
	public String getReportPath() {
		return reportPath;
	}
	/**
	 * --------�趨
	 *
	 * @param reportPath --------
	 */
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}
	/**
	 * ʱ������ȡ��
	 *
	 * @return timeType ʱ������
	 */
	public String getTimeType() {
		return timeType;
	}
	/**
	 * ʱ�������趨
	 *
	 * @param timeType ʱ������
	 */
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	/**
	 * ʱ��ȡ��
	 *
	 * @return dateTime ʱ��
	 */
	public String getDateTime() {
		return dateTime;
	}
	/**
	 * ʱ���趨
	 *
	 * @param dateTime ʱ��
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	/**
	 * VG����ȡ��
	 *
	 * @return vgName VG����
	 */
	public String getVgName() {
		return vgName;
	}
	/**
	 * VG�����趨
	 *
	 * @param vgName VG����
	 */
	public void setVgName(String vgName) {
		this.vgName = vgName;
	}
	/**
	 * FS����ȡ��
	 *
	 * @return fsName FS����
	 */
	public String getFsName() {
		return fsName;
	}
	/**
	 * FS�����趨
	 *
	 * @param fsName FS����
	 */
	public void setFsName(String fsName) {
		this.fsName = fsName;
	}
	/**
	 * TS����ȡ��
	 *
	 * @return tsName TS����
	 */
	public String getTsName() {
		return tsName;
	}
	/**
	 * TS�����趨
	 *
	 * @param tsName TS����
	 */
	public void setTsName(String tsName) {
		this.tsName = tsName;
	}
	/**
	 * ģ������ȡ��
	 *
	 * @return templateName ģ������
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * ģ�������趨
	 *
	 * @param templateName ģ������
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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
	
	
}
