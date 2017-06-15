/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �Աȶ�����ʷ��ӿ�
  * ��������: �Աȶ�����ʷ��ӿ�
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public interface CompareobjectHistoryInfo extends BaseModel {

	/**
	 * ������ʷ������ȡ��
	 *
	 * @return ������ʷ������
	 */
	public Integer getCohid();

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public Integer getCoid();

	/** 
     * �Աȹ������ ȡ��
     * @return fkCrid �Աȹ������ 
     */
    public Integer getFkCrid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getConame();

	/**
	 * �Ա�Ŀ������idȡ��
	 *
	 * @return �Ա�Ŀ������id
	 */
	public Integer getCotarget();

	/**
	 * Դ����IPȡ��
	 *
	 * @return Դ����IP
	 */
	public String getSourceIP();

	/**
	 * targetIPȡ��
	 *
	 * @return targetIP
	 */
	public String getTargetIP();

	/**
	 * �ȶԹ����汾ȡ��
	 *
	 * @return �ȶԹ����汾
	 */
	public Integer getCrversion();
	
	public Integer getCosource();

}