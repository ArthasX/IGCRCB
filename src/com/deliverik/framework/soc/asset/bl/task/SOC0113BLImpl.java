/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0113SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0113DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;

/**
  * 概述: 导入程序管理表业务逻辑实现
  * 功能描述: 导入程序管理表业务逻辑实现
  * 创建记录: 2011/05/05
  * 修改记录: 
  */
public class SOC0113BLImpl extends BaseBLImpl implements
		SOC0113BL {

	/** 导入程序管理表DAO接口 */
	protected SOC0113DAO soc0113DAO;
	

	/**
	 * 导入程序管理表DAO接口设定
	 *
	 * @param soc0113DAO 导入程序管理表DAO接口
	 */
	public void setSoc0113DAO(SOC0113DAO soc0113DAO) {
		this.soc0113DAO = soc0113DAO;
	}

	/**
	 * 导入程序管理表实例取得
	 *
	 * @return 导入程序管理表实例
	 */
	public SOC0113TB getEiImportProgrammeTBInstance() {
		return new SOC0113TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0113Info> searchEiImportProgramme() {
		return soc0113DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0113Info searchEiImportProgrammeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0113SearchCond cond) {
		return soc0113DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0113Info> searchEiImportProgramme(
			SOC0113SearchCond cond) {
		return soc0113DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0113Info> searchEiImportProgramme(
			SOC0113SearchCond cond, int start,
			int count) {
		return soc0113DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0113Info registEiImportProgramme(SOC0113Info instance)
		throws BLException {
		return soc0113DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0113Info updateEiImportProgramme(SOC0113Info instance)
		throws BLException {
		checkExistInstance(instance.getImpTypeid());
		return soc0113DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEiImportProgrammeByPK(Integer pk)
		throws BLException {
		soc0113DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEiImportProgramme(SOC0113Info instance)
		throws BLException {
		soc0113DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0113Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0113Info instance = soc0113DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}