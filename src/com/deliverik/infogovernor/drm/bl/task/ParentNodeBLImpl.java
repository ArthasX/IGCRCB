/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.dao.ParentNodeDAO;

/**
 * 概述：获取几点的父节点BL
 * 功能描述：
 * 创建记录：2014/05/19
 * 修改记录：
 */
public class ParentNodeBLImpl extends BaseBLImpl implements ParentNodeBL {
	
	private ParentNodeDAO parentNodeDao;
	
	public void setParentNodeDao(ParentNodeDAO parentNodeDao) {
		this.parentNodeDao = parentNodeDao;
	}

	/**
	 * 通过流程id获取当前节点信息
	 */
	public List<Map<String,Object>> getParentNodes(String psdid) {
		return parentNodeDao.searchParentNodes(psdid);
	}
}