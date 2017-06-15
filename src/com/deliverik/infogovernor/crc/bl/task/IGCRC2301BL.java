/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301Cond;

/**	
 * 概述:程序开发统计BL
 * 创建记录：yukexin    2014-8-15 下午5:14:01	
 * 修改记录：null
 */	
public interface IGCRC2301BL extends BaseBL{
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IGCRC2301VWInfo> searchIGCRC2301(IGCRC2301Cond cond);
	
	
	/**
	 * 条件检索处理
	 * 		查询处理驳回次数
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> searchList(IGCRC2301Cond cond);
	
	/**
	 * 条件检索处理
	 *		查询处理工单的总数
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> searchListSum(IGCRC2301Cond cond);
}
