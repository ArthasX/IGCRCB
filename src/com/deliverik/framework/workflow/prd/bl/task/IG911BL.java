/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG911TB;

/**
  * 概述: 状态参与者关联流程类型定义表业务逻辑接口
  * 功能描述: 状态参与者关联流程类型定义表业务逻辑接口
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
public interface IG911BL extends BaseBL {

	/**
	 * 状态参与者关联流程类型定义表实例取得
	 *
	 * @return 状态参与者关联流程类型定义表实例
	 */
	public IG911TB getIG911TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG911Info> searchIG911Info();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG911Info searchIG911InfoByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG911SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG911Info> searchIG911Info(
			IG911SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG911Info> searchIG911Info(
			IG911SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG911Info registIG911Info(IG911Info instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG911Info updateIG911Info(IG911Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG911InfoByPK(String pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG911Info(IG911Info instance)
		throws BLException;

	/**
     * PPDID主键值取得
     * 
     * @param 流程状态ID
     * @return PPDID主键值
     */
    public String getPsprpidSequenceNextValue(String psdid);
    
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
     * 相关发起流程状态为启用状态的状态参与者相关发起信息取得
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG911Info> searchIg911RelevantPdid(
            IG911SearchCond cond) ;
    
    /**
     * 相关发起流程状态为启用状态的状态参与者相关发起信息条数取得
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public int getIg911RelevantPdidCount(
            IG911SearchCond cond);
    
    /**
     * 相关发起可发起流程的流程定义信息取得（根据IG911关联取得IG380的信息）
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<IG380Info> searchIg380ByIg911Cond(
            IG911SearchCond cond);
}