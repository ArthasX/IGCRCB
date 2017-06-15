/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCond;

/**
  * ����: ������ѯDAO�ӿ�
  * ��������: ������ѯDAO�ӿ�
  * ������¼: 2014/07/01
  * �޸ļ�¼: 
  */
public interface CheckItemVWDAO extends BaseHibernateDAO<CheckItemVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckItemVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckItemVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckItemVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckItemVWInfo> findByCond(
			final CheckItemVWSearchCond cond, final int start,
			final int count);
	
	/**
	 * (��Ϣ��ȫ �����)������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckItemVWInfo> safeInfoFindByCond(
			final CheckItemVWSearchCond cond, final int start,
			final int count);

}