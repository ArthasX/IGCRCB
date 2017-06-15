/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeGradeDAO;

/**
 * ����:֪ʶ����BLʵ����
 * ����������֪ʶ����BLʵ����
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public class KnowledgeGradeBLImpl extends BaseBLImpl implements
		KnowledgeGradeBL {

	/**֪ʶ����DAO */
	protected KnowledgeGradeDAO knowledgeGradeDAO;

	/**
	 * ֪ʶ����DAO�趨
	 * @param knowledgeGradeDAO ֪ʶ����DAO
	 */
	public void setKnowledgeGradeDAO(KnowledgeGradeDAO knowledgeGradeDAO) {
		this.knowledgeGradeDAO = knowledgeGradeDAO;
	}

	/**
	 * �־û�����
	 * 
	 * @param KnowledgeGradeʵ����
	 * @return KnowledgeGradeʵ����
	 */
	public KnowledgeGrade saveKnowledgeGrade(KnowledgeGrade knowledgeGrade)
			throws BLException {
		return knowledgeGradeDAO.save(knowledgeGrade);
	}

	/**
	 * ������������
	 * 
	 * @param id ����
	 * @return �������
	 */
	public KnowledgeGrade findKnowledgeGradeByPK(Integer id) throws BLException {
		return knowledgeGradeDAO.findByPK(id);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<KnowledgeGrade> findAllKnowledgeGrade() throws BLException {
		return knowledgeGradeDAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(KnowledgeGradeSearchCond cond) throws BLException {
		return knowledgeGradeDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeGrade> findKnowledgeGradeByCond(
			KnowledgeGradeSearchCond cond, int start, int count)
			throws BLException {
		return knowledgeGradeDAO.findByCond(cond, start, count);
	}

	/**
	 * ɾ������
	 * 
	 * @param KnowledgeGradeʵ����
	 */
	public void deleteKnowledgeGrade(KnowledgeGrade knowledgeGrade)
			throws BLException {
		knowledgeGradeDAO.delete(knowledgeGrade);
	}

}
