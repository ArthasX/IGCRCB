/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;

/**
 * ����: ֪ʶ���ѯ��DAO�ӿ�
 * ����������֪ʶ���ѯ��DAO�ӿ�
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public interface KnowLedgeInfoDAO extends BaseHibernateDAO<KnowLedgeInfo> {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final KnowledgeSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowLedgeInfo> findByCond(final KnowledgeSearchCond cond,
			final int start, final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowLedgeInfo> findByCondTime(final KnowledgeSearchCond cond, final int start, final int count);
	
	/**
	 * ���������Ź���֪ʶ����
	 * @return ���������Ź���֪ʶ����
	 */
	public List<KnowLedgeInfo> findKgmSummary();
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public int findByCondForCount(final KnowledgeSearchCond cond);
}
