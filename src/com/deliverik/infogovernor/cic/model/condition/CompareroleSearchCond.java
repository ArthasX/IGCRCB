/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * ����: �Աȹ�����������ӿ�
  * ��������: �Աȹ�����������ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareroleSearchCond {
	
	public Integer getCrsystemid();
	
	public String getCrtype();

    /** 
     * �ȶ���������� ȡ��
     * @return cpid �ȶ���������� 
     */
    public Integer getCpid();
}