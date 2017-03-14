/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301Cond;

/**
 * 概述: 文档查询业务逻辑接口
 * 功能描述: 文档查询业务逻辑接口
 * 创建记录: 2014/07/15
 * 修改记录: 
 */
public interface IGCRC1301BL extends BaseBL {
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGCRC1301Cond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGCRC1301VWInfo> searchIGCRC1301(
			IGCRC1301Cond cond, int start,
			int count);
	
	
	public List<IGCRC1301VWInfo> searchIGCRC1302(IGCRC1301Cond cond, int start,
			int count);
}
