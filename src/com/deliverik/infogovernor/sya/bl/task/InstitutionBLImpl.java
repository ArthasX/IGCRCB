/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sya.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;
import com.deliverik.infogovernor.sya.model.condition.InstitutionSearchCond;
import com.deliverik.infogovernor.sya.model.dao.InstitutionDAO;
import com.deliverik.infogovernor.sya.model.entity.InstitutionTB;

/**
  * 概述: 绩效考核业务逻辑实现
  * 功能描述: 绩效考核业务逻辑实现
  * 创建记录: 2015/01/05
  * 修改记录: 
  */
public class InstitutionBLImpl extends BaseBLImpl implements
		InstitutionBL {

	/** 绩效考核DAO接口 */
	protected InstitutionDAO institutionDAO;
	
	/**
	 * 绩效考核DAO接口设定
	 *
	 * @param institutionDAO 绩效考核DAO接口
	 */
	public void setInstitutionDAO(InstitutionDAO institutionDAO) {
		this.institutionDAO = institutionDAO;
	}

	/**
	 * 绩效考核实例取得
	 *
	 * @return 绩效考核实例
	 */
	public InstitutionTB getInstitutionTBInstance() {
		return new InstitutionTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InstitutionInfo> searchInstitution() {
		return institutionDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InstitutionInfo searchInstitutionByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(InstitutionSearchCond cond) {
		return institutionDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<InstitutionInfo> searchInstitution(
			InstitutionSearchCond cond) {
		return institutionDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<InstitutionInfo> searchInstitution(
			InstitutionSearchCond cond, int start,
			int count) {
		return institutionDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public InstitutionInfo registInstitution(InstitutionInfo instance)
		throws BLException {
		return institutionDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public InstitutionInfo updateInstitution(InstitutionInfo instance)
		throws BLException {
		checkExistInstance(instance.getInid());
		return institutionDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteInstitutionByPK(Integer pk)
		throws BLException {
		institutionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteInstitution(InstitutionInfo instance)
		throws BLException {
		institutionDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public InstitutionInfo checkExistInstance(Integer pk)
		throws BLException {
		InstitutionInfo instance = institutionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}