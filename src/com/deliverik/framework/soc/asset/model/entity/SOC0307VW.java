package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.soc.asset.model.SOC0307Info;

/**
 * �澯��Ϣ��ͼʵ��STORAGEEVENTVW
 * @author Administrator
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0307")
@SuppressWarnings("serial")
public class SOC0307VW implements Serializable, Cloneable, SOC0307Info{
	
	/** id */
	@Id
	protected Integer id;
	
	/** ��־��¼ʱ�� */
	protected String detectiontime;
	
	/** dir */
	protected String dir;
	
	/** src */
	protected String src;
	
	/** ���� */
	protected String category;
	
	/** ���� */
	protected String severity;
	
	/** ����� */
	protected String errornum;
	
	/** ��Ϣ���� */
	protected String errordesc;
	
	/**eirootmark	 */
	protected String eirootmark;
	
	/**״̬	 */
	protected String state;
	
	/**һ������	 */
	protected String sort;
	
	/**��ѯ����*/
	protected String imptypeid;
	
	/**����*/
	protected String lparnam;
	
	/**IP*/
	protected String ip;
	
	/** reportingmtms */
	protected String reportingMTMS;
	
	/** fru1Loc */
	protected String fru1Loc;
	
	/** fru2Loc */
	protected String fru2Loc;
	
	/** fru3Loc */
	protected String fru3Loc;
	
	/** failingenclosuremtms */
	protected String failingEnclosureMTMS;
	
	/**��������*/
	protected String alarmType ;
	
	/** ��������*/
	protected String imptypename;
	
	/** ����ʵ��id*/
	protected Integer eiid;
	
	/** ����״̬*/
	protected String status;
	
	/**
	 * ��������ȡ��
	 * @return
	 */
	public String getAlarmType() {
		return alarmType;
	}

	/**
	 * ���������趨
	 * @param alarmType
	 */
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}


	public String getReportingMTMS()
	{
		return reportingMTMS;
	}


	public void setReportingMTMS(String reportingmtms)
	{
		this.reportingMTMS = reportingmtms;
	}


	public String getFru1Loc()
	{
		return fru1Loc;
	}


	public void setFru1Loc(String fru1Loc)
	{
		this.fru1Loc = fru1Loc;
	}


	public String getFru2Loc()
	{
		return fru2Loc;
	}


	public void setFru2Loc(String fru2Loc)
	{
		this.fru2Loc = fru2Loc;
	}


	public String getFru3Loc()
	{
		return fru3Loc;
	}


	public void setFru3Loc(String fru3Loc)
	{
		this.fru3Loc = fru3Loc;
	}


	public String getFailingEnclosureMTMS()
	{
		return failingEnclosureMTMS;
	}


	public void setFailingEnclosureMTMS(String failingenclosuremtms)
	{
		this.failingEnclosureMTMS = failingenclosuremtms;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLparnam() {
		return lparnam;
	}


	public void setLparnam(String lparnam) {
		this.lparnam = lparnam;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getImptypeid() {
		return imptypeid;
	}


	public void setImptypeid(String imptypeid) {
		this.imptypeid = imptypeid;
	}


	/**
	 * ��־��¼ʱ��ȡ��
	 *
	 * @return ��־��¼ʱ��
	 */
	public String getDetectiontime() {
		return detectiontime;
	}
	

	/**
	 * ��־��¼ʱ���趨
	 *
	 * @param detectiontime��־��¼ʱ��
	 */
	public void setDetectiontime(String detectiontime) {
		this.detectiontime = detectiontime;
	}

	/**
	 * dirȡ��
	 *
	 * @return dir
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * dir�趨
	 *
	 * @param dirdir
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * srcȡ��
	 *
	 * @return src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * src�趨
	 *
	 * @param srcsrc
	 */
	public void setSrc(String src) {
		this.src = src;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * �����趨
	 *
	 * @param category����
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * �����趨
	 *
	 * @param severity����
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public String getErrornum() {
		return errornum;
	}

	/**
	 * ������趨
	 *
	 * @param errornum�����
	 */
	public void setErrornum(String errornum) {
		this.errornum = errornum;
	}

	/**
	 * ��Ϣ����ȡ��
	 *
	 * @return ��Ϣ����
	 */
	public String getErrordesc() {
		return errordesc;
	}

	/**
	 * ��Ϣ�����趨
	 *
	 * @param errordesc��Ϣ����
	 */
	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}

	/**
	 * eirootmarkȡ��
	 * @return eirootmark
	 */
	public String getEirootmark() {
		return eirootmark;
	}

	/**
	 * eirootmark����
	 * @param eirootmark
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * ״̬ȡ��
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * ״̬����
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * һ������ȡ��
	 * @return sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * һ����������
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getImptypename() {
		return imptypename;
	}
	public void setImptypename(String imptypename) {
		this.imptypename = imptypename;
	}
	public Integer getEiid() {
		return eiid;
	}
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
