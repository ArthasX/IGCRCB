/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_FibreVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Dir_FibreVWDAO;

/**
 * 
 * @Description:存储基本信息BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Dir_FibreVWInfoBLImpl extends BaseBLImpl implements
		Collect_Dir_FibreVWInfoBL {

	private Collect_Dir_FibreVWDAO collect_Dir_FibreVWDAO;

	public List<Collect_Dir_FibreVWInfo> findByCond(
			Collect_BusySearchCond cond, int start, int count) {

		return collect_Dir_FibreVWDAO.findByCond(cond, start, count);
	}

	public Collect_Dir_FibreVWDAO getCollect_Dir_FibreVWDAO() {
		return collect_Dir_FibreVWDAO;
	}

	public void setCollect_Dir_FibreVWDAO(
			Collect_Dir_FibreVWDAO collect_Dir_FibreVWDAO) {
		this.collect_Dir_FibreVWDAO = collect_Dir_FibreVWDAO;
	}

}
