/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG561TB;

/**
  * 概述: 状态级私有表单值记录表业务逻辑接口
  * 功能描述: 状态级私有表单值记录表业务逻辑接口
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
public interface IG561BL extends BaseBL {

	/**
	 * 状态级私有表单值记录表实例取得
	 *
	 * @return 状态级私有表单值记录表实例
	 */
	public IG561TB getIG561TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG561Info> searchIG561();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG561Info searchIG561ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG561SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG561Info> searchIG561(
			IG561SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG561Info> searchIG561(
			IG561SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG561Info registIG561(IG561Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG561Info updateIG561(IG561Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG561ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG561(IG561Info instance)
		throws BLException;
	
	/**
     * 流程关闭节点 状态私有表单显示查询，将所有能显示的状态级私有表单都显示出来
     * @Title: searchIG561VW
     * @Description: 流程关闭节点 状态私有表单显示查询，将所有能显示的状态级私有表单都显示出来
     * @param 
     * prid 流程id 
     * ppuserid 参与者id
     * isAdmin 是否是流程管理员
     * @return list561VW
     * @throws
     */
    public List<IG561VWInfo> searchIG561VW( String prid , String ppuserid, boolean isAdmin)throws BLException;


}