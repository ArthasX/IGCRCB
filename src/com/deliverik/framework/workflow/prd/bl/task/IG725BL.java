/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG725TB;

/**
  * 概述: 缺省参与者按钮定义表业务逻辑接口
  * 功能描述: 缺省参与者按钮定义表业务逻辑接口
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
public interface IG725BL extends BaseBL {

	/**
	 * 缺省参与者按钮定义表实例取得
	 *
	 * @return 缺省参与者按钮定义表实例
	 */
	public IG725TB getIG725TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG725Info> searchIG725Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG725Info searchIG725InfoByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG725SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG725Info> searchIG725Info(
			IG725SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG725Info> searchIG725Info(
			IG725SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG725Info registIG725Info(IG725Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG725Info updateIG725Info(IG725Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG725InfoByPK(String pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG725Info(IG725Info instance)
		throws BLException;
	/**
	 * PDBDID主键值取得
	 * 
	 * @param psdid
	 * @return 
	 */
	public String getPdbdidSequenceNextValue(String psdid);
	
	/**
	 * 新增确认按钮处理
	 *
	 * @param psdid 流程状态ID
	 */
	public void registConfirmButton(String psdid) throws BLException;
	
	/**
	 * 删除确认按钮处理
	 *
	 * @param psdid 流程状态ID
	 */
	public void deleteConfirmButton(String psdid) throws BLException;
	
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