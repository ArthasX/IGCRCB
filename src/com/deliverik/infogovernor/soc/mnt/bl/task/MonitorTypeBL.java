/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeTB;

/**
  * ����: ������ͱ�ҵ���߼��ӿ�
  * ��������: ������ͱ�ҵ���߼��ӿ�
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public interface MonitorTypeBL extends BaseBL {

	/**
	 * ������ͱ�ʵ��ȡ��
	 *
	 * @return ������ͱ�ʵ��
	 */
	public MonitorTypeTB getMonitorTypeTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTypeInfo> searchMonitorType();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTypeInfo searchMonitorTypeByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorTypeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorTypeInfo> searchMonitorType(
			MonitorTypeSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorTypeInfo registMonitorType(MonitorTypeInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorTypeInfo updateMonitorType(MonitorTypeInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitorTypeByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorType(MonitorTypeInfo instance)
		throws BLException;

}