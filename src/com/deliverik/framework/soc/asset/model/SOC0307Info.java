package com.deliverik.framework.soc.asset.model;

/**
 * �澯��Ϣ��ͼ�ӿ�
 * @author Administrator
 *
 */
public interface SOC0307Info {
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
	public String getImptypeid();
	
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
	
	public String getImptypename();
	
	public Integer getEiid();
	
	/**
	 * ����״̬ȡ��
	 * @return
	 */
	public String getStatus();
}
