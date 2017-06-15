/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyResultVWSearchCond;

/**
 * ֵ��������DAO�ӿ�
 */
public interface DutyResultVWDAO extends BaseHibernateDAO<DutyResultVWInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyResultVWInfo> findAll();

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public DutyResultVWInfo findByPK(Serializable rcid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyResultVWSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyResultVWInfo> findByCond(final DutyResultVWSearchCond cond, final int start, final int count);
	
	
}
