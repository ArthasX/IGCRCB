/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.condition.RecptionVWSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * �Ӵ�����ҵ���߼��ӿ�
 */
public interface RecptionVWBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionVWInfo> searchRecptionVW(RecptionVWSearchCond cond, int start, int count);
	
	
}
