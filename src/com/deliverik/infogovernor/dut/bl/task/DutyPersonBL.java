/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCond;


/**
 * ֵ�������ҵ���߼��ӿ�
 */
public interface DutyPersonBL extends BaseBL{

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyPersonSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param dpid �����ID
	 * @return �����ID
	 */
	public DutyPerson searchDutyPersonByKey(Integer dperid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������Ϣ
	 */
	public List<DutyPerson> searchDutyPersonAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyPerson> searchDutyPerson(DutyPersonSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param DutyAuditDef ��¼����
	 * @return ֵ��������Ϣ
	 */
	public DutyPerson registDutyPerson(DutyPerson auditCheckRelation) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param dadid �����ID
	 * @throws BLException
	 */
	public void deleteDutyPerson(Integer dperid) throws BLException;

	/**
	 * �������
	 * 
	 * @param auditCheckRelation �������
	 * @return ֵ��������Ϣ
	 */
	public DutyPerson updateDutyPerson(DutyPerson auditCheckRelation) throws BLException;

}
