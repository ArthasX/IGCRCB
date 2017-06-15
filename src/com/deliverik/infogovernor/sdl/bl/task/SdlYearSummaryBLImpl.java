package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlYearSummarySearchCond;
import com.deliverik.infogovernor.sdl.model.dao.SdlYearSummaryVWDAO;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计接口实现
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class SdlYearSummaryBLImpl extends BaseBLImpl implements SdlYearSummaryBL {

	/** SdlYearSummaryVWDAO DAO */
	protected SdlYearSummaryVWDAO sdlYearSummaryVWDAO;

	public void setSdlYearSummaryVWDAO(SdlYearSummaryVWDAO sdlYearSummaryVWDAO) {
		this.sdlYearSummaryVWDAO = sdlYearSummaryVWDAO;
	}

	/**
	 * <p>
	 * Description: 统计查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return List<SdlDefineInfo>
	 * @author liupeng@deliverik.com
	 */
	public List<SdlYearSummary> searchSdlYearSummary(SdlYearSummarySearchCond cond, int start, int count){
		List<SdlYearSummary> ret = sdlYearSummaryVWDAO.findByCond(cond,start,count);
		return ret;
	}

}
