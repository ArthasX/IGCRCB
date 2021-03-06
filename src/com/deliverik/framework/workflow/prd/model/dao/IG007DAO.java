/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;


/**
 * <p>概述:流程变量定义信息DAO接口</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.条件检索记录数</p>
 * <p>          3.主键检索处理</p>
 * <p>          4.条件检索处理</p>
 * <p>创建记录：</p>
 */
public interface IG007DAO extends BaseHibernateDAO<IG007Info> {

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG007Info> findAll();
	
	/**
	 * 功能：条件检索记录数
	 * @return 条件检索记录数
	 */
	public int getSearchCount(final IG007SearchCond cond);

	/**
	 * 功能：主键检索处理
	 * @param prid 主键
	 * @return 检索结果
	 */
	public IG007Info findByPK(Serializable prid);

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG007Info> findByCond(final IG007SearchCond cond, final int start, final int count);
	
	/**
	 * PIDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PSDID主键值
	 */
	public String getPididSequenceNextValue(String pdid);

	public List<IG007Info> findByCondRun(final IG007SearchCond cond);
}
