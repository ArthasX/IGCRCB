/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.ScopesInfo;
import com.deliverik.infogovernor.drm.model.condition.ScopesSearchCond;

/**
  * ����: �¼�Ӱ�췶ΧDAO�ӿ�
  * ��������: �¼�Ӱ�췶ΧDAO�ӿ�
  * ������¼: 2015/03/20
  * �޸ļ�¼: 
  */
public interface ScopesDAO extends BaseHibernateDAO<ScopesInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ScopesInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ScopesInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ScopesSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ScopesInfo> findByCond(
			final ScopesSearchCond cond, final int start,
			final int count);

}