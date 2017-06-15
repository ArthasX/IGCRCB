/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG931TB;

/**
  * 概述: 缺省状态参与者关联流程类型定义表业务逻辑接口
  * 功能描述: 缺省状态参与者关联流程类型定义表业务逻辑接口
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
public interface IG931BL extends BaseBL {

	/**
	 * 缺省状态参与者关联流程类型定义表实例取得
	 *
	 * @return 缺省状态参与者关联流程类型定义表实例
	 */
	public IG931TB getIG931TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG931Info> searchIG931Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG931Info searchIG931InfoByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG931SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG931Info> searchIG931Info(
			IG931SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG931Info> searchIG931Info(
			IG931SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG931Info registIG931Info(IG931Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG931Info updateIG931Info(IG931Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG931InfoByPK(String pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG931Info(IG931Info instance)
		throws BLException;

	/**
     * PPDID主键值取得
     * 
     * @param 流程状态ID
     * @return PPDID主键值
     */
    public String getDpsprpidSequenceNextValue(String psdid);
    
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
    
    /**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息取得
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG931Info> searchIg931RelevantPdid(
            IG931SearchCond cond);
    
    /**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息条数取得
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public int getIg931RelevantPdidCount(
            IG931SearchCond cond);
    
    /**
     * 相关发起可发起流程的流程定义信息取得（根据IG931关联取得IG380的信息）
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG380Info> searchIg380ByIg931Cond(
            IG931SearchCond cond);
}