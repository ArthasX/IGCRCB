package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC1303DAO;

/**
 * ���ܣ�ҵ���߼�ʵ��
 * @author ʷ����   2014-7-22
 */
public class IGCRC1303BLImpl extends BaseBLImpl implements IGCRC1303BL{
	
	/** igcrc1303DAO�ӿ� */
	protected IGCRC1303DAO igcrc1303DAO;
	
	/**
     * igcrc1303DAOʵ��ȡ��
     *
     * @param IGCRC1303DAO igcrc1303dao
     */
	public IGCRC1303DAO getIgcrc1303DAO() {
		return igcrc1303DAO;
	}
	
	/**
     * igcrc1303dao�ӿ��趨
     *
     * @param IGCRC1303DAO igcrc1303dao
     */
	public void setIgcrc1303DAO(IGCRC1303DAO igcrc1303dao) {
		igcrc1303DAO = igcrc1303dao;
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGCRC1303Cond cond) {
		// TODO Auto-generated method stub
		return this.igcrc1303DAO.getSearchCount(cond);
	}
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGCRC1303VWInfo> searchIGCRC1303(IGCRC1303Cond cond, int start,
			int count) {
		// TODO Auto-generated method stub
		return this.igcrc1303DAO.searchIGCRC1303VWInfo(cond, start, count);
	}
	
	/**
	 * ��ѯ�����ص��ĵ�������
	 * @return
	 */
	public List<String> searchDownType(){
		
		return this.igcrc1303DAO.searchDownType();
	}
	
	/**
	 * ��������ͳ�Ƽ�¼
	 * @return
	 */
	public List<String> searchType() {
		// TODO Auto-generated method stub
		return this.igcrc1303DAO.searchType();
	}

	

}
