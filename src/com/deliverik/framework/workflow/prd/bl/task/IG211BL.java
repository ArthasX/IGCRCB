/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */


package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG211TB;

/**
 * 流程状态变量前处理业务逻辑
 * 
 */

public interface IG211BL extends BaseBL {
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	
	public int getIG211InfoSearchCount(IG211SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param psidid 流程状态变量前处理ID
	 * @return 流程状态变量前处理信息
	 */
	
	public IG211Info searchIG211InfoByKey(String psidid) throws BLException;

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	public List<IG211Info> searchIG211Info(
			IG211SearchCond cond, int start, int count);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<IG211Info> searchIG211Info(IG211SearchCond cond);

	/**
	 * 新增处理
	 * 
	 * @param IG211Info 新增数据
	 * @return 资产信息
	 */
	
	public IG211Info registIG211Info(
			IG211Info ig211Info) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param psidid 删除流程状态变量前处理主键
	 * @return
	 */
	
	public void deleteIG211Info(String psidid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param ig211Info 变更数据
	 * @return 流程状态变量前处理
	 */
	
	public IG211Info updateIG211Info(
			IG211Info ig211Info) throws BLException;
	
	/**
	 * 流程状态前处理变量信息实例
	 * 
	 * @return 流程状态前处理变量
	 */
	
	public IG211TB getIG211TBInstance();
	
	/**
	 * PSIDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSIDID主键值
	 */
	public String getPsididSequenceNextValue(String psdid);
	
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
