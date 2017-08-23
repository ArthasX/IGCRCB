/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.model;

import java.io.Serializable;


public interface IGCRC0208VWInfo extends Serializable{
	
	/**
	 * pridȡ��
	 * @return prid  prid
	 */
	public Integer getPrid();
	/**
	 * ���̼�¼����ȡ��
	 * @return prtype  ���̼�¼����
	 */
	public String getPrtype();
	/**
	 * ���̼�¼״̬ȡ��
	 * @return prstatus  ���̼�¼״̬
	 */
	public String getPrstatus();
	/**
	 * ���̼�¼��Ŀȡ��
	 * @return prtitle  ���̼�¼��Ŀ
	 */
	public String getPrtitle();
	/**
	 * ���̼�¼����ʱ��ȡ��
	 * @return propentime  ���̼�¼����ʱ��
	 */
	public String getPropentime();
	/**
	 * ���̼�¼�ر�ʱ��ȡ��
	 * @return prclosetime  ���̼�¼�ر�ʱ��
	 */
	public String getPrclosetime();
	/**
	 * ���̼�ȡ��
	 * @return eventType  ���̼�
	 */
	public String getEventType();
	/**
	 * �¼���Դȡ��
	 * @return eventSource  �¼���Դ
	 */
	public String getEventSource();
	/**
	 * ���س̶�ȡ��
	 * @return eventSeverity  ���س̶�
	 */
//	public String getEventSeverity();
	/**
	 * �����̶�ȡ��
	 * @return eventEmergency  �����̶�
	 */
//	public String getEventEmergency();
	
	/**
	 * ���̼�¼������ȡ��
	 * @return prserialnum  ���̼�¼������
	 */
	public String getPrserialnum();
	
	/**
	 * ���̼�¼�������û�����ȡ��
	 * @return prusername  ���̼�¼�������û�����
	 */
	public String getPrusername();
	
	/**
	 * ���̼�¼״̬��״̬ȡ��
	 * @return prsubstatus  ���̼�¼״̬��״̬
	 */
	public String getPrsubstatus();
	
	/**
	 * ����״̬����ȡ��
	 * @return orderstatus  ����״̬����
	 */
	public String getOrderstatus();
	
	/**
	 * ����ʱ��ȡ��
	 * @return happenTime  ����ʱ��
	 */
	public String getHappenTime();
	/**
	 * ������ȡ��
	 * @return handlingMethod  ������
	 */
//	public String getHandlingMethod();
	/**
	 * ԭ�����ȡ��
	 * @return analysis  ԭ�����
	 */
//	public String getAnalysis();
	/**
	 * ����ϵͳ����ȡ��
	 * @return stoppageName  ����ϵͳ����
	 */
//	public String getStoppageName();
	
	/**
	 * ���̼�¼��������IDȡ��
	 * @return prpdid  ���̼�¼��������ID
	 */
	public String getPrpdid();
	
	public String getInvolveSystem();
	
	public String getInfluenceRange();
	
	public String getInfluenceRangeRemarks();
	
	public String getEventLevel();
	
	public String getEventCause();
	
	public String getEmergencySolution();
	
	public String getIsClosed();
}
