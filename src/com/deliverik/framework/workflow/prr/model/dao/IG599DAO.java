/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;

/**
 * <p>概述:流程变量信息DAO接口</p>
 * <p>功能描述：1.全件检索</p>
 * <p>			 2.主键检索处理</p>
 * <p>			 3.条件检索处理</p>
 * <p>			 4.条件检索处理(自定义流程关闭状态变量查看权限视图)</p>
 * <p>创建记录：</p>
 */
public interface IG599DAO extends BaseHibernateDAO<IG599Info> {

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG599Info> findAll();

	/**
	 * 功能：主键检索处理
	 * @param piid 主键
	 * @return 检索结果
	 */
	public IG599Info findByPK(Serializable piid);

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG599Info> findByCond(final IG599SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：条件检索处理
	 * 
	 * 自定义流程关闭状态变量查看权限视图（缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG599Info> searchIG599InfoForClose(final IG599SearchCond cond) ;
	
	/**
	 * 条件检索处理
	 * 
	 * 自定义流程关闭状态变量查看权限视图（缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG599Info> searchIG599InfoForSee(final IG599SearchCond cond) ;
	
	/**
	 * 功能：查询当前最大流水号
	 * @param prserialnum 流水号
	 * @param label 名称
	 * @return 最大流水号
	 */
	public String searchMaxSerialnum(String serialnum, String label) ;
}
