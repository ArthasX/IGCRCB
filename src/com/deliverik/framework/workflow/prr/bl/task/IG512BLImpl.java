/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG512DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * ���̹�ϵҵ���߼�ʵ��
 * 
 */
public class IG512BLImpl extends BaseBLImpl implements IG512BL{
	
	/** �Ƚ�����������ʱ��*/
	protected static final ProcessRecordRelationComparator processRecordRelationComparator = new ProcessRecordRelationComparator();
	
	
	/** Ig512 DAO */
	protected IG512DAO ig512DAO;
	
	public void setIg512DAO(
			IG512DAO ig512DAO) {
		this.ig512DAO = ig512DAO;
	}
	
	/**
	 * ��ȡ���̹�ϵʵ��
	 * @return Ig512TB
	 */
	public IG512TB getIG512TBInstance(){
		return new IG512TB();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG512SearchCond cond){
		
		return ig512DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param prrid ���̹�ϵID
	 * @return ���̹�ϵ
	 */
	public IG512Info searchIG512InfoByKey(Integer prrid) throws BLException{
		
		return checkExistProcessRecordRelation(prrid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����̹�ϵ��Ϣ
	 */
	public List<IG512Info> searchIG512InfoAll(){
		
		return ig512DAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG512Info> searchIG512Info(IG512SearchCond cond, int start, int count){
		
		return ig512DAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param ig512Info ��¼����
	 * @return ���̹�ϵ
	 */
	public IG512Info registIG512Info(IG512Info ig512Info) throws BLException{
		
		return ig512DAO.save(ig512Info);
	}

	/**
	 * ɾ������
	 * 
	 * @param prrid ���̹�ϵID
	 * @return
	 */
	public void deleteIG512Info(Integer prrid) throws BLException{
		
		IG512Info processRecordRelation = checkExistProcessRecordRelation(prrid);
		
		ig512DAO.delete(processRecordRelation);
	}

	/**
	 * �������
	 * 
	 * @param ig512Info �������
	 * @return ���̹�ϵ
	 */
	public IG512Info updateIG512Info(IG512Info ig512Info) throws BLException{
		
		checkExistProcessRecordRelation(ig512Info.getPrrid());
		return ig512DAO.save(ig512Info);
	}

	/**
	 * ���̹�ϵ���ڼ��
	 * 
	 * @param prrid ���̹�ϵID
	 * @return ���̹�ϵ
	 * @throws BLException 
	 */
	protected IG512Info checkExistProcessRecordRelation(Integer prrid) throws BLException{
		IG512Info info = ig512DAO.findByPK(prrid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���̹�ϵ����");
		}
		return info;
	}
	
	/**
	 * ���̹�ϵ������ʱ����������
	 * 
	 * @param ig512InfoList ���̹�ϵ�б�
	 * 
	 */
	public void orderByTimeAsc(List<IG512Info> ig512InfoList) {
		if(ig512InfoList != null && ig512InfoList.size() > 0) {
			Collections.sort(ig512InfoList, processRecordRelationComparator);
		}
	}
	
}

	/**
	 * �Ƚ�����������ʱ�䣨����
	 * 
	 * */
	class ProcessRecordRelationComparator implements Comparator<IG512Info> {
	
		public int compare(IG512Info arg0, IG512Info arg1) {
			int flag = arg0.getPrrid().compareTo(arg1.getPrrid());
			return flag;
		}
	
	}
