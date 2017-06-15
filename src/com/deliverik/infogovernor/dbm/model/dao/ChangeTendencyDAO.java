package com.deliverik.infogovernor.dbm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;
import com.deliverik.infogovernor.dbm.model.condition.ChangeTendencySearchCond;

public interface ChangeTendencyDAO extends BaseHibernateDAO<ChangeTendency>{


	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public abstract int getSearchCount(final ChangeTendencySearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public abstract List<ChangeTendency> findByCond(
			final ChangeTendencySearchCond cond, final int start,
			final int count);
}