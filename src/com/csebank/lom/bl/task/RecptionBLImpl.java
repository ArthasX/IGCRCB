/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionAmount;
import com.csebank.lom.model.RecptionCost;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.csebank.lom.model.dao.RecptionAmountDAO;
import com.csebank.lom.model.dao.RecptionCostVWDAO;
import com.csebank.lom.model.dao.RecptionDAO;
import com.csebank.lom.model.dao.RecptionGuestInfoDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * �Ӵ�����ҵ���߼��ӿ�ʵ��
 */
public class RecptionBLImpl extends BaseBLImpl implements RecptionBL {
	
	/** Recption DAO */
	protected RecptionDAO recptionDAO;
	protected RecptionGuestInfoDAO recptionguestinfoDAO;
	protected RecptionCostVWDAO recptionCostVWDAO;
	protected RecptionAmountDAO recptionAmountDAO;

	public void setRecptionCostVWDAO(RecptionCostVWDAO recptionCostVWDAO) {
		this.recptionCostVWDAO = recptionCostVWDAO;
	}

	public void setRecptionDAO(
			RecptionDAO recptionDAO) {
		this.recptionDAO = recptionDAO;
	}
    
	
	public void setRecptionGuestInfoDAO(
			RecptionGuestInfoDAO recptionguestinfoDAO) {
		this.recptionguestinfoDAO = recptionguestinfoDAO;
	}
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RecptionSearchCond cond){
		return recptionDAO.getSearchCount(cond);
	}
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getRecptionCostCount(RecptionSearchCond cond){
		return recptionCostVWDAO.getSearchCount(cond);
		//return recptionDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rid �Ӵ�ID
	 * @return �Ӵ�ID
	 */
	public Recption searchRecptionByKey(Integer rid) throws BLException{
		
		return checkExistRecption(rid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���Ӵ���Ϣ
	 */
	public List<Recption> searchRecptionAll(){
		
		return recptionDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Recption> searchRecption(RecptionSearchCond cond, int start, int count){
		return recptionDAO.findByCond(cond,start,count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionAmount> searchRecptionAmount(RecptionSearchCond cond, int start, int count){
		return recptionAmountDAO.findByCond(cond,start,count);
	}
	
	/**
	 * ���ݽӴ���ʼ�������ڲ�ѯ�Ӵ�������Ϣ�ͷ�����Ϣ
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �Ӵ�������Ϣ�ͷ�����Ϣ
	 */
	public List<RecptionCost> searchRecptionCost(RecptionSearchCond cond, int start, int count){
		return recptionCostVWDAO.findByCond(cond, start, count);
	
	}


	/**
	 * ��¼����
	 * �����¼save������Ҳ��װ����
	 * @param recption ��¼����
	 * @return �Ӵ���Ϣ
	 */
	public Recption registRecption(Recption recption) throws BLException{
		
		return recptionDAO.save(recption);
	}

	/**
	 * ɾ������
	 * 
	 * @param rid �Ӵ�ID
	 * @return
	 */
	public void deleteRecption(Integer rid) throws BLException{
		
		Recption recption = checkExistRecption(rid);
		
		recptionDAO.delete(recption);
	}

	/**
	 * �������
	 * 
	 * @param recption �������
	 * @return �Ӵ���Ϣ
	 */
	public Recption updateRecption(Recption recption) throws BLException{
		
		checkExistRecption(recption.getRid());
		return recptionDAO.save(recption);
	}

	/**
	 * �Ӵ���Ϣ���ڼ��
	 * 
	 * @param rid �Ӵ�ID
	 * @return �Ӵ���Ϣ
	 * @throws BLException 
	 */
	protected Recption checkExistRecption(Integer rid) throws BLException{
		Recption info = recptionDAO.findByPK(rid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�Ӵ�����");
		}
		return info;
	}

	
	
     public int getSearchGuestInfoCount(RecptionGuestInfoCond cond){
		
		return recptionguestinfoDAO.getSearchCount(cond);
	}

     /**
 	 * ���ݿͻ��������ͻ���λ��ѯ�Ӵ�������Ϣ
 	 *
 	 * @param cond ��������
 	 * @param start ������¼��ʼ�к�
 	 * @param count ������¼����
 	 * @return �Ӵ�������Ϣ
 	 */
 	public List<GuestRecption> searchRecptionByGuset(RecptionGuestInfoCond cond, int start, int count){
 		
 		return recptionDAO.findByGuestInfoCond(cond,start,count);
 	}

 	/**
	 * ���ݿͻ��������ͻ���λ��ѯ�������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getRecptionSearchCount(RecptionGuestInfoCond cond){
		
		return recptionDAO.getRecptionSearchCount(cond);
	}

	public void setRecptionAmountDAO(RecptionAmountDAO recptionAmountDAO) {
		this.recptionAmountDAO = recptionAmountDAO;
	}

}
