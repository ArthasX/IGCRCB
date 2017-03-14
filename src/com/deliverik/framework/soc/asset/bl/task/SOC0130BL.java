/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.SOC0130Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0130SearchCond;

/**
 * 概述: 设备关系信息业务逻辑（FS-LV-VG）
 * 功能描述: 设备关系信息业务逻辑（FS-LV-VG）
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public interface SOC0130BL extends BaseBL{
	
	public ArrayList<SOC0130Info> searchFsLvVg(SOC0130SearchCond cond) throws BLException;

}
