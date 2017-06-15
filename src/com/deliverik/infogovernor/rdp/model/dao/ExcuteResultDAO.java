/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;
import com.deliverik.infogovernor.rdp.model.condition.ExcuteResultSearchCond;

/**
  * ����: ExcuteResultDAO�ӿ�
  * ��������: ExcuteResultDAO�ӿ�
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public interface ExcuteResultDAO extends BaseHibernateDAO<ExcuteResultInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ExcuteResultInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ExcuteResultInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ExcuteResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ExcuteResultInfo> findByCond(
			final ExcuteResultSearchCond cond, final int start,
			final int count);

}