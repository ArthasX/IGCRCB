/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.condition.DealVWSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * �Ӵ�����ҵ���߼��ӿ�
 */
public interface DealVWBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DealVWInfo> searchDealVW(DealVWSearchCond cond, int start, int count);
	
	
}
