/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;

/**
 * ����: �ʲ�����ϸ��DAO�ӿ�
 * ��������: �ʲ�����ϸ��DAO�ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface EiDomainDetailMaxVWDAO {
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiDomainDetailMaxVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiDomainDetailMaxVWInfo> findByCond(
			final EiDomainDetailMaxVWSearchCond cond, final int start,
			final int count);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiDomainDetailMaxVWInfo> findBySQL(final EiDomainDetailMaxVWSearchCond cond, final int start, final int count);

	/**
	 * ����Ӱ��CI��ѯ����
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(EiDomainDetailMaxVWSearchCond cond);

	/**
	 * ����Ӱ��CI��ѯ
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @return
	 */
	public List<EiDomainDetailCIInfo> findBySQLCI(
			EiDomainDetailMaxVWSearchCond cond, int start, int count);

}
