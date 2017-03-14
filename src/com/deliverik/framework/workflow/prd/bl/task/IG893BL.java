/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCond;

/**
 * <p>
 * 流程参与者变量权限视图业务逻辑
 * </p>
 */
public interface IG893BL extends BaseBL{
	
	/**
	 * 获取流程参与者变量权限
	 * @param cond 检索条件
	 * @return 流程参与者变量权限列表
	 */
	public List<IG893Info> searchIG893Info(final IG893SearchCond cond);
}
