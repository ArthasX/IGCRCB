/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0125Info;
import com.deliverik.framework.soc.asset.model.dao.SOC0125DAO;

/**
 * ����: ���°�����Ϣ��ͼҵ���߼�ʵ��
 * ��������: ���°�����Ϣ��ͼҵ���߼�ʵ��
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class SOC0125BLImpl extends BaseBLImpl implements SOC0125BL {
	
	/** ���°�����Ϣ��ͼDAO�ӿ� */
	protected SOC0125DAO soc0125DAO;




	/**
	 * ���°�����Ϣ��ͼDAO�ӿ��趨
	 *
	 * @param soc0125DAO ���°�����Ϣ��ͼDAO�ӿ�
	 */
	public void setSoc0125DAO(SOC0125DAO soc0125DAO) {
		this.soc0125DAO = soc0125DAO;
	}


	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0125Info> searchEiDomainDefVW() throws BLException{
		return soc0125DAO.findAll();
		
	}


	/**
	 * ����eiddid��ѯ
	 * @param eiddid
	 * @return
	 */
	public SOC0125Info searchEiDomainDefVW(String eiddid)
			throws BLException {
		return soc0125DAO.searchEiDomainDefVW(eiddid);
	}

}
