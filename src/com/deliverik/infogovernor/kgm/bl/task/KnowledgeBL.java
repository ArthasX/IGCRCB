/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTBPK;


 /**
  * ����:֪ʶ����Ϣҵ���߼��ӿ�
  * ����������֪ʶ����Ϣҵ���߼��ӿ�
  * ������¼��wangxiaoqiang 2010/12/07
  * �޸ļ�¼��
  */
public interface KnowledgeBL extends BaseBL {
	/**
	 * �־û�����
	 * 
	 * @param Knowledgeʵ����
	 * @return Knowledgeʵ����
	 */
	public Knowledge registKnowledge(Knowledge knowledge) throws BLException;

	/**
	 * ������������
	 * 
	 * @param id ����
	 * @return �������
	 */
	public Knowledge searchKnowledgeByPK(KnowledgeTBPK pk) throws BLException;

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<Knowledge> searchAllKnowledge() throws BLException;

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(KnowledgeSearchCond cond) throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Knowledge> searchKnowledgeByCond(KnowledgeSearchCond cond,
			int start, int count) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param Knowledgeʵ����
	 */
	public void deleteKnowledge(Knowledge knowledge) throws BLException;

	/**
	 * �������
	 * 
	 * @param knowledgeProcess�������
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public Knowledge updateKnowledge(Knowledge knowledge) throws BLException;
	
	/**
	 * �������
	 * 
	 * @param knowledgeProcess�������
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public Integer getMaxknid() throws BLException;
	
	/**
	 * ����û���������ļ�¼
	 * 
	 * @param knowledgeProcess�������
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public int getSearchNotCheckCount(KnowledgeSearchCond knowledgeSearchCond) throws BLException;	
	
	/**
	 * �������
	 * 
	 * @param knowledgeProcess�������
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public Integer getMaxVersion(Integer knid) throws BLException;
	
	/**
	 * ֪ʶ��ʷ�汾ȡ��
	 * @param knowledgeSearchCond
	 * @return
	 * @throws BLException
	 */
	public List<Knowledge> getKnowledgeHistory(KnowledgeSearchCond knowledgeSearchCond) throws BLException;
	/**
	 * ����֪ʶid������ǰ��Ч֪ʶ����
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public Knowledge searchKnowledgeByByKnid(KnowledgeSearchCond cond) throws BLException;
	
	/**
	 * ֪ʶ���к�ȡ��
	 * 
	 * @param cond ��������
	 * @return ֪ʶ���к�
	 */
	public String getKnserial() throws BLException;
}

