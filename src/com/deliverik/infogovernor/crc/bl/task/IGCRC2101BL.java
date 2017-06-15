/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101Cond;

/**	
 * 概述:人员工作统计BL
 * 创建记录：yukexin    2014-8-15 下午5:12:52	
 * 修改记录：null
 */	
public interface IGCRC2101BL extends BaseBL{
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGCRC2101VWInfo> searchIGCRC2101(
			IGCRC2101Cond cond, int start,
			int count);
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IGCRC2101VWInfo> searchIGCRC2101(IGCRC2101Cond cond);
	
	/**	
	 * 功能：查询部门下拉列表
	 * @return 部门下拉列表
	 * 修改记录：null 	
	 */	
	public List<IGCRC2102VWInfo> searchDepartmentBeanList();
}
