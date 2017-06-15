/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;


/**
 * 概述: 流程策略设定信息DAO接口
 * 功能描述：流程策略设定信息DAO接口
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
public interface IG105DAO extends BaseHibernateDAO<IG105Info> {

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG105Info> findAll();

	/**
	 * 功能：主键检索处理
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG105Info findByPK(Serializable pk);
	

	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG105SearchCond cond);

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG105Info> findByCond(final IG105SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：获取指定流程定义ID当前策略最大版本号
	 * @param pdid流程定义ID
	 * @return 当前策略最大版本号
	 */
	public Integer getMaxgPsdversion(String pdid);

}
