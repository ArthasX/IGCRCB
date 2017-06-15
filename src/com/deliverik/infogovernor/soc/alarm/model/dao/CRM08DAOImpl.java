/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM08SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM08TB;

/**
  * ����: CRM08DAOʵ��
  * ��������: CRM08DAOʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CRM08DAOImpl extends
		BaseHibernateDAOImpl<CRM08Info> implements CRM08DAO {

	/**
	 * ���캯��
	 */
	public CRM08DAOImpl(){
		super(CRM08TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM08Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM08Info findByPK(Serializable pk) {
		CRM08Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM08SearchCond cond){
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
	public List<CRM08Info> findByCond(final CRM08SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("typecid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CRM08SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getTypeccid_eq())){
			c.add(Expression.eq("typeccid", cond.getTypeccid_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getTypecid_eq())){
			c.add(Expression.eq("typecid", cond.getTypecid_eq()));
		}
		if(cond.getRuletempids() != null && cond.getRuletempids().size() != 0){
			c.add(Expression.in("ruletempid", cond.getRuletempids()));
		}
		if(StringUtils.isNotEmpty(cond.getRuletempname())){
			c.add(Expression.like("ruletempname", "%"+cond.getRuletempname()+"%"));
		}
		if(cond.getTempstate()!=null){
			c.add(Expression.eq("tempstate", cond.getTempstate()));
		}
		return c;
	}

}