/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.kgm.bl.task;

 import java.util.List;
 import com.deliverik.framework.base.BLException;
 import com.deliverik.framework.base.BaseBLImpl;
 import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
 import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCond;
 import com.deliverik.infogovernor.kgm.model.dao.KnowledgeAppImpactDAO;


/**
 * 
 * @Description:֪ʶҵ��ϵͳ����BLʵ����
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowledgeAppImpactBLImpl extends BaseBLImpl implements KnowledgeAppImpactBL{

  protected KnowledgeAppImpactDAO knowledgeAppImpactDAO;

 public void setKnowledgeAppImpactDAO(KnowledgeAppImpactDAO knowledgeAppImpactDAO) {
 this.knowledgeAppImpactDAO = knowledgeAppImpactDAO;
 }

   /**
    * �־û�����
    * @param KnowledgeAppImpactʵ����
    * @return KnowledgeAppImpactʵ����
    */
 public KnowledgeAppImpact saveKnowledgeAppImpact(KnowledgeAppImpact knowledgeAppImpact) throws BLException{
 return knowledgeAppImpactDAO.save(knowledgeAppImpact);
 }

   /**
    * ������������
    * @param id ����
    * @return �������
    */
 public KnowledgeAppImpact findKnowledgeAppImpactByPK(Integer id) throws BLException{
 return knowledgeAppImpactDAO.findByPK(id);
 }

   /**
    * ȫ������
    * @return ���������
    */
 public List<KnowledgeAppImpact> findAllKnowledgeAppImpact() throws BLException{
 return knowledgeAppImpactDAO.findAll();
 }

   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
 public int getSearchCount(KnowledgeAppImpactSearchCond cond) throws BLException{
 return knowledgeAppImpactDAO.getSearchCount(cond);
 }

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
 public List<KnowledgeAppImpact> findKnowledgeAppImpactByCond(KnowledgeAppImpactSearchCond cond, int start, int count) throws BLException{
 return knowledgeAppImpactDAO.findByCond(cond, start, count);
 }

    /**
     * ɾ������
     * @param KnowledgeAppImpactʵ����
     */
 public void deleteKnowledgeAppImpact(KnowledgeAppImpact knowledgeAppImpact) throws BLException{
knowledgeAppImpactDAO.delete(knowledgeAppImpact);
 }

}

