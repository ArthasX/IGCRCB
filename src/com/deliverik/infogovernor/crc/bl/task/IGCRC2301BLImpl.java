/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2301DAO;

/**	
 * ����:���򿪷�ͳ��BLʵ��
 * ������¼��yukexin    2014-8-15 ����5:14:19	
 * �޸ļ�¼��null
 */	
public class IGCRC2301BLImpl extends BaseBLImpl implements IGCRC2301BL{
	
	/** igcrc2301DAO�ӿ� */
	protected IGCRC2301DAO igcrc2301DAO;
	
	/**
     * igcrc2301DAOʵ��ȡ��
     *
     * @param IGCRC2301DAO igcrc2301dao
     */
	public IGCRC2301DAO getIgcrc2301DAO() {
		return igcrc2301DAO;
	}
	
	/**
     * igcrc2301dao�ӿ��趨
     *
     * @param IGCRC2301DAO igcrc2301dao
     */
	public void setIgcrc2301DAO(IGCRC2301DAO igcrc2301dao) {
		igcrc2301DAO = igcrc2301dao;
	}
	
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IGCRC2301VWInfo> searchIGCRC2301(IGCRC2301Cond cond) {
		// TODO Auto-generated method stub
		return this.igcrc2301DAO.searchIGCRC2301VWInfo(cond);
	}
	
	/**
	 * ������������
	 * 		��ѯ�����ش���
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Integer> searchList(IGCRC2301Cond cond) {
		// TODO Auto-generated method stub
		return igcrc2301DAO.searchList(cond);
	}
	
	/**
	 * ������������
	 *		��ѯ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Integer> searchListSum(IGCRC2301Cond cond){
		return igcrc2301DAO.searchListSum(cond);
	}
}

