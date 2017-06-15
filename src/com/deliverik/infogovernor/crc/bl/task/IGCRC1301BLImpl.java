/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC1301DAO;

/**
 * ����: ҵ���߼�ʵ��
 * ��������: ҵ���߼�ʵ��
 * ������¼: 2014/07/15
 * �޸ļ�¼: 
 */
public class IGCRC1301BLImpl extends BaseBLImpl implements IGCRC1301BL {

	/** igcrc1301DAO�ӿ� */
	protected IGCRC1301DAO igcrc1301DAO;
	
	/**
	 * igcrc1301DAOʵ��ȡ��
	 *
	 * @return igcrc1301DAOʵ��
	 */
	public IGCRC1301DAO getIgcrc1301DAO() {
		return igcrc1301DAO;
	}

	/**
     * igcrc1301dao�ӿ��趨
     *
     * @param IGCRC1301DAO igcrc1301dao
     */
	public void setIgcrc1301DAO(IGCRC1301DAO igcrc1301dao) {
		igcrc1301DAO = igcrc1301dao;
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGCRC1301VWInfo> searchIGCRC1301(IGCRC1301Cond cond, int start,
			int count) {
		return igcrc1301DAO.searchIGCRC1301VWInfo(cond, start, count);
	}

	
	public List<IGCRC1301VWInfo> searchIGCRC1302(IGCRC1301Cond cond, int start,
			int count) {
		return igcrc1301DAO.searchIGCRC1302VWInfo(cond, start, count);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGCRC1301Cond cond) {
		return igcrc1301DAO.getSearchCount(cond);
	}
}
