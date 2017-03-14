/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;
import com.deliverik.infogovernor.iam.model.condition.AUDITPROJECTSearchCond;
import com.deliverik.infogovernor.iam.model.entity.AUDITPROJECTTB;

/**
  * 概述: 审计报告表业务逻辑接口
  * 功能描述: 审计报告表业务逻辑接口
  * 创建记录: 2012/08/08
  * 修改记录: 
  */
public interface AUDITPROJECTBL extends BaseBL {

	/**
	 * 审计报告表实例取得
	 *
	 * @return 审计报告表实例
	 */
	public AUDITPROJECTTB getAUDITPROJECTTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AUDITPROJECTInfo searchAUDITPROJECTByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AUDITPROJECTSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT(
			AUDITPROJECTSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT(
			AUDITPROJECTSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AUDITPROJECTInfo registAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AUDITPROJECTInfo updateAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAUDITPROJECTByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException;

}