/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefVWInfo;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ����: ���°�����Ϣ��ͼҵ���߼��ӿ�
 * ��������: ���°�����Ϣ��ͼҵ���߼��ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface EiDomainDefVWBL extends BaseBL {
	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiDomainDefVWInfo> searchEiDomainDefVW() throws BLException;

	/**
	 * ����eiddid��ѯ
	 * @param eiddid
	 * @return
	 */
	public EiDomainDefVWInfo searchEiDomainDefVW(String eiddid) throws BLException;
	
}
