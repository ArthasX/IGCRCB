/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_DisksVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_DisksVWDAO;

/**
 * 
 * @Description:存储基本信息BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_DisksVWInfoBLImpl extends BaseBLImpl implements
       Collect_DisksVWInfoBL {

	private Collect_DisksVWDAO collect_DisksVWDAO;

	public List<Collect_DisksVWInfo> findByCond(
			Collect_BusySearchCond cond, int start, int count) {

		return collect_DisksVWDAO.findByCond(cond, start, count);
	}

	public Collect_DisksVWDAO getCollect_DisksVWDAO() {
		return collect_DisksVWDAO;
	}

	public void setCollect_DisksVWDAO(
			Collect_DisksVWDAO collect_DisksVWDAO) {
		this.collect_DisksVWDAO = collect_DisksVWDAO;
	}

	/**
	 * 获取全部磁盘名称
	 */
	public List<Collect_DisksVWInfo> findDisksDeviceName(
			Collect_BusySearchCond cond, int start, int count) {
		
		return collect_DisksVWDAO.findDisksDeviceName(cond, start, count);
	}
	public List<Collect_DisksVWInfo> CX_findDisksDeviceName(Collect_BusySearchCond cond, int start, int count) {
		return collect_DisksVWDAO.CX_findDisksDeviceName(cond, start, count);
	}

	public List<Collect_DisksVWInfo> findDisksByCond_CX(
			Collect_BusySearchCond cond, int start, int  count) {
		return collect_DisksVWDAO.findDisksByCond_CX(cond, start, count);
	}

}
