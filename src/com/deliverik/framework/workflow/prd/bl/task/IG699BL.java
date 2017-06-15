/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;

/** 
 * 流程缺省参与者变量权限业务逻辑
 *
 */
public interface IG699BL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG699InfoSearchCount(IG699SearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param pipdid 流程缺省参与者变量权限ID
	 * @return 流程缺省参与者变量权限
	 */
	public IG699Info searchIG699InfoByKey(String pipdid) throws BLException;
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG699Info> searchIG699Info(IG699SearchCond cond);

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG699Info> searchIG699Info(IG699SearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param IG881 登录数据
	 * @return 流程缺省参与者变量权限
	 */
	public IG699Info registIG699Info(IG699Info ig699Info) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pipdid 删除对象流程缺省参与者主键
	 * @return
	 */
	public void deleteIG699InfoByKey(String pdvid) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pdvid 删除对象流程缺省参与者主键
	 * @return
	 */
	public void deleteIG699Info(IG699Info ig699Info) throws BLException;
	
	/**
	 * 变更处理
	 * 
	 * @param ig699Info 变更数据
	 * @return 流程缺省参与者变量权限
	 */
	public IG699Info updateIG699Info(IG699Info ig699Info) throws BLException;
	
	/**
	 * 流程缺省变量权限视图查询
	 * 
	 * @param cond 查询条件
	 * @return 流程缺省变量权限
	 * @throws BLException 
	 */
	public List<IG909Info> searchIG909Info(IG909SearchCond cond);
	
	/**
	 * PDVID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PDVID主键值
	 */
	public String getPdvidSequenceNextValue(String psdid);
	
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
