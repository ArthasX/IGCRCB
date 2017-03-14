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
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;

/**
 * ���񹤵���������DAOʵ��
 */
@SuppressWarnings("deprecation")
public class IG715DAOImpl extends BaseHibernateDAOImpl<IG715Info> implements IG715DAO {

	/**
	 * ���캯��
	 */
	public IG715DAOImpl(){
		super(IG715TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG715Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("sfid"));
		List<IG715Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param raid ����
	 * @return �������
	 */
	public IG715Info findByPK(Serializable sfid) {

		IG715Info result = super.findByPK(sfid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG715SearchCond cond){
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
	public List<IG715Info> findByCond(final IG715SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("sprrid"));
		List<IG715Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG715SearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();

		if(null != cond.getSprrid()){
			c.add(Expression.eq("sprrid", cond.getSprrid()));
		}
		if(null != cond.getSprrsfid()){
			c.add(Expression.eq("sprrsfid", cond.getSprrsfid()));
		}
		if(null != cond.getSprrprid()){
			c.add(Expression.eq("sprrprid", cond.getSprrprid()));
		}

		return c;
	}

	/**
	 * ��ȡ���񹤵���������ʵ��
	 * @return ���񹤵���������ʵ��
	 */
	public IG715TB getIG715TBInstance() {

		return  new IG715TB();
		
	}

}
