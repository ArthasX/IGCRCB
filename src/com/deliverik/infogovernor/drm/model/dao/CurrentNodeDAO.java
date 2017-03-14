/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

/**
 * 概述：当前节点信息DAO接口
 * 功能描述：当前节点信息DAO接口
 * 创建记录：2014/05/19
 */
public interface CurrentNodeDAO{


	public List<Map<String,Object>> searchCurrentNodes(Integer prid); 
	
	/**
	 * 根据流程id 查询所有节点信息
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchAllNodes(Integer prid,String psdid);
}