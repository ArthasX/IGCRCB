/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG213TB;

/**
 * <p>
 * 流程角色类型处理业务逻辑 
 * </p>
 */

public interface IG213BL extends BaseBL {
	
	/**
	 * 获流程角色类型实例
	 * 
	 * @return ProcessRoleTypeDefTB
	 * @throws BLException
	 */
	
	public IG213TB getIG213TBInstance();
	
	/**
	 * 条件检索流程角色类型信息
	 * @param cond 流程角色类型信息检索条件
	 * @return 流程角色类型信息结果列表
	 * @throws BLException
	 */
	public List<IG213Info> searchIG213Info(IG213SearchCond cond);
	
	/**
	 * 条件检索流程角色类型信息
	 * @param cond 流程角色类型信息检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 流程角色类型信息结果列表
	 * @throws BLException
	 */
	public List<IG213Info> searchIG213Info(IG213SearchCond cond, int start, int count);
	
	/**
	 * 根据流程ID获取流程角色类型
	 * @param pdid 流程ID
	 * @return 流程角色类型
	 * @throws BLException
	 */
	public IG213Info searchIG213InfoByKey(String prtdid) throws BLException;
	
	/**
	 * 新增流程角色类型定义处理
	 * 
	 * @param ig213Info 新增数据
	 * @return 流程角色类型定义
	 */
	
	public IG213Info registIG213Info(
			IG213Info ig213Info) throws BLException;
	
	/**
	 * 删除处理
	 * 
	 * @param pdid 流程角色类型定义
	 * @return
	 */
	
	public void deleteIG213InfoByKey(String prtdid) throws BLException;
	
	/**
	 * 变更处理
	 * 
	 * @param ig213Info 变更数据
	 * @return 流程角色类型定义
	 */
	
	public IG213Info updateIG213Info(
			IG213Info ig213Info) throws BLException;
	
	/**
	 * PRTDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PRTDID主键值
	 */
	public String getPrtdidSequenceNextValue(String pdid);
	
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
