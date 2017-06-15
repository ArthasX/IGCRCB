/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG941Info;
import com.deliverik.framework.workflow.prr.model.condition.IG941SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG941TB;

/**
 * ���񹤵���־DAOʵ��
 */
@SuppressWarnings("deprecation")
public class IG941DAOImpl extends BaseHibernateDAOImpl<IG941Info> implements IG941DAO {

	/**
	 * ���캯��
	 */
	public IG941DAOImpl(){
		super(IG941TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG941Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("sflid"));
		List<IG941Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param sflid ����
	 * @return �������
	 */
	public IG941Info findByPK(Serializable sflid) {

		IG941Info result = super.findByPK(sflid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG941SearchCond cond){
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
	public List<IG941Info> findByCond(final IG941SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("sflid"));
		List<IG941Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG941SearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();
		
		if(cond.getSfid() != null && cond.getSfid() > 0){
			c.add(Expression.eq("sfid", cond.getSfid()));
		}
		return c;
	}

}
