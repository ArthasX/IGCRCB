/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0105SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0105DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0105TB;

/**
  * ����: ��ƴ���������ҵ���߼�ʵ��
  * ��������: ��ƴ���������ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class SOC0105BLImpl extends BaseBLImpl implements
		SOC0105BL {

	/** ��ƴ���������DAO�ӿ� */
	protected SOC0105DAO soc0105DAO;
	
	/**
	 * ��ƴ���������DAO�ӿ��趨
	 *
	 * @param soc0105DAO ��ƴ���������DAO�ӿ�
	 */
	public void setsoc0105DAO(SOC0105DAO soc0105DAO) {
		this.soc0105DAO = soc0105DAO;
	}

	/**
	 * ��ƴ���������ʵ��ȡ��
	 *
	 * @return ��ƴ���������ʵ��
	 */
	public SOC0105TB getSOC0105Instance() {
		return new SOC0105TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0105Info> searchSOC0105() {
		return soc0105DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0105Info searchSOC0105ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0105SearchCond cond) {
		return soc0105DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0105Info> searchSOC0105(
			SOC0105SearchCond cond) {
		return soc0105DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0105Info> searchSOC0105(
			SOC0105SearchCond cond, int start,
			int count) {
		return soc0105DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0105Info registSOC0105(SOC0105Info instance)
		throws BLException {
		return soc0105DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0105Info updateSOC0105(SOC0105Info instance)
		throws BLException {
		checkExistInstance(instance.getAuwtid());
		return soc0105DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0105ByPK(Integer pk)
		throws BLException {
		soc0105DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0105(SOC0105Info instance)
		throws BLException {
		soc0105DAO.delete(instance);
	}

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteSOC0105All(){
		return soc0105DAO.deleteAll();
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0105Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0105Info instance = soc0105DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}