/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorObjectDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectTB;

/**
  * ����: ��ض�����Ϣҵ���߼�ʵ��
  * ��������: ��ض�����Ϣҵ���߼�ʵ��
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public class MonitorObjectBLImpl extends BaseBLImpl implements
		MonitorObjectBL {

	/** ��ض�����ϢDAO�ӿ� */
	protected MonitorObjectDAO monitorObjectDAO;
	
	/**
	 * ��ض�����ϢDAO�ӿ��趨
	 *
	 * @param monitorObjectDAO ��ض�����ϢDAO�ӿ�
	 */
	public void setMonitorObjectDAO(MonitorObjectDAO monitorObjectDAO) {
		this.monitorObjectDAO = monitorObjectDAO;
	}

	/**
	 * ��ض�����Ϣʵ��ȡ��
	 *
	 * @return ��ض�����Ϣʵ��
	 */
	public MonitorObjectTB getMonitorObjectTBInstance() {
		return new MonitorObjectTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectInfo> searchMonitorObject() {
		return monitorObjectDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorObjectInfo searchMonitorObjectByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorObjectSearchCond cond) {
		return monitorObjectDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorObjectInfo> searchMonitorObject(
			MonitorObjectSearchCond cond) {
		return monitorObjectDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorObjectInfo> searchMonitorObject(
			MonitorObjectSearchCond cond, int start,
			int count) {
		return monitorObjectDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorObjectInfo registMonitorObject(MonitorObjectInfo instance)
		throws BLException {
		return monitorObjectDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorObjectInfo updateMonitorObject(MonitorObjectInfo instance)
		throws BLException {
		checkExistInstance(instance.getMoId());
		return monitorObjectDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitorObjectByPK(Integer pk)
		throws BLException {
		monitorObjectDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorObject(MonitorObjectInfo instance)
		throws BLException {
		monitorObjectDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public MonitorObjectInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorObjectInfo instance = monitorObjectDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "");
		}
		return instance;
	}

}