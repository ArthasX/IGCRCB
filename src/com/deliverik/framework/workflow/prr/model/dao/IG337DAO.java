/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;

/**
 * <p>概述:流程参与用户信息DAO接口</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.条件检索结果件数取得</p>
 * <p>          5.指定用户负责的流程处理角色检索处理</p>
 * <p>创建记录：</p>
 */
public interface IG337DAO extends BaseHibernateDAO<IG337Info> {

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG337Info> findAll();

	/**
	 * 功能：主键检索处理
	 * @param pdaid 主键
	 * @return 检索结果
	 */
	public IG337Info findByPK(Serializable ppid);

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果
	 */
	public List<IG337Info> findByCond(final IG337SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getCountByCond(final IG337SearchCond cond);
	
	/**
	 * 功能：指定用户负责的流程处理角色检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG337Info> queryRolemanager(final String userid , final Integer prid);
	
	/**
	 * 流程执行人检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchIG602Info(final String userid, final Integer prid);
	
	/**
	 * 流程可分派人检索处理
	 * @param prid 流程ID
	 * @param roleid 角色ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchSuperAssignExecutors(final Integer prid, final Integer roleid);

	public List<IG337Info> findByCondRun(final IG337SearchCond cond);
}
