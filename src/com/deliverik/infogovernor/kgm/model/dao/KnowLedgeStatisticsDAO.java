/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCond;

/**
 * ����: ֪ʶ��ͳ��DAO�ӿ�
 * ����������֪ʶ��ͳ��DAO�ӿ�
 * ������¼��wanglei 2014/3/13
 * �޸ļ�¼��
 */
public interface KnowLedgeStatisticsDAO extends BaseHibernateDAO<KnowLedgeInfo> {

	/**
	 * ������������(��������)
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeStatisticsInfo> findByKnprofferCond(final KnowledgeStatisticsSearchCond cond,
			final int start, final int count);
	
	/**
	 * ������������(������)
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeStatisticsInfo> findByKnclassCond(final KnowledgeStatisticsSearchCond cond,
			final int start, final int count);
}
