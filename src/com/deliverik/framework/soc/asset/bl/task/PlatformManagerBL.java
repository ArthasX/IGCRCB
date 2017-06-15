/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCond;

/**
  * 概述:  业务系统管理员缺失业务逻辑接口
  * 功能描述: 业务系统管理员缺失业务逻辑接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface PlatformManagerBL extends BaseBL {

	public List<PlatformManagerInfo> findByCond(PlatformManagerVWSearchCond cond,int start,int count)throws BLException;

	public Integer getCount(PlatformManagerVWSearchCond cond)throws BLException;
}