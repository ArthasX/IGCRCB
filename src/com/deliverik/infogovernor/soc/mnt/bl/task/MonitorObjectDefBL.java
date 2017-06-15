/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefTB;

/**
  * ����: ��ض���ֵ��Ϣ��ҵ���߼��ӿ�
  * ��������: ��ض���ֵ��Ϣ��ҵ���߼��ӿ�
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public interface MonitorObjectDefBL extends BaseBL {

	/**
	 * ��ض���ֵ��Ϣ��ʵ��ȡ��
	 *
	 * @return ��ض���ֵ��Ϣ��ʵ��
	 */
	public MonitorObjectDefTB getMonitorObjectDefTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectDefInfo> searchMonitorObjectDef();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorObjectDefInfo searchMonitorObjectDefByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorObjectDefSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorObjectDefInfo> searchMonitorObjectDef(
			MonitorObjectDefSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorObjectDefInfo registMonitorObjectDef(MonitorObjectDefInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorObjectDefInfo updateMonitorObjectDef(MonitorObjectDefInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitorObjectDefByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorObjectDef(MonitorObjectDefInfo instance)
		throws BLException;

}