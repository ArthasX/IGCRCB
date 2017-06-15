/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2201DAO;

/**	
 * 概述:变更总体统计BL接口实现
 * 创建记录：yukexin    2014-8-15 下午5:13:37	
 * 修改记录：null
 */	
public class IGCRC2201BLImpl extends BaseBLImpl implements IGCRC2201BL {

	/** 变更总体统计Dao接口 */
	protected IGCRC2201DAO igcrc2201DAO;

	public IGCRC2201DAO getIgcrc2201DAO() {
		return igcrc2201DAO;
	}

	public void setIgcrc2201DAO(IGCRC2201DAO igcrc2201dao) {
		igcrc2201DAO = igcrc2201dao;
	}


	/**
	 * 统计数据检索
	 * 
	 * @param cond 检索条件
	 * @return List<ChangeTreadVWInfo>
	 */
	public List<IGCRC2201VWInfo> searchIncidentTypeData(IGCRC2201Cond cond) {
		return igcrc2201DAO.searchChangeTreadVW(cond);
	}
}
