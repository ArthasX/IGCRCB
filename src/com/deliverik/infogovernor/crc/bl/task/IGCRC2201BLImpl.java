/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2201DAO;

/**	
 * ����:�������ͳ��BL�ӿ�ʵ��
 * ������¼��yukexin    2014-8-15 ����5:13:37	
 * �޸ļ�¼��null
 */	
public class IGCRC2201BLImpl extends BaseBLImpl implements IGCRC2201BL {

	/** �������ͳ��Dao�ӿ� */
	protected IGCRC2201DAO igcrc2201DAO;

	public IGCRC2201DAO getIgcrc2201DAO() {
		return igcrc2201DAO;
	}

	public void setIgcrc2201DAO(IGCRC2201DAO igcrc2201dao) {
		igcrc2201DAO = igcrc2201dao;
	}


	/**
	 * ͳ�����ݼ���
	 * 
	 * @param cond ��������
	 * @return List<ChangeTreadVWInfo>
	 */
	public List<IGCRC2201VWInfo> searchIncidentTypeData(IGCRC2201Cond cond) {
		return igcrc2201DAO.searchChangeTreadVW(cond);
	}
}
