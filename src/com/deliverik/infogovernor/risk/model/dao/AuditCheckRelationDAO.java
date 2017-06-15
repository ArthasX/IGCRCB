/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;
import com.deliverik.infogovernor.risk.model.condition.AuditCheckRelationSearchCond;

/**
 * �����������ռ���ϵDAO�ӿ�
 * @author lipeng@deliverik.com
 */
public interface AuditCheckRelationDAO extends BaseHibernateDAO<AuditCheckRelation> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<AuditCheckRelation> findAll();

	/**
	 * ������������
	 * @param acrid ����
	 * @return �������
	 */
	public AuditCheckRelation findByPK(Serializable acrid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AuditCheckRelationSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditCheckRelation> findByCond(final AuditCheckRelationSearchCond cond, final int start, final int count);
	
	
}
