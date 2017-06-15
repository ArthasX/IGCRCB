/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.kgm.bl.task;

 import java.util.List;
 import com.deliverik.framework.base.BLException;
 import com.deliverik.framework.base.BaseBL;
 import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
 import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCond;


/**
 * 
 * @Description:֪ʶҵ��ϵͳ����BL�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeAppImpactBL extends BaseBL{
   /**
    * �־û�����
    * @param KnowledgeAppImpactʵ����
    * @return KnowledgeAppImpactʵ����
    */
 public KnowledgeAppImpact saveKnowledgeAppImpact(KnowledgeAppImpact knowledgeAppImpact) throws BLException;

   /**
    * ������������
    * @param id ����
    * @return �������
    */
 public KnowledgeAppImpact findKnowledgeAppImpactByPK(Integer id) throws BLException;

   /**
    * ȫ������
    * @return ���������
    */
 public List<KnowledgeAppImpact> findAllKnowledgeAppImpact() throws BLException;

   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
 public int getSearchCount(KnowledgeAppImpactSearchCond cond) throws BLException;

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
 public List<KnowledgeAppImpact> findKnowledgeAppImpactByCond(KnowledgeAppImpactSearchCond cond, int start, int count) throws BLException;

    /**
     * ɾ������
     * @param KnowledgeAppImpactʵ����
     */
 public void deleteKnowledgeAppImpact(KnowledgeAppImpact knowledgeAppImpact) throws BLException;

}

