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
import com.deliverik.infogovernor.rpt.model.SOC0429Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0429SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0429VW;

/**
  * ����: ����������ͼDAOʵ��
  * ��������: ����������ͼDAOʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��HostCapacityRealTimeVWDAOImpl������ΪSOC0429DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0429DAOImpl extends
		BaseHibernateDAOImpl<SOC0429Info> implements SOC0429DAO {

	/**
	 * ���캯��
	 */
	public SOC0429DAOImpl(){
		super(SOC0429VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0429Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("hostName"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0429Info findByPK(Serializable pk) {
		SOC0429Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0429SearchCond cond){
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
	public List<SOC0429Info> findByCond(final SOC0429SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0429SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getBcId_eq()!=0){
			c.add(Expression.eq("bcid",cond.getBcId_eq()));
		}
		if(!StringUtils.isEmpty(cond.getSName_eq())){
			c.add(Expression.eq("sName",cond.getSName_eq()));
		}
		if(!StringUtils.isEmpty(cond.getBcName_eq())){
			c.add(Expression.eq("bcName",cond.getBcName_eq()));
		}
		return c;
	}

}