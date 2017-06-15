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
import com.deliverik.infogovernor.rpt.model.SOC0409Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0409SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0409TB;

/**
  * ����: ����pvʵʱ��DAOʵ��
  * ��������: ����pvʵʱ��DAOʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVHostRealTimeDAOImpl������ΪSOC0409DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0409DAOImpl extends
		BaseHibernateDAOImpl<SOC0409Info> implements SOC0409DAO {

	/**
	 * ���캯��
	 */
	public SOC0409DAOImpl(){
		super(SOC0409TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0409Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0409Info findByPK(Serializable pk) {
		SOC0409Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0409SearchCond cond){
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
	public List<SOC0409Info> findByCond(final SOC0409SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0409SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getHostName_eq())){
			c.add(Expression.eq("hostName", cond.getHostName_eq()));
		}
		if(!StringUtils.isEmpty(cond.getSName_eq())){
			c.add(Expression.eq("sName", cond.getSName_eq()));
		}
		if("-1".equals(cond.getHostName_eq()) && cond.getHostName_notin()!=null && !StringUtils.isEmpty(cond.getSName_eq())){//��ѯδʹ��LUNID
			c.add(Expression.not(Expression.in("hostName",cond.getHostName_notin())));
			c.add(Expression.eq("sName",cond.getSName_eq()));
		}
		c.addOrder(Order.asc("lunid"));
		return c;
	}

}