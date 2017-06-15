/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.asset.model.entity.ImportVersionTB;

/**
  * 概述: 导入数据版本管理表业务逻辑接口
  * 功能描述: 导入数据版本管理表业务逻辑接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface ImportVersionBL extends BaseBL {

	/**
	 * 导入数据版本管理表实例取得
	 *
	 * @return 导入数据版本管理表实例
	 */
	public ImportVersionTB getImportVersionTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ImportVersionInfo> searchImportVersion();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public ImportVersionInfo searchImportVersionByPK(Serializable pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ImportVersionSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<ImportVersionInfo> searchImportVersion(
			ImportVersionSearchCond cond);

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
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public ImportVersionInfo registImportVersion(ImportVersionInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public ImportVersionInfo updateImportVersion(ImportVersionInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteImportVersionByPK(Serializable pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteImportVersion(ImportVersionInfo instance)
		throws BLException;
	
	/**
	 * 导入对象版本检索
	 * @param impeiname
	 * @param impversion 
	 * @return
	 */
	public List<ImportVersionInfo> searchImportVersionByPK(String impeiname, Integer impversion) throws BLException;

	/**
	 * 导入对象不存在检查
	 * 
	 * @param eilabel实体名
	 * @return
	 * @throws BLException 
	 */
	public void checkNotImportVersion(String impeiname) throws BLException;
}