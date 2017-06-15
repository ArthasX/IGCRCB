/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * ����: �ʲ�����ϸ��ҵ���߼��ӿ�
 * ��������: �ʲ�����ϸ��ҵ���߼��ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface EiDomainDetailMaxVWBL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiDomainDetailMaxVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiDomainDetailMaxVWInfo> searchEiDomainDetailVW(
			EiDomainDetailMaxVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<EiDomainDetailMaxVWInfo> searchEiDomainDetailVW(
			EiDomainDetailMaxVWSearchCond cond, int start,
			int count);
	/**
	 * ����Ӱ��CI��ѯ����
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(
			EiDomainDetailMaxVWSearchCond eiDomainDetailVWSearchCond);

	/**
	 * ����Ӱ��CI��ѯ
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @return
	 */
	public List<EiDomainDetailCIInfo> searchEiDomainDetailVWCI(
			EiDomainDetailMaxVWSearchCond eiDomainDetailVWSearchCond,
			int fromCount, int pageDispCount);

}
