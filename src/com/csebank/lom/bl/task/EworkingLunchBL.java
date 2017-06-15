/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EworkingLunch;
import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 食堂工作餐信息业务逻辑接口
 */
public interface EworkingLunchBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(EworkingLunchSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param ewlid 食堂工作餐ID
	 * @return 食堂工作餐ID
	 */
	public EworkingLunch searchEworkingLunchByKey(Integer ewlid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部食堂工作餐信息
	 */
	public List<EworkingLunch> searchEworkingLunchAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EworkingLunch> searchEworkingLunch(EworkingLunchSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param EworkingLunch 登录数据
	 * @return 食堂工作餐信息
	 */
	public EworkingLunch registEworkingLunch(EworkingLunch EworkingLunch) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param EworkingLunch 变更数据
	 * @return 食堂工作餐信息
	 */
	public EworkingLunch updateEworkingLunch(EworkingLunch EworkingLunch) throws BLException;

}
