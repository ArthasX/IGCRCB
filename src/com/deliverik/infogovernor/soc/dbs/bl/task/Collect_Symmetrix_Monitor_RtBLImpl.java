/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.Date;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtVWSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_Monitor_RtDAO;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_Monitor_RtVWDAO;

/**
 * 
 * @Description:存储实时信息BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_Monitor_RtBLImpl extends BaseBLImpl implements
		Collect_Symmetrix_Monitor_RtBL {

	protected Collect_Symmetrix_Monitor_RtDAO collect_Symmetrix_Monitor_RtDAO;

	protected Collect_Symmetrix_Monitor_RtVWDAO collect_Symmetrix_Monitor_RtVWDAO;

	public void setCollect_Symmetrix_Monitor_RtDAO(
			Collect_Symmetrix_Monitor_RtDAO collect_Symmetrix_Monitor_RtDAO) {
		this.collect_Symmetrix_Monitor_RtDAO = collect_Symmetrix_Monitor_RtDAO;
	}

	public void setCollect_Symmetrix_Monitor_RtVWDAO(
			Collect_Symmetrix_Monitor_RtVWDAO collect_Symmetrix_Monitor_RtVWDAO) {
		this.collect_Symmetrix_Monitor_RtVWDAO = collect_Symmetrix_Monitor_RtVWDAO;
	}

	/**
	 * 持久化处理
	 * 
	 * @param Collect_Symmetrix_Monitor_Rt实体类
	 * @return Collect_Symmetrix_Monitor_Rt实体类
	 */
	public Collect_Symmetrix_Monitor_Rt saveCollect_Symmetrix_Monitor_Rt(
			Collect_Symmetrix_Monitor_Rt collect_Symmetrix_Monitor_Rt)
			throws BLException {
		return collect_Symmetrix_Monitor_RtDAO
				.save(collect_Symmetrix_Monitor_Rt);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param id
	 *            主键
	 * @return 检索结果
	 */
	public Collect_Symmetrix_Monitor_Rt findCollect_Symmetrix_Monitor_RtByPK(
			Integer id) throws BLException {
		return collect_Symmetrix_Monitor_RtDAO.findByPK(id);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findAllCollect_Symmetrix_Monitor_Rt()
			throws BLException {
		return collect_Symmetrix_Monitor_RtDAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Collect_Symmetrix_Monitor_RtSearchCond cond)
			throws BLException {
		return collect_Symmetrix_Monitor_RtDAO.getSearchCount(cond);
	}

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
			throws BLException {
		return collect_Symmetrix_Monitor_RtDAO.findByCond(cond, start, count);
	}

	/**
	 * 删除处理
	 * 
	 * @param Collect_Symmetrix_Monitor_Rt实体类
	 */
	public void deleteCollect_Symmetrix_Monitor_Rt(
			Collect_Symmetrix_Monitor_Rt collect_Symmetrix_Monitor_Rt)
			throws BLException {
		collect_Symmetrix_Monitor_RtDAO.delete(collect_Symmetrix_Monitor_Rt);
	}

	/**
	 * 视图条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果列表
	 */
	public List<Collect_Symmetrix_Monitor_RtVWInfo> findVWByCond(
			final Collect_Symmetrix_Monitor_RtVWSearchCond cond) {
		return collect_Symmetrix_Monitor_RtVWDAO.findByCond(cond);
	}

	/**
	 * 获取最大时间
	 * 
	 * @return
	 */
	public Date getMaxSaveTime(Collect_Symmetrix_Monitor_RtVWSearchCond cond) {
		return collect_Symmetrix_Monitor_RtVWDAO.getMaxSaveTime(cond);
	}

	/**
	 * 获取最大时间
	 * 
	 * @return
	 */
	public Date getMaxSaveTimeRT(Collect_Symmetrix_Monitor_RtSearchCond cond) {
		return collect_Symmetrix_Monitor_RtDAO.getMaxSaveTime(cond);
	}
	
	/**
	 * 视图条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果列表
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findByCond(
			final Collect_Symmetrix_Monitor_RtSearchCond cond) {
		return collect_Symmetrix_Monitor_RtDAO.findByCond(cond,0 ,10000);
	}
}
