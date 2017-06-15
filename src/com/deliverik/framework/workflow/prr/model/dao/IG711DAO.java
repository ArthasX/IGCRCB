/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;


/**
 * 授权管理DAO接口
 */
public interface IG711DAO extends BaseHibernateDAO<IG711Info> {

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG711Info> findByCond(final IG711SearchCond cond, final int start, final int count);
	
	/**
	 * 主键检索处理
	 * @param paid 主键
	 * @return 检索结果
	 */
	public IG711Info findIG711InfoByPK(Integer paid);
}
