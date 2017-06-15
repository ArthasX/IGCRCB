/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201Cond;

/**	
 * 概述:变更总体统计BL接口
 * 创建记录：yukexin    2014-8-15 下午5:13:22	
 * 修改记录：null
 */	
public interface IGCRC2201BL extends BaseBL{
	
	/**
	 * 统计数据检索
	 * 
	 * @param cond 检索条件
	 * @return List<ChangeTreadVWInfo>
	 */
	public List<IGCRC2201VWInfo> searchIncidentTypeData(IGCRC2201Cond cond);
}
