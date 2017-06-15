/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.AuditEntityItemInfo;
import com.deliverik.framework.asset.model.condition.AuditEntityItemSearchCond;
import com.deliverik.framework.asset.model.dao.AuditEntityItemDAO;
import com.deliverik.framework.asset.model.entity.AuditEntityItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * ����: ����ʲ���ҵ���߼�ʵ��
  * ��������: ����ʲ���ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class AuditEntityItemBLImpl extends BaseBLImpl implements
		AuditEntityItemBL {

	/** ����ʲ���DAO�ӿ� */
	protected AuditEntityItemDAO auditEntityItemDAO;
	
	/**
	 * ����ʲ���DAO�ӿ��趨
	 *
	 * @param auditEntityItemDAO ����ʲ���DAO�ӿ�
	 */
	public void setAuditEntityItemDAO(AuditEntityItemDAO auditEntityItemDAO) {
		this.auditEntityItemDAO = auditEntityItemDAO;
	}

	/**
	 * ����ʲ���ʵ��ȡ��
	 *
	 * @return ����ʲ���ʵ��
	 */
	public AuditEntityItemTB getAuditEntityItemTBInstance() {
		return new AuditEntityItemTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem() {
		return auditEntityItemDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditEntityItemInfo searchAuditEntityItemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditEntityItemSearchCond cond) {
		return auditEntityItemDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditEntityItemInfo> searchAuditEntityItem(
			AuditEntityItemSearchCond cond) {
		return auditEntityItemDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return auditEntityItemDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditEntityItemInfo registAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException {
		return auditEntityItemDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditEntityItemInfo updateAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return auditEntityItemDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditEntityItemByPK(Integer pk)
		throws BLException {
		auditEntityItemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditEntityItem(AuditEntityItemInfo instance)
		throws BLException {
		auditEntityItemDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AuditEntityItemInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditEntityItemInfo instance = auditEntityItemDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteAuditEntityItem(){
		return auditEntityItemDAO.deleteAuditEntityItem();
	}

}