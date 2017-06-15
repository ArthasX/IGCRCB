/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD01SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD01DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD01TB;

/**
  * ����: vCloud ServiceInstanceҵ���߼�ʵ��
  * ��������: vCloud ServiceInstanceҵ���߼�ʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD01BLImpl extends BaseBLImpl implements
		VCD01BL {

	/** vCloud ServiceInstanceDAO�ӿ� */
	protected VCD01DAO vcd01DAO;

	/**
	 * vCloudServiceInstanceDAO�ӿ�ȡ��
	 * @return vcd01DAO vCloudServiceInstanceDAO�ӿ�
	 */
	public VCD01DAO getVcd01DAO() {
		return vcd01DAO;
	}

	/**
	 * vCloudServiceInstanceDAO�ӿ��趨
	 * @param vcd01DAO vCloudServiceInstanceDAO�ӿ�
	 */
	public void setVcd01DAO(VCD01DAO vcd01dao) {
		vcd01DAO = vcd01dao;
	}

	/**
	 * vCloud ServiceInstanceʵ��ȡ��
	 *
	 * @return vCloud ServiceInstanceʵ��
	 */
	public VCD01TB getVCD01TBInstance() {
		return new VCD01TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD01Info> searchVCD01() {
		return vcd01DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD01Info searchVCD01ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD01SearchCond cond) {
		return vcd01DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD01Info> searchVCD01(
			VCD01SearchCond cond) {
		return vcd01DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD01Info> searchVCD01(
			VCD01SearchCond cond, int start,
			int count) {
		return vcd01DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD01Info registVCD01(VCD01Info instance)
		throws BLException {
		return vcd01DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD01Info updateVCD01(VCD01Info instance)
		throws BLException {
		checkExistInstance(instance.getVcid());
		return vcd01DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD01ByPK(Integer pk)
		throws BLException {
		vcd01DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD01(VCD01Info instance)
		throws BLException {
		vcd01DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VCD01Info checkExistInstance(Integer pk)
		throws BLException {
		VCD01Info instance = vcd01DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}