/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CIEntityItemInfo;
import com.deliverik.framework.asset.model.condition.CIEntityItemSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: CI����ʲ���DAO�ӿ�
  * ��������: CI����ʲ���DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIEntityItemDAO extends BaseHibernateDAO<CIEntityItemInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIEntityItemInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIEntityItemInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CIEntityItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIEntityItemInfo> findByCond(
			final CIEntityItemSearchCond cond, final int start,
			final int count);

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteCIEntityItem();

}