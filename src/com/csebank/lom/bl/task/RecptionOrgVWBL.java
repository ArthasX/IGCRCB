/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.model.condition.RecptionOrgVWSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ���ŽӴ�����ҵ���߼��ӿ�
 */
public interface RecptionOrgVWBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionOrg> searchRecptionOrgVW(RecptionOrgVWSearchCond cond, int start, int count);
	

}
