package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.SdlSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlSummarySearchCond;
import com.deliverik.infogovernor.sdl.model.dao.SdlSummaryVWDAO;


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
public class SdlSummaryBLImpl extends BaseBLImpl implements SdlSummaryBL {

	/** SdlSummaryVWDAO DAO */
	protected SdlSummaryVWDAO sdlSummaryVWDAO;

	public void setSdlSummaryVWDAO(SdlSummaryVWDAO sdlSummaryVWDAO) {
		this.sdlSummaryVWDAO = sdlSummaryVWDAO;
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
	public List<SdlSummary> searchSdlSummary(SdlSummarySearchCond cond, int start, int count){
		List<SdlSummary> ret = sdlSummaryVWDAO.findByCond(cond,start,count);
		return ret;
	}

}
