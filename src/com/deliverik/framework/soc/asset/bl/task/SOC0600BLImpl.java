/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0600Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0600SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0600DAO;


/**
 * 概述: 资产相关流程查询
 * 功能描述: 资产相关流程查询
 * 创建记录: 2014/03/13
 * 修改记录: 
 */
public class SOC0600BLImpl extends BaseBLImpl implements
	SOC0600BL {

	protected SOC0600DAO soc0600DAO;
	
	/**
	 * SOC0600DAO设定
	 * @param SOC0600DAO SOC0600DAO
	 */
	public void setSoc0600DAO(SOC0600DAO soc0600dao) {
		soc0600DAO = soc0600dao;
	}
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public List<SOC0600Info> findByCond(SOC0600SearchCond cond) {
		return soc0600DAO.findByCond(cond);
	}
}