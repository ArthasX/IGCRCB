/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sya.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �ƶȻ��ӿ�
  * ��������: �ƶȻ��ӿ�
  * ������¼: 2015-2-5 10:54:32
  * �޸ļ�¼: 
  */
public interface InstitutionInfo extends BaseModel {

	/**
	 * ����ȡ��
	 * @return inid  ����
	 */
	public Integer getInid();

	/**
	 * �ƶ�����ȡ��
	 * @return inname  �ƶ�����
	 */
	public String getInname();


	/**
	 * �ƶ�����ȡ��
	 * @return indesc  �ƶ�����
	 */
	public String getIndesc();

	/**
	 * ����ȡ��
	 * @return attkey  ����
	 */
	public String getAttkey();

	/**
	 * �Ǽ���idȡ��
	 * @return inuserid  �Ǽ���id
	 */
	public String getInuserid();

	/**
	 * �Ǽ�������ȡ��
	 * @return inusername  �Ǽ�������
	 */
	public String getInusername();

	/**
	 * �Ǽ��˻���idȡ��
	 * @return inorgid  �Ǽ��˻���id
	 */
	public String getInorgid();

	/**
	 * �Ǽ��˻�������ȡ��
	 * @return inorgname  �Ǽ��˻�������
	 */
	public String getInorgname();

	/**
	 * ����ʱ��ȡ��
	 * @return createtime  ����ʱ��
	 */
	public String getCreatetime();
	
	/**
	 * �ƶȷ���ȡ��
	 * @return intype  �ƶȷ���
	 */
	public String getIntype();
}