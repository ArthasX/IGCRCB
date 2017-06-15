/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.SOC0154Info;
import com.deliverik.infogovernor.soc.vir.model.condition.SOC0154SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.SOC0154DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.SOC0154PK;
import com.deliverik.infogovernor.soc.vir.model.entity.SOC0154TB;

/**
  * ����: soc0154ҵ���߼�ʵ��
  * ��������: soc0154ҵ���߼�ʵ��
  * ������¼: 2013/12/29
  * �޸ļ�¼: 
  */
public class SOC0154BLImpl extends BaseBLImpl implements
		SOC0154BL {

	/** soc0154DAO�ӿ� */
	protected SOC0154DAO soc0154DAO;
	
	/**
	 * soc0154DAO�ӿ��趨
	 *
	 * @param soc0154DAO soc0154DAO�ӿ�
	 */
	public void setSoc0154DAO(SOC0154DAO soc0154DAO) {
		this.soc0154DAO = soc0154DAO;
	}

	/**
	 * soc0154ʵ��ȡ��
	 *
	 * @return soc0154ʵ��
	 */
	public SOC0154TB getSoc0154TBInstance() {
		return new SOC0154TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0154Info> searchSoc0154() {
		return soc0154DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0154Info searchSoc0154ByPK(SOC0154PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0154SearchCond cond) {
		return soc0154DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0154Info> searchSoc0154(
			SOC0154SearchCond cond) {
		return soc0154DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0154Info> searchSoc0154(
			SOC0154SearchCond cond, int start,
			int count) {
		return soc0154DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0154Info registSoc0154(SOC0154Info instance)
		throws BLException {
		return soc0154DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0154Info updateSoc0154(SOC0154Info instance)
		throws BLException {
		checkExistInstance(new SOC0154PK(instance.getMyid(), instance.getFromid(), instance.getIsellipsis()));
		return soc0154DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSoc0154ByPK(SOC0154PK pk)
		throws BLException {
		soc0154DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSoc0154(SOC0154Info instance)
		throws BLException {
		soc0154DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0154Info checkExistInstance(SOC0154PK pk)
		throws BLException {
		SOC0154Info instance = soc0154DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}