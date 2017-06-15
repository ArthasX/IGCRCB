/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.model.SOC0126Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0126DAO;

/**
 * ����: �ʲ�����ϸ��ҵ���߼�ʵ��
 * ��������: �ʲ�����ϸ��ҵ���߼�ʵ��
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class SOC0126BLImpl extends BaseBLImpl implements
SOC0126BL {
	
	/** �ʲ�����ϸ��DAO�ӿ� */
	protected SOC0126DAO soc0126DAO;
	
	

	/**
	 * �ʲ�����ϸ��DAO�ӿ��趨
	 *
	 * @param soc0126DAO �ʲ�����ϸ��DAO�ӿ�
	 */
	public void setSoc0126DAO(SOC0126DAO soc0126DAO) {
		this.soc0126DAO = soc0126DAO;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0126SearchCond cond) {
		return soc0126DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0126Info> searchEiDomainDetailVW(
			SOC0126SearchCond cond) {
		return soc0126DAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return soc0126DAO.findBySQL(cond, start, count);
	}

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
			int count) {
		return soc0126DAO.findAllBySQL(cond, start, count);
	}

	
	/**
	 * ����Ӱ��CI��ѯ����
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(
			SOC0126SearchCond cond,Integer eiid) {
		return  soc0126DAO.getSearchCountCI(cond,eiid);
	}

	/**
	 * ����Ӱ��CI��ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<SOC0136Info> searchEiDomainDetailVWCI(
			SOC0126SearchCond cond,
			int start, int count,Integer eiid) {
		return soc0126DAO.findBySQLCI(cond, start, count,eiid);
	}

	/**
	 * ����Ӳ�̼�����������
	 * @param eiDomainDetailVWSearchCond
	 * @param eiid
	 * @return
	 */
	public int getSearchCountCIByDisk(
			SOC0126SearchCond cond,
			Integer eiid) {
		return soc0126DAO.getSearchCountCIByDisk(cond,eiid);
	}

	/**
	 * ����Ӳ�̼���������Ϣ
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @param eiid
	 * @return
	 */
	public List<SOC0136Info> searchEiDomainDetailVWCIByDisk(
			SOC0126SearchCond cond,
			int start, int count, Integer eiid) {
		return soc0126DAO.searchEiDomainDetailVWCIByDisk(cond, start, count,eiid);
	}


}
