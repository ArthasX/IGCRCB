/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG019Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;

/**
 * <p>
 * 事件和服务请求流程汇总统计业务逻辑
 * </p>
 */
public interface IG019BL extends BaseBL{
	
	/**
	 * 事件和服务请求流程汇总统计(按机构汇总)
	 * 
	 * @return 事件和服务请求流程汇总统计列表
	 */
	
	public List<IG019Info> searchIG019Info(final IG019SearchCond cond, final int start, final int count);
	
	/**
	 * 事件和服务请求流程汇总统计个数(按机构汇总)
	 * 
	 * @return 事件和服务请求流程汇总统计个数
	 */
	public int getIG019Info(final IG019SearchCond cond);
}
