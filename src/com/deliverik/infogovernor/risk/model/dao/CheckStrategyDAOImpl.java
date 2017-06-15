/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckStrategySearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckStrategyTB;

/**
 * ����: ������DAOʵ�� ��������: ������DAOʵ�� ������¼: 2014/09/02 �޸ļ�¼:
 */
@SuppressWarnings("deprecation")
public class CheckStrategyDAOImpl extends
		BaseHibernateDAOImpl<CheckStrategyInfo> implements CheckStrategyDAO {

	/**
	 * ���캯��
	 */
	public CheckStrategyDAOImpl() {
		super(CheckStrategyTB.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<CheckStrategyInfo> findAll() {
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
	public CheckStrategyInfo findByPK(Serializable pk) {
		CheckStrategyInfo result = super.findByPK(pk);
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
	public int getSearchCount(final CheckStrategySearchCond cond) {
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
	public List<CheckStrategyInfo> findByCond(
			final CheckStrategySearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CheckStrategySearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		// ��������
		if (StringUtils.isNotEmpty(cond.getCsname())) {
			c.add(Restrictions.like("csname", "%" + cond.getCsname() + "%"));
		}
		// ��鷽ʽ
		if (StringUtils.isNotEmpty(cond.getCsrtestmode())) {
			c.add(Restrictions.eq("csrtestmode", cond.getCsrtestmode()));
		}
		// ��Ҫ�̶�
		if (StringUtils.isNotEmpty(cond.getCstype())) {
			c.add(Restrictions.eq("cstype", cond.getCstype()));
		}
		// �����״̬
		if (StringUtils.isNotEmpty(cond.getCsstatus())) {
			c.add(Restrictions.eq("csstatus", cond.getCsstatus()));
		}
		// ����������
		if (StringUtils.isNotEmpty(cond.getCsrolename())) {
			c.add(Restrictions.like("csrolename", "%" + cond.getCsrolename()
					+ "%"));
		}

		// ����������
		if (StringUtils.isNotEmpty(cond.getCsusername())) {
			c.add(Restrictions.like("csusername", "%" + cond.getCsusername()
					+ "%"));
		}
		// Ƶ��
		if (StringUtils.isNotEmpty(cond.getCsfrequency())) {
			c.add(Restrictions.like("csfrequency", "%" + cond.getCsfrequency()
					+ "%"));
		}
		return c;
	}

}