/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;


@SuppressWarnings("serial")
@Entity
public class IGCRC0208VW implements Serializable,Cloneable,IGCRC0208VWInfo{
	
	@Id
	protected Integer prid;
	
	/**
	 * ���̼�¼����
	 */
	protected String prtype;
	
	/**
	 * ���̼�¼״̬
	 */
	protected String prstatus;
	
	
	/**
	 * ���̼�¼��Ŀ
	 */
	protected String prtitle;
	
	
	/**
	 * ���̼�¼����ʱ��
	 */
	protected String propentime;
	
	/**
	 * ���̼�¼�ر�ʱ��
	 */
	protected String prclosetime;
	
	/**
	 * ���̼�¼������
	 */
	protected String prserialnum;
	
	/**
	 * ���̼�¼�������û�����
	 */
	protected String prusername;
	
	/**
	 * ���̼�¼״̬��״̬
	 */
	protected String prsubstatus;
	
	/**
	 * ���̼�¼��������ID
	 */
	protected String prpdid;
	
	
	/** �¼�����  */	
	private String eventType;
	/** �¼���Դ  */	
	private String eventSource;
	/** ���س̶� */	
//	private String eventSeverity;
	/** �����̶�  */	
//	private String eventEmergency;
	/** ����״̬���� */
	private String orderstatus;
	
	/** ����ʱ��  */	
	private String happenTime;
	/** ������  */	
//	private String handlingMethod;
	/** ԭ�����  */	
//	private String analysis;
	/** ����ϵͳ����  */	
//	private String stoppageName;
	/** �¼�������  */	
//	private String ppusername;
	
	/**
	 * �漰ϵͳ
	 */
	protected String involveSystem;
	
	/**
	 * Ӱ�췶Χ
	 */
	protected String influenceRange;
	
	/**
	 * Ӱ�췶Χ��ע
	 */
	protected String influenceRangeRemarks;
	
	/**
	 * �¼��ȼ�
	 */
	protected String eventLevel;
	
	/**
	 * �¼�ԭ��
	 */
	protected String eventCause;
	
	/**
	 * Ӧ���������
	 */
	protected String emergencySolution;
	
	/**
	 * �Ƿ��ѹر�
	 */
	protected String isClosed;
	
	
	
	/**
	 * pridȡ��
	 * @return prid  prid
	 */
	public Integer getPrid() {
		return prid;
	}
	/**
	 * prid�趨
	 * @param prid  prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	/**
	 * ���̼�¼����ȡ��
	 * @return prtype  ���̼�¼����
	 */
	public String getPrtype() {
		return prtype;
	}
	/**
	 * ���̼�¼�����趨
	 * @param prtype  ���̼�¼����
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	/**
	 * ���̼�¼״̬ȡ��
	 * @return prstatus  ���̼�¼״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}
	/**
	 * ���̼�¼״̬�趨
	 * @param prstatus  ���̼�¼״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	/**
	 * ���̼�¼��Ŀȡ��
	 * @return prtitle  ���̼�¼��Ŀ
	 */
	public String getPrtitle() {
		return prtitle;
	}
	/**
	 * ���̼�¼��Ŀ�趨
	 * @param prtitle  ���̼�¼��Ŀ
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	/**
	 * ���̼�¼����ʱ��ȡ��
	 * @return propentime  ���̼�¼����ʱ��
	 */
	public String getPropentime() {
		return propentime;
	}
	/**
	 * ���̼�¼����ʱ���趨
	 * @param propentime  ���̼�¼����ʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	/**
	 * ���̼�¼�ر�ʱ��ȡ��
	 * @return prclosetime  ���̼�¼�ر�ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}
	/**
	 * ���̼�¼�ر�ʱ���趨
	 * @param prclosetime  ���̼�¼�ر�ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
	/**
	 * ���̼�ȡ��
	 * @return eventType  ���̼�
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * ���̼��趨
	 * @param eventType  ���̼�
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * �¼���Դȡ��
	 * @return eventSource  �¼���Դ
	 */
	public String getEventSource() {
		return eventSource;
	}
	/**
	 * �¼���Դ�趨
	 * @param eventSource  �¼���Դ
	 */
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}


	/**
	 * ���̼�¼������ȡ��
	 * @return prserialnum  ���̼�¼������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}
	/**
	 * ���̼�¼�������趨
	 * @param prserialnum  ���̼�¼������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	/**
	 * ���̼�¼�������û�����ȡ��
	 * @return prusername  ���̼�¼�������û�����
	 */
	public String getPrusername() {
		return prusername;
	}
	/**
	 * ���̼�¼�������û������趨
	 * @param prusername  ���̼�¼�������û�����
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}
	/**
	 * ���̼�¼״̬��״̬ȡ��
	 * @return prsubstatus  ���̼�¼״̬��״̬
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}
	/**
	 * ���̼�¼״̬��״̬�趨
	 * @param prsubstatus  ���̼�¼״̬��״̬
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}
	/**
	 * ����״̬����ȡ��
	 * @return orderstatus  ����״̬����
	 */
	public String getOrderstatus() {
		return orderstatus;
	}
	/**
	 * ����״̬�����趨
	 * @param orderstatus  ����״̬����
	 */
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	/**
	 * ����ʱ��ȡ��
	 * @return happenTime  ����ʱ��
	 */
	public String getHappenTime() {
		return happenTime;
	}
	/**
	 * ����ʱ���趨
	 * @param happenTime  ����ʱ��
	 */
	public void setHappenTime(String happenTime) {
		this.happenTime = happenTime;
	}



	/**
	 * ���̼�¼��������IDȡ��
	 * @return prpdid  ���̼�¼��������ID
	 */
	public String getPrpdid() {
		return prpdid;
	}
	/**
	 * ���̼�¼��������ID�趨
	 * @param prpdid  ���̼�¼��������ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}
	public String getInvolveSystem() {
		return involveSystem;
	}
	public void setInvolveSystem(String involveSystem) {
		this.involveSystem = involveSystem;
	}
	public String getInfluenceRange() {
		return influenceRange;
	}
	public void setInfluenceRange(String influenceRange) {
		this.influenceRange = influenceRange;
	}
	public String getInfluenceRangeRemarks() {
		return influenceRangeRemarks;
	}
	public void setInfluenceRangeRemarks(String influenceRangeRemarks) {
		this.influenceRangeRemarks = influenceRangeRemarks;
	}
	public String getEventLevel() {
		return eventLevel;
	}
	public void setEventLevel(String eventLevel) {
		this.eventLevel = eventLevel;
	}
	public String getEventCause() {
		return eventCause;
	}
	public void setEventCause(String eventCause) {
		this.eventCause = eventCause;
	}
	public String getEmergencySolution() {
		return emergencySolution;
	}
	public void setEmergencySolution(String emergencySolution) {
		this.emergencySolution = emergencySolution;
	}
	public String getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	
	
	
}
