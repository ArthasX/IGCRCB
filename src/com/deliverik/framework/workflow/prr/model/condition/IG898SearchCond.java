/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ������ֵ����������ӿ�
  * ��������: ������ֵ����������ӿ�
  * ������¼: 2013/06/25
  * �޸ļ�¼: 
  */
public interface IG898SearchCond {

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid();
	
	/**
	 * ��������������ȡ��
	 * @return pidid ��������������
	 */
	public String getPidid();
	
	/**
     * ������ȡ��
     * @return pidname ������
     */
    public String getPidname();
    
	/**
	 * �к�ȡ��
	 * @return rownumber �к�
	 */
	public String getRownumber();
	
	/**
	 * ��ȡ����
	 * @return pvcolname �к�
	 */
	public String getPvcolname();
	
	/**
	 * ��ֵ
	 * @return
	 */
	public String getPvalue();
}