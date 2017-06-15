/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.condition.StatisticsSearchCond;

/**
 * 概述：应急管理统计DAO
 * 功能描述：应急管理统计DAO接口
 * 创建记录：2015/5/23
 * zhnagjian
 */
public interface StatisticsDAO extends BaseHibernateDAO<Object> {


	/**
	 * 预案统计查询
	 * 统计预案总数,修订数量,演练数量
	 * @return
	 */
	public List<Map<String,Object>> planStatistics(StatisticsSearchCond cond );
	/**
	 * 演练统计查询
	 * 演练计划统计,演练任务统计,演练执行统计
	 * @return
	 */
	public List<Map<String,Object>> drillStatistics(StatisticsSearchCond cond );
	/**
	 * 演练形式统计
	 * 
	 * @return
	 */
	public List<Map<String,Object>> drillTypeStatistics(StatisticsSearchCond cond );
	/**
	 * 预案统计查询-获取预案关联的“已演练”的场景的eiid集合
	 * @return
	 */
	public List<Map<String, Object>> getSceneEiids(StatisticsSearchCond cond );
	

}