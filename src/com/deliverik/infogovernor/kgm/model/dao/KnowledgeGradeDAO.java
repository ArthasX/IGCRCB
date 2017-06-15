/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;

/**
 * 
 * @Description:֪ʶ����DAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeGradeDAO extends BaseHibernateDAO<KnowledgeGrade> {
	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<KnowledgeGrade> findAll();

	/**
	 * ������������
	 * 
	 * @param id
	 *            ����
	 * @return �������
	 */
	public KnowledgeGrade findByPK(Serializable id);

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(final KnowledgeGradeSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeGrade> findByCond(final KnowledgeGradeSearchCond cond,
			final int start, final int count);
}
