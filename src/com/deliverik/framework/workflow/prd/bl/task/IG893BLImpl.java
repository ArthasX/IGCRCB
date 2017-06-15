package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG893DAO;

/**
 * <p>
 * 流程参与者变量权限视图业务逻辑实现
 * </p>
 */
public class IG893BLImpl extends BaseBLImpl implements IG893BL{
	
	/** 流程参与者变量权限视图 DAO*/
	protected IG893DAO ig893DAO;
	
	/**
	 * 流程参与者变量权限视图DAO设定
	 * @param ig893DAO流程参与者变量权限视图DAO
	 */
	public void setIg893DAO(IG893DAO ig893DAO) {
		this.ig893DAO = ig893DAO;
	}

	/**
	 * 获取流程参与者变量权限
	 * @param cond 检索条件
	 * @return 流程参与者变量权限列表
	 */
	public List<IG893Info> searchIG893Info(final IG893SearchCond cond) {
		return ig893DAO.findByCond(cond);
	}
}
