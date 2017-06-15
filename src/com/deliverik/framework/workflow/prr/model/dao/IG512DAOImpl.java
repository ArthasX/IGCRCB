/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * ���̹�ϵʵ��DAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG512DAOImpl extends BaseHibernateDAOImpl<IG512Info> implements IG512DAO {

	/** Ig512 DAO */
	protected IG512DAO ig512DAO;
	/**
	 * ���캯��
	 */
	public IG512DAOImpl(){
		super(IG512TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG512Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("prrid"));
		List<IG512Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param prrid ����
	 * @return �������
	 */
	public IG512Info findByPK(Serializable prrid) {

		IG512Info result = super.findByPK(prrid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG512SearchCond cond){
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
	public List<IG512Info> findByCond(final IG512SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("prrid"));
		List<IG512Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG512SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��������ID
		if(cond.getParprid() != null && cond.getParprid() > 0){
			c.add(Expression.eq("parprid", cond.getParprid()));
		}
		//��������ID
		if(cond.getCldprid() != null && cond.getCldprid() > 0){
			c.add(Expression.eq("cldprid", cond.getCldprid()));
		}
		return c;
	}

}
