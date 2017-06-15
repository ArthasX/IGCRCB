/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;

/**
 * <p>
 * 事件和服务请求流程汇总统计业务逻辑
 * </p>
 */
public interface IG144BL extends BaseBL{
	
	/**
	 * 事件流程汇总统计
	 * 
	 * @return 事件流程汇总统计列表
	 */
	
	public List<IG500Info> searchIG019Info(final IG019SearchCond cond, final int start, final int count);
	
	/**
	 * 事件流程汇总统计个数
	 * 
	 * @return 事件流程汇总统计个数
	 */
	public int getIG019Info(final IG019SearchCond cond);
	
	/**
	 * 服务请求流程汇总统计
	 * 
	 * @return 服务请求流程汇总统计列表
	 */
	
	public List<IG500Info> searchServiceRequest(final IG019SearchCond cond, final int start, final int count);
	
	/**
	 * 服务请求流程汇总统计个数
	 * 
	 * @return 服务请求流程汇总统计个数
	 */
	public int getServiceRequestSearchCount(final IG019SearchCond cond);
}
