/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;

/**
  * ����: ��֯�ܹ���������������ӿ�
  * ��������: ��֯�ܹ���������������ӿ�
  * ������¼: 2015/03/09
  * �޸ļ�¼: 
  */
public interface StructureRoleSearchCond {
    /**
     * ��֯�ܹ������ȡ��
     *
     * @return ��֯�ܹ������
     */
    public String getSyscoding();

    /**
     * ��֯�ܹ�cidȡ��
     *
     * @return ��֯�ܹ�cid
     */
    public String getCid();

    /**
     * ��֯�ܹ�����ȡ��
     *
     * @return ��֯�ܹ�����
     */
    public String getSname();

    /**
     * ��ɫidȡ��
     *
     * @return ��ɫid
     */
    public Integer getRoleid();

    /**
     * ��ɫ����ȡ��
     *
     * @return ��ɫ����
     */
    public String getRolename();

    /**
     * ��֯�ܹ����� YӦ����֯�ܹ���R�ճ���֯�ܹ�ȡ��
     *
     * @return ��֯�ܹ����� YӦ����֯�ܹ���R�ճ���֯�ܹ�
     */
    public String getSrtype();
    //��ȫƥ��
    public String getSyscoding_q();
    
    public List<Integer> getRoleid_in();
}