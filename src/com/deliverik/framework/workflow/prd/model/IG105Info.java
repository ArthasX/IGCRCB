/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ����: ���̲����趨��Ϣ�ӿ�
 * �������������̲����趨��Ϣ�ӿ�
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public interface IG105Info  extends BaseModel {

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ����״̬ȡ��
	 * 
	 * @return ����״̬
	 */
	public String getPrstatus();

	/**
	 * �����̶�ȡ��
	 * 
	 * @return �����̶�
	 */
	public String getPrurgency();

	/**
	 * ���԰汾ȡ��
	 * 
	 * @return ���԰汾
	 */
	public Integer getPsdversion();

	/**
	 * �������ʱ��ȡ��
	 * 
	 * @return �������ʱ��
	 */
	public Double getExpecttime();
	
	/**
	 * ���Դ���ʱ��ȡ��
	 * 
	 * @return ���Դ���ʱ��
	 */
	public String getCreatetime();

}