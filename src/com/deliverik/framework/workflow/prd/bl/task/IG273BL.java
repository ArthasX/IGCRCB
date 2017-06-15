/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */


package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG273TB;

/**
 * 流程状态跃迁规则业务逻辑
 * 
 */

public interface IG273BL extends BaseBL {
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	
	public int getIG273InfoSearchCount(IG273SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param ptdid 流程状态跃迁规则ID
	 * @return 流程状态跃迁规则信息
	 */
	
	public IG273Info searchIG273InfoByKey(String ptdid) throws BLException;

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	public List<IG273Info> searchIG273Info(
			IG273SearchCond cond, int start, int count);
	
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<IG273Info> searchIG273Info(IG273SearchCond cond);
	
	/**
	 * 全部检索处理
	 * 
	 * @return 检索结果列表
	 */
	
	public List<IG273Info> searchIG273InfoAll();

	/**
	 * 新增处理
	 * 
	 * @param IG273Info 新增数据
	 * @return 资产信息
	 */
	
	public IG273Info registIG273Info(
			IG273Info ig273Info) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param ptdid 删除流程状态跃迁规则主键
	 */
	
	public void deleteIG273InfoByKey(String ptdid) throws BLException;
	
	/**
	 * 删除处理
	 * 
	 * @param ig273Info 删除流程状态跃迁规则信息
	 */
	
	public void deleteIG273Info(IG273Info ig273Info) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param ig273Info 变更数据
	 * @return 流程状态跃迁规则
	 */
	
	public IG273Info updateIG273Info(
			IG273Info ig273Info) throws BLException;
	
	/**
	 * 获取规则定义信息实例
	 * 
	 * @return 规则定义
	 */
	
	public IG273TB getIG273TBInstance();
	
	/**
	 * PTDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PTDID主键值
	 */
	public String getPtdidSequenceNextValue(String psdid);
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 * @throws BLException
	 */
	public StringBuffer exportXML(String pdid) throws BLException;
	
	/**
	 * XML脚本导入处理
	 *
	 * @param element Element
	 * @throws BLException
	 */
	public void importXML(Element element) throws BLException;

}
