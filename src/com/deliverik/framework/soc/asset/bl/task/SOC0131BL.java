/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.SOC0131Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0131SearchCond;

/**
 * 概述: 设备关系信息业务逻辑(VG-PV-Meta)
 * 功能描述: 设备关系信息业务逻辑(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public interface SOC0131BL extends  BaseBL{
	
	public ArrayList<SOC0131Info> searchVgPvMeta(SOC0131SearchCond cond) throws BLException;
}
