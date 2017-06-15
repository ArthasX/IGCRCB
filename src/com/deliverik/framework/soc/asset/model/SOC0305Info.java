/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;

/**
 * ����: StorageEvent�ӿ� ��������: StorageEvent�ӿ� ������¼: 2011/06/13 �޸ļ�¼:
 */
public interface SOC0305Info extends BaseModel {

	/**
	 * ��־��¼ʱ��ȡ��
	 * 
	 * @return ��־��¼ʱ��
	 */
	public String getDetectiontime();

	/**
	 * dirȡ��
	 * 
	 * @return dir
	 */
	public String getDir();

	/**
	 * srcȡ��
	 * 
	 * @return src
	 */
	public String getSrc();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getCategory();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getSeverity();

	/**
	 * �����ȡ��
	 * 
	 * @return �����
	 */
	public String getErrornum();

	/**
	 * ��Ϣ����ȡ��
	 * 
	 * @return ��Ϣ����
	 */
	public String getErrordesc();

	/**
	 * Eirootmark ȡ��
	 * 
	 * @return eirootmark
	 */
	public String getEirootmark();

	/**
	 * ״̬ȡ��
	 * 
	 * @return state
	 */
	public String getState();

	/**
	 * һ������ȡ��
	 * 
	 * @return sort
	 */
	public String getSort();

	/**
	 *��ѯ����ȡ��
	 * 
	 * @return sort
	 */
	public Integer getImptypeid();
	
	public String getLparnam();
	/**
	 * 
	 * ip��ַ
	 * @return IP
	 */
	public String getIp();
	
	/**
	 * 
	 * FailingEnclosureMTMS
	 * @return IP
	 */
	public String getFailingEnclosureMTMS();
	
	public String getFru1Loc();
	
	public String getFru2Loc();
	
	public String getFru3Loc();
	
	public String getReportingMTMS();
	
	/**
	 * ��������ȡ��
	 * @return
	 */
	public String getAlarmType();
	
	public Integer getId();
	
	/**
	 * �����������ʵ��ȡ��
	 * @return
	 */
	public SOC0113TB getEiImportProgrammeTB();
	
	/**
	 * ����״̬ȡ��
	 * @return
	 */
	public String getStatus();
}