/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditResultSearchCond;

/**
 * ������ƽ��DAO�ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskAuditResultDAO extends BaseHibernateDAO<RiskAuditResult> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAuditResult> findAll();

	/**
	 * ������������
	 * @param rarid ����
	 * @return �������
	 */
	public RiskAuditResult findByPK(Serializable rarid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditResultSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditResult> findByCond(final RiskAuditResultSearchCond cond, final int start, final int count);
	
	
}
