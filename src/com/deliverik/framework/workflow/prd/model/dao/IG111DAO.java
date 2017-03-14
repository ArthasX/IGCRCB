/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.condition.IG111SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询条件定义实体DAO接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG111DAO extends BaseHibernateDAO<IG111Info>{

	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @param start 起始页码
	 * @param count 每页数量
	 * @return 检索结果
	 */
	public List<IG111Info> findByCond(IG111SearchCond cond, int start, int count);
	
	/**
	 * 取得下一个ID
	 * @param pdid 流程定义ID
	 * @return 实体ID
	 */
	public String getNextId(String pdid);

	/**
	 * 根据流程定义id删除 自定义查询条件
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid);
}
