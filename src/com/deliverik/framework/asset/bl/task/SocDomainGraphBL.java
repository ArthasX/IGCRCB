/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

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
	public String initGraph(IG688Info ei, Integer domainid,
			Integer domainversion, String createtime) throws BLException;

}