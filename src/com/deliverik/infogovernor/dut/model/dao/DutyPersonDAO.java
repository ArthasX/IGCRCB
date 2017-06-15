/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCond;

/**
 * ֵ������߼��ӿ�
 *
 */
public interface DutyPersonDAO  extends BaseHibernateDAO<DutyPerson> {
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<DutyPerson> findAll();

	/**
	 * ������������
	 * @param dperid ����
	 * @return �������
	 */
	public DutyPerson findByPK(Serializable dperid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DutyPersonSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyPerson> findByCond(final DutyPersonSearchCond cond, final int start, final int count);

}
