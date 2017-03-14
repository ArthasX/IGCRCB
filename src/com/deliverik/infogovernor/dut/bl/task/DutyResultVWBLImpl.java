/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyResultVWSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyResultVWDAO;


/**
 * 
 * ֵ���ձ�ҵ���߼��ӿ�
 *
 */
public class DutyResultVWBLImpl extends BaseBLImpl implements DutyResultVWBL{
	
	/** DutyResultVWInfo DAO */
	protected DutyResultVWDAO dutyResultVWDAO;
	
	
	/**
	 * @param dutyResultVWDAO the dutyResultVWDAO to set
	 */
	public void setDutyResultVWDAO(DutyResultVWDAO dutyResultVWDAO) {
		this.dutyResultVWDAO = dutyResultVWDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyResultVWSearchCond cond){
		
		return dutyResultVWDAO.getSearchCount(cond);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������
	 */
	public List<DutyResultVWInfo> searchDutyResultVWAll(){
		
		return dutyResultVWDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyResultVWInfo> searchDutyResultVW(DutyResultVWSearchCond cond, int start, int count){
		
		return dutyResultVWDAO.findByCond(cond,start,count);
	}

	
}
