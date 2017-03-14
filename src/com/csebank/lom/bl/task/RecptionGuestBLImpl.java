/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.csebank.lom.model.dao.RecptionGuestDAO;
import com.csebank.lom.model.dao.RecptionGuestInfoDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * �Ӵ�����ҵ���߼��ӿ�ʵ��
 */
public class RecptionGuestBLImpl extends BaseBLImpl implements RecptionGuestBL {
	
	/** RecptionGuest DAO */
	protected RecptionGuestDAO recptionGuestDAO;
	protected RecptionGuestInfoDAO recptionguestInfoDAO;
	
	
	
	
	public RecptionGuestDAO getRecptionGuestDAO() {
		return recptionGuestDAO;
	}

	public void setRecptionGuestDAO(RecptionGuestDAO recptionGuestDAO) {
		this.recptionGuestDAO = recptionGuestDAO;
	}

	public RecptionGuestInfoDAO getRecptionguestInfoDAO() {
		return recptionguestInfoDAO;
	}

	public void setRecptionguestInfoDAO(RecptionGuestInfoDAO recptionguestInfoDAO) {
		this.recptionguestInfoDAO = recptionguestInfoDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RecptionGuestSearchCond cond){
		
		return recptionGuestDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rgid �Ӵ�����ID
	 * @return �Ӵ�����ID
	 */
	public RecptionGuest searchRecptionGuestByKey(Integer rgid) throws BLException{
		
		return checkExistRecptionGuest(rgid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���Ӵ���Ϣ
	 */
	public List<RecptionGuest> searchRecptionGuestAll(){
		
		return recptionGuestDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionGuest> searchRecptionGuest(RecptionGuestSearchCond cond, int start, int count){
		
		return recptionGuestDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param recptionGuest ��¼����
	 * @return �Ӵ���Ϣ
	 */
	public RecptionGuest registRecptionGuest(RecptionGuest recptionGuest) throws BLException{
		
		return recptionGuestDAO.save(recptionGuest);
	}

	/**
	 * ɾ������
	 * 
	 * @param rgid �Ӵ�ID
	 * @return
	 */
	public void deleteRecptionGuest(Integer rgid) throws BLException{
		
		RecptionGuest recptionGuest = checkExistRecptionGuest(rgid);
		
		recptionGuestDAO.delete(recptionGuest);
	}

	/**
	 * �������
	 * 
	 * @param recptionGuest �������
	 * @return �Ӵ���Ϣ
	 */
	public RecptionGuest updateRecptionGuest(RecptionGuest recptionGuest) throws BLException{
		
		checkExistRecptionGuest(recptionGuest.getRgid());
		return recptionGuestDAO.save(recptionGuest);
	}

	/**
	 * �Ӵ���Ϣ���ڼ��
	 * 
	 * @param rgid �Ӵ�ID
	 * @return �Ӵ���Ϣ
	 * @throws BLException 
	 */
	protected RecptionGuest checkExistRecptionGuest(Integer rgid) throws BLException{
		RecptionGuest info = recptionGuestDAO.findByPK(rgid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�Ӵ����˻���");
		}
		return info;
	}

	public int getSearchCount(RecptionGuestInfoCond cond) {
		// TODO Auto-generated method stub
		return recptionguestInfoDAO.getSearchCount(cond);
	}

	public List<RecptionGuestInfo> searchRecptionGuestInfo(
			RecptionGuestInfoCond cond, int start, int count) {
		// TODO Auto-generated method stub
		return recptionguestInfoDAO.findByCond(cond,start,count);
	}

}
