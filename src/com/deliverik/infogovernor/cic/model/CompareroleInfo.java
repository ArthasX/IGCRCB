/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �Աȹ���ӿ�
  * ��������: �Աȹ���ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareroleInfo extends BaseModel {

	/**
	 * cridȡ��
	 *
	 * @return crid
	 */
	public Integer getCrid();

	/**
	 * �Ա�����ȡ��
	 *
	 * @return �Ա�����
	 */
	public String getCrtype();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCrname();

	/**
	 * �Ա������ȡ��
	 *
	 * @return �Ա������
	 */
	public Integer getFkCsid();

	/**
	 * ҵ��ϵͳidȡ��
	 *
	 * @return ҵ��ϵͳid
	 */
	public Integer getCrsystemid();

	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return ҵ��ϵͳ����
	 */
	public String getCrsystemname();
	
	/** 
     * �Աȹ���汾 ȡ��
     * @return crversion �Աȹ���汾 
     */
    public Integer getCrversion();
    
}