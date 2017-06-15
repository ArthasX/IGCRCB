/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0113SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;

/**
  * 概述: 导入程序管理表业务逻辑接口
  * 功能描述: 导入程序管理表业务逻辑接口
  * 创建记录: 2011/05/05
  * 修改记录: 
  */
public interface SOC0113BL extends BaseBL {

	/**
	 * 导入程序管理表实例取得
	 *
	 * @return 导入程序管理表实例
	 */
	public SOC0113TB getEiImportProgrammeTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0113Info> searchEiImportProgramme();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0113Info searchEiImportProgrammeByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0113SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0113Info> searchEiImportProgramme(
			SOC0113SearchCond cond);

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
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0113Info registEiImportProgramme(SOC0113Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0113Info updateEiImportProgramme(SOC0113Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEiImportProgrammeByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEiImportProgramme(SOC0113Info instance)
		throws BLException;

}