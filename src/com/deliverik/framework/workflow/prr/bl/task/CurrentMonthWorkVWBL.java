/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCond;

/**
 * ����:��ѯ���д����˵ı��¹��� 
 * ������������ѯ���д����˵ı��¹���
 * �����ˣ�����͢
 * ������¼�� 2013-04-22
 * �޸ļ�¼��
 */
public interface CurrentMonthWorkVWBL extends BaseBL {

	/**
	 * ���¹��������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCurrentMonthWorkCount(final CurrentMonthWorkVWSearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CurrentMonthWorkVWInfo> findCurrentMonthWorkByCond(
			final CurrentMonthWorkVWSearchCond cond, final int start,
			final int count);
}
