/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;

/**
 * ��������������������ͼ�ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDefResultVWDAO extends BaseHibernateDAO<RiskAuditDefResultVWInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAuditDefResultVWInfo> findAll();

	/**
	 * ������������
	 * @param acrid ����
	 * @return �������
	 */
	public RiskAuditDefResultVWInfo findByPK(Serializable acrid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditDefResultVWSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditDefResultVWInfo> findByCond(final RiskAuditDefResultVWSearchCond cond, final int start, final int count);
	
	/**
	 * ��ȡ�������󼶴�
	 * @return �������󼶴�
	 */
	public String getMaxRadlevel(final RiskAuditDefResultVWSearchCond cond);
	
	
}
