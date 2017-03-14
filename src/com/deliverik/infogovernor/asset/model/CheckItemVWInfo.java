/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������ѯ�ӿ�
  * ��������: ������ѯ�ӿ�
  * ������¼: 2014/07/01
  * �޸ļ�¼: 
  */
public interface CheckItemVWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 *
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�����
	 */
	public String getEiname();

	/**
	 * �ʲ�˵��ȡ��
	 *
	 * @return �ʲ�˵��
	 */
	public String getEidesc();

	/**
	 * �ʲ����ȡ��
	 *
	 * @return �ʲ����
	 */
	public String getEilabel();

	/**
	 * �ʲ�����ʱ��ȡ��
	 *
	 * @return �ʲ�����ʱ��
	 */
	public String getEiupdtime();

	/**
	 * �ʲ�״̬ȡ��
	 *
	 * @return �ʲ�״̬
	 */
	public String getEistatus();

	/**
	 * �ʲ��汾��ȡ��
	 *
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion();

	/**
	 * �ʲ��Ǽ���ȡ��
	 *
	 * @return �ʲ��Ǽ���
	 */
	public String getEiinsdate();

	/**
	 * �ʲ��������������ȡ��
	 *
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding();

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 *
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding();

	/**
	 * �ʲ�������ȡ��
	 *
	 * @return �ʲ�������
	 */
	public String getEiuserid();

	/**
	 * �ʲ�����������ȡ��
	 *
	 * @return �ʲ�����������
	 */
	public String getEiusername();

	/**
	 * �ʲ�С�汾ȡ��
	 *
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion();

	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 *
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark();

	/**
	 * �ʲ�������ȡ��
	 *
	 * @return �ʲ�������
	 */
	public String getManagername();

	/**
	 * ���ϵ���ȡ��
	 *
	 * @return ���ϵ���
	 */
	public String getDatady();

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getBh();

	/**
	 * ��̸����ȡ��
	 *
	 * @return ��̸����
	 */
	public String getViewobj();

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getRiskly();

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getRiskarea();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getRiskitem();
	
	/**������Ƶ��*/
	public String getCheckfrequency();
	
	/**
	 * ʹ�÷�Χȡ��
	 * @return mgrange ʹ�÷�Χ
	 */
	public String getMgrange();
	/**
	 * ������idȡ��
	 * @return mguserid ������id
	 */
	public String getMguserid();

}