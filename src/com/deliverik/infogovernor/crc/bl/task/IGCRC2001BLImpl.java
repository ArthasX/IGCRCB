package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2001DAO;

/**
 * 概述: 业务逻辑实现
 * 创建记录:  lianghongyang 2014-8-11 10:34:11
 * 修改记录: 
 */
public class IGCRC2001BLImpl extends BaseBLImpl implements IGCRC2001BL{
	
	/**igcrc2001Dao接口*/
	public IGCRC2001DAO igcrc2001DAO;


	/**根据条件得到年度统计结果*/
	public List<IGCRC2001VWInfo> list(IGCRC2001Cond cond) {
		// TODO Auto-generated method stub
		return igcrc2001DAO.getFindStatistics(cond);
	}

	/**
	 * igcrc2001Dao接口取得
	 * @return igcrc2001DAO  igcrc2001Dao接口
	 */
	public IGCRC2001DAO getIgcrc2001DAO() {
		return igcrc2001DAO;
	}





	/**
	 * igcrc2001Dao接口设定
	 * @param igcrc2001dao  igcrc2001DAO
	 */
	public void setIgcrc2001DAO(IGCRC2001DAO igcrc2001dao) {
		igcrc2001DAO = igcrc2001dao;
	}

	
	
	
}
