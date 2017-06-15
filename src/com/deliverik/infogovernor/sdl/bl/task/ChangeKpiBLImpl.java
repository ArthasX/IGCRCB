package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;
import com.deliverik.infogovernor.sdl.model.condition.ChangeKpiSearchCond;
import com.deliverik.infogovernor.sdl.model.dao.ChangeKpiVWDAO;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_变更KPI统计接口实现
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
public class ChangeKpiBLImpl extends BaseBLImpl implements ChangeKpiBL {

	/** ChangeKpiVWDAO DAO */
	protected ChangeKpiVWDAO changeKpiVWDAO;

	public void setChangeKpiVWDAO(ChangeKpiVWDAO changeKpiVWDAO) {
		this.changeKpiVWDAO = changeKpiVWDAO;
	}



	/**
	 * <p>
	 * Description: 变更KPI统计查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return List<ChangeKpi>
	 * @author maozhipeng@deliverik.com
	 */
	public List<ChangeKpi> searchChangeKpi(ChangeKpiSearchCond cond, int start, int count){
		List<ChangeKpi> ret = changeKpiVWDAO.findByCond(cond,start,count);
		return ret;
	}

}
