/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GstockVWInfo;
import com.csebank.lom.model.condition.GstockVWSearchCond;
import com.csebank.lom.model.dao.GstockVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 库存预警信息业务逻辑接口实现
 */
public class GstockVWBLImpl extends BaseBLImpl implements GstockVWBL {
	
	/**  DAO */
	protected GstockVWDAO gstockVWDAO;
	

	/**
	 * @param gstockVWDAO the gstockVWDAO to set
	 */
	public void setGstockVWDAO(GstockVWDAO gstockVWDAO) {
		this.gstockVWDAO = gstockVWDAO;
	}

	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<GstockVWInfo> searchGstockVW(GstockVWSearchCond cond, int start, int count){
		
		return gstockVWDAO.findByCond(cond,start,count);
	}

	
}
