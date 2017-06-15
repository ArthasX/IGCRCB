/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCond;

/**
 * ����: ֪ʶ���ѯ��ϢDAO�ӿ�
 * ����������֪ʶ���ѯ��ϢDAO�ӿ�
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public interface KnowledgeProcessDAO extends BaseHibernateDAO<KnowledgeProcess> {
	
	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<KnowledgeProcess> findAll();

	/**
	 * ������������
	 * 
	 * @param kpid����
	 * @return �������
	 */
	public KnowledgeProcess findByPK(Serializable kpid);

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(final KnowledgeProcessSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> findByCond(
			final KnowledgeProcessSearchCond cond, final int start,
			final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> findByCond_KnowledgeProcess(
			final KnowledgeProcessSearchCond cond, final int start,
			final int count);
}
