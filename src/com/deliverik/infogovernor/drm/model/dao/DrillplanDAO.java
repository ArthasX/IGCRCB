/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanSearchCond;
import com.deliverik.infogovernor.drm.model.condition.DrillplanVWSearchCond;

/**
  * 概述: 演练计划DAO接口
  * 功能描述: 演练计划DAO接口
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
public interface DrillplanDAO extends BaseHibernateDAO<DrillplanInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<DrillplanInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public DrillplanInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DrillplanSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DrillplanInfo> findByCond(
			final DrillplanSearchCond cond, final int start,
			final int count);
	
	/**
     * 查询演练计划条目视图
     * @param cond
     * @return
     */
    public List<DrillplanVWInfo> getDrillPlanVW(final DrillplanVWSearchCond cond,final int start,final int count);
    /**
     * 查询演练个数
     * @param cond
     * @return
     */
    public Integer getDrillPlanVWCount(final DrillplanVWSearchCond cond);
    
    /**
     * 根据diid获取计划条目视图
     * @param diid
     * @return
     */
    public DrillplanVWInfo getDrillPlanVWByDiid(final int diid);
	/**
	 * 统计演练计划已演练的条目的检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 */
	public List<Map<String,Object>> searchDrilledPlanByCond(final DrillplanSearchCond cond, final int start, final int count);

}