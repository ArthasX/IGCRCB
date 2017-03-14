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

import com.csebank.lom.model.Eatery;
import com.csebank.lom.model.condition.EaterySearchCond;
import com.csebank.lom.model.entity.EateryTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ʳ�óɱ�����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class EateryDAOImpl extends BaseHibernateDAOImpl<Eatery> implements EateryDAO {

	/**
	 * ���캯��
	 */
	public EateryDAOImpl(){
		super(EateryTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Eatery> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("edate"));
		List<Eatery> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public Eatery findByPK(Serializable eid) {

		Eatery result = super.findByPK(eid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EaterySearchCond cond){
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
	public List<Eatery> findByCond(final EaterySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("edate"));
		List<Eatery> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EaterySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	
		//ʳ�óɱ���Ϣ��ʼʱ��
		if(StringUtils.isNotEmpty(cond.getEtime_from())){
			c.add(Expression.ge("edate", cond.getEtime_from()));
		}

		//ʳ�óɱ���Ϣ����ʱ��
		if(StringUtils.isNotEmpty(cond.getEtime_to())){
			c.add(Expression.le("edate", cond.getEtime_to()));
		}

		return c;
	}

}
