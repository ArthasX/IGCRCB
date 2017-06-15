/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogBusinessSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogBusinessTB;

/**
  * 概述: 项目日志付款表业务逻辑接口
  * 功能描述: 项目日志付款表业务逻辑接口
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
public interface ProjectLogBusinessBL extends BaseBL {

	/**
	 * 项目日志付款表实例取得
	 *
	 * @return 项目日志付款表实例
	 */
	public ProjectLogBusinessTB getProjectLogBusinessTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProjectLogBusinessInfo searchProjectLogBusinessByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ProjectLogBusinessSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness(
			ProjectLogBusinessSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness(
			ProjectLogBusinessSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ProjectLogBusinessInfo registProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ProjectLogBusinessInfo updateProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteProjectLogBusinessByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException;

}