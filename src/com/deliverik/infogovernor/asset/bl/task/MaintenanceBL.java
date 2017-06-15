/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCond;
import com.deliverik.infogovernor.asset.model.entity.MaintenanceTB;

/**
  * ����: ����ָ��ά��ҵ���߼��ӿ�
  * ��������: ����ָ��ά��ҵ���߼��ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface MaintenanceBL extends BaseBL {

	/**
	 * ����ָ��ά��ʵ��ȡ��
	 *
	 * @return ����ָ��ά��ʵ��
	 */
	public MaintenanceTB getMaintenanceTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MaintenanceInfo> searchMaintenance();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MaintenanceInfo searchMaintenanceByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MaintenanceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MaintenanceInfo> searchMaintenance(
			MaintenanceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MaintenanceInfo> searchMaintenance(
			MaintenanceSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MaintenanceInfo registMaintenance(MaintenanceInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MaintenanceInfo updateMaintenance(MaintenanceInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMaintenanceByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMaintenance(MaintenanceInfo instance)
		throws BLException;

	
	public List<Integer> saveOrUpdateMaintenance(MaintenanceInfo instance);
	
	/**
	 * ������������ 
	 * ����sql��ѯ
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Object> SearchBySQL(MaintenanceSearchCond cond);
	
}