/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prr.model.EntityItemTempInfo;
import com.deliverik.infogovernor.prr.model.condition.EntityItemTempSearchCond;


/**
  * ����: ������ʱ�豸��Ϣ��DAO�ӿ�
  * ��������: ������ʱ�豸��Ϣ��DAO�ӿ�
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
public interface EntityItemTempDAO extends BaseHibernateDAO<EntityItemTempInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EntityItemTempInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EntityItemTempInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EntityItemTempSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EntityItemTempInfo> findByCond(
			final EntityItemTempSearchCond cond, final int start,
			final int count);

}