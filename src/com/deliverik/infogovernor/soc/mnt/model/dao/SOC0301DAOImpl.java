/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0301TB;

/**
  * ����: DMXʵʱ������ܱ�DAOʵ��
  * ��������: DMXʵʱ������ܱ�DAOʵ��
  * ������¼: 2012/05/16
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0301DAOImpl extends
		BaseHibernateDAOImpl<SOC0301Info> implements SOC0301DAO {

	/**
	 * ���캯��
	 */
	public SOC0301DAOImpl(){
		super(SOC0301TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0301Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0301Info findByPK(Serializable pk) {
		SOC0301Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0301SearchCond cond){
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
	public List<SOC0301Info> findByCond(final SOC0301SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("id"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0301SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getMtId_eq().toString())){
			c.add(Expression.eq("mtId", cond.getMtId_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getMtoName_eq())){
			c.add(Expression.eq("mtoName", cond.getMtoName_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getMtKpi_eq())){
			c.add(Expression.eq("mtKpi", cond.getMtKpi_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getTimestamp_ge())){
			c.add(Expression.ge("timestamp", cond.getTimestamp_ge()));
		}
		return c;
	}
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0301Info> findByCondOrderByTimeAndName(
			SOC0301SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("mtoName"));
		c.addOrder(Order.asc("timeStamp"));
		return findByCriteria(c, start, count);
	}


}