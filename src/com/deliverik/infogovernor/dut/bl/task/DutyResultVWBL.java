/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyResultVWSearchCond;

/**
 * 
 * ֵ���ձ�ҵ���߼��ӿ�
 *
 */
public interface DutyResultVWBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyResultVWSearchCond cond);
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������
	 */
	public List<DutyResultVWInfo> searchDutyResultVWAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyResultVWInfo> searchDutyResultVW(DutyResultVWSearchCond cond, int start, int count);

	

}
