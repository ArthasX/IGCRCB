/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 概述：查询父节点信息DAO接口
 * 功能描述：查询父节点信息DAO接口
 * 创建记录：2014/05/19
 */
public interface ParentNodeDAO extends BaseHibernateDAO<Object> {

	/**
	 * 根据流程id 查询当前节点信息
	 */
	public List<Map<String,Object>> searchParentNodes(String psdid); 
	

}