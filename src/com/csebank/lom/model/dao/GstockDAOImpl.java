/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.condition.GstockSearchCond;
import com.csebank.lom.model.entity.GstockTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ��ƷDAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class GstockDAOImpl extends BaseHibernateDAOImpl<Gstock> implements GstockDAO {

	/**
	 * ���캯�� 
	 */
	public GstockDAOImpl(){
		super(GstockTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Gstock> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("gsid"));
		List<Gstock> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param gsid ����
	 * @return �������
	 */
	public Gstock findByPK(Serializable gsid) {
		Gstock result = super.findByPK(gsid);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GstockSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Gstock> findByCond(final GstockSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("gsid"));
		List<Gstock> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(GstockSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGscode())){
			c.add(Expression.eq("gscode", cond.getGscode()));
		}
		
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGsname())){
			c.add(Expression.like("gsname", "%"+cond.getGsname()+"%"));
		}
		
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGscategory())){
			c.add(Expression.like("gscategory", cond.getGscategory()+"%"));
		}
		
		//�������������
		if(StringUtils.isNotEmpty(cond.getGsorg())){
			c.add(Expression.eq("gsorg", cond.getGsorg()));
		}
		
		return c;
	}

}
