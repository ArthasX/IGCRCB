/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG941Info;
import com.deliverik.framework.workflow.prr.model.condition.IG941SearchCond;

/**
 * 
 * 服务工单日志业务逻辑接口
 *
 */
public interface IG941BL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG941SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param sflid 服务工单日志ID
	 * @return 服务工单日志
	 */
	public IG941Info searchIG941InfoByKey(Integer sflid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部服务工单日志信息
	 */
	public List<IG941Info> searchIG941InfoAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG941Info> searchIG941Info(IG941SearchCond cond, int start, int count);

	/**
	 * 登记处理
	 * 
	 * @param IG941Info 登记数据
	 * @return 服务工单日志
	 */
	public IG941Info registIG941Info(IG941Info ig941Info) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param IG941Info 变更数据
	 * @return 服务工单日志日志
	 */
	public IG941Info updateIG941Info(IG941Info ig941Info) throws BLException;
	
}
