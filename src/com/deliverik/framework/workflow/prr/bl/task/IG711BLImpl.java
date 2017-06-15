/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG711DAO;

/**
 * <p>概述:授权管理业务逻辑实现</p>
 * <p>功能描述：1.授权登录处理</p>
 * <p>          2.条件检索处理</p>
 * <p>          3.主键检索处理</p>
 * <p>创建记录：</p>
 */
public class IG711BLImpl extends BaseBLImpl implements IG711BL{
	
	/** Ig711 DAO */
	protected IG711DAO ig711DAO;
	
	/**
	 * 功能：流程授权DAO
	 * 
	 * @param ig711DAO 流程授权DAO
	 */
	public void setIg711DAO(IG711DAO ig711DAO) {
		this.ig711DAO = ig711DAO;
	}

	/**
	 * 功能：授权登录处理
	 * @param IG711Info 流程授权
	 * @return Ig711 流程授权
	 * @throws BLException
	 */
	public IG711Info insertIG711Info(IG711Info ig711Info) throws BLException{
		return ig711DAO.save(ig711Info);
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public List<IG711Info> searchIG711Info(
			IG711SearchCond cond, int start, int count)
			throws BLException {
		
		return ig711DAO.findByCond(cond, start, count);
	}

	/**
	 * 功能：主键检索处理
	 * 
	 * @param paid 流程授权ID
	 * @return 流程授权
	 * @throws BLException
	 */
	public IG711Info findIG711InfoByPk(Integer paid)
			throws BLException {
		
		return ig711DAO.findByPK(paid);
	}
	
	
}
