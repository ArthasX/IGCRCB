/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG881SearchCond;

/** 
 * 流程参与者变量权限业务逻辑
 *
 */
public interface IG881BL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG881InfoSearchCount(IG881SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param pipdid 流程参与者变量权限ID
	 * @return 流程参与者变量权限
	 */
	public IG881Info searchIG881InfoByKey(String pipdid) throws BLException;
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG881Info> searchIG881Info(IG881SearchCond cond);

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG881Info> searchIG881Info(IG881SearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param IG881 登录数据
	 * @return 流程参与者变量权限
	 */
	public IG881Info registIG881Info(IG881Info ig881Info) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pipdid 删除对象流程参与者主键
	 * @return
	 */
	public void deleteIG881InfoByKey(String pipdid) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pipdid 删除对象流程参与者主键
	 * @return
	 */
	public void deleteIG881Info(IG881Info ig881Info) throws BLException;
	
	/**
	 * 变更处理
	 * 
	 * @param IG881 变更数据
	 * @return 流程参与者变量权限
	 */
	public IG881Info updateIG881Info(IG881Info ig881Info) throws BLException;
	
	/**
	 * 流程参与者变量权限视图查询
	 * 
	 * @param cond 查询条件
	 * @return 流程参与者变量权限
	 * @throws BLException 
	 */
	public List<IG100Info> searchIG100Info(IG100SearchCond cond) throws BLException;
	
	/**
	 * PIPDID主键值取得
	 * 
	 * @param 流程状态参与者定义ID
	 * @return PIPDID主键值
	 */
	public String getPipdidSequenceNextValue(String ppdid);
	
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
