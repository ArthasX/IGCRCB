/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;

/**
 * ��Ʒ���ʵ��DAO�ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskAuditInsDAO extends BaseHibernateDAO<RiskAuditIns> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskAuditIns> findAll();

	/**
	 * ������������
	 * @param raiid ����
	 * @return �������
	 */
	public RiskAuditIns findByPK(Serializable raiid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskAuditInsSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditIns> findByCond(final RiskAuditInsSearchCond cond, final int start, final int count);

	
}
