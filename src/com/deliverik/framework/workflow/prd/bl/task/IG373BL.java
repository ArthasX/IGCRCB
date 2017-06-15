/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG373TB;

/**
  * 概述: 流程表单初始化事件定义表业务逻辑接口
  * 功能描述: 流程表单初始化事件定义表业务逻辑接口
  * 创建记录: 2012/07/03
  * 修改记录: 
  */
public interface IG373BL extends BaseBL {

	/**
	 * 流程表单初始化事件定义表实例取得
	 *
	 * @return 流程表单初始化事件定义表实例
	 */
	public IG373TB getIG373TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG373Info> searchIG373Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG373Info searchIG373InfoByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG373SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG373Info> searchIG373Info(
			IG373SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG373Info> searchIG373Info(
			IG373SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG373Info registIG373Info(IG373Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG373Info updateIG373Info(IG373Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG373InfoByPK(String pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG373Info(IG373Info instance)
		throws BLException;
	
	/**
	 * PIIDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PIIDID主键值
	 */
	public String getPiididSequenceNextValue(String psdid);
	
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