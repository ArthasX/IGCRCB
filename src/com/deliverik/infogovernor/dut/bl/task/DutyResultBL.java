/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;

/**
 * 
 * ֵ��������ҵ���߼��ӿ�
 *
 */
public interface DutyResultBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyResultSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param drid ֵ��������ID
	 * @return ֵ��������
	 */
	public DutyResult searchDutyResultByKey(Integer drid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������
	 */
	public List<DutyResult> searchDutyResultAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyResult> searchDutyResult(DutyResultSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param DutyResult ��¼����
	 * @return ֵ��������
	 */
	public DutyResult registDutyResult(DutyResult riskCheck) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param drid ֵ��������ID
	 * @return
	 */
	public void deleteDutyResult(Integer drid) throws BLException;

	/**
	 * �������
	 * 
	 * @param riskCheck �������
	 * @return ֵ��������
	 */
	public DutyResult updateDutyResult(DutyResult riskCheck) throws BLException;

}
