/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.asset.VgPvMetaInfo;
import com.deliverik.framework.asset.model.condition.VgPvMetaSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 概述: 设备关系信息业务逻辑(VG-PV-Meta)
 * 功能描述: 设备关系信息业务逻辑(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public interface VgPvMetaBL extends  BaseBL{
	
	public ArrayList<VgPvMetaInfo> searchVgPvMeta(VgPvMetaSearchCond cond) throws BLException;
}
