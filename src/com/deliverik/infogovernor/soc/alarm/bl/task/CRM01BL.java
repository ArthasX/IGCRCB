/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM07DTO;
import com.deliverik.infogovernor.soc.alarm.model.CRMVW01Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM10SearchCond;

public interface CRM01BL extends BaseBL{

	/**
	 * 采集结果查询
	 * @param cond 查询条件
	 * @param start 起始页码
	 * @param length 显示条数
	 * @return 查询结果
	 */
	public List<CRMVW01Info> searchCRM01VWInfoList(CRM10SearchCond cond , int start,int length);
	public Integer  getSearchCount(CRM10SearchCond cond);
	public IGALM07DTO getRefreshRate(IGALM07DTO dto) throws BLException; 
	public String searchTable(final CRM10SearchCond cond);
}
