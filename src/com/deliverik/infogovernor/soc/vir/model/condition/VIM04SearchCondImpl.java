/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * ����: ��־���������ʵ��
  * ��������: ��־���������ʵ��
  * ������¼: 2014/02/19
  * �޸ļ�¼: 
  */
public class VIM04SearchCondImpl implements
		VIM04SearchCond {

    /** ��Ŀ���� */
    protected Integer pid_eq;

    /**
     * ��ȡ��Ŀ����
     * @return ��Ŀ���� 
     */
    public Integer getPid_eq() {
        return pid_eq;
    }

    /**
     * ������Ŀ����
     * @param pid_eq ��Ŀ����
     */
    public void setPid_eq(Integer pid_eq) {
        this.pid_eq = pid_eq;
    }
    
}