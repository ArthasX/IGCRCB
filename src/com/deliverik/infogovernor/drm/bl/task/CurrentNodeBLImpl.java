/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.dao.CurrentNodeDAO;

/**
 * 概述：获取技术恢复流程当前节点BL
 * 功能描述：
 * 创建记录：2014/05/19
 * 修改记录：
 */
public class CurrentNodeBLImpl extends BaseBLImpl implements CurrentNodeBL {
	private CurrentNodeDAO currentNodeDao;
	
	

	public void setCurrentNodeDao(CurrentNodeDAO currentNodeDao) {
		this.currentNodeDao = currentNodeDao;
	}



	/**
	 * 通过流程id获取当前节点信息
	 */
	public List<Map<String,Object>> getCurrentNodes(Integer prid) throws BLException {
		
		return currentNodeDao.searchCurrentNodes(prid);
	}

	/**
	 * 根据流程id 查询所有节点信息
	 */
	public List<Map<String,Object>> searchAllNodes(Integer prid,String psdid) throws BLException{
		return currentNodeDao.searchAllNodes(prid,psdid);
	}
	
}