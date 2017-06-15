/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.model.SOC0126Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCond;

/**
 * ����: �ʲ�����ϸ��ҵ���߼��ӿ�
 * ��������: �ʲ�����ϸ��ҵ���߼��ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface SOC0126BL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0126SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0126Info> searchEiDomainDetailVW(
			SOC0126SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0138Info> searchEiDomainDetailVW(
			SOC0126SearchCond cond, int start,
			int count);
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0126Info> searchEiDomainDetailAllVW(
			SOC0126SearchCond cond, int start,
			int count);
	
	/**
	 * ����Ӱ��CI��ѯ����
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(
			SOC0126SearchCond eiDomainDetailVWSearchCond,Integer eiid);

	/**
	 * ����Ӱ��CI��ѯ
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @return
	 */
	public List<SOC0136Info> searchEiDomainDetailVWCI(
			SOC0126SearchCond eiDomainDetailVWSearchCond,
			int fromCount, int pageDispCount,Integer eiid);

	/**
	 * ����Ӳ�̼�����������
	 * @param eiDomainDetailVWSearchCond
	 * @param eiid
	 * @return
	 */
	public int getSearchCountCIByDisk(
			SOC0126SearchCond eiDomainDetailVWSearchCond,
			Integer eiid);

	/**
	 * ����Ӳ�̼���������Ϣ
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @param eiid
	 * @return
	 */
	public List<SOC0136Info> searchEiDomainDetailVWCIByDisk(
			SOC0126SearchCond eiDomainDetailVWSearchCond,
			int fromCount, int pageDispCount, Integer eiid);

}
