/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.AuditConfigItemInfo;
import com.deliverik.framework.asset.model.condition.AuditConfigItemSearchCond;
import com.deliverik.framework.asset.model.entity.AuditConfigItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * ����: ����ʲ����Ա�ҵ���߼��ӿ�
  * ��������: ����ʲ����Ա�ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditConfigItemBL extends BaseBL {

	/**
	 * ����ʲ����Ա�ʵ��ȡ��
	 *
	 * @return ����ʲ����Ա�ʵ��
	 */
	public AuditConfigItemTB getAuditConfigItemTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItem();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditConfigItemInfo searchAuditConfigItemByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditConfigItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItem(
			AuditConfigItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItem(
			AuditConfigItemSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditConfigItemInfo registAuditConfigItem(AuditConfigItemInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditConfigItemInfo updateAuditConfigItem(AuditConfigItemInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditConfigItemByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditConfigItem(AuditConfigItemInfo instance)
		throws BLException;

	/**
	 * �����ʲ����Լ����ԶԱȷ���
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItemForAucmptype(Integer eiid);

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteAuditConfigItem();

}