/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * ����: ����ͼҵ���߼��ӿ�
  * ��������: ����ͼҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface IGDomainGraphBL extends BaseBL {

	/**
	 * ����ͼ��ʾ��ʼ������
	 * 
	 * @param eiid ѡ���ʲ�ID
	 * @param domainid ��ID
	 * @param domainversion ��汾
	 * @param createtime ����ʱ��
	 * @return ��ʾ��XML
	 * @throws BLException 
	 * 
	 */
	public String initGraph(Integer eiid, Integer domainid,
			Integer domainversion, String createtime) throws BLException;

}