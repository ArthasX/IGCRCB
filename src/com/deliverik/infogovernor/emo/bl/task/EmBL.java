/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.emo.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.emo.model.EmInfo;
import com.deliverik.infogovernor.emo.model.condition.EmSearchCond;
import com.deliverik.infogovernor.emo.model.entity.EmTB;

/**
  * 概述: oracle性能采集业务逻辑接口
  * 功能描述: oracle性能采集业务逻辑接口
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public interface EmBL extends BaseBL {

	/**
	 * oracle性能采集实例取得
	 *
	 * @return oracle性能采集实例
	 */
	public EmTB getEmTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EmInfo> searchEm();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EmInfo searchEmByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EmSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EmInfo> searchEm(
			EmSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EmInfo> searchEm(
			EmSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public EmInfo registEm(EmInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public EmInfo updateEm(EmInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEmByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEm(EmInfo instance)
		throws BLException;

}