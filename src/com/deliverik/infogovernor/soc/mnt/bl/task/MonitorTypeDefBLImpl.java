/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeDefSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorTypeDefDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeDefTB;

/**
  * ����: ������ͷ�ֵ��Ϣҵ���߼�ʵ��
  * ��������: ������ͷ�ֵ��Ϣҵ���߼�ʵ��
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public class MonitorTypeDefBLImpl extends BaseBLImpl implements
		MonitorTypeDefBL {

	/** ������ͷ�ֵ��ϢDAO�ӿ� */
	protected MonitorTypeDefDAO monitorTypeDefDAO;
	
	/**
	 * ������ͷ�ֵ��ϢDAO�ӿ��趨
	 *
	 * @param monitorTypeDefDAO ������ͷ�ֵ��ϢDAO�ӿ�
	 */
	public void setMonitorTypeDefDAO(MonitorTypeDefDAO monitorTypeDefDAO) {
		this.monitorTypeDefDAO = monitorTypeDefDAO;
	}

	/**
	 * ������ͷ�ֵ��Ϣʵ��ȡ��
	 *
	 * @return ������ͷ�ֵ��Ϣʵ��
	 */
	public MonitorTypeDefTB getMonitorTypeDefTBInstance() {
		return new MonitorTypeDefTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTypeDefInfo> searchMonitorTypeDef() {
		return monitorTypeDefDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTypeDefInfo searchMonitorTypeDefByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorTypeDefSearchCond cond) {
		return monitorTypeDefDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorTypeDefInfo> searchMonitorTypeDef(
			MonitorTypeDefSearchCond cond) {
		return monitorTypeDefDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorTypeDefInfo> searchMonitorTypeDef(
			MonitorTypeDefSearchCond cond, int start,
			int count) {
		return monitorTypeDefDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorTypeDefInfo registMonitorTypeDef(MonitorTypeDefInfo instance)
		throws BLException {
		return monitorTypeDefDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorTypeDefInfo updateMonitorTypeDef(MonitorTypeDefInfo instance)
		throws BLException {
		checkExistInstance(instance.getMtdId());
		return monitorTypeDefDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitorTypeDefByPK(Integer pk)
		throws BLException {
		monitorTypeDefDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorTypeDef(MonitorTypeDefInfo instance)
		throws BLException {
		monitorTypeDefDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public MonitorTypeDefInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorTypeDefInfo instance = monitorTypeDefDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}