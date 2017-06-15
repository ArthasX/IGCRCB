package com.deliverik.infogovernor.sta.bl.task;
/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;
import com.deliverik.infogovernor.sta.model.condition.ProcessRecordSummarySearchCond;
import com.deliverik.infogovernor.sta.model.dao.ProcessRecordSummaryVWDAO;

/**
 * <p>
 * �������ͳ��ҵ���߼�ʵ��
 * </p>
 */

public class ProcessRecordSummaryVWBLImpl  extends BaseBLImpl implements ProcessRecordSummaryVWBL{
	
	/**
	 * ע��ProcessRecordSummaryVWDAO
	 */
	
	protected ProcessRecordSummaryVWDAO processRecordSummaryVWDAO;
	
	/**
	 * ����processRecordSummaryVWDAO
	 * 
	 * @param processRecordSummaryVWDAO
	 *            processRecordSummaryVWDAO
	 */
	public void setProcessRecordSummaryVWDAO(
			ProcessRecordSummaryVWDAO processRecordSummaryVWDAO) {
		this.processRecordSummaryVWDAO = processRecordSummaryVWDAO;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessRecordSummary> searchServiceProcessRecordRelation(ProcessRecordSummarySearchCond cond, int start, int count){
		
		return processRecordSummaryVWDAO.findByCond(cond, start, count);
		
	}

}
