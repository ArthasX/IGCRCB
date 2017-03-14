/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;
import com.deliverik.framework.soc.asset.model.condition.EquipmentInquireVWSearchCond;
import com.deliverik.framework.soc.asset.model.dao.EquipmentInquireVWDAO;

/**
 * 概述:3D机房支持IP查询 
 * 功能描述：3D机房支持IP查询
 * 创建人：赵梓廷
 * 创建记录： 2013-02-01
 * 修改记录：
 */
public class EquipmentInquireVWBLImpl extends BaseBLImpl implements EquipmentInquireVWBL {
	
	/**EquipmentInquireVW DAO*/
	protected EquipmentInquireVWDAO equipmentInquireVWDAO ;
	
	

	public void setEquipmentInquireVWDAO(EquipmentInquireVWDAO equipmentInquireVWDAO) {
		this.equipmentInquireVWDAO = equipmentInquireVWDAO;
	}

	public List<EquipmentInquireVWInfo> getEquipmentAndIP(
			EquipmentInquireVWSearchCond cond, int start, int count) {
		
		return equipmentInquireVWDAO.getEquipmentAndIP(cond, start, count);
	}

	public int getEquipmentAndIPCount(EquipmentInquireVWSearchCond cond) {
		
		return equipmentInquireVWDAO.getEquipmentAndIPCount(cond);
	}

}
