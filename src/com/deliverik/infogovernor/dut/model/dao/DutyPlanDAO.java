/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;

/**
 * ֵ������߼��ӿ�
 *
 */
public interface DutyPlanDAO  extends BaseHibernateDAO<DutyPlan> {
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyPlan> findAll();

	/**
	 * ������������
	 * @param dpid ����
	 * @return �������
	 */
	public DutyPlan findByPK(Serializable dpid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyPlanSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyPlan> findByCond(final DutyPlanSearchCond cond, final int start, final int count);

}
