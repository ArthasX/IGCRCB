/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2101DAO;

/**	
 * ����:ҵ���߼�ʵ��	
 * ������¼��yukexin    2014-8-15 ����5:13:07	
 * �޸ļ�¼��null
 */	
public class IGCRC2101BLImpl extends BaseBLImpl implements IGCRC2101BL{
	
	/** igcrc2101DAO�ӿ� */
	protected IGCRC2101DAO igcrc2101DAO;
	
	/**
     * igcrc2101DAOʵ��ȡ��
     *
     * @param IGCRC2101DAO igcrc2101dao
     */
	public IGCRC2101DAO getIgcrc2101DAO() {
		return igcrc2101DAO;
	}
	
	/**
     * igcrc2101dao�ӿ��趨
     *
     * @param IGCRC2101DAO igcrc2101dao
     */
	public void setIgcrc2101DAO(IGCRC2101DAO igcrc2101dao) {
		igcrc2101DAO = igcrc2101dao;
	}
	
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGCRC2101VWInfo> searchIGCRC2101(IGCRC2101Cond cond, int start,
			int count) {
		// TODO Auto-generated method stub
		return this.igcrc2101DAO.searchIGCRC2101VWInfo(cond, start, count);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IGCRC2101VWInfo> searchIGCRC2101(IGCRC2101Cond cond) {
		return this.igcrc2101DAO.searchIGCRC2101VWInfo(cond);
	}

	public List<IGCRC2102VWInfo> searchDepartmentBeanList() {
		return igcrc2101DAO.searchDepartmentBeanList();
	}
}
