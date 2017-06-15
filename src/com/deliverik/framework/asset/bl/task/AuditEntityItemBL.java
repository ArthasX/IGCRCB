/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.AuditEntityItemInfo;
import com.deliverik.framework.asset.model.condition.AuditEntityItemSearchCond;
import com.deliverik.framework.asset.model.entity.AuditEntityItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * ����: ����ʲ���ҵ���߼��ӿ�
  * ��������: ����ʲ���ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditEntityItemBL extends BaseBL {

	/**
	 * ����ʲ���ʵ��ȡ��
	 *
	 * @return ����ʲ���ʵ��
	 */
	public AuditEntityItemTB getAuditEntityItemTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditEntityItemInfo searchAuditEntityItemByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditEntityItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem(
			AuditEntityItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem(
			AuditEntityItemSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditEntityItemInfo registAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditEntityItemInfo updateAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditEntityItemByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException;

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteAuditEntityItem();

}