/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��鹤��ͳ�Ʊ���ӿ�
  * ��������: ��鹤��ͳ�Ʊ���ӿ�
  * ������¼: 2014/07/09
  * �޸ļ�¼: 
  */
public interface CheckWorkConutVWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRcid();

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getRcname();
	
	/**
	 * �����˵��ȡ��
	 * @return the rcdesc
	 */
	public String getRcdesc();

	/**
	 * ���Ƶ��ȡ��
	 *
	 * @return ���Ƶ��
	 */
	public String getRcfrequency();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRcusername();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRccategoryname();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtitle();

	/**
	 * ��鷽ʽȡ��
	 *
	 * @return ��鷽ʽ
	 */
	public String getRcrtestmode();

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public String getRcstatus();

	/**
	 * ʵ�ʼ��ʱ��ȡ��
	 *
	 * @return ʵ�ʼ��ʱ��
	 */
	public String getRccreatetime();

	/**
	 * ���˵��ȡ��
	 *
	 * @return ���˵��
	 */
	public String getRcrcomment();

	/**
	 * ���̶�ȡ��
	 *
	 * @return ���̶�
	 */
	public String getRcrresult();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRcrattch();

	/**
	 * ���ƻ�ʱ��ȡ��
	 *
	 * @return ���ƻ�ʱ��
	 */
	public String getRcrplandate();
	
	/**��鿪ʼʱ��*/
	public String getRcstartdate();
	
	/**
	 * ���ռ������ȡ��
	 * @return rcclass ���ռ������
	 */
	public String getRcclass();
	/**
	 * ����idȡ��
	 * @return attachid ����id
	 */
	public String getAttachid();

}