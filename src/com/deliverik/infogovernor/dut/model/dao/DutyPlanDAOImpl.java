/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;
import com.deliverik.infogovernor.dut.model.entity.DutyPlanTB;

/**
 * ֵ�������DAO�ӿ�ʵ��
 */
@SuppressWarnings("deprecation")
public class DutyPlanDAOImpl extends BaseHibernateDAOImpl<DutyPlan> implements DutyPlanDAO {

	/**
	 * ���캯��
	 */
	public DutyPlanDAOImpl(){
		super(DutyPlanTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyPlan> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dpid"));
		List<DutyPlan> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * @param dadid ����
	 * @return �������
	 */
	public DutyPlan findByPK(Serializable dpid) {
		DutyPlan result = super.findByPK(dpid);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyPlanSearchCond cond){
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
	public List<DutyPlan> findByCond(final DutyPlanSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getDptime_ge())) {
			c.addOrder(Order.asc("dptime"));
		} else {
			c.addOrder(Order.asc("dpid"));
		}
		List<DutyPlan> ret = findByCriteria(c, start, count);
		
		for(DutyPlan i : ret){
			lazyLoad(i);
		}

		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DutyPlanSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�ƻ�״̬
		if(StringUtils.isNotEmpty(cond.getDpstatus())){
			c.add(Expression.eq("dpstatus", cond.getDpstatus()));
		}
		//ֵ������
		if(StringUtils.isNotEmpty(cond.getDadcategory())){
			c.add(Expression.eq("dadcategory", cond.getDadcategory()));
		}
		//ֵ�����ڣ����ڵ���ƥ�䣩
		if(StringUtils.isNotEmpty(cond.getDptime_ge())){
			c.add(Expression.ge("dptime", cond.getDptime_ge()));
		}
		//ֵ�����ڣ�С�ڵ���ƥ�䣩
		if(StringUtils.isNotEmpty(cond.getDptime_le())){
			c.add(Expression.le("dptime", cond.getDptime_le()));
		}
		// ֵ��ƻ�������
		if(null != cond.getDpid()){
			c.add(Expression.eq("dpid", cond.getDpid()));
		}
		if(StringUtils.isNotEmpty(cond.getDptime())){
			c.add(Expression.eq("dptime", cond.getDptime()));
		}
		if(StringUtils.isNotEmpty(cond.getDptype())){
			c.add(Expression.eq("dptype", cond.getDptype()));
		}
		return c;
	}

	protected void lazyLoad(DutyPlan info){

		if(info == null) 
			return;

		Hibernate.initialize(info.getDutyPersonList());
		
		for(DutyPersonTB i : info.getDutyPersonList())
			Hibernate.initialize(i);
		
	}

}
