/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �Աȶ���ӿ�
  * ��������: �Աȶ���ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareobjectInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCoid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getConame();

	/**
	 * �Ա�Դ����idȡ��
	 *
	 * @return �Ա�Դ����id
	 */
	public Integer getCosource();

	/**
	 * �Ա�Ŀ������idȡ��
	 *
	 * @return �Ա�Ŀ������id
	 */
	public Integer getCotarget();

	/**
	 * �Աȹ������ȡ��
	 *
	 * @return �Աȹ������
	 */
	public Integer getFkCrid();

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
     * �Աȹ���汾 ȡ��
     * @return crversion �Աȹ���汾 
     */
    public Integer getCrversion();

}