/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.EiDomainDetailInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailSearchCond;
import com.deliverik.framework.asset.model.entity.EiDomainDetailPK;
import com.deliverik.framework.asset.model.entity.EiDomainDetailTB;

/**
  * ����: �ʲ�����ϸ��ҵ���߼��ӿ�
  * ��������: �ʲ�����ϸ��ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface EiDomainDetailBL extends BaseBL {

	/**
	 * �ʲ�����ϸ��ʵ��ȡ��
	 *
	 * @return �ʲ�����ϸ��ʵ��
	 */
	public EiDomainDetailTB getEiDomainDetailTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetail();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public EiDomainDetailInfo searchEiDomainDetailByPK(EiDomainDetailPK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiDomainDetailSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetail(
			EiDomainDetailSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetail(
			EiDomainDetailSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public EiDomainDetailInfo registEiDomainDetail(EiDomainDetailInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiDomainDetailInfo updateEiDomainDetail(EiDomainDetailInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiDomainDetailByPK(EiDomainDetailPK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiDomainDetail(EiDomainDetailInfo instance)
		throws BLException;

}