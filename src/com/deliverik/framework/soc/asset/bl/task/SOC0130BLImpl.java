/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0130SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0130DAO;

/**
 * ����: �豸��ϵ��Ϣҵ��ʵ�֣�FS-LV-VG��
 * ��������: �豸��ϵ��Ϣҵ��ʵ�֣�FS-LV-VG��
 * ������¼: 2011/05/13
 * �޸ļ�¼: 
 */
public class SOC0130BLImpl implements SOC0130BL{
	
	/**
	 * soc0130DAO�趨
	 *
	 * @param soc0130DAO soc0130DAO
	 */
	public void setSoc0130DAO(SOC0130DAO soc0130DAO) {
		this.soc0130DAO = soc0130DAO;
	}


	protected SOC0130DAO soc0130DAO;
	

	public ArrayList<SOC0130Info> searchFsLvVg(SOC0130SearchCond cond) throws BLException{
		return soc0130DAO.searchFsLvVg(cond);
	}

}
