/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����������ӿ�
  * ��������: ����������ӿ�
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
public interface EiWaitTaskInfo extends BaseModel {

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getEitid();

	/**
	 * ���񴴽�ʱ��ȡ��
	 *
	 * @return ���񴴽�ʱ��
	 */
	public String getEitcreatetime();

	/**
	 * ����ciȡ��
	 *
	 * @return ����ci
	 */
	public String getEittopci();

	/**
	 * Դ�ļ���ȡ��
	 *
	 * @return Դ�ļ���
	 */
	public String getEitfilename();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getEitstatus();

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getEitparsestart();

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getEitparseend();

	/**
	 * CIʵ�����ɿ�ʼʱ��ȡ��
	 *
	 * @return CIʵ�����ɿ�ʼʱ��
	 */
	public String getEitcistart();

	/**
	 * CIʵ�����ɽ���ʱ��ȡ��
	 *
	 * @return CIʵ�����ɽ���ʱ��
	 */
	public String getEitciend();

	/**
	 * ��ϵ������ʼʱ��ȡ��
	 *
	 * @return ��ϵ������ʼʱ��
	 */
	public String getEitrelationstart();

	/**
	 * ��ϵ��������ʱ��ȡ��
	 *
	 * @return ��ϵ��������ʱ��
	 */
	public String getEitrelationend();
	
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