package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC1304DAO;

/**
 * ���ܣ�ҵ���߼�ʵ��
 * @author ʷ����   2014-7-22
 */
public class IGCRC1304BLImpl extends BaseBLImpl implements IGCRC1304BL{
	
	/** igcrc1304DAO�ӿ� */
	protected IGCRC1304DAO igcrc1304DAO;

	/**
     * igcrc1304DAOʵ��ȡ��
     *
     * @param IGCRC1304DAO igcrc1304dao
     */
	public IGCRC1304DAO getIgcrc1304DAO() {
		return igcrc1304DAO;
	}

	/**
     * igcrc1304dao�ӿ��趨
     *
     * @param IGCRC1304DAO igcrc1304dao
     */
	public void setIgcrc1304DAO(IGCRC1304DAO igcrc1304dao) {
		igcrc1304DAO = igcrc1304dao;
	}

	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGCRC1304Cond cond) {
		// TODO Auto-generated method stub
		return this.igcrc1304DAO.getSearchCount(cond);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGCRC1303VWInfo> searchIGCRC1304(IGCRC1304Cond cond, int start,
			int count) {
		// TODO Auto-generated method stub
		return this.igcrc1304DAO.searchIGCRC1304VWInfo(cond, start, count);
	}

	/**
	 * ��������ͳ�Ƽ�¼
	 * @return
	 */
	public List<String> searchType() {
		// TODO Auto-generated method stub
		return this.igcrc1304DAO.searchType();
	}
	
	/**
	 * ��ѯ�����ص��ĵ��Ĳ���
	 * @return
	 */
	public List<String> searchDownDepart(){
		 
		return this.igcrc1304DAO.searchDownDepart();
	}

	public List<Integer> searchTypeID(IGCRC1304Cond cond) {
		// TODO Auto-generated method stub
		return this.igcrc1304DAO.searchTypeID(cond);
	}

}
