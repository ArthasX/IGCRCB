/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.asset.VgPvMetaInfo;
import com.deliverik.framework.asset.model.condition.VgPvMetaSearchCond;
import com.deliverik.framework.asset.model.dao.VgPvMetaDao;
import com.deliverik.framework.base.BLException;

/**
 * 概述: 设备关系信息业务实现(VG-PV-Meta)
 * 功能描述: 设备关系信息业务实现(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public class VgPvMetaBLImpl implements VgPvMetaBL{
	
	protected  VgPvMetaDao vgPvMetaDao;
	
	
	
	
	public void setVgPvMetaDao(VgPvMetaDao vgPvMetaDao) {
		this.vgPvMetaDao = vgPvMetaDao;
	}




	public ArrayList<VgPvMetaInfo> searchVgPvMeta(VgPvMetaSearchCond cond) throws BLException{
		return vgPvMetaDao.searchVgPvMeta(cond);
	}

}
