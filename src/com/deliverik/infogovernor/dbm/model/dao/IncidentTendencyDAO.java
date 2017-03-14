package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;
import com.deliverik.infogovernor.dbm.model.condition.IncidentTendencySearchCond;

public interface IncidentTendencyDAO extends BaseHibernateDAO<IncidentTendency>{

	/**
	 * ȫ������
	 * @return ���������
	 */
	public abstract List<IncidentTendency> findAll();

	/**
	 * ������������
	 * @param id ����
	 * @return �������
	 */
	public abstract IncidentTendency findByPK(Serializable id);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public abstract int getSearchCount(final IncidentTendencySearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public abstract List<IncidentTendency> findByCond(
			final IncidentTendencySearchCond cond, final int start,
			final int count);

}