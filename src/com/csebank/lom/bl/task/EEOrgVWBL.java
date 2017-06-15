/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EEOrgVWSearchCond;
import com.csebank.lom.model.condition.EESearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ���д����Ż���ҵ���߼��ӿ�
 * ���ߣ�������
 */
public interface EEOrgVWBL extends BaseBL {
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EEOrg> searchEEOrgVW(EEOrgVWSearchCond cond, int start, int count);
	/**
	 * ʳ���д����Ż�����ϸ��ѯ
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Eentertainment> searchEEOrgVWDetail(EESearchCond cond, int start, int count);

}
