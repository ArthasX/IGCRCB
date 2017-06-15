/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_CXVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
/**
 * 
 * @Description:存储基本信息BL接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_CXVWInfoBL extends BaseBL {

	public List<Collect_CXVWInfo> CX_findProtDeviceName(final Collect_BusySearchCond cond, final int start,final int count);

	public List<Collect_CXVWInfo> findProtByCond_CX(final Collect_BusySearchCond cond,
			final	int i,final int j);

	public List<Collect_CXVWInfo> findSPByCond_CX(
			Collect_BusySearchCond cond, int i, int j);
}
