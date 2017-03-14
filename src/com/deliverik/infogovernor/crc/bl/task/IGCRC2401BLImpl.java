package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2401DAO;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2401VW;

/**
 * 功能：业务逻辑实现
 * 
 */
public class IGCRC2401BLImpl extends BaseBLImpl implements IGCRC2401BL{
	public IGCRC2401DAO igcrc2401DAO;


	/**
	 * igcrc2401DAO取得
	 * @return igcrc2401DAO  igcrc2401DAO
	 */
	public IGCRC2401DAO getIgcrc2401DAO() {
		return igcrc2401DAO;
	}


	/**
	 * igcrc2401DAO设定
	 * @param igcrc2401dao  igcrc2401DAO
	 */
	public void setIgcrc2401DAO(IGCRC2401DAO igcrc2401dao) {
		igcrc2401DAO = igcrc2401dao;
	}


	/**得到DAO结果*/
	public List<IGCRC2401VW> igcrc2401vwList(IGCRC2401Cond cond) {
		return igcrc2401DAO.getFindStatistics(cond);
	}

	/**
	 * 得到DAO结果
	 * zhangq@deliverik.com
	 * 2014-12-25  增加新方法
	 * 获取响应时间
	 * */
	public List<IGCRC2401VW> igcrc2401vwListConfirm(IGCRC2401Cond cond) {
		return igcrc2401DAO.getFindStatisticsConfirm(cond);
	}

	
	
}
