/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;

/**
 * ֵ�������DAO�ӿ�ʵ��
 */
@SuppressWarnings("deprecation")
public class DutyPersonDAOImpl extends BaseHibernateDAOImpl<DutyPerson> implements DutyPersonDAO {

	/**
	 * ���캯��
	 */
	public DutyPersonDAOImpl(){
		super(DutyPersonTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyPerson> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dperid"));
		List<DutyPerson> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * @param dadid ����
	 * @return �������
	 */
	public DutyPerson findByPK(Serializable dpid) {
		DutyPerson result = super.findByPK(dpid);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyPersonSearchCond cond){
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
	public List<DutyPerson> findByCond(final DutyPersonSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("dperid"));
		List<DutyPerson> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DutyPersonSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//ֵ��ƻ�ID
		if(cond.getDpid() != null && cond.getDpid() > 0) {
			c.add(Expression.eq("dpid", cond.getDpid()));
		}
		if(StringUtils.isNotEmpty(cond.getDpertime())){
			c.add(Expression.eq("dpertime", cond.getDpertime()));
		}
		if(StringUtils.isNotEmpty(cond.getDperuserid())){
			c.add(Expression.eq("dperuserid", cond.getDperuserid()));
		}
		if(StringUtils.isNotEmpty(cond.getDptype())){
			c.add(Expression.eq("dptype", cond.getDptype()));
		}
		
		if(null != cond.getDpidList() && cond.getDpidList().size() > 0){
			c.add(Expression.in("dpid", cond.getDpidList()));
		}	
		return c;
	}

}
