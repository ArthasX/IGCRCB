/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG933SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG933DAO;

/**
 * 
 * ���񹤵�ҵ���߼��ӿ�
 *
 */
public class IG933BLImpl extends BaseBLImpl implements IG933BL {
	
	protected IG933DAO ig933DAO;
	
	public void setIg933DAO(IG933DAO ig933DAO) {
		this.ig933DAO = ig933DAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG933SearchCond cond){
		
		return ig933DAO.getSearchCount(cond);
		
	}

	/**
	 * ������������
	 * 
	 * @param sfid ���񹤵�ID
	 * @return ���񹤵�
	 */
	public IG933Info searchIG933InfoByKey(Integer sfid) throws BLException{
		
		return checkExistServiceForm(sfid);
		
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����񹤵���Ϣ
	 */
	public List<IG933Info> searchIG933InfoAll(){
		
		return ig933DAO.findAll();
		
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����񹤵���Ϣʱ������
	 */
	public List<IG933Info> searchIG933InfoAllAsc(){
		
		return ig933DAO.findAllAsc();
		
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG933Info> searchIG933Info(IG933SearchCond cond, int start, int count){
		
		return ig933DAO.findByCond(cond, start, count);
		
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�ʱ������
	 */
	public List<IG933Info> searchIG933InfoAsc(IG933SearchCond cond, int start, int count){
		
		return ig933DAO.findByCondAsc(cond, start, count);
		
	}
	
	/**
	 * �ǼǴ���
	 * 
	 * @param ig933Info ����
	 * @return ���񹤵�
	 */
	public IG933Info registIG933Info(IG933Info ig933Info) throws BLException{

		return ig933DAO.save(ig933Info);
		
	}


	/**
	 * �������
	 * 
	 * @param ig933Info �������
	 * @return ���񹤵�
	 */
	public IG933Info updateIG933Info(IG933Info ig933Info) throws BLException{

		return ig933DAO.save(ig933Info);
		
	}

	/**
	 * ���񹤵����ڼ��
	 * 
	 * @param sfid ���񹤵�ID
	 * @return ���񹤵�
	 * @throws BLException 
	 */
	protected IG933Info checkExistServiceForm(Integer sfid) throws BLException{
		
		IG933Info serviceForm = ig933DAO.findByPK(sfid);
		
		if(serviceForm == null) {
			
			throw new BLException("IGCO10000.E004","���񹤵�����");
			
		}
		
		return serviceForm;
	}

	 /**
	 * ��ȡ���񹤵�������ֵ
	 * 
	 * @param code ���񹤵���������
	 * @return ���񹤵�������ֵ
	 */
	public String searchMaxID(String code) {
		
		String maxid = ig933DAO.searchMaxID(code);

		return maxid;
	}
}
