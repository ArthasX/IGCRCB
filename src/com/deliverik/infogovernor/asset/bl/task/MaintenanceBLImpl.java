/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCond;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCondImpl;
import com.deliverik.infogovernor.asset.model.dao.MaintenanceDAO;
import com.deliverik.infogovernor.asset.model.entity.MaintenanceTB;

/**
  * ����: ����ָ��ά��ҵ���߼�ʵ��
  * ��������: ����ָ��ά��ҵ���߼�ʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public class MaintenanceBLImpl extends BaseBLImpl implements
		MaintenanceBL {

	/** ����ָ��ά��DAO�ӿ� */
	protected MaintenanceDAO maintenanceDAO;
	
	/**
	 * ����ָ��ά��DAO�ӿ��趨
	 *
	 * @param maintenanceDAO ����ָ��ά��DAO�ӿ�
	 */
	public void setMaintenanceDAO(MaintenanceDAO maintenanceDAO) {
		this.maintenanceDAO = maintenanceDAO;
	}

	/**
	 * ����ָ��ά��ʵ��ȡ��
	 *
	 * @return ����ָ��ά��ʵ��
	 */
	public MaintenanceTB getMaintenanceTBInstance() {
		return new MaintenanceTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MaintenanceInfo> searchMaintenance() {
		return maintenanceDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MaintenanceInfo searchMaintenanceByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MaintenanceSearchCond cond) {
		return maintenanceDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MaintenanceInfo> searchMaintenance(
			MaintenanceSearchCond cond) {
		return maintenanceDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return maintenanceDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MaintenanceInfo registMaintenance(MaintenanceInfo instance)
		throws BLException {
		return maintenanceDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MaintenanceInfo updateMaintenance(MaintenanceInfo instance)
		throws BLException {
		
		return maintenanceDAO.update(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMaintenanceByPK(Integer pk)
		throws BLException {
		maintenanceDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMaintenance(MaintenanceInfo instance)
		throws BLException {
		maintenanceDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public MaintenanceInfo checkExistInstance(Integer pk)
		throws BLException {
		MaintenanceInfo instance = maintenanceDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public List<Integer> saveOrUpdateMaintenance(MaintenanceInfo instance) {
		// TODO Auto-generated method stub

		return this.maintenanceDAO.saveOrUpdateMaintenance(instance);
	}
	
	/**
	 * ������������ 
	 * ����sql��ѯ
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Object> SearchBySQL(MaintenanceSearchCond cond) {
		return maintenanceDAO.SearchBySQL(cond);
	}
}