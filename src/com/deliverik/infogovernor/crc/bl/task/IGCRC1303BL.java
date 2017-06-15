package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;

/**
 * 
 * 功能：文档统计BL
 * @author 史凯龙   2014-7-24
 */
public interface IGCRC1303BL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGCRC1303Cond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGCRC1303VWInfo> searchIGCRC1303(
			IGCRC1303Cond cond, int start,
			int count);
	
	/**
	 * 检索借阅统计记录
	 * @return
	 */
	public List<String> searchType();
	
	/**
	 * 根据查询借阅流程的部门名称
	 * @return
	 */
	public List<String> searchDownType();
}
