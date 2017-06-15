/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.SOC0507Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCond;
import com.deliverik.infogovernor.drm.model.entity.SOC0507TB;

/**
  * 概述: 预案信息表业务逻辑接口
  * 功能描述: 预案信息表业务逻辑接口
  * 创建记录: 2016/07/15
  * 修改记录: 
  */
public interface SOC0507BL extends BaseBL {

	/**
	 * 预案信息表实例取得
	 *
	 * @return 预案信息表实例
	 */
	public SOC0507TB getSOC0507TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0507Info> searchSOC0507();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0507Info searchSOC0507ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0507SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0507Info> searchSOC0507(
			SOC0507SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0507Info> searchSOC0507(
			SOC0507SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0507Info registSOC0507(SOC0507Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0507Info updateSOC0507(SOC0507Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0507ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0507(SOC0507Info instance)
		throws BLException;
	/**
	 * 根据预案id和目录id查询指定目录内容
	 * 
	 * @param cid
	 * @param eiid
	 * @return
	 * @throws BLException
	 */
	public SOC0507Info getPlanContent(String cid, Integer eiid) throws BLException;
}