/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;
import java.util.Map;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * <p>
 * 流程变量定义业务逻辑
 * </p>
 */

public interface IG007BL extends BaseBL {

	/**
	 * 获取流程变量定义实例
	 * 
	 * @return ProcessInfoDefTB
	 * @throws BLException
	 */
	
	public IG007TB getIG007TBInstance();
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG007InfoSearchCount(IG007SearchCond cond);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG007Info> searchIG007Info(IG007SearchCond cond);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG007Info> searchIG007Info(IG007SearchCond cond, int start, int count);
	
	/**
	 * 保存处理
	 * 
	 * @param ig007Info 流程变量定义数据
	 * @return 流程变量定义信息
	 */
	public IG007Info registIG007Info(IG007Info ig007Info) throws BLException;
	
	/**
	 * 更新处理
	 * 
	 * @param ig007Info 更新数据
	 * @return 全局变量
	 */
	public IG007Info updateIG007Info(IG007Info ig007Info) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param pipdid 流程变量定义主键
	 * @return
	 */
	public void deleteIG007InfoByKey(String pidid) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param ig007Info 流程变量定义
	 * @return
	 */
	public void deleteIG007Info(IG007Info ig007Info) throws BLException;
	
	/**
	 * 流程变量定义信息检索处理
	 * 
	 * @param pidid 流程变量ID
	 * @return 流程变量定义信息
	 * @throws BLException 
	 */
	public IG007Info searchIG007InfoByKey(String pidid) throws BLException;
	
	/**
	 * 获取流程变量集合
	 * @param pdid 流程定义ID
	 * @return  流程变量集合
	 */
	
	public List<IG007Info> searchIG007InfoByPdid(String pdid);
	
	/**
	 * 获取流程变量缺省审批人
	 * @param pdid 流程定义ID
	 * @return  流程变量缺省审批人集合
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid);
	
	/**
	 * 获取流程变量集合，不包括缺省变量
	 * @param pdid 流程定义ID
	 * @return  流程变量集合
	 */
	
	public List<IG007Info> searchIG007InfoNoDefault(String pdid);
	
	/**
	 * 获取流程变量缺省审批分派人集合
	 * @param pdid 流程定义ID
	 * @return  流程变量缺省审批分派人集合
	 */
	
	public List<IG337Info> searchDefaultApprovorDispatcherByPdid(String pdid);
	
	/**
	 * PIDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PIDID主键值
	 */
	public String getPididSequenceNextValue(String pdid);
	
	/**
	 * 根据表单名查询表单定义信息
	 * 
	 * @param pdid 流程定义ID
	 * @param name 表单名
	 * @return 表单定义信息
	 * @throws BLException
	 */
	public IG007Info searchIG007Info(String pdid, String name) throws BLException;
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG007Info> searchIG007InfoRun(IG007SearchCond cond);
	
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
