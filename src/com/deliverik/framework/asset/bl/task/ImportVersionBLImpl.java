/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCondImpl;
import com.deliverik.framework.asset.model.dao.ImportVersionDAO;
import com.deliverik.framework.asset.model.entity.ImportVersionPK;
import com.deliverik.framework.asset.model.entity.ImportVersionTB;

/**
  * 概述: 导入数据版本管理表业务逻辑实现
  * 功能描述: 导入数据版本管理表业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class ImportVersionBLImpl extends BaseBLImpl implements
		ImportVersionBL {

	/** 导入数据版本管理表DAO接口 */
	protected ImportVersionDAO importVersionDAO;
	
	/**
	 * 导入数据版本管理表DAO接口设定
	 *
	 * @param importVersionDAO导入数据版本管理表DAO接口
	 */
	public void setImportVersionDAO(ImportVersionDAO importVersionDAO) {
		this.importVersionDAO = importVersionDAO;
	}

	/**
	 * 导入数据版本管理表实例取得
	 *
	 * @return 导入数据版本管理表实例
	 */
	public ImportVersionTB getImportVersionTBInstance() {
		return new ImportVersionTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ImportVersionInfo> searchImportVersion() {
		return importVersionDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public ImportVersionInfo searchImportVersionByPK(Serializable pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ImportVersionSearchCond cond) {
		return importVersionDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<ImportVersionInfo> searchImportVersion(
			ImportVersionSearchCond cond) {
		return importVersionDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<ImportVersionInfo> searchImportVersion(
			ImportVersionSearchCond cond, int start,
			int count) {
		return importVersionDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public ImportVersionInfo registImportVersion(ImportVersionInfo instance)
		throws BLException {
		checkNotImportVersion(instance.getImpeiname());
		return importVersionDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public ImportVersionInfo updateImportVersion(ImportVersionInfo instance)
		throws BLException {
		checkExistInstance(new ImportVersionPK(instance.getImpversion(),instance.getImpeiname()));
		return importVersionDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteImportVersionByPK(Serializable pk)
		throws BLException {
		importVersionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteImportVersion(ImportVersionInfo instance)
		throws BLException {
		importVersionDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public ImportVersionInfo checkExistInstance(Serializable pk)
		throws BLException {
		ImportVersionInfo instance = importVersionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 导入对象版本检索
	 */
	public List<ImportVersionInfo> searchImportVersionByPK(
			String impeiname,Integer impversion) throws BLException{
		return importVersionDAO.searchImportVersionByImpname(impeiname,impversion);
	}

	/**
	 * 导入对象不存在检查
	 * 
	 * @param impeiname实体名
	 * @return
	 * @throws BLException 
	 */
	public void checkNotImportVersion(String impeiname) throws BLException {
		ImportVersionSearchCondImpl cond = new ImportVersionSearchCondImpl();
		cond.setImpeiname(impeiname);
		List<ImportVersionInfo> infoList = importVersionDAO.findByImpeiname(cond);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO00000.E027","导入对象实体名");
		}
	}

}