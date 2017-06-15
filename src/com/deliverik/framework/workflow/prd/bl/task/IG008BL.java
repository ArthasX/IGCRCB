/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG008PK;
import com.deliverik.framework.workflow.prd.model.entity.IG008TB;

/**
  * 概述: 人员表单角色限定业务逻辑接口
  * 功能描述: 人员表单角色限定业务逻辑接口
  * 创建记录: 2013/11/27
  * 修改记录: 
  */
public interface IG008BL extends BaseBL {

	/**
	 * 人员表单角色限定实例取得
	 *
	 * @return 人员表单角色限定实例
	 */
	public IG008TB getIG008TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG008Info> searchIG008();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG008Info searchIG008ByPK(IG008PK pk) throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG008SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG008Info> searchIG008(IG008SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG008Info> searchIG008(IG008SearchCond cond, int start,int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG008Info registIG008(IG008Info instance) throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG008Info updateIG008(IG008Info instance) throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG008ByPK(IG008PK pk) throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG008(IG008Info instance) throws BLException;

	/**
	 * 删除处理
	 *
	 * @param entitys 删除实例集合
	 */
	public void deleteIG008(List<IG008Info> entitys) throws BLException;
	
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