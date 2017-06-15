/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCond;
import com.deliverik.framework.soc.asset.model.dao.PlatformManagerDAO;

/**
  * 概述: 业务系统管理员缺失业务逻辑实现
  * 功能描述: 业务系统管理员缺失业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class PlatformManagerBLImpl extends BaseBLImpl implements
		PlatformManagerBL {

	/** 审计资产属性表DAO接口 */
	protected PlatformManagerDAO platformManagerDAO;
	
	

	public void setPlatformManagerDAO(PlatformManagerDAO platformManagerDAO) {
		this.platformManagerDAO = platformManagerDAO;
	}

	
	public Integer getCount(PlatformManagerVWSearchCond cond)throws BLException{
		return platformManagerDAO.getSearchCount(cond);
	}

	public List<PlatformManagerInfo> findByCond(PlatformManagerVWSearchCond cond,int start,int count)throws BLException{
		return platformManagerDAO.findByCond(cond, start, count);
	}
}