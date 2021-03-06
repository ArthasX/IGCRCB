/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;

/**
 * 
 * 值班检查内容业务逻辑接口
 *
 */
public interface DutyResultBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DutyResultSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param drid 值班检查内容ID
	 * @return 值班检查内容
	 */
	public DutyResult searchDutyResultByKey(Integer drid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查内容
	 */
	public List<DutyResult> searchDutyResultAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyResult> searchDutyResult(DutyResultSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param DutyResult 登录数据
	 * @return 值班检查内容
	 */
	public DutyResult registDutyResult(DutyResult riskCheck) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param drid 值班检查内容ID
	 * @return
	 */
	public void deleteDutyResult(Integer drid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param riskCheck 变更数据
	 * @return 值班检查内容
	 */
	public DutyResult updateDutyResult(DutyResult riskCheck) throws BLException;

}
