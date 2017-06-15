/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.util.HashMap;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.RehearseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;



/**
  * 概述: 角色组织架构关系表DAO接口
  * 功能描述: 角色组织架构关系表DAO接口
  * 创建记录: 2014/06/16
  * 修改记录: 
  */
public interface RehearseDAO extends BaseHibernateDAO<RehearseVWInfo> {

	/**
	 * 演练统计 条件查询 分页
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchAssessRisk(final RehearseSearchCond cond, final int start, final int count);
	/**
	 * 演练统计 条件查询 分页
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchRiskInfo(final RehearseSearchCond cond, final int start, final int count);
	/**
	 * 演练统计 条件查询 分页
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchIssueCorrectiveInfo(final RehearseSearchCond cond, final int start, final int count);
	/**
	 * 演练统计 条件查询 分页
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchIssueCorrectiveByField(final RehearseSearchCond cond, final int start, final int count);
	
	
}