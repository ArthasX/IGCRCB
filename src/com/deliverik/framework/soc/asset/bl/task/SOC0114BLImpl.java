/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0114DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0114PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0114TB;

/**
  * ����: ʵ����·ͼҵ���߼�ʵ��
  * ��������: ʵ����·ͼҵ���߼�ʵ��
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public class SOC0114BLImpl extends BaseBLImpl implements
		SOC0114BL {

	/**
	 * ʵ����·ͼDAO�ӿ��趨
	 *
	 * @param soc0114DAO ʵ����·ͼDAO�ӿ�
	 */
	public void setSoc0114DAO(SOC0114DAO soc0114DAO) {
		this.soc0114DAO = soc0114DAO;
	}

	/** ʵ����·ͼDAO�ӿ� */
	protected SOC0114DAO soc0114DAO;
	


	/**
	 * ʵ����·ͼʵ��ȡ��
	 *
	 * @return ʵ����·ͼʵ��
	 */
	public SOC0114TB getEiLinkMapTBInstance() {
		return new SOC0114TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0114Info> searchEiLinkMap() {
		return soc0114DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0114Info searchEiLinkMapByPK(SOC0114PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0114SearchCond cond) {
		return soc0114DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0114Info> searchEiLinkMap(
			SOC0114SearchCond cond) {
		return soc0114DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0114Info> searchEiLinkMap(
			SOC0114SearchCond cond, int start,
			int count) {
		return soc0114DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0114Info registEiLinkMap(SOC0114Info instance)
		throws BLException {
		return soc0114DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0114Info updateEiLinkMap(SOC0114Info instance)
		throws BLException {
		checkExistInstance(new SOC0114PK(instance.getDomainid(), instance.getDomainversion(), instance.getLinkid(), instance.getLinkorder()));
		return soc0114DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEiLinkMapByPK(SOC0114PK pk)
		throws BLException {
		soc0114DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEiLinkMap(SOC0114Info instance)
		throws BLException {
		soc0114DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0114Info checkExistInstance(SOC0114PK pk)
		throws BLException {
		SOC0114Info instance = soc0114DAO.findByPK(pk);
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
	public List<SOC0114Info> queryEiLinkMapList(SOC0114SearchCond cond) {
		return this.soc0114DAO.queryEiLinkMapList(cond);
	}
	
	/**
	 * Ӱ��CI��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Integer> queryImpactCI(final SOC0114SearchCond cond) {
		return this.soc0114DAO.queryImpactCI(cond);
	}

	public List<SOC0114Info> searchEiLinkMapByOtherEiid(
			EiLinkMapSearchCondImpl emCond) {
		return this.soc0114DAO.searchEiLinkMapByOtherEiid(emCond);
	}
	
	/**
	 * ����eiid ɾ����·
	 * @param eiid
	 */
	public void delByEiid (Integer eiid)throws BLException{
		this.soc0114DAO.delByEiid(eiid);
	}

	/**
	 * ����eiid��ѯ������ص�ҵ��ϵͳeiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchLinkByEiid(Integer eiid)throws BLException{
		return this.soc0114DAO.searchLinkByEiid(eiid);
	}
}