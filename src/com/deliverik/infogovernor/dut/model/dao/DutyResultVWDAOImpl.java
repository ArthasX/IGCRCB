/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyResultVWSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyResultVW;

/**
 * ֵ���ձ�DAOʵ��
 */
@SuppressWarnings("deprecation")
public class DutyResultVWDAOImpl extends BaseHibernateDAOImpl<DutyResultVWInfo> implements DutyResultVWDAO {

	/**
	 * ���캯��
	 */
	public DutyResultVWDAOImpl(){
		super(DutyResultVW.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyResultVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dadtype"));
		c.addOrder(Order.asc("dattime"));
		c.addOrder(Order.asc("dadname"));
		List<DutyResultVWInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rcid ����
	 * @return �������
	 */
	public DutyResultVWInfo findByPK(Serializable rcid) {

		DutyResultVWInfo result = super.findByPK(rcid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyResultVWSearchCond cond){
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
	public List<DutyResultVWInfo> findByCond(final DutyResultVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("dadtype"));
		c.addOrder(Order.asc("dattime"));
		c.addOrder(Order.asc("dadorderby"));
		//c.addOrder(Order.asc("dattime"));
		//c.addOrder(Order.asc("dadname"));
		List<DutyResultVWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DutyResultVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//ֵ������ID
		if(cond.getDadid() != null && cond.getDadid() > 0) {
			c.add(Expression.eq("dadid", cond.getDadid()));
		}
		
		//ֵ��ƻ�ID
		if(cond.getDpid() != null && cond.getDpid() > 0) {
			c.add(Expression.eq("dpid", cond.getDpid()));
		}
		
		//ֵ������
		if(StringUtils.isNotEmpty(cond.getDadcategory())) {
			c.add(Expression.eq("dadcategory", cond.getDadcategory()));
		}
		
		//
		if(StringUtils.isNotEmpty(cond.getDattime_form()) && StringUtils.isEmpty(cond.getDattime_q())) {
			c.add(Expression.ge("dattime", cond.getDattime_form()));
		}
		
		if(StringUtils.isNotEmpty(cond.getDattime_to()) && StringUtils.isEmpty(cond.getDattime_q())) {
			c.add(Expression.lt("dattime", cond.getDattime_to()));
		}
		
		if(StringUtils.isNotEmpty(cond.getDattime_q())){
			if(StringUtils.isNotEmpty(cond.getDattime_form()) && StringUtils.isNotEmpty(cond.getDattime_to())) {
				StringBuffer buff = new StringBuffer();
				buff.append("(dattime>='");
				buff.append(cond.getDattime_form());
				buff.append("' and dattime<'23:59'");
				buff.append(" or ");
				buff.append("dattime>='00:00' and dattime< '");
				buff.append(cond.getDattime_to());
				buff.append("')");
				c.add(Expression.sql(buff.toString()));
			}
			
			
		}
		
		return c;
	}



}
