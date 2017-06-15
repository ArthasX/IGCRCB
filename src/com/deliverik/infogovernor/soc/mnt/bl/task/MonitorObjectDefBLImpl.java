/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorObjectDefDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefTB;

/**
  * ����: ��ض���ֵ��Ϣ��ҵ���߼�ʵ��
  * ��������: ��ض���ֵ��Ϣ��ҵ���߼�ʵ��
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public class MonitorObjectDefBLImpl extends BaseBLImpl implements
		MonitorObjectDefBL {

	/** ��ض���ֵ��Ϣ��DAO�ӿ� */
	protected MonitorObjectDefDAO monitorObjectDefDAO;
	
	/**
	 * ��ض���ֵ��Ϣ��DAO�ӿ��趨
	 *
	 * @param monitorObjectDefDAO ��ض���ֵ��Ϣ��DAO�ӿ�
	 */
	public void setMonitorObjectDefDAO(MonitorObjectDefDAO monitorObjectDefDAO) {
		this.monitorObjectDefDAO = monitorObjectDefDAO;
	}

	/**
	 * ��ض���ֵ��Ϣ��ʵ��ȡ��
	 *
	 * @return ��ض���ֵ��Ϣ��ʵ��
	 */
	public MonitorObjectDefTB getMonitorObjectDefTBInstance() {
		return new MonitorObjectDefTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectDefInfo> searchMonitorObjectDef() {
		return monitorObjectDefDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorObjectDefInfo searchMonitorObjectDefByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorObjectDefSearchCond cond) {
		return monitorObjectDefDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorObjectDefInfo> searchMonitorObjectDef(
			MonitorObjectDefSearchCond cond) {
		return monitorObjectDefDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorObjectDefInfo> searchMonitorObjectDef(
			MonitorObjectDefSearchCond cond, int start,
			int count) {
		return monitorObjectDefDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorObjectDefInfo registMonitorObjectDef(MonitorObjectDefInfo instance)
		throws BLException {
		return monitorObjectDefDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorObjectDefInfo updateMonitorObjectDef(MonitorObjectDefInfo instance)
		throws BLException {
		checkExistInstance(instance.getModId());
		return monitorObjectDefDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitorObjectDefByPK(Integer pk)
		throws BLException {
		monitorObjectDefDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorObjectDef(MonitorObjectDefInfo instance)
		throws BLException {
		monitorObjectDefDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public MonitorObjectDefInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorObjectDefInfo instance = monitorObjectDefDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}