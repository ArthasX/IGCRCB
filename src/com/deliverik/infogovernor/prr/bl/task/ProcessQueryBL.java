/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.model.condition.ProcessSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessQueryBL extends BaseBL{

	/**
	 * 流程数量取得
	 * @param cond 查询条件
	 * @return 规定总数
	 * @throws BLException
	 */
	public int getProcessCount(ProcessSearchCond cond) throws BLException;

	/**
	 * 查询流程信息
	 * @param cond 查询条件
	 * @param start 起始页码
	 * @param count 显示数量
	 * @return 流程信息集合
	 */
	public List<Map<String, Object>> searchProcess(ProcessSearchCond cond, int start, int count);

}
