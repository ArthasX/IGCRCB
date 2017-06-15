/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeGradeTB;

/**
 * 
 * @Description:֪ʶ����DAOʵ��
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class KnowledgeGradeDAOImpl extends BaseHibernateDAOImpl<KnowledgeGrade>
		implements KnowledgeGradeDAO {
	/**
	 * ���캯��
	 */
	public KnowledgeGradeDAOImpl() {
		super(KnowledgeGradeTB.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<KnowledgeGrade> findAll() {
		return null;
	}

	/**
	 * ������������
	 * 
	 * @param id
	 *            ����
	 * @return �������
	 */
	public KnowledgeGrade findByPK(Serializable id) {
		KnowledgeGrade result = super.findByPK(id);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(final KnowledgeGradeSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

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
			final int start, final int count) {
		 	DetachedCriteria c = getCriteria(cond);
		 	c.addOrder(Order.desc("kgtime"));
			List<KnowledgeGrade> ret = findByCriteria(c, start, count);
	       return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(KnowledgeGradeSearchCond cond) {
	       DetachedCriteria c = getDetachedCriteria();
	        //֪ʶID
			if(cond.getKnid()!=null){
				c.add(Expression.eq("knid", cond.getKnid()));
			}
		
	       return c;
	   }
}
