/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorTypeDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeTB;

/**
  * ����: ������ͱ�ҵ���߼�ʵ��
  * ��������: ������ͱ�ҵ���߼�ʵ��
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public class MonitorTypeBLImpl extends BaseBLImpl implements
		MonitorTypeBL {

	/** ������ͱ�DAO�ӿ� */
	protected MonitorTypeDAO monitorTypeDAO;
	
	/**
	 * ������ͱ�DAO�ӿ��趨
	 *
	 * @param monitorTypeDAO ������ͱ�DAO�ӿ�
	 */
	public void setMonitorTypeDAO(MonitorTypeDAO monitorTypeDAO) {
		this.monitorTypeDAO = monitorTypeDAO;
	}

	/**
	 * ������ͱ�ʵ��ȡ��
	 *
	 * @return ������ͱ�ʵ��
	 */
	public MonitorTypeTB getMonitorTypeTBInstance() {
		return new MonitorTypeTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTypeInfo> searchMonitorType() {
		return monitorTypeDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTypeInfo searchMonitorTypeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorTypeSearchCond cond) {
		return monitorTypeDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorTypeInfo> searchMonitorType(
			MonitorTypeSearchCond cond) {
		return monitorTypeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorTypeInfo> searchMonitorType(
			MonitorTypeSearchCond cond, int start,
			int count) {
		return monitorTypeDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorTypeInfo registMonitorType(MonitorTypeInfo instance)
		throws BLException {
		return monitorTypeDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorTypeInfo updateMonitorType(MonitorTypeInfo instance)
		throws BLException {
		checkExistInstance(instance.getMtId());
		return monitorTypeDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitorTypeByPK(Integer pk)
		throws BLException {
		monitorTypeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorType(MonitorTypeInfo instance)
		throws BLException {
		monitorTypeDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public MonitorTypeInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorTypeInfo instance = monitorTypeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}