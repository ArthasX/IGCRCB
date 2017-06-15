/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0111TB;

/**
  * ����: �ʲ������ҵ���߼��ӿ�
  * ��������: �ʲ������ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0111BL extends BaseBL {

	/**
	 * �ʲ������ʵ��ȡ��
	 *
	 * @return �ʲ������ʵ��
	 */
	public SOC0111TB getEiDomainDefTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0111Info> searchEiDomainDef();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0111Info searchEiDomainDefByPK(Serializable pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0111SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0111Info> searchEiDomainDef(
			SOC0111SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0111Info> searchEiDomainDef(
			SOC0111SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0111Info registEiDomainDef(SOC0111Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0111Info updateEiDomainDef(SOC0111Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiDomainDefByPK(Serializable pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiDomainDef(SOC0111Info instance)
		throws BLException;
	/**
	 * ��ѯ���EiddId
	 * @return 
	 * @throws BLException
	 */
	public Integer findMaxEiddId() throws BLException;

	/**
	 * ��ȡ���°汾��
	 * @param eiddid ��ID
	 * @return ���°汾��
	 * @throws BLException 
	 */
	public SOC0111Info searchDomainMaxVersion(Integer eiddid) throws BLException;

	/**
	 * ��ȡ�ʲ�����汾
	 * @param eiddid
	 * @param version
	 * @return
	 * @throws BLException
	 */
	public List<SOC0111Info> searchEiDomainDefByPK(Integer eiddid,Integer version) throws BLException;

}