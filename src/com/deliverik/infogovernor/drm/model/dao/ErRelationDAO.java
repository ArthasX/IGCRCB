/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.ErRelationSearchCond;

/**
  * ����: ErRelationDAO�ӿ�
  * ��������: ErRelationDAO�ӿ�
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public interface ErRelationDAO extends BaseHibernateDAO<ErRelationInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ErRelationInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ErRelationInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ErRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ErRelationInfo> findByCond(
			final ErRelationSearchCond cond, final int start,
			final int count);

}