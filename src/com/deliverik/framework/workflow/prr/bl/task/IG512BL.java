/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * 流程关系业务逻辑接口
 * 
 */
public interface IG512BL extends BaseBL{
	
	/**
	 * 获取流程关系实例
	 * @return IG512TB
	 */
	public IG512TB getIG512TBInstance();
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG512SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param pprid 流程关系ID
	 * @return 流程关系
	 */
	public IG512Info searchIG512InfoByKey(Integer pprid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部流程关系信息
	 */
	public List<IG512Info> searchIG512InfoAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG512Info> searchIG512Info(IG512SearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param ig512Info 登录数据
	 * @return 流程关系
	 */
	public IG512Info registIG512Info(IG512Info ig512Info) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pprid 流程关系ID
	 * @return
	 */
	public void deleteIG512Info(Integer pprid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param ig512Info 变更数据
	 * @return 流程关系
	 */
	public IG512Info updateIG512Info(IG512Info ig512Info) throws BLException;
	
	/**
	 * 流程关系按建立时间排序（升序）
	 * 
	 * @param ig512InfoList 流程关系列表
	 * 
	 */
	public void orderByTimeAsc(List<IG512Info> ig512InfoList);
	
}
