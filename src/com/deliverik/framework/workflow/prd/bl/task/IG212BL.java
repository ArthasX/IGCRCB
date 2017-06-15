/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG212PK;
import com.deliverik.framework.workflow.prd.model.entity.IG212TB;

/**
  * 概述: 流程通知策略业务逻辑接口
  * 功能描述: 流程通知策略业务逻辑接口
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
public interface IG212BL extends BaseBL {

	/**
	 * 流程通知策略实例取得
	 *
	 * @return 流程通知策略实例
	 */
	public IG212TB getIG212TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG212Info> searchIG212Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG212Info searchIG212InfoByPK(IG212PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG212SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG212Info> searchIG212Info(
			IG212SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG212Info> searchIG212Info(
			IG212SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG212Info registIG212Info(IG212Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG212Info updateIG212Info(IG212Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG212InfoByPK(IG212PK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG212Info(IG212Info instance)
		throws BLException;
	
	/**
	 * 流程通知策略查询
	 * 
	 * @param pdid 流程定义ID
	 * @return 流程通知策略列表
	 */
	public List<IG238Info> searchIG238Info(String pdid);
	
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