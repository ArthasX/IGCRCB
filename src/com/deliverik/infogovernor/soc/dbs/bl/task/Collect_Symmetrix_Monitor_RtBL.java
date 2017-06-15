/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.Date;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtVWSearchCond;

/**
 * 
 * @Description:存储实时信息BL接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtBL extends BaseBL {
	/**
	 * 持久化处理
	 * 
	 * @param Collect_Symmetrix_Monitor_Rt实体类
	 * @return Collect_Symmetrix_Monitor_Rt实体类
	 */
	public Collect_Symmetrix_Monitor_Rt saveCollect_Symmetrix_Monitor_Rt(
			Collect_Symmetrix_Monitor_Rt collect_Symmetrix_Monitor_Rt)
			throws BLException;

	/**
	 * 主键检索处理
	 * 
	 * @param id
	 *            主键
	 * @return 检索结果
	 */
	public Collect_Symmetrix_Monitor_Rt findCollect_Symmetrix_Monitor_RtByPK(
			Integer id) throws BLException;

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findAllCollect_Symmetrix_Monitor_Rt()
			throws BLException;

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Collect_Symmetrix_Monitor_RtSearchCond cond)
			throws BLException;

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @param start
	 *            检索记录起始行号
	 * @param count
	 *            检索记录件数
	 * @return 检索结果列表
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findCollect_Symmetrix_Monitor_RtByCond(
			Collect_Symmetrix_Monitor_RtSearchCond cond, int start, int count)
			throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param Collect_Symmetrix_Monitor_Rt实体类
	 */
	public void deleteCollect_Symmetrix_Monitor_Rt(
			Collect_Symmetrix_Monitor_Rt collect_Symmetrix_Monitor_Rt)
			throws BLException;

	/**
	 * 视图条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果列表
	 */
	public List<Collect_Symmetrix_Monitor_RtVWInfo> findVWByCond(
			final Collect_Symmetrix_Monitor_RtVWSearchCond cond);

	/**
	 * 获取最大时间
	 * 
	 * @return
	 */
	public Date getMaxSaveTime(Collect_Symmetrix_Monitor_RtVWSearchCond cond);
	
	/**
	 * 获取最大时间
	 * 
	 * @return
	 */
	public Date getMaxSaveTimeRT(Collect_Symmetrix_Monitor_RtSearchCond cond);
	/**
	 * 视图条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果列表
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findByCond(
			final Collect_Symmetrix_Monitor_RtSearchCond cond);
}
