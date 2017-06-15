/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG237PK;
import com.deliverik.framework.workflow.prd.model.entity.IG237TB;

/**
  * 概述: 流程策略通知人业务逻辑接口
  * 功能描述: 流程策略通知人业务逻辑接口
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public interface IG237BL extends BaseBL {

	/**
	 * 流程策略通知人实例取得
	 *
	 * @return 流程策略通知人实例
	 */
	public IG237TB getIG237TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG237Info> searchIG237Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG237Info searchIG237InfoByPK(IG237PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG237SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG237Info> searchIG237Info(
			IG237SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG237Info> searchIG237Info(
			IG237SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG237Info registIG237Info(IG237Info instance)
		throws BLException;

	/**
	 * 新增处理
	 *
	 * @param ig237tblist_temp 新增实例
	 * @return 新增实例
	 */
	public void registAllIG237Info(List<IG237Info> ig237tblist_temp)
			throws BLException;
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG237Info updateIG237Info(IG237Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG237InfoByPK(IG237PK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG237Info(IG237Info instance)
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