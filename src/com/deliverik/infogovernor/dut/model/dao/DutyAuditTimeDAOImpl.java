/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyAuditTimeTB;

/**
 * ֵ��������ʱ���߼�ʵ����
 *
 */
@SuppressWarnings("deprecation")
public class DutyAuditTimeDAOImpl  extends BaseHibernateDAOImpl<DutyAuditTime> implements DutyAuditTimeDAO{
    
	/**
	 * ���캯��
	 */
	public DutyAuditTimeDAOImpl(){
		super(DutyAuditTimeTB.class);
	}
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyAuditTime> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("datid"));
		List<DutyAuditTime> ret = findByCriteria(c);

		return ret;
	}
	
	/**
	 * ������������
	 * @param acrid ����
	 * @return �������
	 */
	public DutyAuditTime findByPK(Serializable datid) {

		DutyAuditTime result = super.findByPK(datid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyAuditTimeSearchCond cond){
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
	public List<DutyAuditTime> findByCond(final DutyAuditTimeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("datid"));
		List<DutyAuditTime> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DutyAuditTimeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getDadid()!=null && cond.getDadid()!=0){
			c.add(Expression.eq("dadid", cond.getDadid()));
		}
		return c;
	}
	

}
