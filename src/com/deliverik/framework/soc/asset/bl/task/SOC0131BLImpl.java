/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0131SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0131DAO;

/**
 * ����: �豸��ϵ��Ϣҵ��ʵ��(VG-PV-Meta)
 * ��������: �豸��ϵ��Ϣҵ��ʵ��(VG-PV-Meta)
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public class SOC0131BLImpl implements SOC0131BL{

	protected  SOC0131DAO soc0131DAO;
	
	/**
	 * soc0131DAO�趨
	 *
	 * @param soc0131DAO soc0131DAO
	 */
	public void setSoc0131DAO(SOC0131DAO soc0131DAO) {
		this.soc0131DAO = soc0131DAO;
	}


	public ArrayList<SOC0131Info> searchVgPvMeta(SOC0131SearchCond cond) throws BLException{
		return soc0131DAO.searchVgPvMeta(cond);
	}

}
