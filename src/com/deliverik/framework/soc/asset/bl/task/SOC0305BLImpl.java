/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0305DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0307DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0305TB;

/**
  * ����: SOC0305ҵ���߼�ʵ��
  * ��������: SOC0305ҵ���߼�ʵ��
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
public class SOC0305BLImpl extends BaseBLImpl implements
		SOC0305BL {

	/** SOC0305DAO�ӿ� */
	protected SOC0305DAO soc0305DAO;
	
	/** SOC0307DAO�ӿ� */
	protected SOC0307DAO soc0307DAO;
	
	/**
	 * SOC0305VWDAO�ӿ��趨
	 * @param soc0307DAO
	 */
	public void setSoc0307DAO(SOC0307DAO soc0307DAO) {
		this.soc0307DAO = soc0307DAO;
	}

	/**
	 * SOC0305DAO�ӿ��趨
	 *
	 * @param storageEventDAOSOC0305DAO�ӿ�
	 */
	public void setSoc0305DAO(SOC0305DAO soc0305DAO) {
		this.soc0305DAO = soc0305DAO;
	}

	/**
	 * SOC0305ʵ��ȡ��
	 *
	 * @return SOC0305ʵ��
	 */
	public SOC0305TB getSoc0305Instance() {
		return new SOC0305TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0305Info> searchSoc0305() {
		return soc0305DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0305Info searchSoc0305ByPK(Integer id)
		throws BLException {
		return checkExistInstance(id);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0305SearchCond cond) {
		return soc0305DAO.getSearchCount(cond);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getVWSearchCount(SOC0305SearchCond cond) {
		return soc0307DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0305Info> searchSoc0305(
			SOC0305SearchCond cond) {
		return soc0305DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0305Info> searchSoc0305(
			SOC0305SearchCond cond, int start,
			int count) {
		return soc0305DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0307Info> searchSOC0307(
			SOC0305SearchCond cond, int start,
			int count) {
		return soc0307DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0305Info registSoc0305(SOC0305Info instance)
		throws BLException {
		return soc0305DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0305Info updateSoc0305(SOC0305Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return soc0305DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteSoc0305ByPK(Integer id)
		throws BLException {
		soc0305DAO.delete(checkExistInstance(id));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteSoc0305(SOC0305Info instance)
		throws BLException {
		soc0305DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SOC0305Info checkExistInstance(Integer id)
		throws BLException {
		SOC0305Info instance = soc0305DAO.findByPK(id);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}


}