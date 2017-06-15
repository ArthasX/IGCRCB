/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCond;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/**
  * 概述: 集成告警表业务逻辑接口
  * 功能描述: 集成告警表业务逻辑接口
  * 创建记录: 2014/06/21
  * 修改记录: 
  */
public interface IgalarmBL extends BaseBL {

	/**
	 * 集成告警表实例取得
	 *
	 * @return 集成告警表实例
	 */
	public IgalarmTB getIgalarmTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IgalarmInfo> searchIgalarm();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IgalarmInfo searchIgalarmByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IgalarmSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> searchIgalarm(
			IgalarmSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> searchIgalarm(
			IgalarmSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IgalarmInfo registIgalarm(IgalarmInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IgalarmInfo updateIgalarm(IgalarmInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIgalarmByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIgalarm(IgalarmInfo instance)
		throws BLException;

	/**
	 * 告警事件查询
	 */
	public int searchProcessCount(IG500SearchCond cond, String type) throws BLException;
	
	/**
	 * 告警事件查询
	 */
	public List<IGCRC0208VWInfo> searchProcessByType(IG500SearchCond cond, int start,
			int count, String type) throws BLException;
	
	/**
	 * 条件检索处理(没有默认排序)
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> searchIgalarmNoSort(IgalarmSearchCond cond, int start,int count);
	
}