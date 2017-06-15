/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VCD04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD04TB;

/**
  * 概述: vCloud部署日志业务逻辑接口
  * 功能描述: vCloud部署日志业务逻辑接口
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public interface VCD04BL extends BaseBL {

	/**
	 * vCloud部署日志实例取得
	 *
	 * @return vCloud部署日志实例
	 */
	public VCD04TB getVCD04TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VCD04Info> searchVCD04();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD04Info searchVCD04ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VCD04SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VCD04Info> searchVCD04(
			VCD04SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD04Info> searchVCD04(
			VCD04SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VCD04Info registVCD04(VCD04Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VCD04Info updateVCD04(VCD04Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVCD04ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVCD04(VCD04Info instance)
		throws BLException;

}