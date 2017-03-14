package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;
import com.deliverik.infogovernor.dbm.model.condition.ChangeTendencySearchCond;

public interface ChangeTendencyBL {

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public abstract List<ChangeTendency> findAllChangeTendency()
			throws BLException;

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public abstract int getSearchCount(ChangeTendencySearchCond cond)
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
	public abstract List<ChangeTendency> findChangeTendencyByCond(
			ChangeTendencySearchCond cond, int start, int count)
			throws BLException;

}