/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CI�������������ӿ�
  * ��������: CI�������������ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIWaitTaskInfo extends BaseModel {

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getCiwtid();

	/**
	 * ���񴴽�ʱ��ȡ��
	 *
	 * @return ���񴴽�ʱ��
	 */
	public String getCiwtcreatetime();

	/**
	 * Դ�ļ���ȡ��
	 *
	 * @return Դ�ļ���
	 */
	public String getCiwtfilename();
	
	/**
	 * ����CIȡ��
	 * 
	 * @return ����CI
	 */
	public String getCiwttopci();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getCiwtstatus();

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getCiwtparsestart();

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getCiwtparseend();

	/**
	 * CIʵ�����ɿ�ʼʱ��ȡ��
	 *
	 * @return CIʵ�����ɿ�ʼʱ��
	 */
	public String getCiwtcistart();

	/**
	 * CIʵ�����ɽ���ʱ��ȡ��
	 *
	 * @return CIʵ�����ɽ���ʱ��
	 */
	public String getCiwtciend();
	
	/**
	 * �߼�ɾ����ʶ�趨
	 *
	 * @param deleteflag�߼�ɾ����ʶ
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
	public EiImportProgrammeInfo getEiImportProgrammeTB();


}