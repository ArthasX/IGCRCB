/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;
import com.deliverik.infogovernor.risk.model.condition.AuditCheckRelationSearchCond;
import com.deliverik.infogovernor.risk.model.dao.AuditCheckRelationDAO;

/**
 * 
 * ���ռ���������ƹ�ϵҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public class AuditCheckRelationBLImpl extends BaseBLImpl implements AuditCheckRelationBL{
	
	/** AuditCheckRelation DAO */
	protected AuditCheckRelationDAO auditCheckRelationDAO;
	
	public void setAuditCheckRelationDAO(
			AuditCheckRelationDAO auditCheckRelationDAO) {
		this.auditCheckRelationDAO = auditCheckRelationDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(AuditCheckRelationSearchCond cond){
		
		return auditCheckRelationDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param acrid ���ռ���������ƹ�ϵID
	 * @return ���ռ���������ƹ�ϵ
	 */
	public AuditCheckRelation searchAuditCheckRelationByKey(Integer acrid) throws BLException{
		
		return checkExistAuditCheckRelation(acrid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����ռ���������ƹ�ϵ��Ϣ
	 */
	public List<AuditCheckRelation> searchAuditCheckRelationAll(){
		
		return auditCheckRelationDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditCheckRelation> searchAuditCheckRelation(AuditCheckRelationSearchCond cond, int start, int count){
		
		return auditCheckRelationDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param auditCheckRelation ��¼����
	 * @return ���ռ���������ƹ�ϵ
	 */
	public AuditCheckRelation registAuditCheckRelation(AuditCheckRelation auditCheckRelation) throws BLException{
		
		return auditCheckRelationDAO.save(auditCheckRelation);
	}

	/**
	 * ɾ������
	 * 
	 * @param acrid ���ռ���������ƹ�ϵID
	 * @return
	 */
	public void deleteAuditCheckRelation(Integer acrid) throws BLException{
		
		AuditCheckRelation auditCheckRelation = checkExistAuditCheckRelation(acrid);
		
		auditCheckRelationDAO.delete(auditCheckRelation);
	}

	/**
	 * �������
	 * 
	 * @param auditCheckRelation �������
	 * @return ���ռ���������ƹ�ϵ
	 */
	public AuditCheckRelation updateAuditCheckRelation(AuditCheckRelation auditCheckRelation) throws BLException{
		
		checkExistAuditCheckRelation(auditCheckRelation.getAcrid());
		return auditCheckRelationDAO.save(auditCheckRelation);
	}

	/**
	 * ���ռ���������ƹ�ϵ���ڼ��
	 * 
	 * @param acrid ���ռ���������ƹ�ϵID
	 * @return ���ռ���������ƹ�ϵ
	 * @throws BLException 
	 */
	protected AuditCheckRelation checkExistAuditCheckRelation(Integer acrid) throws BLException{
		AuditCheckRelation info = auditCheckRelationDAO.findByPK(acrid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���ռ���������ƹ�ϵ����");
		}
		return info;
	}
}
