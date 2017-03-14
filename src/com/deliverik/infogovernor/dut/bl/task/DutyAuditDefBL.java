/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;


/**
 * ֵ�������ҵ���߼��ӿ�
 */
public interface DutyAuditDefBL extends BaseBL{

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyAuditDefSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param dadid �����ID
	 * @return �����ID
	 */
	public DutyAuditDef searchDutyAuditDefByKey(Integer dadid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������Ϣ
	 */
	public List<DutyAuditDef> searchDutyAuditDefAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyAuditDef> searchDutyAuditDef(DutyAuditDefSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param DutyAuditDef ��¼����
	 * @return ֵ��������Ϣ
	 */
	public DutyAuditDef registDutyAuditDef(DutyAuditDef auditCheckRelation) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param dadid �����ID
	 * @throws BLException
	 */
	public void deleteDutyAuditDef(Integer dadid) throws BLException;

	/**
	 * �������
	 * 
	 * @param auditCheckRelation �������
	 * @return ֵ��������Ϣ
	 */
	public DutyAuditDef updateDutyAuditDef(DutyAuditDef auditCheckRelation) throws BLException;

}
