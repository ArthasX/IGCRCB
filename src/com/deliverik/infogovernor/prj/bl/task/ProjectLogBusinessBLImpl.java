/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogBusinessSearchCond;
import com.deliverik.infogovernor.prj.model.dao.ProjectLogBusinessDAO;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogBusinessTB;

/**
  * 概述: 项目日志付款表业务逻辑实现
  * 功能描述: 项目日志付款表业务逻辑实现
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
public class ProjectLogBusinessBLImpl extends BaseBLImpl implements
		ProjectLogBusinessBL {

	/** 项目日志付款表DAO接口 */
	protected ProjectLogBusinessDAO projectLogBusinessDAO;
	
	/**
	 * 项目日志付款表DAO接口设定
	 *
	 * @param projectLogBusinessDAO 项目日志付款表DAO接口
	 */
	public void setProjectLogBusinessDAO(ProjectLogBusinessDAO projectLogBusinessDAO) {
		this.projectLogBusinessDAO = projectLogBusinessDAO;
	}

	/**
	 * 项目日志付款表实例取得
	 *
	 * @return 项目日志付款表实例
	 */
	public ProjectLogBusinessTB getProjectLogBusinessTBInstance() {
		return new ProjectLogBusinessTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness() {
		return projectLogBusinessDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProjectLogBusinessInfo searchProjectLogBusinessByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ProjectLogBusinessSearchCond cond) {
		return projectLogBusinessDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness(
			ProjectLogBusinessSearchCond cond) {
		return projectLogBusinessDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return projectLogBusinessDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ProjectLogBusinessInfo registProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException {
		return projectLogBusinessDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ProjectLogBusinessInfo updateProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException {
		checkExistInstance(instance.getPlbid());
		return projectLogBusinessDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteProjectLogBusinessByPK(Integer pk)
		throws BLException {
		projectLogBusinessDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException {
		projectLogBusinessDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ProjectLogBusinessInfo checkExistInstance(Integer pk)
		throws BLException {
		ProjectLogBusinessInfo instance = projectLogBusinessDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}