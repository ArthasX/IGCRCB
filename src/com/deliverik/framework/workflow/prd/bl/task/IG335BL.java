/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG335PK;
import com.deliverik.framework.workflow.prd.model.entity.IG335TB;

/**
  * 概述: 表单策略表业务逻辑接口
  * 功能描述: 表单策略表业务逻辑接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG335BL extends BaseBL {

	/**
	 * 表单策略表实例取得
	 *
	 * @return 表单策略表实例
	 */
	public IG335TB getIG335TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG335Info> searchIG335();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG335Info searchIG335ByPK(IG335PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG335SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG335Info> searchIG335(
			IG335SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG335Info> searchIG335(
			IG335SearchCond cond, int start,
			int count);

	/**
	 * 超时通知策略查询
	 * 
	 * @param pdid 流程定义ID
	 * @param psdid 状态定义ID
	 * @param pidid 表单定义ID
	 * @return  超时通知策略列表
	 */
	public List<IG335Info> searchIG335Info(String pdid,  String psdid, String pidid, String psdconfirm);
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG335Info registIG335(IG335Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG335Info updateIG335(IG335Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG335ByPK(IG335PK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG335(List<IG335Info> instanceList)
			throws BLException;
			
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG335(IG335Info instance)
		throws BLException;

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