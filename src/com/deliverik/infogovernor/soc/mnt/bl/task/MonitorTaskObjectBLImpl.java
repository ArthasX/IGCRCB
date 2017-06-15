/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTaskObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTaskObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorTaskObjectDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTaskObjectTB;

/**
  * ����: �����������ҵ���߼�ʵ��
  * ��������: �����������ҵ���߼�ʵ��
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
public class MonitorTaskObjectBLImpl extends BaseBLImpl implements
		MonitorTaskObjectBL {

	/** �����������DAO�ӿ� */
	protected MonitorTaskObjectDAO monitorTaskObjectDAO;
	
	/**
	 * �����������DAO�ӿ��趨
	 *
	 * @param monitorTaskObjectDAO �����������DAO�ӿ�
	 */
	public void setMonitorTaskObjectDAO(MonitorTaskObjectDAO monitorTaskObjectDAO) {
		this.monitorTaskObjectDAO = monitorTaskObjectDAO;
	}

	/**
	 * �����������ʵ��ȡ��
	 *
	 * @return �����������ʵ��
	 */
	public MonitorTaskObjectTB getMonitorTaskObjectTBInstance() {
		return new MonitorTaskObjectTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTaskObjectInfo> searchMonitorTaskObject() {
		return monitorTaskObjectDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTaskObjectInfo searchMonitorTaskObjectByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorTaskObjectSearchCond cond) {
		return monitorTaskObjectDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorTaskObjectInfo> searchMonitorTaskObject(
			MonitorTaskObjectSearchCond cond) {
		return monitorTaskObjectDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorTaskObjectInfo> searchMonitorTaskObject(
			MonitorTaskObjectSearchCond cond, int start,
			int count) {
		return monitorTaskObjectDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorTaskObjectInfo registMonitorTaskObject(MonitorTaskObjectInfo instance)
		throws BLException {
		return monitorTaskObjectDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorTaskObjectInfo updateMonitorTaskObject(MonitorTaskObjectInfo instance)
		throws BLException {
		checkExistInstance(instance.getMtoId());
		return monitorTaskObjectDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitorTaskObjectByPK(Integer pk)
		throws BLException {
		monitorTaskObjectDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorTaskObject(MonitorTaskObjectInfo instance)
		throws BLException {
		monitorTaskObjectDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public MonitorTaskObjectInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorTaskObjectInfo instance = monitorTaskObjectDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}