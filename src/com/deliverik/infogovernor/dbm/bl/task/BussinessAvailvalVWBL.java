/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.dbm.model.dao.BussinessAvailvalVWDAO;
import com.deliverik.infogovernor.dbm.model.entity.BussinessAvailvalVW;

/**
  * ����: TOPOXMLҵ���߼��ӿ�
  * ��������: TOPOXMLҵ���߼��ӿ�
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public interface BussinessAvailvalVWBL extends BaseBL {

	/**
	 * BussinessAvailvalVWʵ��ȡ��
	 *
	 * @return BussinessAvailvalVWʵ��
	 */
	public BussinessAvailvalVW getBussinessAvailvalVWInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<BussinessAvailval> searchBussinessAvailvalVW();
	/**
	 * bussinessAvailvalVWDAO�趨
	 *
	 * @param bussinessAvailvalVWDAO bussinessAvailvalVWDAO
	 */
	public void setBussinessAvailvalVWDAO(BussinessAvailvalVWDAO bussinessAvailvalVWDAO);
}