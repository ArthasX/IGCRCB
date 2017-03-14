/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;


/**
 * ֵ�������ҵ���߼��ӿ�
 */
public interface DutyPlanBL extends BaseBL{

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyPlanSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param dpid �����ID
	 * @return �����ID
	 */
	public DutyPlan searchDutyPlanByKey(Integer dpid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������Ϣ
	 */
	public List<DutyPlan> searchDutyPlanAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyPlan> searchDutyPlan(DutyPlanSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param DutyAuditDef ��¼����
	 * @return ֵ��������Ϣ
	 */
	public DutyPlan registDutyPlan(DutyPlan auditCheckRelation) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param dadid �����ID
	 * @throws BLException
	 */
	public void deleteDutyPlan(Integer dpid) throws BLException;

	/**
	 * �������
	 * 
	 * @param auditCheckRelation �������
	 * @return ֵ��������Ϣ
	 */
	public DutyPlan updateDutyPlan(DutyPlan auditCheckRelation) throws BLException;

}
