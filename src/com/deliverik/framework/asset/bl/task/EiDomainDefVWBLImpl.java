/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefVWInfo;
import com.deliverik.framework.asset.model.dao.EiDomainDefVWDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 概述: 最新版域信息视图业务逻辑实现
 * 功能描述: 最新版域信息视图业务逻辑实现
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class EiDomainDefVWBLImpl extends BaseBLImpl implements EiDomainDefVWBL {
	
	/** 最新版域信息视图DAO接口 */
	protected EiDomainDefVWDAO eiDomainDefVWDAO;
	
	
	/**
	 * 最新版域信息视图DAO接口设定
	 * @param eiDomainDefVWDAO最新版域信息视图DAO接口
	 */
	public void setEiDomainDefVWDAO(EiDomainDefVWDAO eiDomainDefVWDAO) {
		this.eiDomainDefVWDAO = eiDomainDefVWDAO;
	}



	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiDomainDefVWInfo> searchEiDomainDefVW() throws BLException{
		return eiDomainDefVWDAO.findAll();
		
	}


	/**
	 * 根据eiddid查询
	 * @param eiddid
	 * @return
	 */
	public EiDomainDefVWInfo searchEiDomainDefVW(String eiddid)
			throws BLException {
		return eiDomainDefVWDAO.searchEiDomainDefVW(eiddid);
	}

}
