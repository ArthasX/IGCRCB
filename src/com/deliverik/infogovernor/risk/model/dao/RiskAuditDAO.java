/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCond;

/**
 * �������DAO�ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDAO extends BaseHibernateDAO<RiskAudit> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAudit> findAll();

	/**
	 * ������������
	 * @param raid ����
	 * @return �������
	 */
	public RiskAudit findByPK(Serializable raid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAudit> findByCond(final RiskAuditSearchCond cond, final int start, final int count);
	
	/**
	 * ��ȡ��ǰ���汾����ʶ
	 * @return ���汾����ʶ
	 */
	
	public String getMaxRacode();
}
