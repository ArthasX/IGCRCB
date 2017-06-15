/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0434Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0434SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0434TB;

/**
  * ����: PVVIODAOʵ��
  * ��������: PVVIODAOʵ��
  * ������¼: 2012/08/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0434DAOImpl extends
		BaseHibernateDAOImpl<SOC0434Info> implements SOC0434DAO {

	/**
	 * ���캯��
	 */
	public SOC0434DAOImpl(){
		super(SOC0434TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0434Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0434Info findByPK(Serializable pk) {
		SOC0434Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0434SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0434Info> findByCond(final SOC0434SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0434SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getSName())){
			c.add(Expression.eq("SNAME", cond.getSName()));
		}
		if(StringUtils.isNotEmpty(cond.getSN())){
			c.add(Expression.eq("SN", cond.getSN()));
		}
		if(StringUtils.isNotEmpty(cond.getIsUsed())){
			c.add(Expression.eq("ISUSED", cond.getIsUsed()));
		}
		c.addOrder(Order.asc("LUNID"));
		return c;
	}

}