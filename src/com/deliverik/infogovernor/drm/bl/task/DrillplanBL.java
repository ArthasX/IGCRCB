/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanSearchCond;
import com.deliverik.infogovernor.drm.model.condition.DrillplanVWSearchCond;
import com.deliverik.infogovernor.drm.model.entity.DrillplanTB;

/**
  * 概述: 演练计划业务逻辑接口
  * 功能描述: 演练计划业务逻辑接口
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
public interface DrillplanBL extends BaseBL {

	/**
	 * 演练计划实例取得
	 *
	 * @return 演练计划实例
	 */
	public DrillplanTB getDrillplanTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<DrillplanInfo> searchDrillplan();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public DrillplanInfo searchDrillplanByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(DrillplanSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<DrillplanInfo> searchDrillplan(
			DrillplanSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DrillplanInfo> searchDrillplan(
			DrillplanSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public DrillplanInfo registDrillplan(DrillplanInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public DrillplanInfo updateDrillplan(DrillplanInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteDrillplanByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteDrillplan(DrillplanInfo instance)
		throws BLException;
	
	/**
     * 查询演练计划条目视图
     * @param cond
     * @return
     */
    public List<DrillplanVWInfo> getDrillPlanVW( DrillplanVWSearchCond cond, int start, int count)throws BLException;
    /**
     * 查询演练个数
     * @param cond
     * @return
     */
    public Integer getDrillPlanVWCount( DrillplanVWSearchCond cond)throws BLException;
    
    public DrillplanVWInfo getDrillPlanVWByDiid(int diid)throws BLException;
	/**
	 * 统计演练计划已演练的条目的检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 */
	public List<Map<String,Object>> searchDrilledPlanByCond(final DrillplanSearchCond cond, final int start, final int count);

}