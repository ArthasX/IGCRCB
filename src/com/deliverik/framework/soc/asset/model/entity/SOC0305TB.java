/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0305Info;

/**
  * ����: StorageEventʵ��
  * ��������: StorageEventʵ��
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0305")
public class SOC0305TB extends BaseEntity implements Serializable,
		Cloneable, SOC0305Info {

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
	
	/**eirootmark	 */
	
	protected String eirootmark;
	
	/**״̬	 */
	protected String state;
	
	/**һ������	 */
	protected String sort;

	/** ��Ϣ���� */
	protected String errordesc;

	/**��ѯ����*/
	protected Integer imptypeid ;
	
	/**����*/
	protected String lparnam ;
	
	/**IP*/
	protected String ip ;
	
	/**����״̬*/
	protected String status;

	/** ����� */
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "identity")
	protected Integer id;
	
	/** reportingmtms */
	public String reportingMTMS;
	/** fru1Loc */
	public String fru1Loc;
	/** fru2Loc */
	public String fru2Loc;
	/** fru3Loc */
	public String fru3Loc;
	/** failingenclosuremtms */
	protected String failingEnclosureMTMS;
	
	/**��������*/
	protected String alarmType ;
	
	 /** �����������ʵ�� */
	@OneToOne
	@JoinColumn(name="imptypeid", referencedColumnName="impTypeid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0113TB eiImportProgrammeTB;
//	
//	/** �ʲ���Ϣʵ�� */
//	@OneToOne
//	@JoinColumn(name="eirootmark", referencedColumnName="einame", updatable=false, insertable= false)
//	@Basic(fetch = FetchType.EAGER)
//	@NotFound(action = NotFoundAction.IGNORE)
//	protected EntityItemTB entityItemTB;
	
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


	public void setReportingmtms(String reportingmtms)
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

	public Integer getImptypeid() {
		return imptypeid;
	}


	public void setImptypeid(Integer imptypeid) {
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


	/**
	 * �����������ʵ��ȡ��
	 * @return
	 */
	public SOC0113TB getEiImportProgrammeTB() {
		return eiImportProgrammeTB;
	}

	/**
	 * �����������ʵ���趨
	 * @param eiImportProgrammeTB
	 */
	public void setEiImportProgrammeTB(SOC0113TB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
	}

//	/**
//	 * �ʲ���Ϣʵ��ȡ��
//	 * @return
//	 */
//	public EntityItemTB getEntityItemTB() {
//		return entityItemTB;
//	}
//
//	/**
//	 * �ʲ���Ϣʵ���趨
//	 * @param entityItemTB
//	 */
//	public void setEntityItemTB(EntityItemTB entityItemTB) {
//		this.entityItemTB = entityItemTB;
//	}

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