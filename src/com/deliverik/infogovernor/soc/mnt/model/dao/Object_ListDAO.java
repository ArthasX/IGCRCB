/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.Object_ListSearchCond;

/**
  * ����: ���󼯺ϱ�DAO�ӿ�
  * ��������: ���󼯺ϱ�DAO�ӿ�
  * ������¼: 2012/05/11
  * �޸ļ�¼: 
  */
public interface Object_ListDAO extends BaseHibernateDAO<Object_ListInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Object_ListInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Object_ListInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Object_ListSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Object_ListInfo> findByCond(
			final Object_ListSearchCond cond, final int start,
			final int count);

}