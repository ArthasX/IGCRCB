/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.bl.task;

/**
 * <p>
 * �������ͳ��ҵ���߼��ӿ�
 * </p>
 */
import java.util.List;

import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;
import com.deliverik.infogovernor.sta.model.condition.ProcessRecordSummarySearchCond;

public interface ProcessRecordSummaryVWBL {
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessRecordSummary> searchServiceProcessRecordRelation(ProcessRecordSummarySearchCond cond, int start, int count);
}
