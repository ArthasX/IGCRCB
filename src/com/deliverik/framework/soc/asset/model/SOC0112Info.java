/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0111TB;

/**
  * ����: �ʲ�����ϸ��ӿ�
  * ��������: �ʲ�����ϸ��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0112Info extends BaseModel {

	/**
	 * �ʲ���IDȡ��
	 *
	 * @return �ʲ���ID
	 */
	public Integer getEiddid();

	/**
	 * �ʲ���汾ȡ��
	 *
	 * @return �ʲ���汾
	 */
	public Integer getEiddversion();

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�ID
	 */
	public String getEiname();

	/**
	 * �ʲ�����汾ȡ��
	 *
	 * @return �ʲ�����汾
	 */
	public Integer getEiImportversion();
	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag();
	
	/**
	 * ����Ϣȡ��
	 * @return ����Ϣ
	 */
	public SOC0111TB getEiDomainDefTB();

}