/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0125Info;
import com.deliverik.framework.soc.asset.model.dao.SOC0125DAO;

/**
 * 概述: 最新版域信息视图业务逻辑实现
 * 功能描述: 最新版域信息视图业务逻辑实现
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class SOC0125BLImpl extends BaseBLImpl implements SOC0125BL {
	
	/** 最新版域信息视图DAO接口 */
	protected SOC0125DAO soc0125DAO;




	/**
	 * 最新版域信息视图DAO接口设定
	 *
	 * @param soc0125DAO 最新版域信息视图DAO接口
	 */
	public void setSoc0125DAO(SOC0125DAO soc0125DAO) {
		this.soc0125DAO = soc0125DAO;
	}


	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0125Info> searchEiDomainDefVW() throws BLException{
		return soc0125DAO.findAll();
		
	}


	/**
	 * 根据eiddid查询
	 * @param eiddid
	 * @return
	 */
	public SOC0125Info searchEiDomainDefVW(String eiddid)
			throws BLException {
		return soc0125DAO.searchEiDomainDefVW(eiddid);
	}

}
