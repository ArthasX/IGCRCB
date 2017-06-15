/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.condition.DealSearchCond;
import com.csebank.lom.model.dao.DealDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * �Ӵ�����ҵ���߼��ӿ�ʵ��
 */
public class DealBLImpl extends BaseBLImpl implements DealBL {
	
	/** Recption DAO */
	protected DealDAO dealDAO;
	//protected RecptionGuestInfoDAO recptionguestinfoDAO;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Deal> searchDeal(DealSearchCond cond, int start, int count){
		
		return dealDAO.findByCond(cond,start,count);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���Ӵ���Ϣ
	 */
	public List<Deal> searchDealAll(){
		
		return dealDAO.findAll();
	}
    
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DealSearchCond cond){
		
		return dealDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rid �Ӵ�ID
	 * @return �Ӵ�ID
	 */
	public Deal searchDealByKey(Integer rid) throws BLException{
		
		return checkExistDeal(rid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���Ӵ���Ϣ
	 */
	public List<Deal> searchRecptionAll(){
		
		return dealDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Deal> searchRecption(DealSearchCond cond, int start, int count){
		
		return dealDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * �����¼save������Ҳ��װ����
	 * @param recption ��¼����
	 * @return �Ӵ���Ϣ
	 */
	public Deal insertDealInfo(Deal recption) throws BLException{
		
		return dealDAO.save(recption);
	}

	/**
	 * ɾ������
	 * 
	 * @param rid �Ӵ�ID
	 * @return
	 */
	public void deleteDeal(Integer rid) throws BLException{
		
		Deal deal = checkExistDeal(rid);
		
		dealDAO.delete(deal);
	}

	/**
	 * �������
	 * 
	 * @param recption �������
	 * @return �Ӵ���Ϣ
	 */
	public Deal updateDeal(Deal deal) throws BLException{
		
		checkExistDeal(deal.getRid());
		return dealDAO.save(deal);
	}

	/**
	 * �Ӵ���Ϣ���ڼ��
	 * 
	 * @param rid �Ӵ�ID
	 * @return �Ӵ���Ϣ
	 * @throws BLException 
	 */
	protected Deal checkExistDeal(Integer rid) throws BLException{
		Deal info = dealDAO.findByPK(rid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����Ͳͻ���");
		}
		return info;
	}

	


	public void setDealDAO(DealDAO dealDAO) {
		this.dealDAO = dealDAO;
	}

}
