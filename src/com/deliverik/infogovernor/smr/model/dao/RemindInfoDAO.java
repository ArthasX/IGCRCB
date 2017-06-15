/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.smr.model.RemindInfoInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindInfoSearchCond;

/**
  * ����: ������Ϣ��DAO�ӿ�
  * ��������: ������Ϣ��DAO�ӿ�
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public interface RemindInfoDAO extends BaseHibernateDAO<RemindInfoInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RemindInfoInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RemindInfoInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RemindInfoSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RemindInfoInfo> findByCond(
			final RemindInfoSearchCond cond, final int start,
			final int count);

}