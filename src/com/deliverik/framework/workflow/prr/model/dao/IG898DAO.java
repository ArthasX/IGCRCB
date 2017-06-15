/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;

/**
  * ����: ������ֵ��DAO�ӿ�
  * ��������: ������ֵ��DAO�ӿ�
  * ������¼: 2013/06/25
  * �޸ļ�¼: 
  */
public interface IG898DAO extends BaseHibernateDAO<IG898Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG898Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG898Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG898SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG898Info> findByCond(
			final IG898SearchCond cond, final int start,
			final int count);
	
	/**
     * ȡ�ñ�����ͱ�������
     *
     * @param cond ��������
     * @return ��������
     */
    public int getTableRowCount(final IG898SearchCond cond);

}