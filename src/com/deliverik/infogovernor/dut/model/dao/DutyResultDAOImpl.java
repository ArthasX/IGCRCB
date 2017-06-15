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
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyResultTB;

/**
 * ֵ��������DAOʵ��
 */
@SuppressWarnings("deprecation")
public class DutyResultDAOImpl extends BaseHibernateDAOImpl<DutyResult> implements DutyResultDAO {

	/**
	 * ���캯��
	 */
	public DutyResultDAOImpl(){
		super(DutyResultTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyResult> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dadtype"));
		c.addOrder(Order.asc("dattime"));
		c.addOrder(Order.asc("dadname"));
		List<DutyResult> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rcid ����
	 * @return �������
	 */
	public DutyResult findByPK(Serializable rcid) {

		DutyResult result = super.findByPK(rcid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyResultSearchCond cond){
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
	public List<DutyResult> findByCond(final DutyResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("dadtype"));
		c.addOrder(Order.asc("dattime"));
		c.addOrder(Order.asc("dadname"));
		List<DutyResult> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DutyResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//ֵ��ƻ�ID
		if(cond.getDpid() != null && cond.getDpid() > 0) {
			c.add(Expression.eq("dpid", cond.getDpid()));
		}
		//ֵ������ID
		if(cond.getDadid() != null && cond.getDadid() > 0) {
			c.add(Expression.eq("dadid", cond.getDadid()));
		}
		
		//ֵ������
		if(StringUtils.isNotEmpty(cond.getDptime())) {
			c.add(Expression.eq("dptime", cond.getDptime()));
		}
		
		//�������
		if(StringUtils.isNotEmpty(cond.getDadname())){
			c.add(Expression.like("dadname", "%"+cond.getDadname()+"%"));
		}
		
		//ʱ���
		if( !StringUtils.isEmpty(cond.getDclosetime())){
			c.add(Expression.le("dptime", cond.getDclosetime()));
		}
		if( !StringUtils.isEmpty(cond.getDopentime())){
			c.add(Expression.ge("dptime", cond.getDopentime()));
		}
		//ֵ�����ڣ����ڵ���ƥ�䣩
		if(StringUtils.isNotEmpty(cond.getDptime_ge())){
			c.add(Expression.ge("dptime", cond.getDptime_ge()));
		}
		//ֵ�����ڣ�С�ڵ���ƥ�䣩
		if(StringUtils.isNotEmpty(cond.getDptime_le())){
			c.add(Expression.le("dptime", cond.getDptime_le()));
		}
		//ֵ������
		if(StringUtils.isNotEmpty(cond.getDadcategory())){
			c.add(Expression.eq("dadcategory", cond.getDadcategory()));
		}
		//���������ƥ�䣩
		if(StringUtils.isNotEmpty(cond.getIsNullDrcontent())){
			c.add(Expression.or(Expression.eq("drcontent",""), Expression.isNull("drcontent")));
		}
		if(StringUtils.isNotEmpty(cond.getDattime())){
			c.add(Expression.eq("dattime", cond.getDattime()));
		}
		return c;
	}



}
