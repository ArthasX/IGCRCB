/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM02TB;

/**
  * 概述: 虚拟资源项目信息表业务逻辑接口
  * 功能描述: 虚拟资源项目信息表业务逻辑接口
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public interface VIM02BL extends BaseBL {

	/**
	 * 虚拟资源项目信息表实例取得
	 *
	 * @return 虚拟资源项目信息表实例
	 */
	public VIM02TB getVIM02TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM02Info> searchVIM02();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM02Info searchVIM02ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VIM02SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM02Info> searchVIM02(
			VIM02SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM02Info> searchVIM02(
			VIM02SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VIM02Info registVIM02(VIM02Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VIM02Info updateVIM02(VIM02Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVIM02ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVIM02(VIM02Info instance)
		throws BLException;

}