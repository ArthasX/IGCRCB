/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;

/**
 * ����汾DAO�ӿ�
 */
public interface ReportFileVersionDAO extends BaseHibernateDAO<ReportFileVersion> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<ReportFileVersion> findAll();

	/**
	 * ������������
	 * @param rdid ����
	 * @return �������
	 */
	public ReportFileVersion findByPK(Serializable rdid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ReportFileVersionSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ReportFileVersion> findByCond(final ReportFileVersionSearchCond cond, final int start, final int count);
}
