/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.csebank.lom.model.dao.EentertainmentDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ʳ�ýӴ���Ϣҵ���߼��ӿ�ʵ��
 */
public class EentertainmentBLImpl extends BaseBLImpl implements EentertainmentBL {
	
	/** Eentertainment DAO */
	protected EentertainmentDAO eentertainmentDAO;
	
	public void setEentertainmentDAO(
			EentertainmentDAO eentertainmentDAO) {
		this.eentertainmentDAO = eentertainmentDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(EentertainmentSearchCond cond){
		
		return eentertainmentDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param eeid ʳ�ýӴ�ID
	 * @return ʳ�ýӴ�ID
	 */
	public Eentertainment searchEentertainmentByKey(Integer eeid) throws BLException{
		Eentertainment ret = eentertainmentDAO.findByPK(eeid);
		return ret;
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ʳ�ýӴ���Ϣ
	 */
	public List<Eentertainment> searchEentertainmentAll(){
		
		return eentertainmentDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Eentertainment> searchEentertainment(EentertainmentSearchCond cond, int start, int count){
		
		return eentertainmentDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param eentertainment ��¼����
	 * @return ʳ�ýӴ���Ϣ
	 */
	public Eentertainment registEentertainment(Eentertainment eentertainment) throws BLException{
		
		return eentertainmentDAO.save(eentertainment);
	}

	/**
	 * �������
	 * 
	 * @param eentertainment �������
	 * @return ʳ�ýӴ���Ϣ
	 */
	public Eentertainment updateEentertainment(Eentertainment eentertainment) throws BLException{
		
		checkExistEentertainment(eentertainment.getEeid());
		return eentertainmentDAO.save(eentertainment);
	}

	/**
	 * ʳ�ýӴ���Ϣ���ڼ��
	 * 
	 * @param eeid ʳ�ýӴ�ID
	 * @return ʳ�ýӴ���Ϣ
	 * @throws BLException 
	 */
	protected Eentertainment checkExistEentertainment(Integer eeid) throws BLException{
		Eentertainment info = eentertainmentDAO.findByPK(eeid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ʳ�ýӴ�");
		}
		return info;
	}
	
	/**
	 * ʳ�ýӴ���Ϣɾ��
	 * 
	 * @param eeid ʳ�ýӴ�ID
	 * @return ʳ�ýӴ���Ϣ
	 * @throws BLException 
	 */
	
	public void deleteEentertainment(Integer eeid) throws BLException {
		Eentertainment eentertainment = checkExistEentertainment(eeid);
		eentertainmentDAO.delete(eentertainment);
	}

}
