/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckSearchCond;

/**
 * ���ռ��DAO�ӿ�
 * @author lipeng@deliverik.com
 */
public interface RiskCheckDAO extends BaseHibernateDAO<RiskCheck> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskCheck> findAll();

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public RiskCheck findByPK(Serializable rcid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskCheckSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheck> findByCond(final RiskCheckSearchCond cond, final int start, final int count);
	public List<RiskCheck> dbmselByrcclass();
	public List<RiskCheck> getRcclassByMonth(final RiskCheckSearchCond cond) ;
	public List<RiskCheck> getRcTestMode (final RiskCheckSearchCond cond) ;
	
}
