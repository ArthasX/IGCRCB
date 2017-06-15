/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCond;

/**
 * ֵ��������ʱ���߼��ӿ�
 *
 */
public interface DutyAuditTimeDAO  extends BaseHibernateDAO<DutyAuditTime> {
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyAuditTime> findAll();

	/**
	 * ������������
	 * @param acrid ����
	 * @return �������
	 */
	public DutyAuditTime findByPK(Serializable datid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyAuditTimeSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyAuditTime> findByCond(final DutyAuditTimeSearchCond cond, final int start, final int count);
	


}
