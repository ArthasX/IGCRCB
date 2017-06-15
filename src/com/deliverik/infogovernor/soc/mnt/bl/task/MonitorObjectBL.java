/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectTB;

/**
  * ����: ��ض�����Ϣҵ���߼��ӿ�
  * ��������: ��ض�����Ϣҵ���߼��ӿ�
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public interface MonitorObjectBL extends BaseBL {

	/**
	 * ��ض�����Ϣʵ��ȡ��
	 *
	 * @return ��ض�����Ϣʵ��
	 */
	public MonitorObjectTB getMonitorObjectTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectInfo> searchMonitorObject();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorObjectInfo searchMonitorObjectByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorObjectSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorObjectInfo> searchMonitorObject(
			MonitorObjectSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorObjectInfo registMonitorObject(MonitorObjectInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorObjectInfo updateMonitorObject(MonitorObjectInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitorObjectByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorObject(MonitorObjectInfo instance)
		throws BLException;

}