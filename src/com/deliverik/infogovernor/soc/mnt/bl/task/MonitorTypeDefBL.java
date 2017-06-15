/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeDefSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeDefTB;

/**
  * ����: ������ͷ�ֵ��Ϣҵ���߼��ӿ�
  * ��������: ������ͷ�ֵ��Ϣҵ���߼��ӿ�
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public interface MonitorTypeDefBL extends BaseBL {

	/**
	 * ������ͷ�ֵ��Ϣʵ��ȡ��
	 *
	 * @return ������ͷ�ֵ��Ϣʵ��
	 */
	public MonitorTypeDefTB getMonitorTypeDefTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTypeDefInfo> searchMonitorTypeDef();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTypeDefInfo searchMonitorTypeDefByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MonitorTypeDefSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MonitorTypeDefInfo> searchMonitorTypeDef(
			MonitorTypeDefSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MonitorTypeDefInfo registMonitorTypeDef(MonitorTypeDefInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MonitorTypeDefInfo updateMonitorTypeDef(MonitorTypeDefInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMonitorTypeDefByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMonitorTypeDef(MonitorTypeDefInfo instance)
		throws BLException;

}