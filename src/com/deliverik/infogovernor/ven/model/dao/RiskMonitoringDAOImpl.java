/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskMonitoringSearchCond;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;

/**
  * ����: ���ռ���DAOʵ��
  * ��������: ���ռ���DAOʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class RiskMonitoringDAOImpl extends
		BaseHibernateDAOImpl<RiskMonitoringInfo> implements RiskMonitoringDAO {

	/**
	 * ���캯��
	 */
	public RiskMonitoringDAOImpl(){
		super(RiskMonitoringTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskMonitoringInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskMonitoringInfo findByPK(Serializable pk) {
		RiskMonitoringInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskMonitoringSearchCond cond){
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
	public List<RiskMonitoringInfo> findByCond(final RiskMonitoringSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskMonitoringSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getRsid() != null && !(cond.getRsid().equals("0"))) {
			c.add(Restrictions.eq("rsid", cond.getRsid()));
		}
		// �����������
		if (StringUtils.isNotEmpty(cond.getRmname())) {
			c.add(Restrictions.like("rmname", "%" + cond.getRmname() + "%"));
		}
		// �ƻ���ʼʱ��
		if (StringUtils.isNotEmpty(cond.getRmstartdate_from())
				&& StringUtils.isNotEmpty(cond.getRmstartdate_to())) {
			c.add(Restrictions.ge("rmstartdate", cond.getRmstartdate_from()));
			c.add(Restrictions.le("rmstartdate", cond.getRmstartdate_to()));
		} else if (StringUtils.isNotEmpty(cond.getRmstartdate_from())) {
			c.add(Restrictions.ge("rmstartdate", cond.getRmstartdate_from()));
		} else if (StringUtils.isNotEmpty(cond.getRmstartdate_to())) {
			c.add(Restrictions.le("rmstartdate", cond.getRmstartdate_to()));
		}
		// ���ʱ��
		if (StringUtils.isNotEmpty(cond.getRmenddate_from())
				&& StringUtils.isNotEmpty(cond.getRmenddate_to())) {
			c.add(Restrictions.ge("rmenddate", cond.getRmenddate_from()));
			c.add(Restrictions.le("rmenddate", cond.getRmenddate_to()));
		} else if (StringUtils.isNotEmpty(cond.getRmenddate_from())) {
			c.add(Restrictions.ge("rmenddate", cond.getRmenddate_from()));
		} else if (StringUtils.isNotEmpty(cond.getRmenddate_to())) {
			c.add(Restrictions.le("rmenddate", cond.getRmenddate_to()));
		}
		c.addOrder(Order.desc("rmid"));
		return c;
	}

}