package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.SMSLog;
import com.deliverik.infogovernor.sym.model.condition.SMSLogSearchCond;

public interface SMSLogDAO extends BaseHibernateDAO<SMSLog>{

	/**
	 * ȫ������
	 * @return ���������
	 */
	public abstract List<SMSLog> findAll();

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public abstract List<SMSLog> findByCond(final SMSLogSearchCond cond,
			final int start, final int count);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public abstract int getSearchCount(final SMSLogSearchCond cond);

}