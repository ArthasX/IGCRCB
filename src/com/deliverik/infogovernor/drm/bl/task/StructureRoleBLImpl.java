/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;
import com.deliverik.infogovernor.drm.model.condition.StructureRoleSearchCond;
import com.deliverik.infogovernor.drm.model.dao.StructureRoleDAO;
import com.deliverik.infogovernor.drm.model.entity.StructureRoleTB;

/**
  * 概述: 组织架构关联表业务逻辑实现
  * 功能描述: 组织架构关联表业务逻辑实现
  * 创建记录: 2015/03/09
  * 修改记录: 
  */
public class StructureRoleBLImpl extends BaseBLImpl implements
		StructureRoleBL {

	/** 组织架构关联表DAO接口 */
	protected StructureRoleDAO structureRoleDAO;
	
	/**
	 * 组织架构关联表DAO接口设定
	 *
	 * @param structureRoleDAO 组织架构关联表DAO接口
	 */
	public void setStructureRoleDAO(StructureRoleDAO structureRoleDAO) {
		this.structureRoleDAO = structureRoleDAO;
	}

	/**
	 * 组织架构关联表实例取得
	 *
	 * @return 组织架构关联表实例
	 */
	public StructureRoleTB getStructureRoleTBInstance() {
		return new StructureRoleTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<StructureRoleInfo> searchStructureRole() {
		return structureRoleDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public StructureRoleInfo searchStructureRoleByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(StructureRoleSearchCond cond) {
		return structureRoleDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<StructureRoleInfo> searchStructureRole(
			StructureRoleSearchCond cond) {
		return structureRoleDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<StructureRoleInfo> searchStructureRole(
			StructureRoleSearchCond cond, int start,
			int count) {
		return structureRoleDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public StructureRoleInfo registStructureRole(StructureRoleInfo instance)
		throws BLException {
		return structureRoleDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public StructureRoleInfo updateStructureRole(StructureRoleInfo instance)
		throws BLException {
		checkExistInstance(instance.getSrid());
		return structureRoleDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteStructureRoleByPK(Integer pk)
		throws BLException {
		structureRoleDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteStructureRole(StructureRoleInfo instance)
		throws BLException {
		structureRoleDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public StructureRoleInfo checkExistInstance(Integer pk)
		throws BLException {
		StructureRoleInfo instance = structureRoleDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	   /**
     * 角色查询
     * @param cond
     * @return
     */
    public List<RoleInfo> searchRole( StructureRoleSearchCond cond, int start, int count)throws BLException{
        return this.structureRoleDAO.searchRole(cond, start, count);
    }
    /**
     * 角色查询
     * @param cond
     * @return
     */
    public Integer searchRoleCount( StructureRoleSearchCond cond)throws BLException{
        return this.structureRoleDAO.searchRoleCount(cond);
    }

}