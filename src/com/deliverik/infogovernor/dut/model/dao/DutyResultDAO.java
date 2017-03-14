/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;

/**
 * ֵ��������DAO�ӿ�
 */
public interface DutyResultDAO extends BaseHibernateDAO<DutyResult> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyResult> findAll();

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public DutyResult findByPK(Serializable rcid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyResultSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyResult> findByCond(final DutyResultSearchCond cond, final int start, final int count);
	
	
}
