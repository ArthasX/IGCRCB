/*
 * ���������ƹɷ����޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;
import com.deliverik.infogovernor.crc.model.condition.EventAndProblemVWSearchCond;

public interface EventAndProblemVWDAO {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EventAndProblemVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EventAndProblemVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EventAndProblemVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EventAndProblemVWInfo> findByCond(
			final EventAndProblemVWSearchCond cond, final int start,
			final int count);
}
