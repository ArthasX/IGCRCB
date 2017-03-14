package com.deliverik.infogovernor.dbm.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;
import com.deliverik.infogovernor.dbm.model.condition.IncidentTendencySearchCond;

public interface IncidentTendencyBL {

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public abstract List<IncidentTendency> findAllIncidentTendency()
			throws BLException;

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public abstract int getSearchCount(IncidentTendencySearchCond cond)
			throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public abstract List<IncidentTendency> findIncidentTendencyByCond(
			IncidentTendencySearchCond cond, int start, int count)
			throws BLException;
}