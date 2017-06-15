/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanitemSearchCond;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;

/**
  * 概述: 演练计划条目业务逻辑接口
  * 功能描述: 演练计划条目业务逻辑接口
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
public interface DrillplanitemBL extends BaseBL {

	/**
	 * 演练计划条目实例取得
	 *
	 * @return 演练计划条目实例
	 */
	public DrillplanitemTB getDrillplanitemTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<DrillplanitemInfo> searchDrillplanitem();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public DrillplanitemInfo searchDrillplanitemByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(DrillplanitemSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<DrillplanitemInfo> searchDrillplanitem(
			DrillplanitemSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DrillplanitemInfo> searchDrillplanitem(
			DrillplanitemSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public DrillplanitemInfo registDrillplanitem(DrillplanitemInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public DrillplanitemInfo updateDrillplanitem(DrillplanitemInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteDrillplanitemByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteDrillplanitem(DrillplanitemInfo instance)
		throws BLException;
	
	/**查询演练基本信息*/
	public Map<String,Object> searchDrillDetailByPrid(String prid,String flowType) throws BLException;
	
}