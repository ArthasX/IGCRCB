/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;
 
import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG701PK;
import com.deliverik.framework.workflow.prd.model.entity.IG701TB;

/**
  * 概述: 流程查看角色授权表单表业务逻辑接口
  * 功能描述: 流程查看角色授权表单表业务逻辑接口
  * 创建记录: 2012/10/15
  * 修改记录: 
  */
public interface IG701BL extends BaseBL {

	/**
	 * 流程查看角色授权表单表实例取得
	 *
	 * @return 流程查看角色授权表单表实例
	 */
	public IG701TB getIg701TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG701Info> searchIg701();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG701Info searchIg701ByPK(IG701PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG701SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG701Info> searchIg701(
			IG701SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG701Info> searchIg701(
			IG701SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG701Info registIg701(IG701Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG701Info updateIg701(IG701Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIg701ByPK(IG701PK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIg701(IG701Info instance)
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