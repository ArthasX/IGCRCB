/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ƴ���������ӿ�
  * ��������: ��ƴ���������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface SOC0105Info extends BaseModel {

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getAuwtid();

	/**
	 * ���񴴽�ʱ��ȡ��
	 *
	 * @return ���񴴽�ʱ��
	 */
	public String getAuwtcreatetime();

	/**
	 * Դ�ļ���ȡ��
	 *
	 * @return Դ�ļ���
	 */
	public String getAuwtfilename();
	
	/**
	 * ����CIȡ��
	 * 
	 * @return ����CI
	 */
	public String getAuwttopci();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getAuwtstatus();

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getAuwtparsestart();

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getAuwtparseend();

	/**
	 * CIʵ�����ɿ�ʼʱ��ȡ��
	 *
	 * @return CIʵ�����ɿ�ʼʱ��
	 */
	public String getAuwtcistart();

	/**
	 * CIʵ�����ɽ���ʱ��ȡ��
	 *
	 * @return CIʵ�����ɽ���ʱ��
	 */
	public String getAuwtciend();

	/**
	 * ɾ����ʶȡ��
	 *
	 * @return ɾ����ʶ
	 */
	public String getDeleteflag();
	
	/**
	 * ����CI����ȡ��
	 *
	 * @return ����CI����
	 */
	public Integer getImpTypeid();
	
	/**
	 * �������������Ϣȡ��
	 * @return �������������Ϣ
	 */
	public SOC0113Info getEiImportProgrammeTB();


}