/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_RfbVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Dir_RfbVWDAO;

/**
 * 
 * @Description:存储基本信息BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Dir_RfbVWInfoBLImpl extends BaseBLImpl implements
			Collect_Dir_RfbVWInfoBL {

	private Collect_Dir_RfbVWDAO collect_Dir_RfbVWDAO;

	public List<Collect_Dir_RfbVWInfo> findByCond(
			Collect_BusySearchCond cond, int start, int count) {

		return collect_Dir_RfbVWDAO.findByCond(cond, start, count);
	}

	public Collect_Dir_RfbVWDAO getCollect_Dir_RfbVWDAO() {
		return collect_Dir_RfbVWDAO;
	}

	public void setCollect_Dir_RfbVWDAO(
			Collect_Dir_RfbVWDAO collect_Dir_RfbVWDAO) {
		this.collect_Dir_RfbVWDAO = collect_Dir_RfbVWDAO;
	}

}
