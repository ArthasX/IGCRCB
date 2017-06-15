/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCond;

/**
  * ����: ����ָ��ά��DAO�ӿ�
  * ��������: ����ָ��ά��DAO�ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface MaintenanceDAO extends BaseHibernateDAO<MaintenanceInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MaintenanceInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MaintenanceInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MaintenanceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MaintenanceInfo> findByCond(
			final MaintenanceSearchCond cond, final int start,
			final int count);


	public List<Integer> saveOrUpdateMaintenance(final MaintenanceInfo instance);

	/**
	 *  ����
	 * @param instance
	 * @return
	 */
	public MaintenanceInfo update(MaintenanceInfo instance);
	
	/**
	 * ������������
	 * ����sql��ѯ
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Object> SearchBySQL(final MaintenanceSearchCond cond);
}