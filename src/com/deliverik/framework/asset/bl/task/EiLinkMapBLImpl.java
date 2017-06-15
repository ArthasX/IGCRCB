/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCond;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.asset.model.dao.EiLinkMapDAO;
import com.deliverik.framework.asset.model.entity.EiLinkMapPK;
import com.deliverik.framework.asset.model.entity.EiLinkMapTB;

/**
  * ����: ʵ����·ͼҵ���߼�ʵ��
  * ��������: ʵ����·ͼҵ���߼�ʵ��
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public class EiLinkMapBLImpl extends BaseBLImpl implements
		EiLinkMapBL {

	/** ʵ����·ͼDAO�ӿ� */
	protected EiLinkMapDAO eiLinkMapDAO;
	
	/**
	 * ʵ����·ͼDAO�ӿ��趨
	 *
	 * @param eiLinkMapDAO ʵ����·ͼDAO�ӿ�
	 */
	public void setEiLinkMapDAO(EiLinkMapDAO eiLinkMapDAO) {
		this.eiLinkMapDAO = eiLinkMapDAO;
	}

	/**
	 * ʵ����·ͼʵ��ȡ��
	 *
	 * @return ʵ����·ͼʵ��
	 */
	public EiLinkMapTB getEiLinkMapTBInstance() {
		return new EiLinkMapTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiLinkMapInfo> searchEiLinkMap() {
		return eiLinkMapDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiLinkMapInfo searchEiLinkMapByPK(EiLinkMapPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EiLinkMapSearchCond cond) {
		return eiLinkMapDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiLinkMapInfo> searchEiLinkMap(
			EiLinkMapSearchCond cond) {
		return eiLinkMapDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiLinkMapInfo> searchEiLinkMap(
			EiLinkMapSearchCond cond, int start,
			int count) {
		return eiLinkMapDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EiLinkMapInfo registEiLinkMap(EiLinkMapInfo instance)
		throws BLException {
		return eiLinkMapDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiLinkMapInfo updateEiLinkMap(EiLinkMapInfo instance)
		throws BLException {
		checkExistInstance(new EiLinkMapPK(instance.getDomainid(), instance.getDomainversion(), instance.getLinkid(), instance.getLinkorder()));
		return eiLinkMapDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEiLinkMapByPK(EiLinkMapPK pk)
		throws BLException {
		eiLinkMapDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEiLinkMap(EiLinkMapInfo instance)
		throws BLException {
		eiLinkMapDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public EiLinkMapInfo checkExistInstance(EiLinkMapPK pk)
		throws BLException {
		EiLinkMapInfo instance = eiLinkMapDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * ����ͼ��·��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiLinkMapInfo> queryEiLinkMapList(EiLinkMapSearchCond cond) {
		return this.eiLinkMapDAO.queryEiLinkMapList(cond);
	}
	
	/**
	 * Ӱ��CI��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Integer> queryImpactCI(final EiLinkMapSearchCond cond) {
		return this.eiLinkMapDAO.queryImpactCI(cond);
	}
	public List<EiLinkMapInfo> searchEiLinkMapByOtherEiid(
			EiLinkMapSearchCondImpl emCond) {
		return this.eiLinkMapDAO.searchEiLinkMapByOtherEiid(emCond);
	}

}