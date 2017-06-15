/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0102Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0102SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0102DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0102TB;

/**
  * ����: ����ʲ���ҵ���߼�ʵ��
  * ��������: ����ʲ���ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class SOC0102BLImpl extends BaseBLImpl implements
		SOC0102BL {

	/** ����ʲ���DAO�ӿ� */
	protected SOC0102DAO soc0102DAO;
	
	/**
	 * ����ʲ���DAO�ӿ��趨
	 *
	 * @param SOC0102DAO ����ʲ���DAO�ӿ�
	 */
	public void setSoc0102DAO(SOC0102DAO soc0102DAO) {
		this.soc0102DAO = soc0102DAO;
	}

	/**
	 * ����ʲ���ʵ��ȡ��
	 *
	 * @return ����ʲ���ʵ��
	 */
	public SOC0102TB getSOC0102Instance() {
		return new SOC0102TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0102Info> searchSOC0102() {
		return soc0102DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0102Info searchSOC0102ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0102SearchCond cond) {
		return soc0102DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0102Info> searchSOC0102(
			SOC0102SearchCond cond) {
		return soc0102DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0102Info> searchSOC0102(
			SOC0102SearchCond cond, int start,
			int count) {
		return soc0102DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0102Info registSOC0102(SOC0102Info instance)
		throws BLException {
		return soc0102DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0102Info updateSOC0102(SOC0102Info instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return soc0102DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0102ByPK(Integer pk)
		throws BLException {
		soc0102DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0102(SOC0102Info instance)
		throws BLException {
		soc0102DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0102Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0102Info instance = soc0102DAO.findByPK(pk);
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
	public Integer deleteSOC0102(){
		return soc0102DAO.deleteSOC0102();
	}


}