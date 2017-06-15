/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0152Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0152SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0152DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0152TB;

/**
  * ����: �ʲ���ϵ��ҵ���߼�ʵ��
  * ��������: �ʲ���ϵ��ҵ���߼�ʵ��
  * ������¼: ����ȫ 2013/05/27
  * �޸ļ�¼: 
  */
public class SOC0152BLImpl extends BaseBLImpl implements
		SOC0152BL {

	/** �ʲ���ϵ��DAO�ӿ� */
	protected SOC0152DAO soc0152DAO;
	
	/**
	 * �ʲ���ϵ��DAO�ӿ��趨
	 *
	 * @param soc0152DAO �ʲ���ϵ��DAO�ӿ�
	 */
	public void setSoc0152DAO(SOC0152DAO soc0152DAO) {
		this.soc0152DAO = soc0152DAO;
	}

	/**
	 * �ʲ���ϵ��ʵ��ȡ��
	 *
	 * @return �ʲ���ϵ��ʵ��
	 */
	public SOC0152TB getSOC0152TBInstance() {
		return new SOC0152TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0152Info> searchSOC0152() {
		return soc0152DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0152Info searchSOC0152ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0152SearchCond cond) {
		return soc0152DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0152Info> searchSOC0152(
			SOC0152SearchCond cond) {
		return soc0152DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0152Info> searchSOC0152(
			SOC0152SearchCond cond, int start,
			int count) {
		return soc0152DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0152Info registSOC0152(SOC0152Info instance)
		throws BLException {
		return soc0152DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0152Info updateSOC0152(SOC0152Info instance)
		throws BLException {
		checkExistInstance(instance.getRlnCode());
		return soc0152DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0152ByPK(String pk)
		throws BLException {
		soc0152DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0152(SOC0152Info instance)
		throws BLException {
		soc0152DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0152Info checkExistInstance(String pk)
		throws BLException {
		SOC0152Info instance = soc0152DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}