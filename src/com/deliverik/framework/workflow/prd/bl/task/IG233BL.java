/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG233PK;
import com.deliverik.framework.workflow.prd.model.entity.IG233TB;

/**
  * 概述: 自定义流程分派定义表业务逻辑接口
  * 功能描述: 自定义流程分派定义表业务逻辑接口
  * 创建记录: 2013/03/12
  * 修改记录: 
  */
public interface IG233BL extends BaseBL {

	/**
	 * 自定义流程分派定义表实例取得
	 *
	 * @return 自定义流程分派定义表实例
	 */
	public IG233TB getIG233TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG233Info> searchIG233();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG233Info searchIG233ByPK(IG233PK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG233SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG233Info> searchIG233(IG233SearchCond cond);
	
	/**
	 * 根据状态id查询
	 * @param psdid
	 * @return
	 */
	public List<IG233Info> searchByPsdid(String psdid);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG233Info> searchIG233(IG233SearchCond cond, int start,int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG233Info registIG233(IG233Info instance)throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG233Info updateIG233(IG233Info instance)throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG233ByPK(IG233PK pk)throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG233(IG233Info instance)throws BLException;
	
	/**
	 * 集合删除
	 * @param list
	 */
	public void deleteIG233(List<IG233Info> list);
	
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