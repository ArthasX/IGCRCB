/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.user.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.framework.user.model.condition.IG622SearchCond;
import com.deliverik.framework.user.model.entity.IG622TB;

/**
  * 概述: 首页跳转URL定义业务逻辑接口
  * 功能描述: 首页跳转URL定义业务逻辑接口
  * 创建记录: 2012/07/18
  * 修改记录: 
  */
public interface IG622BL extends BaseBL {

	/**
	 * 首页跳转URL定义实例取得
	 *
	 * @return 首页跳转URL定义实例
	 */
	public IG622TB getIG622TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG622Info> searchIG622Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG622Info searchIG622InfoByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG622SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG622Info> searchIG622Info(
			IG622SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG622Info> searchIG622Info(
			IG622SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG622Info registIG622Info(IG622Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG622Info updateIG622Info(IG622Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG622InfoByPK(String pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG622Info(IG622Info instance)
		throws BLException;
	
	/**
	 * 用户首页下拉列表取得
	 *
	 * @return 用户首页下拉列表
	 */
	public List<LabelValueBean> getComboBox();
	
	/**
	 * 首页跳转URL取得
	 *
	 * @param hpid 定义ID
	 * @return 首页跳转URL
	 * @throws BLException 
	 */
	public String getUrl(String hpid) throws BLException;
	
	/**
	 * 首页显示名称取得
	 *
	 * @param hpid 定义ID
	 * @return 首页显示名称
	 * @throws BLException 
	 */
	public String getTitle(String hpid) throws BLException;

}