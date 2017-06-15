/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0104SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0104DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0104TB;

/**
  * ����: ��������ҵ���߼�ʵ��
  * ��������: ��������ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class SOC0104BLImpl extends BaseBLImpl implements
		SOC0104BL {

	/** ��������DAO�ӿ� */
	protected SOC0104DAO soc0104DAO;
	
	/**
	 * ��������DAO�ӿ��趨
	 *
	 * @param soc0104DAO ��������DAO�ӿ�
	 */
	public void setsoc0104DAO(SOC0104DAO soc0104DAO) {
		this.soc0104DAO = soc0104DAO;
	}

	/**
	 * ��������ʵ��ȡ��
	 *
	 * @return ��������ʵ��
	 */
	public SOC0104TB getSOC0104Instance() {
		return new SOC0104TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0104Info> searchSOC0104() {
		return soc0104DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0104Info searchSOC0104ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0104SearchCond cond) {
		return soc0104DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0104Info> searchSOC0104(
			SOC0104SearchCond cond) {
		return soc0104DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0104Info> searchSOC0104(
			SOC0104SearchCond cond, int start,
			int count) {
		return soc0104DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0104Info registSOC0104(SOC0104Info instance)
		throws BLException {
		return soc0104DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0104Info updateSOC0104(SOC0104Info instance)
		throws BLException {
		checkExistInstance(instance.getAutid());
		return soc0104DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0104ByPK(Integer pk)
		throws BLException {
		soc0104DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0104(SOC0104Info instance)
		throws BLException {
		soc0104DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0104Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0104Info instance = soc0104DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}