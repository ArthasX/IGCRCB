/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * ����: Ӱ�����ͼ��ʾҵ���߼��ӿ�
  * ��������: Ӱ�����ͼ��ʾҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SocImpactGraphBL extends BaseBL {

	/**
	 * Ӱ�����ͼ��ʾ��ʼ������(Ĭ�ϼ���default��)
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
	
	/**
	 * Ӱ��CI��������(Ĭ�ϼ���default��)
	 * 
	 * @param eiid ѡ����ʲ�ID
	 * @param domainid ��ID
	 * @param syscoding Ӱ��CIģ�Ͳ����
	 * @return Ӱ��CI�ʲ�ID����
	 * @throws BLException
	 */
	public List<Integer> searchImpactCI(Integer eiid, Integer domainid, String syscoding) throws BLException;

}