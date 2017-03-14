/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCond;
import com.deliverik.infogovernor.ven.model.dao.MonitoringWorkDAO;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;

/**
  * ����: ��⹤�����ҵ���߼�ʵ��
  * ��������: ��⹤�����ҵ���߼�ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class MonitoringWorkBLImpl extends BaseBLImpl implements
		MonitoringWorkBL {

	/** ��⹤�����DAO�ӿ� */
	protected MonitoringWorkDAO monitoringWorkDAO;
	
	/**
	 * ��⹤�����DAO�ӿ��趨
	 *
	 * @param monitoringWorkDAO ��⹤�����DAO�ӿ�
	 */
	public void setMonitoringWorkDAO(MonitoringWorkDAO monitoringWorkDAO) {
		this.monitoringWorkDAO = monitoringWorkDAO;
	}

	/**
	 * ��⹤�����ʵ��ȡ��
	 *
	 * @return ��⹤�����ʵ��
	 */
	public MonitoringWorkTB getMonitoringWorkTBInstance() {
		return new MonitoringWorkTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitoringWorkInfo> searchMonitoringWork() {
		return monitoringWorkDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitoringWorkInfo searchMonitoringWorkByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitoringWorkSearchCond cond) {
		return monitoringWorkDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitoringWorkInfo> searchMonitoringWork(
			MonitoringWorkSearchCond cond) {
		return monitoringWorkDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitoringWorkInfo> searchMonitoringWork(
			MonitoringWorkSearchCond cond, int start,
			int count) {
		return monitoringWorkDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitoringWorkInfo registMonitoringWork(MonitoringWorkInfo instance)
		throws BLException {
		return monitoringWorkDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitoringWorkInfo updateMonitoringWork(MonitoringWorkInfo instance)
		throws BLException {
		checkExistInstance(instance.getMwid());
		return monitoringWorkDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitoringWorkByPK(Integer pk)
		throws BLException {
		monitoringWorkDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitoringWork(MonitoringWorkInfo instance)
		throws BLException {
		monitoringWorkDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public MonitoringWorkInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitoringWorkInfo instance = monitoringWorkDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}