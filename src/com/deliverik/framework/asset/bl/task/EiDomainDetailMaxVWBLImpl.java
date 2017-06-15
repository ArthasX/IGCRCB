/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;
import com.deliverik.framework.asset.model.dao.EiDomainDetailMaxVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ����: �ʲ�����ϸ��ҵ���߼�ʵ��
 * ��������: �ʲ�����ϸ��ҵ���߼�ʵ��
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class EiDomainDetailMaxVWBLImpl extends BaseBLImpl implements
EiDomainDetailMaxVWBL {
	
	/** �ʲ�����ϸ��DAO�ӿ� */
	protected EiDomainDetailMaxVWDAO eiDomainDetailMaxVWDAO;
	
	
	
	/**
	 * �ʲ�����ϸ��DAO�ӿ��趨
	 * @param eiDomainDetailMaxVWDAO�ʲ�����ϸ��DAO�ӿ�
	 */
	public void seteiDomainDetailMaxVWDAO(EiDomainDetailMaxVWDAO eiDomainDetailMaxVWDAO) {
		this.eiDomainDetailMaxVWDAO = eiDomainDetailMaxVWDAO;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiDomainDetailMaxVWSearchCond cond) {
		return eiDomainDetailMaxVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiDomainDetailMaxVWInfo> searchEiDomainDetailVW(
			EiDomainDetailMaxVWSearchCond cond) {
		return eiDomainDetailMaxVWDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return eiDomainDetailMaxVWDAO.findBySQL(cond, start, count);
	}

	/**
	 * ����Ӱ��CI��ѯ����
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(
			EiDomainDetailMaxVWSearchCond cond) {
		return  eiDomainDetailMaxVWDAO.getSearchCountCI(cond);
	}

	/**
	 * ����Ӱ��CI��ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<EiDomainDetailCIInfo> searchEiDomainDetailVWCI(
			EiDomainDetailMaxVWSearchCond cond,
			int start, int count) {
		return eiDomainDetailMaxVWDAO.findBySQLCI(cond, start, count);
	}


}
