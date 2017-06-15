/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import java.io.Serializable;
import java.util.List;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeAppImpactDAO;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeAppImpactTB;

/**
 * 
 * @Description:֪ʶҵ��ϵͳ����DAOʵ��
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class KnowledgeAppImpactDAOImpl extends
		BaseHibernateDAOImpl<KnowledgeAppImpact> implements
		KnowledgeAppImpactDAO {
	/**
	 * ���캯��
	 */
	public KnowledgeAppImpactDAOImpl() {
		super(KnowledgeAppImpactTB.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<KnowledgeAppImpact> findAll() {
		return null;
	}

	/**
	 * ������������
	 * 
	 * @param id ����
	 * @return �������
	 */
	public KnowledgeAppImpact findByPK(Serializable id) {
		KnowledgeAppImpact result = super.findByPK(id);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final KnowledgeAppImpactSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

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
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		List<KnowledgeAppImpact> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(KnowledgeAppImpactSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//֪ʶID
		if(cond.getKnid() != null && cond.getKnid() > 0){
			c.add(Expression.eq("knid", cond.getKnid()));
		}
		//֪ʶ�汾
		if(cond.getKnversion() != null && cond.getKnversion() > 0){
			c.add(Expression.eq("knversion", cond.getKnversion()));
		}
		return c;
	}
}
