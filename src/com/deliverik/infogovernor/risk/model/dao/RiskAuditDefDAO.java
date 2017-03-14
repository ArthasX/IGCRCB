/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCond;

/**
 * ���������DAO�ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDefDAO extends BaseHibernateDAO<RiskAuditDef> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAuditDef> findAll();

	/**
	 * ������������
	 * @param radid ����
	 * @return �������
	 */
	public RiskAuditDef findByPK(Serializable radid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditDefSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditDef> findByCond(final RiskAuditDefSearchCond cond, final int start, final int count);
	
	
}
