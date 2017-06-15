/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.kgm.bl.task;

 import java.util.List;
 import com.deliverik.framework.base.BLException;
 import com.deliverik.framework.base.BaseBL;
 import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
 import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;


/**
 * 
 * @Description:֪ʶ����BL�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeGradeBL extends BaseBL{
   /**
    * �־û�����
    * @param KnowledgeGradeʵ����
    * @return KnowledgeGradeʵ����
    */
 public KnowledgeGrade saveKnowledgeGrade(KnowledgeGrade knowledgeGrade) throws BLException;

   /**
    * ������������
    * @param id ����
    * @return �������
    */
 public KnowledgeGrade findKnowledgeGradeByPK(Integer id) throws BLException;

   /**
    * ȫ������
    * @return ���������
    */
 public List<KnowledgeGrade> findAllKnowledgeGrade() throws BLException;

   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
 public int getSearchCount(KnowledgeGradeSearchCond cond) throws BLException;

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
 public List<KnowledgeGrade> findKnowledgeGradeByCond(KnowledgeGradeSearchCond cond, int start, int count) throws BLException;

    /**
     * ɾ������
     * @param KnowledgeGradeʵ����
     */
 public void deleteKnowledgeGrade(KnowledgeGrade knowledgeGrade) throws BLException;

}

