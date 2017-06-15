/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Eatery;
import com.csebank.lom.model.condition.EaterySearchCond;
import com.csebank.lom.model.dao.EateryDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ʳ�óɱ���Ϣҵ���߼��ӿ�ʵ��
 */
public class EateryBLImpl extends BaseBLImpl implements EateryBL {
	
	/** Eatery DAO */
	protected EateryDAO eateryDAO;
	
	public void setEateryDAO(
			EateryDAO eateryDAO) {
		this.eateryDAO = eateryDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(EaterySearchCond cond){
		
		return eateryDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param eid ʳ�óɱ�ID
	 * @return ʳ�óɱ�ID
	 */
	public Eatery searchEateryByKey(Integer eid) throws BLException{
		Eatery ret = eateryDAO.findByPK(eid);
		return ret;
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ʳ�óɱ���Ϣ
	 */
	public List<Eatery> searchEateryAll(){
		
		return eateryDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Eatery> searchEatery(EaterySearchCond cond, int start, int count){
		
		return eateryDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param eatery ��¼����
	 * @return ʳ�óɱ���Ϣ
	 */
	public Eatery registEatery(Eatery eatery) throws BLException{
		
		return eateryDAO.save(eatery);
	}

	/**
	 * �������
	 * 
	 * @param eatery �������
	 * @return ʳ�óɱ���Ϣ
	 */
	public Eatery updateEatery(Eatery eatery) throws BLException{
		
		checkExistEatery(eatery.getEid());
		return eateryDAO.save(eatery);
	}

	/**
	 * ʳ�óɱ���Ϣ���ڼ��
	 * 
	 * @param eid ʳ�óɱ�ID
	 * @return ʳ�óɱ���Ϣ
	 * @throws BLException 
	 */
	protected Eatery checkExistEatery(Integer eid) throws BLException{
		Eatery info = eateryDAO.findByPK(eid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ʳ�óɱ�");
		}
		return info;
	}

}
