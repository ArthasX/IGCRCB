/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG299TB;

/**
  * 概述: 状态可分派机构定义表业务逻辑接口
  * 功能描述: 状态可分派机构定义表业务逻辑接口
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
public interface IG299BL extends BaseBL {

	/**
	 * 状态可分派机构定义表实例取得
	 *
	 * @return 状态可分派机构定义表实例
	 */
	public IG299TB getIG299TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG299Info> searchIG299();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG299Info searchIG299ByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG299SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG299Info> searchIG299(
			IG299SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG299Info> searchIG299(
			IG299SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG299Info registIG299(IG299Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG299Info updateIG299(IG299Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG299ByPK(String pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG299(IG299Info instance)
		throws BLException;

	/**
	 * PSODID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSODID主键值
	 */
	public String getPsrdidSequenceNextValue(String psdid) ;
	
	/**
	 * 指定状态可分派机构查询
	 *
	 * @param psdid 流程状态ID
	 * @return 可分派机构列表
	 * @throws BLException 
	 */
	public List<IG299Info> searchIG299Info(
			String psdid) throws BLException;
	
	/**
	 * 可被分派的机构检索处理
	 * @param pdid 流程类型ID
	 * @param levellen 机构的当前级数
	 * @param psdid 流程状态节点ID
	 * @return 可被分派的机构列表
	 */
	public List<Organization> searchToBeAssignOrg(String pdid, int levellen, String psdid);

	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
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