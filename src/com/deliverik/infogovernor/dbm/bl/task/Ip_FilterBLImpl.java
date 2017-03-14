/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;
import com.deliverik.infogovernor.dbm.model.condition.Ip_FilterSearchCond;
import com.deliverik.infogovernor.dbm.model.dao.Ip_FilterDAO;
import com.deliverik.infogovernor.dbm.model.entity.Ip_FilterTB;

/**
  * ����: ȫ��IP����ҵ���߼�ʵ��
  * ��������: ȫ��IP����ҵ���߼�ʵ��
  * ������¼: 2012/11/07
  * �޸ļ�¼: 
  */
public class Ip_FilterBLImpl extends BaseBLImpl implements
		Ip_FilterBL {

	/** ȫ��IP����DAO�ӿ� */
	protected Ip_FilterDAO ip_FilterDAO;
	
	/**
	 * ȫ��IP����DAO�ӿ��趨
	 *
	 * @param ip_FilterDAO ȫ��IP����DAO�ӿ�
	 */
	public void setIp_FilterDAO(Ip_FilterDAO ip_FilterDAO) {
		this.ip_FilterDAO = ip_FilterDAO;
	}

	/**
	 * ȫ��IP����ʵ��ȡ��
	 *
	 * @return ȫ��IP����ʵ��
	 */
	public Ip_FilterTB getIp_FilterTBInstance() {
		return new Ip_FilterTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Ip_FilterInfo> searchIp_Filter() {
		return ip_FilterDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Ip_FilterInfo searchIp_FilterByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Ip_FilterSearchCond cond) {
		return ip_FilterDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Ip_FilterInfo> searchIp_Filter(
			Ip_FilterSearchCond cond) {
		return ip_FilterDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Ip_FilterInfo> searchIp_Filter(
			Ip_FilterSearchCond cond, int start,
			int count) {
		return ip_FilterDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Ip_FilterInfo registIp_Filter(Ip_FilterInfo instance)
		throws BLException {
		return ip_FilterDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Ip_FilterInfo updateIp_Filter(Ip_FilterInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return ip_FilterDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIp_FilterByPK(Integer pk)
		throws BLException {
		ip_FilterDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIp_Filter(Ip_FilterInfo instance)
		throws BLException {
		ip_FilterDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public Ip_FilterInfo checkExistInstance(Integer pk)
		throws BLException {
		Ip_FilterInfo instance = ip_FilterDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}