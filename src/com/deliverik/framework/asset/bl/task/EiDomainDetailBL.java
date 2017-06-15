/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.EiDomainDetailInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailSearchCond;
import com.deliverik.framework.asset.model.entity.EiDomainDetailPK;
import com.deliverik.framework.asset.model.entity.EiDomainDetailTB;

/**
  * 概述: 资产域明细表业务逻辑接口
  * 功能描述: 资产域明细表业务逻辑接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface EiDomainDetailBL extends BaseBL {

	/**
	 * 资产域明细表实例取得
	 *
	 * @return 资产域明细表实例
	 */
	public EiDomainDetailTB getEiDomainDetailTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetail();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public EiDomainDetailInfo searchEiDomainDetailByPK(EiDomainDetailPK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EiDomainDetailSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetail(
			EiDomainDetailSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetail(
			EiDomainDetailSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public EiDomainDetailInfo registEiDomainDetail(EiDomainDetailInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public EiDomainDetailInfo updateEiDomainDetail(EiDomainDetailInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiDomainDetailByPK(EiDomainDetailPK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiDomainDetail(EiDomainDetailInfo instance)
		throws BLException;

}