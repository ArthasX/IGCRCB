/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.AuditConfigItemInfo;
import com.deliverik.framework.asset.model.condition.AuditConfigItemSearchCond;
import com.deliverik.framework.asset.model.dao.AuditConfigItemDAO;
import com.deliverik.framework.asset.model.entity.AuditConfigItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * ����: ����ʲ����Ա�ҵ���߼�ʵ��
  * ��������: ����ʲ����Ա�ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class AuditConfigItemBLImpl extends BaseBLImpl implements
		AuditConfigItemBL {

	/** ����ʲ����Ա�DAO�ӿ� */
	protected AuditConfigItemDAO auditConfigItemDAO;
	
	/**
	 * ����ʲ����Ա�DAO�ӿ��趨
	 *
	 * @param auditConfigItemDAO ����ʲ����Ա�DAO�ӿ�
	 */
	public void setAuditConfigItemDAO(AuditConfigItemDAO auditConfigItemDAO) {
		this.auditConfigItemDAO = auditConfigItemDAO;
	}

	/**
	 * ����ʲ����Ա�ʵ��ȡ��
	 *
	 * @return ����ʲ����Ա�ʵ��
	 */
	public AuditConfigItemTB getAuditConfigItemTBInstance() {
		return new AuditConfigItemTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItem() {
		return auditConfigItemDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditConfigItemInfo searchAuditConfigItemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditConfigItemSearchCond cond) {
		return auditConfigItemDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItem(
			AuditConfigItemSearchCond cond) {
		return auditConfigItemDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return auditConfigItemDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditConfigItemInfo registAuditConfigItem(AuditConfigItemInfo instance)
		throws BLException {
		return auditConfigItemDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditConfigItemInfo updateAuditConfigItem(AuditConfigItemInfo instance)
		throws BLException {
		checkExistInstance(instance.getCiid());
		return auditConfigItemDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditConfigItemByPK(Integer pk)
		throws BLException {
		auditConfigItemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditConfigItem(AuditConfigItemInfo instance)
		throws BLException {
		auditConfigItemDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public AuditConfigItemInfo checkExistInstance(Integer pk)
		throws BLException {
		AuditConfigItemInfo instance = auditConfigItemDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * �����ʲ����Լ����ԶԱȷ���
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItemForAucmptype(Integer eiid){
		return auditConfigItemDAO.searchAuditConfigItemForAucmptype(eiid);
	}

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteAuditConfigItem(){
		return auditConfigItemDAO.deleteAuditConfigItem();
	}

}