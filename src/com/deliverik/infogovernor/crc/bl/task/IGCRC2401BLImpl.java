package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2401DAO;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2401VW;

/**
 * ���ܣ�ҵ���߼�ʵ��
 * 
 */
public class IGCRC2401BLImpl extends BaseBLImpl implements IGCRC2401BL{
	public IGCRC2401DAO igcrc2401DAO;


	/**
	 * igcrc2401DAOȡ��
	 * @return igcrc2401DAO  igcrc2401DAO
	 */
	public IGCRC2401DAO getIgcrc2401DAO() {
		return igcrc2401DAO;
	}


	/**
	 * igcrc2401DAO�趨
	 * @param igcrc2401dao  igcrc2401DAO
	 */
	public void setIgcrc2401DAO(IGCRC2401DAO igcrc2401dao) {
		igcrc2401DAO = igcrc2401dao;
	}


	/**�õ�DAO���*/
	public List<IGCRC2401VW> igcrc2401vwList(IGCRC2401Cond cond) {
		return igcrc2401DAO.getFindStatistics(cond);
	}

	/**
	 * �õ�DAO���
	 * zhangq@deliverik.com
	 * 2014-12-25  �����·���
	 * ��ȡ��Ӧʱ��
	 * */
	public List<IGCRC2401VW> igcrc2401vwListConfirm(IGCRC2401Cond cond) {
		return igcrc2401DAO.getFindStatisticsConfirm(cond);
	}

	
	
}
