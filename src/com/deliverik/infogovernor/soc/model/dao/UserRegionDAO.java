/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.UserRegionInfo;
import com.deliverik.infogovernor.soc.model.condition.UserRegionSearchCond;

/**
  * ����: UserRegionDAO�ӿ�
  * ��������: UserRegionDAO�ӿ�
  * ������¼: 2014/01/10
  * �޸ļ�¼: 
  */
public interface UserRegionDAO extends BaseHibernateDAO<UserRegionInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<UserRegionInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public UserRegionInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final UserRegionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<UserRegionInfo> findByCond(
			final UserRegionSearchCond cond, final int start,
			final int count);

}