/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.dbm.model.dao.BussinessAvailvalVWDAO;
import com.deliverik.infogovernor.dbm.model.entity.BussinessAvailvalVW;

/**
  * ����: TOPOXMLҵ���߼�ʵ��
  * ��������: TOPOXMLҵ���߼�ʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public class BussinessAvailvalVWBLImpl extends BaseBLImpl implements BussinessAvailvalVWBL {

	/** TOPOXMLDAO�ӿ� */
	protected BussinessAvailvalVWDAO bussinessAvailvalVWDAO;
	


	/**
	 * BussinessAvailvalVWʵ��ȡ��
	 *
	 * @return BussinessAvailvalVWʵ��
	 */
	public BussinessAvailvalVW getBussinessAvailvalVWInstance() {
		return new BussinessAvailvalVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<BussinessAvailval> searchBussinessAvailvalVW() {
		return bussinessAvailvalVWDAO.getAllBusinessAvailvalList();
	}

	/**
	 * bussinessAvailvalVWDAO�趨
	 *
	 * @param bussinessAvailvalVWDAO bussinessAvailvalVWDAO
	 */
	public void setBussinessAvailvalVWDAO(BussinessAvailvalVWDAO bussinessAvailvalVWDAO) {
		this.bussinessAvailvalVWDAO = bussinessAvailvalVWDAO;
	}

}