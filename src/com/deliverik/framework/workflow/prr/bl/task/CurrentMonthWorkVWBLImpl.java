/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCond;
import com.deliverik.framework.workflow.prr.model.dao.CurrentMonthWorkVWDAO;

/**
 * ����:��ѯ���д����˵ı��¹��� 
 * ������������ѯ���д����˵ı��¹���
 * �����ˣ�����͢
 * ������¼�� 2013-04-22
 * �޸ļ�¼��
 */
public class CurrentMonthWorkVWBLImpl extends BaseBLImpl implements
		CurrentMonthWorkVWBL {

	/** ��ѯ���е�ǰ�����˵ı��¹���DAO�ӿ� */
	protected CurrentMonthWorkVWDAO  currentMonthWorkVWDAO;
	
	/**
	 * ��ѯ���е�ǰ�����˵ı��¹���DAO�ӿ��趨
	 *
	 * @param currentMonthWorkVWDAO ��ѯ���е�ǰ�����˵ı��¹���DAO�ӿ�
	 */
	public void setCurrentMonthWorkVWDAO(CurrentMonthWorkVWDAO currentMonthWorkVWDAO) {
		this.currentMonthWorkVWDAO = currentMonthWorkVWDAO;
	}

	/**
	 * ���¹��������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCurrentMonthWorkCount(CurrentMonthWorkVWSearchCond cond) {
		
		return currentMonthWorkVWDAO.getSearchCurrentMonthWorkCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CurrentMonthWorkVWInfo> findCurrentMonthWorkByCond(
			CurrentMonthWorkVWSearchCond cond, int start, int count) {
		
		return currentMonthWorkVWDAO.findCurrentMonthWorkByCond(cond, start, count);
	}

}
