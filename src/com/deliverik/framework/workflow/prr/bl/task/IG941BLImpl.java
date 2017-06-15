/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG941Info;
import com.deliverik.framework.workflow.prr.model.condition.IG941SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG941DAO;

/**
 * 
 * ���񹤵���־ҵ���߼��ӿ�
 *
 */
public class IG941BLImpl extends BaseBLImpl implements IG941BL {
	
	protected IG941DAO ig941DAO;
	
	public void setIg941DAO(IG941DAO ig941DAO) {
		this.ig941DAO = ig941DAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG941SearchCond cond){
		
		return ig941DAO.getSearchCount(cond);
		
	}

	/**
	 * ������������
	 * 
	 * @param sflid ���񹤵���־ID
	 * @return ���񹤵���־
	 */
	public IG941Info searchIG941InfoByKey(Integer sflid) throws BLException{
		
		return checkExistServiceFormLog(sflid);
		
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����񹤵���־��Ϣ
	 */
	public List<IG941Info> searchIG941InfoAll(){
		
		return ig941DAO.findAll();
		
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG941Info> searchIG941Info(IG941SearchCond cond, int start, int count){
		
		return ig941DAO.findByCond(cond, start, count);
		
	}

	/**
	 * �ǼǴ���
	 * 
	 * @param ig941Info ����
	 * @return ���񹤵���־
	 */
	public IG941Info registIG941Info(IG941Info ig941Info) throws BLException{

		return ig941DAO.save(ig941Info);
		
	}


	/**
	 * �������
	 * 
	 * @param ig941Info �������
	 * @return ���񹤵���־
	 */
	public IG941Info updateIG941Info(IG941Info ig941Info) throws BLException{

		return ig941DAO.save(ig941Info);
		
	}

	/**
	 * ���񹤵���־���ڼ��
	 * 
	 * @param sflid ���񹤵���־ID
	 * @return ���񹤵���־
	 * @throws BLException 
	 */
	protected IG941Info checkExistServiceFormLog(Integer sflid) throws BLException{
		
		IG941Info serviceFormLog = ig941DAO.findByPK(sflid);
		
		if(serviceFormLog == null) {
			
			throw new BLException("IGCO10000.E004","���񹤵���־����");
			
		}
		
		return serviceFormLog;
	}

}
