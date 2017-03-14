/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefVWInfo;
import com.deliverik.framework.asset.model.dao.EiDomainDefVWDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ����: ���°�����Ϣ��ͼҵ���߼�ʵ��
 * ��������: ���°�����Ϣ��ͼҵ���߼�ʵ��
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class EiDomainDefVWBLImpl extends BaseBLImpl implements EiDomainDefVWBL {
	
	/** ���°�����Ϣ��ͼDAO�ӿ� */
	protected EiDomainDefVWDAO eiDomainDefVWDAO;
	
	
	/**
	 * ���°�����Ϣ��ͼDAO�ӿ��趨
	 * @param eiDomainDefVWDAO���°�����Ϣ��ͼDAO�ӿ�
	 */
	public void setEiDomainDefVWDAO(EiDomainDefVWDAO eiDomainDefVWDAO) {
		this.eiDomainDefVWDAO = eiDomainDefVWDAO;
	}



	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiDomainDefVWInfo> searchEiDomainDefVW() throws BLException{
		return eiDomainDefVWDAO.findAll();
		
	}


	/**
	 * ����eiddid��ѯ
	 * @param eiddid
	 * @return
	 */
	public EiDomainDefVWInfo searchEiDomainDefVW(String eiddid)
			throws BLException {
		return eiDomainDefVWDAO.searchEiDomainDefVW(eiddid);
	}

}
