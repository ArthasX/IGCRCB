/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0502Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0502SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0502DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0502TB;

/**
  * 概述: SOC0502业务逻辑实现
  * 功能描述: SOC0502业务逻辑实现
  * 创建记录: 2011/06/13
  * 修改记录: 
  */
public class SOC0502BLImpl extends BaseBLImpl implements
		SOC0502BL {

	private SOC0502DAO soc0502DAO;
	
	public SOC0502TB getSoc0502Instance() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SOC0502Info> searchSoc0502() {
		// TODO Auto-generated method stub
		return null;
	}

	public SOC0502Info searchSoc0502ByPK(Integer id) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSearchCount(SOC0502SearchCond cond) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<SOC0502Info> searchSoc0502(SOC0502SearchCond cond) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SOC0502Info> searchSoc0502(SOC0502SearchCond cond, int start,
			int count) {
		return soc0502DAO.findByCond(cond, start, count);
	}

	public SOC0502Info registSoc0502(SOC0502Info instance) throws BLException {
		return soc0502DAO.save(instance);
	}

	public SOC0502Info updateSoc0502(SOC0502Info instance) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteSoc0502ByPK(Integer id) throws BLException {
		// TODO Auto-generated method stub
		
	}

	public void deleteSoc0502(Integer[] rids) throws BLException {
		
		
		soc0502DAO.deleteByRids(rids);
		
	}

	public int getVWSearchCount(SOC0502SearchCond storageEventSearchCond)
			throws BLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<SOC0502Info> searchSOC0502(
			SOC0502SearchCond storageEventSearchCond, int fromCount,
			int pageDispCount) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSoc0502DAO(SOC0502DAO soc0502dao) {
		soc0502DAO = soc0502dao;
	}

	
	
	


}