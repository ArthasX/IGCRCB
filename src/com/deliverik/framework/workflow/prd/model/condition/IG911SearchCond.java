/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ״̬�����߹����������Ͷ������������ӿ�
  * ��������: ״̬�����߹����������Ͷ������������ӿ�
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public interface IG911SearchCond {
    
    /**
     * ����ȡ��
     *
     * @return ����
     */
    public String getPsprpid();

    /**
     * ���̶���idȡ��
     *
     * @return ���̶���id
     */
    public String getPdid() ;

    /**
     * ����״̬idȡ��
     *
     * @return ����״̬id
     */
    public String getPsdid();

    /**
     * �����߽�ɫidȡ��
     *
     * @return �����߽�ɫid
     */
    public Integer getRoleid() ;

    /**
     * @return the ����ģ��״̬��a���ã�iͣ�ã�t���ԣ�
     */
    public String[] getPtstatuses();
    
}