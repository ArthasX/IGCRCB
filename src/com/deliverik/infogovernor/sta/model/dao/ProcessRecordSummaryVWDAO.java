package com.deliverik.infogovernor.sta.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;
import com.deliverik.infogovernor.sta.model.condition.ProcessRecordSummarySearchCond;

public interface ProcessRecordSummaryVWDAO extends BaseHibernateDAO<ProcessRecordSummary> {
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessRecordSummary> findByCond(final ProcessRecordSummarySearchCond cond, final int start,
			final int count);
}
