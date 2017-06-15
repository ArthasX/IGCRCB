/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
  * ����: ����ͼҵ���߼��ӿ�
  * ��������: ����ͼҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SocDomainGraphBL extends BaseBL {

	/**
	 * ����ͼ��ʾ��ʼ������(Ĭ�ϼ���default��)
	 * 
	 * @param ei ѡ���ʲ���Ϣ
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ����ʱ��
	 * @return ��ʾ��XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(SOC0118Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException;

	/**
	 * Ӱ��CIΪӲ��ʱ����ͼ��ʾ
	 * @param ei
	 * @param domainid
	 * @param domainversion
	 * @param updatetime
	 * @param diskei
	 * @return
	 * @throws BLException
	 */
	public String initGraph(SOC0118Info ei, Integer domainid,
			Integer domainversion, String updatetime, SOC0118Info diskei) throws BLException;

}