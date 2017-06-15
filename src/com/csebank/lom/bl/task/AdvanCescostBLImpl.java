/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.csebank.lom.model.dao.AdvanCescostDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * Ԥ֧����ҵ���߼��ӿ�ʵ��
 */
public class AdvanCescostBLImpl extends BaseBLImpl implements AdvanCescostBL {
	
	/** AdvanCescost DAO */
	protected AdvanCescostDAO advanCescostDAO;
	
	public void setAdvanCescostDAO(
			AdvanCescostDAO advanCescostDAO) {
		this.advanCescostDAO = advanCescostDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(AdvanCescostSearchCond cond){
		
		return advanCescostDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param acid Ԥ֧����ID
	 * @return Ԥ֧����ID
	 */
	public AdvanCescost searchAdvanCescostByKey(Integer acid) throws BLException{
		
		return checkExistAdvanCescost(acid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��Ԥ֧������Ϣ
	 */
	public List<AdvanCescost> searchAdvanCescostAll(){
		
		return advanCescostDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AdvanCescost> searchAdvanCescost(AdvanCescostSearchCond cond, int start, int count){
		
		return advanCescostDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param advanCescost ��¼����
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanCescost registAdvanCescost(AdvanCescost advanCescost) throws BLException{
		
		return advanCescostDAO.save(advanCescost);
	}

	/**
	 * ɾ������
	 * 
	 * @param acid Ԥ֧����ID
	 * @return
	 */
	public void deleteAdvanCescost(Integer acid) throws BLException{
		
		AdvanCescost advanCescost = checkExistAdvanCescost(acid);
		
		advanCescostDAO.delete(advanCescost);
	}

	/**
	 * �������
	 * 
	 * @param advanCescost �������
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanCescost updateAdvanCescost(AdvanCescost advanCescost) throws BLException{
		
		checkExistAdvanCescost(advanCescost.getAcid());
		return advanCescostDAO.save(advanCescost);
	}

	/**
	 * Ԥ֧������Ϣ���ڼ��
	 * 
	 * @param acid Ԥ֧����ID
	 * @return Ԥ֧������Ϣ
	 * @throws BLException 
	 */
	protected AdvanCescost checkExistAdvanCescost(Integer acid) throws BLException{
		AdvanCescost info = advanCescostDAO.findByPK(acid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","Ԥ֧���û���");
		}
		return info;
	}

}
