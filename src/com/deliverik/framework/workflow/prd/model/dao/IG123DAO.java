/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.condition.IG123SearchCond;

/**
  * ����: �Զ������̻�����Χ��DAO�ӿ�
  * ��������: �Զ������̻�����Χ��DAO�ӿ�
  * ������¼: 2013/03/07
  * �޸ļ�¼: 
  */
public interface IG123DAO extends BaseHibernateDAO<IG123Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG123Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG123Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG123SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG123Info> findByCond(IG123SearchCond cond, final int start,int count);
	
	/**
	 * POTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PRTDID����ֵ
	 */
	public String getPotdidSequenceNextValue(String pdid);

}