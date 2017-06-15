/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */


package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;

/**
 * 流程状态定义业务逻辑
 * 
 */

public interface IG333BL extends BaseBL {
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	
	public int getIG333InfoSearchCount(IG333SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param psdid 流程状态定义ID
	 * @return 流程状态定义信息
	 */
	
	public IG333Info searchIG333InfoByKey(String psdid) throws BLException;

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	public List<IG333Info> searchIG333Info(
			IG333SearchCond cond, int start, int count);
	
	/**
	 * 全部检索处理
	 * 
	 * @return 检索结果列表
	 */
	
	public List<IG333Info> searchIG333InfoAll();
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<IG333Info> searchIG333Info(IG333SearchCond cond);

	/**
	 * 登录处理
	 * 
	 * @param IG333Info 登录数据
	 * @return 资产信息
	 */
	
	public IG333Info registIG333Info(
			IG333Info ig333Info) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param psdid 删除流程状态定义主键
	 * @return
	 */
	
	public void deleteIG333InfoByKey(String psdid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param ig333Info 变更数据
	 * @return 流程状态定义
	 */
	
	public IG333Info updateIG333Info(
			IG333Info ig333Info) throws BLException;
	
	/**
	 * 流程状态定义信息实例
	 * 
	 * @return 流程状态定义信息
	 */
	
	public IG333TB getIG333TBInstance();
	
	/**
	 * 根据状态code获取指定流程类型的状态ID
	 * 
	 * @param pdid 流程定义ID
	 * @param psdcode 流程状态标识
	 * @return 流程状态ID
	 * @throws BLException 
	 */
	
	public String getIG333InfoIdByStatus(String pdid, String psdcode) throws BLException;
	
	/**
	 * PSDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PSDID主键值
	 */
	public String getPsdidSequenceNextValue(String pdid);
	
	/**
	 * 可被分派节点取得
	 * 
	 * @param 分派节点ID
	 * @param 分派按钮ID
	 * @return 可被分派节点列表
	 * @throws BLException 
	 */
	public List<IG333Info> searchAssignedStatusDef(String psdid, String pbdid) throws BLException;
	
	/**
	 * 指定状态关联的可调整参与者的状态集合取得
	 *
	 * @param psdid 状态ID
	 * @return 状态集合
	 */
	public List<IG333Info> searchAdjustStatus(String psdid);
	
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
