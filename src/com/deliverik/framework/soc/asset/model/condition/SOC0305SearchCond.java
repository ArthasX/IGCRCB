/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: StorageEvent���������ӿ�
  * ��������: StorageEvent���������ӿ�
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
public interface SOC0305SearchCond {

	/**
	 * ��ѯ����ȡ��
	 * @return impcitype
	 */
	public abstract String getImpcitype();
	/**
	 * ������־������ȡ��
	 * @return sort_eq
	 */
	public abstract String getEirootmark_eq();
	
	/**
	 * ������־��DIRȡ��
	 * @return dir_eq
	 */
	public abstract String getDir_eq(); 
	
	/**
	 * ������־�Ĵ����ȡ��
	 * @return errornum_eq
	 */
	public abstract String getErrornum_eq(); 
	
	/**
	 * ��־����ʱ��ȡ��
	 * @return
	 */
	public String getDetectiontime_eq();
	
	/**
	 * ��ʼ�Ĵ洢�¼�����ʱ��ȡ��
	 * @return detectiontime_from �洢�¼�����ʱ��
	 */
	public abstract String getDetectiontime_from();
	
	/**
	 * �����Ĵ洢�¼�����ʱ��ȡ��
	 * @return detectiontime_to �洢�¼�����ʱ��
	 */
	public abstract String getDetectiontime_to();
	
	/**
	 * �澯����ȡ��
	 * @return severity_eq
	 */
	public String getSeverity_eq();
	
	/**
	 * ��������ȡ��
	 * @return
	 */
	public String getErrorDesc();
	
	/**
	 * �澯����ȡ��
	 * @return
	 */
	public String getAlarmType();
	
	/**
	 * idȡ��
	 * @return
	 */
	public String getId();
	
	/**
	 * ����״̬ȡ��
	 * @return
	 */
	public String getStatus();
}