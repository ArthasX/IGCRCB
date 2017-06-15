/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0131SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0131DAO;

/**
 * 概述: 设备关系信息业务实现(VG-PV-Meta)
 * 功能描述: 设备关系信息业务实现(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public class SOC0131BLImpl implements SOC0131BL{

	protected  SOC0131DAO soc0131DAO;
	
	/**
	 * soc0131DAO设定
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
