/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckSearchCond;

/**
 * 
 * 风险检查信息业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public interface RiskCheckBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskCheckSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param rcid 风险检查信息ID
	 * @return 风险检查信息
	 */
	public RiskCheck searchRiskCheckByKey(Integer rcid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部风险检查信息信息
	 */
	public List<RiskCheck> searchRiskCheckAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheck> searchRiskCheck(RiskCheckSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param RiskCheck 登录数据
	 * @return 风险检查信息
	 */
	public RiskCheck registRiskCheck(RiskCheck riskCheck) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param rcid 风险检查信息ID
	 * @return
	 */
	public void deleteRiskCheck(Integer rcid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param riskCheck 变更数据
	 * @return 风险检查信息
	 */
	public RiskCheck updateRiskCheck(RiskCheck riskCheck) throws BLException;
	public List<RiskCheck> dbmselByrcclass() throws BLException;
	public List<RiskCheck> getRcclassByMonth(final RiskCheckSearchCond cond)  throws BLException;
	public List<RiskCheck> getRcTestMode (final RiskCheckSearchCond cond)  throws BLException;
}
