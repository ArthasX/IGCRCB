/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * �����ͳɱ�ͳ��ҵ���߼��ӿ�
 */
public interface WorkLunchEateryBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkLunchEatery> searchWorkLunchEatery(WorkLunchEaterySearchCond cond, int start, int count);

}
