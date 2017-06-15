/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;
import com.deliverik.infogovernor.dbm.model.condition.TOPOXMLSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.TOPOXMLTB;

/**
  * 概述: TOPOXML业务逻辑接口
  * 功能描述: TOPOXML业务逻辑接口
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
public interface TOPOXMLBL extends BaseBL {

	/**
	 * TOPOXML实例取得
	 *
	 * @return TOPOXML实例
	 */
	public TOPOXMLTB getTOPOXMLTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TOPOXMLInfo> searchTOPOXML();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TOPOXMLInfo searchTOPOXMLByPK(Serializable pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(TOPOXMLSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<TOPOXMLInfo> searchTOPOXML(
			TOPOXMLSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<TOPOXMLInfo> searchTOPOXML(
			TOPOXMLSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public TOPOXMLInfo registTOPOXML(TOPOXMLInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public TOPOXMLInfo updateTOPOXML(TOPOXMLInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteTOPOXMLByPK(Serializable pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteTOPOXML(TOPOXMLInfo instance)
		throws BLException;
	
	/**根据用户删除对象*/
	public boolean deleteTOPOXMLByUserid(String userid) throws BLException;

}