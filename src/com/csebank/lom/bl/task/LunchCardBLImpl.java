/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.csebank.lom.model.dao.LunchCardDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * �Ϳ���Ϣҵ���߼��ӿ�ʵ��
 */
public class LunchCardBLImpl extends BaseBLImpl implements LunchCardBL {
	
	/** LunchCard DAO */
	protected LunchCardDAO lunchCardDAO;
	
	public void setLunchCardDAO(
			LunchCardDAO lunchCardDAO) {
		this.lunchCardDAO = lunchCardDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(LunchCardSearchCond cond){
		
		return lunchCardDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param typecode �Ϳ�ID
	 * @return �Ϳ�ID
	 */
	public ItemsCodesSt searchLunchCardByKey(Integer icid) throws BLException{
		ItemsCodesSt ret = lunchCardDAO.findByPK(icid);
		return ret;
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���Ϳ���Ϣ
	 */
	public List<ItemsCodesSt> searchLunchCardAll(){
		
		return lunchCardDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ItemsCodesSt> searchLunchCard(LunchCardSearchCond cond, int start, int count){
		
		return lunchCardDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param eatery ��¼����
	 * @return �Ϳ���Ϣ
	 */
	public ItemsCodesSt registLunchCard(ItemsCodesSt lunchCard) throws BLException{
		
		return lunchCardDAO.save(lunchCard);
	}

	/**
	 * �������
	 * 
	 * @param eatery �������
	 * @return �Ϳ���Ϣ
	 */
	public ItemsCodesSt updateLunchCard(ItemsCodesSt lunchCard) throws BLException{
		
		checkExistEatery(lunchCard.getIcid());
		return lunchCardDAO.save(lunchCard);
	}

	/**
	 * �Ϳ���Ϣ���ڼ��
	 * 
	 * @param typecode �Ϳ�ID
	 * @return �Ϳ���Ϣ
	 * @throws BLException 
	 */
	protected ItemsCodesSt checkExistEatery(Integer icid) throws BLException{
		ItemsCodesSt info = lunchCardDAO.findByPK(icid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�Ϳ�");
		}
		return info;
	}

}
