/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;
import com.deliverik.infogovernor.risk.model.condition.AuditCheckRelationSearchCond;

/**
 * 
 * ���ռ���������ƹ�ϵҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public interface AuditCheckRelationBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(AuditCheckRelationSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param acrid ���ռ���������ƹ�ϵID
	 * @return ���ռ���������ƹ�ϵ
	 */
	public AuditCheckRelation searchAuditCheckRelationByKey(Integer acrid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����ռ���������ƹ�ϵ��Ϣ
	 */
	public List<AuditCheckRelation> searchAuditCheckRelationAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditCheckRelation> searchAuditCheckRelation(AuditCheckRelationSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param AuditCheckRelation ��¼����
	 * @return ���ռ���������ƹ�ϵ
	 */
	public AuditCheckRelation registAuditCheckRelation(AuditCheckRelation auditCheckRelation) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param acrid ���ռ���������ƹ�ϵID
	 * @return
	 */
	public void deleteAuditCheckRelation(Integer acrid) throws BLException;

	/**
	 * �������
	 * 
	 * @param auditCheckRelation �������
	 * @return ���ռ���������ƹ�ϵ
	 */
	public AuditCheckRelation updateAuditCheckRelation(AuditCheckRelation auditCheckRelation) throws BLException;

}
