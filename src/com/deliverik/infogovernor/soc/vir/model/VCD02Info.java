/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������Դ��Ŀ��Ϣ�ӿ�
  * ��������: ������Դ��Ŀ��Ϣ�ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD02Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * ��Ŀ����ȡ��
	 *
	 * @return ��Ŀ����
	 */
	public String getProjectName();

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getExpectDeployTime();

	/**
	 * ��Ŀ����ʱ��ȡ��
	 *
	 * @return ��Ŀ����ʱ��
	 */
	public String getProjectExpireTime();

	/**
	 * ��Ŀ���ȡ��
	 *
	 * @return ��Ŀ���
	 */
	public String getProjectType();

	/**
	 * ��Ŀ˵��ȡ��
	 *
	 * @return ��Ŀ˵��
	 */
	public String getProjectDesc();

	/**
	 * ����˵��ȡ��
	 *
	 * @return ����˵��
	 */
	public String getProjectApplyReason();

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getOrgsyscoding();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getOrgname();

	/**
	 * �Զ��������ȡ��
	 *
	 * @return �Զ��������
	 */
	public String getProgress();

}