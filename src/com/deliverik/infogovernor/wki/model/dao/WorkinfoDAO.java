/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wki.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;
import com.deliverik.infogovernor.wki.model.condition.WorkinfoSearchCond;

/**
  * ����: ������ϢDAO�ӿ�
  * ��������: ������ϢDAO�ӿ�
  * ������¼: 2017/03/02
  * �޸ļ�¼: 
  */
public interface WorkinfoDAO extends BaseHibernateDAO<WorkinfoInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkinfoInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkinfoInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkinfoSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkinfoInfo> findByCond(
			final WorkinfoSearchCond cond, final int start,
			final int count);

}