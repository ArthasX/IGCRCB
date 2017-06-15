/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;

/**
 * <p>概述:流程级联表单业务逻辑</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>          2.登录处理</p>
 * <p>          3.删除处理</p>
 * <p>          4.主键检索处理</p>
 * <p>创建记录：</p>
 */
public interface IG286BL extends BaseBL{
	
	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG286Info> searchIG286Info(IG286SearchCond cond, int start, int count);
	
	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG286Info> searchIG286Info(IG286SearchCond cond);

	/**
	 * 功能：登录处理
	 * 
	 * @param IG286Info 登录数据
	 * @return IG286 流程级联表单信息
	 * @throws BLException
	 */
	public IG286Info insertIG286Info(IG286Info processLinkageDef) throws BLException;
	
	/**
	 * 功能：删除处理
	 * 
	 * @param ig286Info 流程级联表单信息 
	 */
	public void deleteIG286Info(IG286Info ig286Info);
	
	
	/**
	 * 功能：主键检索处理
	 * 
	 * @param plid 流程级联表单主键
	 * @return IG286 流程级联表单信息
	 */
	public IG286Info searchIG286InfoByPk(String plid);
	
	/**
	 * PLID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PLID主键值
	 */
	public String getPlidSequenceNextValue(String pdid);
	
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
