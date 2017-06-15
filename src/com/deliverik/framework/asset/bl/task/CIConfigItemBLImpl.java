/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.asset.model.condition.CIConfigItemSearchCond;
import com.deliverik.framework.asset.model.dao.CIConfigItemDAO;
import com.deliverik.framework.asset.model.entity.CIConfigItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * ����: CI����ʲ����Ա�ҵ���߼�ʵ��
  * ��������: CI����ʲ����Ա�ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class CIConfigItemBLImpl extends BaseBLImpl implements
		CIConfigItemBL {

	/** CI����ʲ����Ա�DAO�ӿ� */
	protected CIConfigItemDAO ciConfigItemDAO;
	
	/**
	 * CI����ʲ����Ա�DAO�ӿ��趨
	 *
	 * @param ciConfigItemDAO CI����ʲ����Ա�DAO�ӿ�
	 */
	public void setCiConfigItemDAO(CIConfigItemDAO ciConfigItemDAO) {
		this.ciConfigItemDAO = ciConfigItemDAO;
	}

	/**
	 * CI����ʲ����Ա�ʵ��ȡ��
	 *
	 * @return CI����ʲ����Ա�ʵ��
	 */
	public CIConfigItemTB getCIConfigItemTBInstance() {
		return new CIConfigItemTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIConfigItemInfo> searchCIConfigItem() {
		return ciConfigItemDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIConfigItemInfo searchCIConfigItemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CIConfigItemSearchCond cond) {
		return ciConfigItemDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIConfigItemInfo> searchCIConfigItem(
			CIConfigItemSearchCond cond) {
		return ciConfigItemDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIConfigItemInfo> searchCIConfigItem(
			CIConfigItemSearchCond cond, int start,
			int count) {
		return ciConfigItemDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CIConfigItemInfo registCIConfigItem(CIConfigItemInfo instance)
		throws BLException {
		return ciConfigItemDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CIConfigItemInfo updateCIConfigItem(CIConfigItemInfo instance)
		throws BLException {
		checkExistInstance(instance.getCiid());
		return ciConfigItemDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCIConfigItemByPK(Integer pk)
		throws BLException {
		ciConfigItemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCIConfigItem(CIConfigItemInfo instance)
		throws BLException {
		ciConfigItemDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CIConfigItemInfo checkExistInstance(Integer pk)
		throws BLException {
		CIConfigItemInfo instance = ciConfigItemDAO.findByPK(pk);
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
	public List<CIConfigItemInfo> searchCIConfigItemForAucmptype(Integer eiid){
		return ciConfigItemDAO.searchCIConfigItemForAucmptype(eiid);
	}

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteCIConfigItem(){
		return ciConfigItemDAO.deleteCIConfigItem();
	}

}