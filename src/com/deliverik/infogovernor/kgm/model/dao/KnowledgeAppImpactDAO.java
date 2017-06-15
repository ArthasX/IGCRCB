/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.util.List;
import java.io.Serializable;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeAppImpactDAO;

/**
 * 
 * @Description:֪ʶҵ��ϵͳ����DAO�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeAppImpactDAO extends BaseHibernateDAO<KnowledgeAppImpact> {
	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<KnowledgeAppImpact> findAll();

	/**
	 * ������������
	 * 
	 * @param id ����
	 * @return �������
	 */
	public KnowledgeAppImpact findByPK(Serializable id);

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final KnowledgeAppImpactSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeAppImpact> findByCond(
			final KnowledgeAppImpactSearchCond cond, final int start,
			final int count);
}
