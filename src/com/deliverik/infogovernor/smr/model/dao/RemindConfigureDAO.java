/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindConfigureSearchCond;

/**
  * ����: �������ñ�DAO�ӿ�
  * ��������: �������ñ�DAO�ӿ�
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public interface RemindConfigureDAO extends BaseHibernateDAO<RemindConfigureInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RemindConfigureInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RemindConfigureInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RemindConfigureSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RemindConfigureInfo> findByCond(
			final RemindConfigureSearchCond cond, final int start,
			final int count);

}