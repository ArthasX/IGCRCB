/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG715DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;

/**
 * 
 * ���񹤵���������ҵ���߼�ʵ��
 *
 */
public class IG715BLImpl extends BaseBLImpl implements IG715BL {
	
	protected IG715DAO ig715DAO;
	
	public void setIg715DAO (IG715DAO ig715DAO) {
		this.ig715DAO = ig715DAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG715SearchCond cond){
		
		return ig715DAO.getSearchCount(cond);
		
	}

	/**
	 * ������������
	 * 
	 * @param sfid ���񹤵���������ID
	 * @return ���񹤵�
	 */
	public IG715Info searchIG715InfoByKey(Integer sfid) throws BLException{
		
		return checkExistServiceProcessRecordRelation(sfid);
		
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��������񹤵���������
	 */
	public List<IG715Info> searchIG715InfoAll(){
		
		return ig715DAO.findAll();
		
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG715Info> searchIG715Info(IG715SearchCond cond, int start, int count){
		
		return ig715DAO.findByCond(cond, start, count);
		
	}

	/**
	 * ���洦��
	 * 
	 * @param ServiceProcessRecordRelation ���񹤵���������
	 * @return ���񹤵���������
	 */
	public IG715Info registIG715Info(IG715Info ServiceProcessRecordRelation) throws BLException{

		return ig715DAO.save(ServiceProcessRecordRelation);
		
	}


	/**
	 * �������
	 * 
	 * @param ServiceProcessRecordRelation �������
	 * @return ���񹤵�
	 */
	public IG715Info updateIG715Info(IG715Info ServiceProcessRecordRelation) throws BLException{

		return ig715DAO.save(ServiceProcessRecordRelation);
		
	}

	/**
	 * ���񹤵��������̴��ڼ��
	 * 
	 * @param sfid ���񹤵�ID
	 * @return ���񹤵���������
	 * @throws BLException 
	 */
	protected IG715Info checkExistServiceProcessRecordRelation(Integer sfid) throws BLException{
		
		IG715Info ig715Info = ig715DAO.findByPK(sfid);
		
		if(ig715Info == null) {
			
			throw new BLException("IGCO10000.E004","���񹤵�����");
			
		}
		
		return ig715Info;
	}


	/**
	 * ��ȡʵ�����
	 * @return ʵ�����
	 */
	public IG715TB getIG715TBInstance() {

		return ig715DAO.getIG715TBInstance();
		
	}
}
