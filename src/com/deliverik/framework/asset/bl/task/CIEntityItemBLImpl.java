/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIEntityItemInfo;
import com.deliverik.framework.asset.model.condition.CIEntityItemSearchCond;
import com.deliverik.framework.asset.model.dao.CIEntityItemDAO;
import com.deliverik.framework.asset.model.entity.CIEntityItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * ����: CI����ʲ���ҵ���߼�ʵ��
  * ��������: CI����ʲ���ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class CIEntityItemBLImpl extends BaseBLImpl implements
		CIEntityItemBL {

	/** CI����ʲ���DAO�ӿ� */
	protected CIEntityItemDAO ciEntityItemDAO;
	
	/**
	 * CI����ʲ���DAO�ӿ��趨
	 *
	 * @param ciEntityItemDAO CI����ʲ���DAO�ӿ�
	 */
	public void setCiEntityItemDAO(CIEntityItemDAO ciEntityItemDAO) {
		this.ciEntityItemDAO = ciEntityItemDAO;
	}

	/**
	 * CI����ʲ���ʵ��ȡ��
	 *
	 * @return CI����ʲ���ʵ��
	 */
	public CIEntityItemTB getCIEntityItemTBInstance() {
		return new CIEntityItemTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIEntityItemInfo> searchCIEntityItem() {
		return ciEntityItemDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIEntityItemInfo searchCIEntityItemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CIEntityItemSearchCond cond) {
		return ciEntityItemDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CIEntityItemInfo> searchCIEntityItem(
			CIEntityItemSearchCond cond) {
		return ciEntityItemDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CIEntityItemInfo> searchCIEntityItem(
			CIEntityItemSearchCond cond, int start,
			int count) {
		return ciEntityItemDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CIEntityItemInfo registCIEntityItem(CIEntityItemInfo instance)
		throws BLException {
		return ciEntityItemDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CIEntityItemInfo updateCIEntityItem(CIEntityItemInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return ciEntityItemDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCIEntityItemByPK(Integer pk)
		throws BLException {
		ciEntityItemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCIEntityItem(CIEntityItemInfo instance)
		throws BLException {
		ciEntityItemDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CIEntityItemInfo checkExistInstance(Integer pk)
		throws BLException {
		CIEntityItemInfo instance = ciEntityItemDAO.findByPK(pk);
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
	public Integer deleteCIEntityItem(){
		return ciEntityItemDAO.deleteCIEntityItem();
	}

}