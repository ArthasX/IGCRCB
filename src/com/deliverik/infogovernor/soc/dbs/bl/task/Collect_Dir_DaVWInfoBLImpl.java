/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_DaVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Dir_DaVWDAO;

/**
 * 
 * @Description:存储基本信息BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Dir_DaVWInfoBLImpl extends BaseBLImpl implements
         Collect_Dir_DaVWInfoBL {

	private Collect_Dir_DaVWDAO collect_Dir_DaVWDAO;

	public List<Collect_Dir_DaVWInfo> findByCond(
			Collect_BusySearchCond cond, int start, int count) {

		return collect_Dir_DaVWDAO.findByCond(cond, start, count);
	}

	public Collect_Dir_DaVWDAO getCollect_Dir_DaVWDAO() {
		return collect_Dir_DaVWDAO;
	}

	public void setcollect_Dir_DaVWDAO(
			Collect_Dir_DaVWDAO collect_Dir_DaVWDAO) {
		this.collect_Dir_DaVWDAO = collect_Dir_DaVWDAO;
	}

}
