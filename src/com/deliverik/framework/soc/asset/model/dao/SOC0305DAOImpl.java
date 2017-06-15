/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0305TB;

/**
 * ����: StorageEventDAOʵ�� ��������: StorageEventDAOʵ�� ������¼: 2011/06/13 �޸ļ�¼:
 */
@SuppressWarnings("deprecation")
public class SOC0305DAOImpl extends BaseHibernateDAOImpl<SOC0305Info>
		implements SOC0305DAO {

	/**
	 * ���캯��
	 */
	public SOC0305DAOImpl() {
		super(SOC0305TB.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<SOC0305Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 * 
	 * @param pk
	 *            ����
	 * @return �������
	 */
	public SOC0305Info findByPK(Serializable pk) {
		SOC0305Info result = super.findByPK(pk);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0305SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<SOC0305Info> findByCond(final SOC0305SearchCond cond,
			final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("detectiontime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0305SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getImpcitype())) {
			c.add(Expression.eq("imptypeid", Integer.parseInt(cond.getImpcitype())));
		}
		if (!StringUtils.isEmpty(cond.getEirootmark_eq())) {
			c.add(Expression.eq("eirootmark", "'"+cond.getEirootmark_eq().trim()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getDir_eq())) {
			c.add(Expression.eq("dir", "'"+cond.getDir_eq().trim().toUpperCase()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getErrornum_eq())) {
			c.add(Expression.eq("errornum", "'"+cond.getErrornum_eq().trim()
					.toLowerCase()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getDetectiontime_from())) {
			c.add(Expression.ge("detectiontime", "'"+cond.getDetectiontime_from()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getDetectiontime_to())) {
			c.add(Expression.le("detectiontime", "'"+cond.getDetectiontime_to()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getSeverity_eq())) {
			c.add(Expression.eq("severity", "'"+cond.getSeverity_eq()+"'"));
		}
		if (!StringUtils.isEmpty(cond.getAlarmType())) {
			c.add(Expression.eq("alarmType", cond.getAlarmType()));
		}
		if (!StringUtils.isEmpty(cond.getErrorDesc())) {
			c.add(Expression.like("errordesc", "%"+cond.getErrorDesc()+"%"));
		}
		if (!StringUtils.isEmpty(cond.getId())) {
			c.add(Expression.eq("id", Integer.parseInt(cond.getId())));
		}
		if (!StringUtils.isEmpty(cond.getStatus())) {
			c.add(Expression.eq("status", cond.getStatus()));
		}
		return c;
	}

}