/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * ������DAO�ӿ�
 */
public interface ReportFileDefinitionDAO extends BaseHibernateDAO<ReportFileDefinition> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<ReportFileDefinition> findAll();

	/**
	 * ������������
	 * @param rdid ����
	 * @return �������
	 */
	public ReportFileDefinition findByPK(Serializable rdid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ReportFileDefinitionSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ReportFileDefinition> findByCond(final ReportFileDefinitionSearchCond cond, final int start, final int count);
}
