/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * ����: ������Դ��Ŀ��Ϣ���������ʵ��
  * ��������: ������Դ��Ŀ��Ϣ���������ʵ��
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public class VIM02SearchCondImpl implements
		VIM02SearchCond {
    
    /** �������  */
    protected String progress_eq;

    /**
     * ��ȡ�������
     * @return ������� 
     */
    public String getProgress_eq() {
        return progress_eq;
    }

    /**
     * ���ò������
     * @param progress_eq �������
     */
    public void setProgress_eq(String progress_eq) {
        this.progress_eq = progress_eq;
    }
    
    
}