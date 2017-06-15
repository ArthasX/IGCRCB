/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;

/**
 * <p>����:����ģ��DAOʵ��</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>          4.������������</p>
 * <p>          5.���������������ȡ��</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("deprecation")
public class IG259DAOImpl extends
		BaseHibernateDAOImpl<IG259Info> implements IG259DAO {

	/**
	 * ���ܣ����캯��
	 */
	public IG259DAOImpl() {
		super(IG259TB.class);
	}

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG259Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ptid"));
		List<IG259Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * @param ptid ����
	 * @return �������
	 */
	public IG259Info findByPK(Serializable ptid) {

		IG259Info pt = super.findByPK(ptid);
		if (pt == null)
			return null;

		return pt;
	}

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG259Info> findByCond(final IG259SearchCond cond, final int start,final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ptid"));
		List<IG259Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG259SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getPtid() != null && cond.getPtid() != 0) {
			c.add(Expression.eq("ptid", cond.getPtid()));
		}
		if (!StringUtils.isEmpty(cond.getPtname())) {
			c.add(Expression.eq("ptname", cond.getPtname()));
		}
		if (!StringUtils.isEmpty(cond.getPttype())) {
			c.add(Expression.eq("pttype", cond.getPttype()));
		}
		if (!StringUtils.isEmpty(cond.getPtstatus())) {
			c.add(Expression.eq("ptstatus", cond.getPtstatus()));
		}
		if (!StringUtils.isEmpty(cond.getPtqrtzflag())) {
			c.add(Expression.like("ptqrtzflag", "%"+cond.getPtqrtzflag()+"%"));
		}
		if (cond.getIsWorkPt()==1) {
			c.add(Expression.like("pttype", "W%"));
		}
		if (cond.getPtstatuses() != null && cond.getPtstatuses().length > 0) {
			c.add(Expression.in("ptstatus", cond.getPtstatuses()));
		}
		return c;
	}

	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG259SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}
