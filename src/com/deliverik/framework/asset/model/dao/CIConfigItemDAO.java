/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.asset.model.condition.CIConfigItemSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: CI����ʲ����Ա�DAO�ӿ�
  * ��������: CI����ʲ����Ա�DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIConfigItemDAO extends BaseHibernateDAO<CIConfigItemInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIConfigItemInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIConfigItemInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CIConfigItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIConfigItemInfo> findByCond(
			final CIConfigItemSearchCond cond, final int start,
			final int count);

	/**
	 * �����ʲ����Լ����ԶԱȷ���
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIConfigItemInfo> searchCIConfigItemForAucmptype(Integer eiid);

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteCIConfigItem();

}