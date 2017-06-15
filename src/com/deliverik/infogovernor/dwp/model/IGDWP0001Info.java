/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�ʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0001Info extends BaseModel{

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();

	/**
	 * �ƻ�����ȡ��
	 * @return pname �ƻ�����
	 */
	public String getPname();

	/**
	 * �ƻ�����ȡ��
	 * @return pdesc �ƻ�����
	 */
	public String getPdesc();
	
	/**
	 * ������IDȡ��
	 * @return puserid ������ID
	 */
	public String getPuserid();
	
	/**
	 * ����������ȡ��
	 * @return pusername ����������
	 */
	public String getPusername();

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid();

	/**
	 * ��������ȡ��
	 * @return pdname ��������
	 */
	public String getPdname();

	/**
	 * ��������ȡ��
	 * @return smscontent ��������
	 */
	public String getSmscontent();

	/**
	 * ��ʼʱ��ȡ��
	 * @return startdate ��ʼʱ��
	 */
	public String getStartdate();

	/**
	 * ����ʱ��ȡ��
	 * @return enddate ����ʱ��
	 */
	public String getEnddate();

	/**
	 * �ƻ�ģʽȡ��
	 * @return pmode �ƻ�ģʽ
	 */
	public String getPmode();

	/**
	 * �ƻ�����ȡ��
	 * @return ptype �ƻ�����
	 */
	public String getPtype();

	/**
	 * �ƻ�ִ��ʱ�䣺Сʱȡ��
	 * @return hour �ƻ�ִ��ʱ�䣺Сʱ
	 */
	public String getPhour();

	/**
	 * �ƻ�ִ��ʱ�䣺����ȡ��
	 * @return pminute �ƻ�ִ��ʱ�䣺����
	 */
	public String getPminute();
	
	/**
	 * �Ƿ����JOBȡ��
	 * @return isAddJob �Ƿ����JOB
	 */
	public String getIsAddJob();
}
