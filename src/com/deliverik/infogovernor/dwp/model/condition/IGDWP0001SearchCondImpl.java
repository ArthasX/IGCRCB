/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ���ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0001SearchCondImpl implements IGDWP0001SearchCond{

	/** ��ʼʱ�䣺�� */
	protected String startdate_from;
	
	/** ��ʼʱ�䣺�� */
	protected String startdate_to;
	
	/** �Ƿ����JOB */
	protected String isAddJob;
	
	/** ��������ID */
	protected String puserid;

	/**
	 * ��ʼʱ�䣺��ȡ��
	 * @return startdate_from ��ʼʱ�䣺��
	 */
	public String getStartdate_from() {
		return startdate_from;
	}

	/**
	 * ��ʼʱ�䣺���趨
	 * @param startdate_from ��ʼʱ�䣺��
	 */
	public void setStartdate_from(String startdate_from) {
		this.startdate_from = startdate_from;
	}

	/**
	 * ��ʼʱ�䣺��ȡ��
	 * @return startdate_to ��ʼʱ�䣺��
	 */
	public String getStartdate_to() {
		return startdate_to;
	}

	/**
	 * ��ʼʱ�䣺���趨
	 * @param startdate_to ��ʼʱ�䣺��
	 */
	public void setStartdate_to(String startdate_to) {
		this.startdate_to = startdate_to;
	}

	/**
	 * �Ƿ����JOBȡ��
	 * @return isAddJob �Ƿ����JOB
	 */
	public String getIsAddJob() {
		return isAddJob;
	}

	/**
	 * �Ƿ����JOB�趨
	 * @param isAddJob �Ƿ����JOB
	 */
	public void setIsAddJob(String isAddJob) {
		this.isAddJob = isAddJob;
	}

	/**
	 * ��������IDȡ��
	 * @return puserid ��������ID
	 */
	public String getPuserid() {
		return puserid;
	}

	/**
	 * ��������ID�趨
	 * @param puserid ��������ID
	 */
	public void setPuserid(String puserid) {
		this.puserid = puserid;
	}

}
