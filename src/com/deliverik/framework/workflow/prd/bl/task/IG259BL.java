/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;

/**
 * <p>
 * 流程模板信息处理业务逻辑 
 * </p>
 */

public interface IG259BL extends BaseBL {
	
	/**
	 * 获流程模板实例
	 * 
	 * @return ProcessTemplateTB
	 * @throws BLException
	 */
	
	public IG259TB getIG259TBInstance();

	/**
	 * 根据流程类型获取流程模板信息 
	 * @param processType 流程类型
	 * @return 流程模板信息
	 * @throws BLException
	 */
	
	public IG259Info searchIG259ByPrType(String processType);
	
	/**
	 * 条件检索流程模板信息
	 * @param cond 流程模板信息检索条件
	 * @return 流程模板信息结果列表
	 * @throws BLException
	 */
	public List<IG259Info> searchIG259Info(IG259SearchCond cond);
	
	/**
	 * 条件检索流程模板信息
	 * @param cond 流程模板信息检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 流程模板信息结果列表
	 * @throws BLException
	 */
	public List<IG259Info> searchIG259Info(IG259SearchCond cond, int start, int count);
	
	/**
	 * 根据流程模板ID获取流程模板
	 * @param ptid 流程模板ID
	 * @return 流程模板信息
	 * @throws BLException
	 */
	public IG259Info searchIG259InfoByKey(Integer ptid) throws BLException;
	
	/**
	 * 新增流程模板处理
	 * 
	 * @param ig259Info 新增数据
	 * @return 流程模板信息
	 */
	
	public IG259Info registIG259Info(
			IG259Info ig259Info) throws BLException;
	
	/**
	 * 删除处理
	 * 
	 * @param ptid 流程模版ID
	 * @return
	 */
	
	public void deleteIG259InfoByKey(Integer ptid) throws BLException;
	
	/**
	 * 变更处理
	 * 
	 * @param processTemplate 变更数据
	 * @return 流程状态跃迁规则
	 */
	
	public IG259Info updateIG259Info(
			IG259Info processTemplate) throws BLException;
}
