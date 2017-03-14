/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.condition.AdvanceSummarySearchCond;
import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * Ԥ֧����DAO�ӿ�
 *
 */
public interface AdvanceSummaryDAO extends BaseHibernateDAO<AdvanceSummary> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<AdvanceSummary> findAll();

	/**
	 * ������������
	 * @param advanceSummaryTBPK ����
	 * @return �������
	 */
	public AdvanceSummary findByPK(Serializable advanceSummaryTBPK);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AdvanceSummarySearchCond cond);
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AdvancesummaryCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AdvanceSummary> findByCond(final AdvanceSummarySearchCond cond, final int start, final int count);
	
	
	/**Ԥ֧�¶�ͳ��
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AdvanceSummary> findByCond(final AdvancesummaryCond cond, final int start, final int count);
	
}
