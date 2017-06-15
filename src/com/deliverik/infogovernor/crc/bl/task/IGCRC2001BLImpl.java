package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2001DAO;

/**
 * ����: ҵ���߼�ʵ��
 * ������¼:  lianghongyang 2014-8-11 10:34:11
 * �޸ļ�¼: 
 */
public class IGCRC2001BLImpl extends BaseBLImpl implements IGCRC2001BL{
	
	/**igcrc2001Dao�ӿ�*/
	public IGCRC2001DAO igcrc2001DAO;


	/**���������õ����ͳ�ƽ��*/
	public List<IGCRC2001VWInfo> list(IGCRC2001Cond cond) {
		// TODO Auto-generated method stub
		return igcrc2001DAO.getFindStatistics(cond);
	}

	/**
	 * igcrc2001Dao�ӿ�ȡ��
	 * @return igcrc2001DAO  igcrc2001Dao�ӿ�
	 */
	public IGCRC2001DAO getIgcrc2001DAO() {
		return igcrc2001DAO;
	}





	/**
	 * igcrc2001Dao�ӿ��趨
	 * @param igcrc2001dao  igcrc2001DAO
	 */
	public void setIgcrc2001DAO(IGCRC2001DAO igcrc2001dao) {
		igcrc2001DAO = igcrc2001dao;
	}

	
	
	
}
