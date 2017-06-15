/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCond;

/**
  * ����: ���̲鿴��ɫ���ñ�DAO�ӿ�
  * ��������: ���̲鿴��ɫ���ñ�DAO�ӿ�
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public interface IG700DAO extends BaseHibernateDAO<IG700Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG700Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG700Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG700SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG700Info> findByCond(
			final IG700SearchCond cond, final int start,
			final int count);

}