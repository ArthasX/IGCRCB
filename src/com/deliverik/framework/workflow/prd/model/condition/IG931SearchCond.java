/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ȱʡ״̬�����߹����������Ͷ������������ӿ�
  * ��������: ȱʡ״̬�����߹����������Ͷ������������ӿ�
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public interface IG931SearchCond {

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
     * @return the ����ģ��״̬��a���ã�iͣ�ã�t���ԣ�
     */
    public String[] getPtstatuses();
}