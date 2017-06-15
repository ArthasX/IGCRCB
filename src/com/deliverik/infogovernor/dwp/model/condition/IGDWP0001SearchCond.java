/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ���ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0001SearchCond {

	/**
	 * ��ʼʱ�䣺��ȡ��
	 * @return startdate_from ��ʼʱ�䣺��
	 */
	public String getStartdate_from();

	/**
	 * ��ʼʱ�䣺��ȡ��
	 * @return startdate_to ��ʼʱ�䣺��
	 */
	public String getStartdate_to();
	
	/**
	 * �Ƿ����JOBȡ��
	 * @return isAddJob �Ƿ����JOB
	 */
	public String getIsAddJob();
	
	/**
	 * ��������IDȡ��
	 * @return puserid ��������ID
	 */
	public String getPuserid();
}
