/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.ProjectLogContractInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogContractSearchCond;
import com.deliverik.infogovernor.prj.model.dao.ProjectLogContractDAO;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogContractTB;

/**
  * 概述: 项目日志合同表业务逻辑实现
  * 功能描述: 项目日志合同表业务逻辑实现
  * 创建记录: 2012/04/10
  * 修改记录: 
  */
public class ProjectLogContractBLImpl extends BaseBLImpl implements
		ProjectLogContractBL {

	/** 项目日志合同表DAO接口 */
	protected ProjectLogContractDAO projectLogContractDAO;
	
	/**
	 * 项目日志合同表DAO接口设定
	 *
	 * @param projectLogContractDAO 项目日志合同表DAO接口
	 */
	public void setProjectLogContractDAO(ProjectLogContractDAO projectLogContractDAO) {
		this.projectLogContractDAO = projectLogContractDAO;
	}

	/**
	 * 项目日志合同表实例取得
	 *
	 * @return 项目日志合同表实例
	 */
	public ProjectLogContractTB getProjectLogContractTBInstance() {
		return new ProjectLogContractTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProjectLogContractInfo> searchProjectLogContract() {
		return projectLogContractDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProjectLogContractInfo searchProjectLogContractByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ProjectLogContractSearchCond cond) {
		return projectLogContractDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ProjectLogContractInfo> searchProjectLogContract(
			ProjectLogContractSearchCond cond) {
		return projectLogContractDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProjectLogContractInfo> searchProjectLogContract(
			ProjectLogContractSearchCond cond, int start,
			int count) {
		return projectLogContractDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ProjectLogContractInfo registProjectLogContract(ProjectLogContractInfo instance)
		throws BLException {
		return projectLogContractDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ProjectLogContractInfo updateProjectLogContract(ProjectLogContractInfo instance)
		throws BLException {
		checkExistInstance(instance.getPlcid());
		return projectLogContractDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteProjectLogContractByPK(Integer pk)
		throws BLException {
		projectLogContractDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteProjectLogContract(ProjectLogContractInfo instance)
		throws BLException {
		projectLogContractDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ProjectLogContractInfo checkExistInstance(Integer pk)
		throws BLException {
		ProjectLogContractInfo instance = projectLogContractDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}