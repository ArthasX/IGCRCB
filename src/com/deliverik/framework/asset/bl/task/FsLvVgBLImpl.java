/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;

import com.deliverik.framework.asset.FsLvVgInfo;
import com.deliverik.framework.asset.model.condition.FsLvVgSearchCond;
import com.deliverik.framework.asset.model.dao.FsLvVgDao;
import com.deliverik.framework.base.BLException;

/**
 * 概述: 设备关系信息业务实现（FS-LV-VG）
 * 功能描述: 设备关系信息业务实现（FS-LV-VG）
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public class FsLvVgBLImpl implements FsLvVgBL{
	
	protected FsLvVgDao fsLvVgDao;
	
	

	public void setFsLvVgDao(FsLvVgDao fsLvVgDao) {
		this.fsLvVgDao = fsLvVgDao;
	}



	public ArrayList<FsLvVgInfo> searchFsLvVg(FsLvVgSearchCond cond) throws BLException{
		return fsLvVgDao.searchFsLvVg(cond);
	}

}
