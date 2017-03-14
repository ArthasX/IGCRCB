/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.condition.IG110SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 查询显示列定义实体DAO接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG110DAO extends BaseHibernateDAO<IG110Info>{

	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @param start 
	 * @param count
	 * @return
	 */
	public List<IG110Info> findByCond(IG110SearchCond cond, int start, int count);

	/**
	 * 取得下一个ID
	 * @param pdid 流程定义ID
	 * @return 实体ID
	 */
	public String getNextId(String pdid);

	/**
	 * 根据流程定义id删除显示列
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid);

}
