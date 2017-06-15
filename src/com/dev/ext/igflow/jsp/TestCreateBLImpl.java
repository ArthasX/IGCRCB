/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.jsp;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowJspHandlerBL;

/**
 * <p>
 * 流程JSP跳转业务逻辑实现
 * </p>
 */
public class TestCreateBLImpl extends BaseBLImpl implements
		WorkFlowJspHandlerBL {

	/**
	 * 流程跳转JSP取得
	 * 
	 * @param pdid流程定义ID
	 * @param prid流程ID
	 * @param pjdtype页面类型
	 * @param user登录用户信息
	 * @return JSP路径
	 */
	public String forwardExecute(String pdid, Integer prid, String pjdtype, User user)
			throws BLException {
		return "/prrff/IGPRR0101.jsp";
	}
	

}
