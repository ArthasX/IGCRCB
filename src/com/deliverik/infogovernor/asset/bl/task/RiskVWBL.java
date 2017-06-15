/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskVWCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险检查统计查询业务逻辑接口
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface RiskVWBL extends BaseBL {
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskVWInfo> findByCond(final RiskVWCond cond);
}
