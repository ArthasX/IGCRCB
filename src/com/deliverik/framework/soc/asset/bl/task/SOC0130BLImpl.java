/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0130SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0130DAO;

/**
 * 概述: 设备关系信息业务实现（FS-LV-VG）
 * 功能描述: 设备关系信息业务实现（FS-LV-VG）
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public class SOC0130BLImpl implements SOC0130BL{
	
	/**
	 * soc0130DAO设定
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
