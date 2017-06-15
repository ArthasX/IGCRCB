/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 预支费用业务逻辑接口
 */
public interface AdvanCescostBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(AdvanCescostSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param acid 预支费用ID
	 * @return 预支费用ID
	 */
	public AdvanCescost searchAdvanCescostByKey(Integer acid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部预支费用信息
	 */
	public List<AdvanCescost> searchAdvanCescostAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AdvanCescost> searchAdvanCescost(AdvanCescostSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param AdvanCescost 登录数据
	 * @return 预支费用信息
	 */
	public AdvanCescost registAdvanCescost(AdvanCescost advanCescost) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param acid 预支费用ID
	 * @throws BLException
	 */
	public void deleteAdvanCescost(Integer acid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param advanCescost 变更数据
	 * @return 预支费用信息
	 */
	public AdvanCescost updateAdvanCescost(AdvanCescost advanCescost) throws BLException;

}
