/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;
import com.deliverik.infogovernor.rdp.model.condition.RealtimedetailSearchCond;

/**
  * ����: ��־��ϢDAO�ӿ�
  * ��������: ��־��ϢDAO�ӿ�
  * ������¼: 2014/05/06
  * �޸ļ�¼: 
  */
public interface RealtimedetailDAO extends BaseHibernateDAO<RealtimedetailInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RealtimedetailInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RealtimedetailInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RealtimedetailSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RealtimedetailInfo> findByCond(
			final RealtimedetailSearchCond cond, final int start,
			final int count);

}