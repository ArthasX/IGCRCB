/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;

/**
 * ֵ�������DAO�ӿ�
 */
public interface DutyAuditDefDAO extends BaseHibernateDAO<DutyAuditDef> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyAuditDef> findAll();

	/**
	 * ������������
	 * @param dadid ����
	 * @return �������
	 */
	public DutyAuditDef findByPK(Serializable dadid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyAuditDefSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyAuditDef> findByCond(final DutyAuditDefSearchCond cond, final int start, final int count);
	
	

}
