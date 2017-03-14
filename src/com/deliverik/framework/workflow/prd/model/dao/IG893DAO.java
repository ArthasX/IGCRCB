package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCond;

/**
 * 流程参与者变量权限视图DAO接口
 */
public interface IG893DAO extends
		BaseHibernateDAO<IG893Info> {

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG893Info> findByCond(final IG893SearchCond cond);
	
}
