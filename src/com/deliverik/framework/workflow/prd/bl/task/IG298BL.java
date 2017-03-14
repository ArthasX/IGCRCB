/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG298TB;

/**
  * 概述: 流程状态可分派角色定义信息业务逻辑接口
  * 功能描述: 流程状态可分派角色定义信息业务逻辑接口
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
public interface IG298BL extends BaseBL {

	/**
	 * 流程状态可分派角色定义信息实例取得
	 *
	 * @return 流程状态可分派角色定义信息实例
	 */
	public IG298TB getIG298TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG298Info> searchIG298Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG298Info searchIG298InfoByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG298SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG298Info> searchIG298Info(
			IG298SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG298Info> searchIG298Info(
			IG298SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG298Info registIG298Info(IG298Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG298Info updateIG298Info(IG298Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG298InfoByPK(String pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG298Info(IG298Info instance)
		throws BLException;
	
	/**
	 * PSRDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSRDID主键值
	 */
	public String getPsrdidSequenceNextValue(String psdid);
	
	/**
	 * 指定状态可分派角色查询
	 *
	 * @param psdid 流程状态ID
	 * @return 可分派角色列表
	 * @throws BLException 
	 */
	public List<IG298Info> searchIG298Info(
			String psdid) throws BLException;
	
	/**
	 * 可被分派的角色检索处理
	 * @param pdid 流程定义ID
	 * @param psdid 流程状态ID
	 * @return 可被分派的角色列表
	 */
	public List<Role> searchToBeAssignRole(String pdid, String psdid);
	
	/**
	 * 实例存在检查处理
	 *
	 * @param psdid 状态ID
	 * @param roleid 角色ID
	 * @return 实例
	 */
	public IG298Info checkIG298Info(String psdid, Integer roleid)
		throws BLException;
	
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