/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_InfoTB;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeTB;

/**
  * ����: ��ض�����Ϣ�ӿ�
  * ��������: ��ض�����Ϣ�ӿ�
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
public interface MonitorObjectInfo extends BaseModel {

	/**
	 * ����Idȡ��
	 *
	 * @return ����Id
	 */
	public Integer getMoId();

	/**
	 * ��ض�������ȡ��
	 *
	 * @return ��ض�������
	 */
	public String getMoName();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getMoCreateTime();

	/**
	 * ������Ͳ����ȡ��
	 *
	 * @return ������Ͳ����
	 */
	public String getMtSyscoding();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getDeleteFlag();
	
	/**
	 * ip��ַȡ��
	 * @return
	 */
	public String getIp();
	
	/**
	 * MonitorTypeTB ʵ���ȡ
	 * @return
	 */
	public MonitorTypeTB getMonitorTypeTB();
	
	/**
	 * Collect_Symmetrix_InfoTB ʵ��ȡ��
	 * @return
	 */
	public Collect_Symmetrix_InfoTB getCollect_Symmetrix_InfoTB();

}