/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.asset.model.condition.EiImportProgrammeSearchCond;
import com.deliverik.framework.asset.model.dao.EiImportProgrammeDAO;
import com.deliverik.framework.asset.model.entity.EiImportProgrammeTB;

/**
  * 概述: 导入程序管理表业务逻辑实现
  * 功能描述: 导入程序管理表业务逻辑实现
  * 创建记录: 2011/05/05
  * 修改记录: 
  */
public class EiImportProgrammeBLImpl extends BaseBLImpl implements
		EiImportProgrammeBL {

	/** 导入程序管理表DAO接口 */
	protected EiImportProgrammeDAO eiImportProgrammeDAO;
	
	/**
	 * 导入程序管理表DAO接口设定
	 *
	 * @param eiImportProgrammeDAO 导入程序管理表DAO接口
	 */
	public void setEiImportProgrammeDAO(EiImportProgrammeDAO eiImportProgrammeDAO) {
		this.eiImportProgrammeDAO = eiImportProgrammeDAO;
	}

	/**
	 * 导入程序管理表实例取得
	 *
	 * @return 导入程序管理表实例
	 */
	public EiImportProgrammeTB getEiImportProgrammeTBInstance() {
		return new EiImportProgrammeTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiImportProgrammeInfo> searchEiImportProgramme() {
		return eiImportProgrammeDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EiImportProgrammeInfo searchEiImportProgrammeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EiImportProgrammeSearchCond cond) {
		return eiImportProgrammeDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EiImportProgrammeInfo> searchEiImportProgramme(
			EiImportProgrammeSearchCond cond) {
		return eiImportProgrammeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiImportProgrammeInfo> searchEiImportProgramme(
			EiImportProgrammeSearchCond cond, int start,
			int count) {
		return eiImportProgrammeDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public EiImportProgrammeInfo registEiImportProgramme(EiImportProgrammeInfo instance)
		throws BLException {
		return eiImportProgrammeDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public EiImportProgrammeInfo updateEiImportProgramme(EiImportProgrammeInfo instance)
		throws BLException {
		checkExistInstance(instance.getImpTypeid());
		return eiImportProgrammeDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEiImportProgrammeByPK(Integer pk)
		throws BLException {
		eiImportProgrammeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEiImportProgramme(EiImportProgrammeInfo instance)
		throws BLException {
		eiImportProgrammeDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public EiImportProgrammeInfo checkExistInstance(Integer pk)
		throws BLException {
		EiImportProgrammeInfo instance = eiImportProgrammeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}