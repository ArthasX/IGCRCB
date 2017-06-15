/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.asset.model.entity.EiDomainDefTB;

/**
  * ����: �ʲ������ҵ���߼��ӿ�
  * ��������: �ʲ������ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface EiDomainDefBL extends BaseBL {

	/**
	 * �ʲ������ʵ��ȡ��
	 *
	 * @return �ʲ������ʵ��
	 */
	public EiDomainDefTB getEiDomainDefTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiDomainDefInfo> searchEiDomainDef();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public EiDomainDefInfo searchEiDomainDefByPK(Serializable pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiDomainDefSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiDomainDefInfo> searchEiDomainDef(
			EiDomainDefSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<EiDomainDefInfo> searchEiDomainDef(
			EiDomainDefSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public EiDomainDefInfo registEiDomainDef(EiDomainDefInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiDomainDefInfo updateEiDomainDef(EiDomainDefInfo instance)
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
	public void deleteEiDomainDef(EiDomainDefInfo instance)
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
	public EiDomainDefInfo searchDomainMaxVersion(Integer eiddid) throws BLException;

	/**
	 * ��ȡ�ʲ�����汾
	 * @param eiddid
	 * @param version
	 * @return
	 * @throws BLException
	 */
	public List<EiDomainDefInfo> searchEiDomainDefByPK(Integer eiddid,Integer version) throws BLException;

}