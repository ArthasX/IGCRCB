/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0125Info;

/**
 * ����: ���°�����Ϣ��ͼҵ���߼��ӿ�
 * ��������: ���°�����Ϣ��ͼҵ���߼��ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface SOC0125BL extends BaseBL {
	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0125Info> searchEiDomainDefVW() throws BLException;

	/**
	 * ����eiddid��ѯ
	 * @param eiddid
	 * @return
	 */
	public SOC0125Info searchEiDomainDefVW(String eiddid) throws BLException;
	
}
