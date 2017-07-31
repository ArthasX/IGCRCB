/*
g * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;

/**
  * 概述: 工作实例DAO接口
  * 功能描述: 工作实例DAO接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkInstanceDAO extends BaseHibernateDAO<WorkInstanceInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkInstanceInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkInstanceInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkInstanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkInstanceInfo> findByCond(
			final WorkInstanceSearchCond cond, final int start,
			final int count);
	/**
	 * 查询工作
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findWeekWorkByCond(final WorkInstanceSearchCond cond, final int start, final int count);
	
	/**
	 * @Description 检索工作实例提醒数据集
	 * @author WangLiang
	 * @return 工作实例信息集合
	 */
	public List<WorkInstanceInfo> findInstanceTips();
	
	/**
	 * 工作信息统计查询
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Map<String,String>> findCountSearch(final WorkInstanceSearchCond cond, final int start, final int count);
	/**
	 * 首页查询当日工作
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findTodayWorkByCondForFirstPageTop5(final WorkInstanceSearchCond cond, final int start, final int count);
	
	/**
	 * 首页查询当日工作
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findTodayWorkByCondForFirstPage(final WorkInstanceSearchCond cond, final int start, final int count);
	
	/**
	 * 查询当前工作已经用时多久了，所有日志里填的处理时间之和
	 * @param cond 只用到了实例id-wiid
	 * @return
	 */
	public String getTotalExcuteTime(final WorkInstanceSearchCond cond);
	
	/**
	 * 查询所有预计完成时间小于当前时间，并且所有工作都结束
	 * @param 
	 * @return 时间最大值和对应工作项id
	 */
    public List<Map<String, String>> getExcutedMaxTime();
}