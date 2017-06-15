/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCond;
/**
 * 
 * ֵ��������ʱ��ҵ���߼��ӿ�
 *
 */
public interface DutyAuditTimeBL  extends BaseBL{

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyAuditTimeSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param dadid �����ID
	 * @return �����ID
	 */
	public DutyAuditTime searchDutyAuditTimeByKey(Integer datid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������Ϣ
	 */
	public List<DutyAuditTime> searchDutyAuditTimeAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyAuditTime> searchDutyAuditTime(DutyAuditTimeSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param DutyAuditDef ��¼����
	 * @return ֵ��������Ϣ
	 */
	public DutyAuditTime registDutyAuditTime(DutyAuditTime auditCheckRelation) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param dadid �����ID
	 * @throws BLException
	 */
	public void deleteDutyAuditTime(Integer datid) throws BLException;

	/**
	 * �������
	 * 
	 * @param auditCheckRelation �������
	 * @return ֵ��������Ϣ
	 */
	public DutyAuditTime updateDutyAuditTime(DutyAuditTime auditCheckRelation) throws BLException;
}
