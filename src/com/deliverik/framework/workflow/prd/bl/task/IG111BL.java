/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.condition.IG111SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询条件定义实体BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG111BL extends BaseBL{

	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG111Info> searchIG111(IG111SearchCond cond) throws BLException;

	/**
	 * 删除处理
	 * @param instance 删除实例
	 */
	public void deleteIG111(IG111Info instance) throws BLException;
	
	/**
	 * 取得下一个ID
	 * @param pdid 流程定义ID
	 * @return 实体ID
	 * @throws BLException
	 */
	public String getNextId(String pdid) throws BLException;

	/**
	 * 新增处理
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG111Info registIG111(IG111Info instance) throws BLException;
	
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
	 * 根据流程定义id删除 自定义查询条件
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid) throws BLException;

}
