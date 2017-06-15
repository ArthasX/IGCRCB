/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��Ŀ�ܱ���Ա�������ӿ�
  * ��������: ��Ŀ�ܱ���Ա�������ӿ�
  * ������¼: 2016/08/11
  * �޸ļ�¼: 
  */
public interface EvaluationContentInfo extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getEvid();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid();

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public Integer getSortId();

	/**
	 * �ڵ�����ȡ��
	 *
	 * @return �ڵ�����
	 */
	public String getStepName();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPeoples();

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getStartTime();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getStopTime();


	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getSuggestion();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getEvpeople();

	
	/**  
	 * ��ȡpsdid  
	 * @return psdid 
	 */
	public String getPsdid();
	
	/**  
	 * ��ȡdoTime  
	 * @return doTime 
	 */
	public String getDoTime();
	
	/**  
	 * ��ȡflowType  
	 * @return flowType 
	 */
	public String getFlowType();
}