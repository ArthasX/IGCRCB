/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EworkingLunch;
import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.csebank.lom.model.dao.EworkingLunchDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ʳ�ù�������Ϣҵ���߼��ӿ�ʵ��
 */
public class EworkingLunchBLImpl extends BaseBLImpl implements EworkingLunchBL {
	
	/** EworkingLunch DAO */
	protected EworkingLunchDAO eworkingLunchDAO;
	
	public void setEworkingLunchDAO(
			EworkingLunchDAO eworkingLunchDAO) {
		this.eworkingLunchDAO = eworkingLunchDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(EworkingLunchSearchCond cond){
		
		return eworkingLunchDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param eid ʳ�óɱ�ID
	 * @return ʳ�ù�����ID
	 */
	public EworkingLunch searchEworkingLunchByKey(Integer ewlid) throws BLException{
		EworkingLunch ret = eworkingLunchDAO.findByPK(ewlid);
		return ret;
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ʳ�ù�������Ϣ
	 */
	public List<EworkingLunch> searchEworkingLunchAll(){
		
		return eworkingLunchDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EworkingLunch> searchEworkingLunch(EworkingLunchSearchCond cond, int start, int count){
		
		return eworkingLunchDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param eatery ��¼����
	 * @return ʳ�ù�������Ϣ
	 */
	public EworkingLunch registEworkingLunch(EworkingLunch EworkingLunch) throws BLException{
		
		return eworkingLunchDAO.save(EworkingLunch);
	}

	/**
	 * �������
	 * 
	 * @param eatery �������
	 * @return ʳ�óɱ���Ϣ
	 */
	public EworkingLunch updateEworkingLunch(EworkingLunch EworkingLunch) throws BLException{
		
		checkExistEworkingLunch(EworkingLunch.getEwlid());
		return eworkingLunchDAO.save(EworkingLunch);
	}

	/**
	 * ʳ�ù�������Ϣ���ڼ��
	 * 
	 * @param ewlid ʳ�ù�����ID
	 * @return ʳ�ù�������Ϣ
	 * @throws BLException 
	 */
	protected EworkingLunch checkExistEworkingLunch(Integer ewlid) throws BLException{
		EworkingLunch info = eworkingLunchDAO.findByPK(ewlid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ʳ�ù�����");
		}
		return info;
	}

}
