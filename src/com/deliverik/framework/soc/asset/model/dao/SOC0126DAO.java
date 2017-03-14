/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.model.SOC0126Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCond;

/**
 * ����: �ʲ�����ϸ��DAO�ӿ�
 * ��������: �ʲ�����ϸ��DAO�ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface SOC0126DAO {
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0126SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0126Info> findByCond(
			final SOC0126SearchCond cond, final int start,
			final int count);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0138Info> findBySQL(final SOC0126SearchCond cond, final int start, final int count);

	/**
	 * ����Ӱ��CI��ѯ����
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(SOC0126SearchCond cond,Integer eiid);

	/**
	 * ����Ӱ��CI��ѯ
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @return
	 */
	public List<SOC0136Info> findBySQLCI(
			SOC0126SearchCond cond, int start, int count,Integer eiid);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0126Info> findAllBySQL(final SOC0126SearchCond cond, final int start, final int count);

	/**
	 * ����Ӳ�̼�����������
	 * @param eiDomainDetailVWSearchCond
	 * @param eiid
	 * @return
	 */
	public int getSearchCountCIByDisk(final SOC0126SearchCond cond,
			final Integer eiid);

	/**
	 * ����Ӳ�̼���������Ϣ
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @param eiid
	 * @return
	 */
	public List<SOC0136Info> searchEiDomainDetailVWCIByDisk(
			final SOC0126SearchCond cond,final int start,final int count,
			final Integer eiid);

}
