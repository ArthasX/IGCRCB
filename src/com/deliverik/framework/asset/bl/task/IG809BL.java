/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.asset.model.condition.IG809SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;


/**
 * 资产关系图文件信息业务逻辑接口实现
 *
 */
public interface IG809BL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG809SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param eirfid 主键
	 */
	public IG809Info searchIG809InfoByKey(Integer eirfid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部信息
	 */
	public List<IG809Info> searchIG809InfoAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG809Info> searchIG809Info(IG809SearchCond cond, int start, int count);
	
	/**
	 * 登录处理
	 * 
	 * @param ig809Info 登录数据
	 * @return 资产关系图文件信息
	 */
	public IG809Info registIG809Info(IG809Info ig809Info) throws BLException;


	/**
	 * 删除处理
	 * 
	 * @param eirfid 主键
	 */
	public void deleteIG809Info(Integer eirfid) throws BLException;
	
	/**
	 * 删除处理
	 * 
	 * @param ig809Info 资产关系图文件信息
	 */
	public void deleteIG809Info(IG809Info ig809Info) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param ig809Info 变更数据
	 * @return 资产关系图文件信息
	 */
	public IG809Info updateIG809Info(IG809Info ig809Info) throws BLException;
}
