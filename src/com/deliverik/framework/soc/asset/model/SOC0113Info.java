/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����������ӿ�
  * ��������: �����������ӿ�
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
public interface SOC0113Info extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getImpTypeid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getImpTypename();

	/**
	 * ����bat����ȡ��
	 *
	 * @return ����bat����
	 */
	public String getImpProgramme();
	
	/**
	 * ���bat����ȡ��
	 * @return ���bat����
	 */
	public String getImpProgrammeAudit();
	
	/**
	 * ����bat����ȡ��
	 * @return ����bat����
	 */
	public String getImpProgrammeUpdate();
	
	/**
	 * �ű�����ȡ��
	 * @return �ű�����
	 */
	public String getShellname();

}