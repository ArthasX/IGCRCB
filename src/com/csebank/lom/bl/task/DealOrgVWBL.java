/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.condition.DealOrgVWSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ģ�飺���ڹ���=����Ͳ͹���
 * ˵������������Ͳͻ���ҵ���߼��ӿ�
 * ���ߣ�������
 */
public interface DealOrgVWBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DealOrg> searchDealOrgVW(DealOrgVWSearchCond cond, int start, int count);
	

}
