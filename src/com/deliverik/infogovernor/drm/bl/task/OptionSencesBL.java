/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;
import com.deliverik.infogovernor.drm.model.condition.OptionSencesSearchCond;
import com.deliverik.infogovernor.drm.model.entity.OptionSencesTB;

/**
  * 概述: 备选场景业务逻辑接口
  * 功能描述: 备选场景业务逻辑接口
  * 创建记录: 2016/10/09
  * 修改记录: 
  */
public interface OptionSencesBL extends BaseBL {

	/**
	 * 备选场景实例取得
	 *
	 * @return 备选场景实例
	 */
	public OptionSencesTB getOptionSencesTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<OptionSencesInfo> searchOptionSences();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public OptionSencesInfo searchOptionSencesByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(OptionSencesSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<OptionSencesInfo> searchOptionSences(
			OptionSencesSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<OptionSencesInfo> searchOptionSences(
			OptionSencesSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public OptionSencesInfo registOptionSences(OptionSencesInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public OptionSencesInfo updateOptionSences(OptionSencesInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteOptionSencesByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteOptionSences(OptionSencesInfo instance)
		throws BLException;

}