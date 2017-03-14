/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.condition.IG123SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG123TB;

/**
  * 概述: 自定义流程机构范围表业务逻辑接口
  * 功能描述: 自定义流程机构范围表业务逻辑接口
  * 创建记录: 2013/03/07
  * 修改记录: 
  */
public interface IG123BL extends BaseBL {

	/**
	 * 自定义流程机构范围表实例取得
	 *
	 * @return 自定义流程机构范围表实例
	 */
	public IG123TB getIG123TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG123Info> searchIG123();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG123Info searchIG123ByPK(String pk) throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG123SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG123Info> searchIG123(IG123SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG123Info> searchIG123(IG123SearchCond cond, int start, int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG123Info registIG123(IG123Info instance) throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG123Info updateIG123(IG123Info instance) throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG123ByPK(String pk) throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG123(IG123Info instance) throws BLException;
	
	/**
	 * 集合删除处理
	 * @param list
	 * @throws BLException
	 */
	public void deleteIG123List(List<IG123Info> list) throws BLException;
	
	/**
	 * 根据流程定义主键查询
	 * @param pdid 流程定义主键
	 * @return 机构范围集合
	 * @throws BLException
	 */
	public List<IG123Info> findBypdid(String pdid);
	
	/**
	 * POTDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PRTDID主键值
	 */
	public String getPotdidSequenceNextValue(String pdid) throws BLException;
	
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