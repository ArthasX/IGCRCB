/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;

/**
 * <p>
 * 流程事件定义业务逻辑
 * </p>
 */

public interface IG413BL extends BaseBL {
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG413SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param pedid 流程事件定义ID
	 * @return 流程事件定义信息
	 */
	public IG413Info searchIG413InfoByKey(String pedid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部流程事件定义信息
	 */
	public List<IG413Info> searchIG413InfoAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG413Info> searchIG413Info(IG413SearchCond cond, int start, int count);

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG413Info> searchIG413Info(IG413SearchCond cond);

	/**
	 * 登录处理
	 * 
	 * @param ig413Info 登录数据
	 * @return 流程事件定义信息
	 */
	public IG413Info registIG413Info(IG413Info ig413Info) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pedid 流程事件定义ID
	 */
	public void deleteIG413Info(String pedid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param ig413Info 变更数据
	 * @return 流程事件定义信息
	 */
	public IG413Info updateIG413Info(IG413Info ig413Info) throws BLException;
	
	/**
	 * PEDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	public String getPedidSequenceNextValue(String psdid);
	
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
