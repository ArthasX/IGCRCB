/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;
import com.deliverik.infogovernor.prr.model.entity.CopyReadUserTB;

/**
  * 概述: 抄阅人表业务逻辑接口
  * 功能描述: 抄阅人表业务逻辑接口
  * 创建记录: 2013/02/25
  * 修改记录: 
  */
public interface CopyReadUserBL extends BaseBL {

	/**
	 * 抄阅人表实例取得
	 *
	 * @return 抄阅人表实例
	 */
	public CopyReadUserTB getCopyReadUserTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CopyReadUserInfo> searchCopyReadUser();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CopyReadUserInfo searchCopyReadUserByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CopyReadUserSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CopyReadUserInfo> searchCopyReadUser(
			CopyReadUserSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CopyReadUserInfo> searchCopyReadUser(
			CopyReadUserSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CopyReadUserInfo registCopyReadUser(CopyReadUserInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CopyReadUserInfo updateCopyReadUser(CopyReadUserInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCopyReadUserByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCopyReadUser(CopyReadUserInfo instance)
		throws BLException;

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public List<CopyReadUserInfo> getCopyReadUserInfo(
			final CopyReadUserSearchCond cond, final int start,final int count);
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int getCopyReadUserCount( final CopyReadUserSearchCond cond) ;
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public List<CopyReadUserInfo> getCopyReadUserInfoDesc(final CopyReadUserSearchCond cond, final int start,final int count);
}