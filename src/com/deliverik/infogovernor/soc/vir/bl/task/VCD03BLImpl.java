/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD03SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD03DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD03TB;

/**
  * ����: ��Դ���������Ϣҵ���߼�ʵ��
  * ��������: ��Դ���������Ϣҵ���߼�ʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD03BLImpl extends BaseBLImpl implements
		VCD03BL {

	/** ��Դ���������ϢDAO�ӿ� */
	protected VCD03DAO vcd03DAO;

	/**
	 * ��Դ���������ϢDAO�ӿ��趨
	 * @param vcd03DAO ��Դ���������ϢDAO�ӿ�
	 */
	public void setVcd03DAO(VCD03DAO vcd03dao) {
		vcd03DAO = vcd03dao;
	}

	/**
	 * ��Դ���������Ϣʵ��ȡ��
	 *
	 * @return ��Դ���������Ϣʵ��
	 */
	public VCD03TB getVCD03TBInstance() {
		return new VCD03TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD03Info> searchVCD03() {
		return vcd03DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD03Info searchVCD03ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD03SearchCond cond) {
		return vcd03DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD03Info> searchVCD03(
			VCD03SearchCond cond) {
		return vcd03DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD03Info> searchVCD03(
			VCD03SearchCond cond, int start,
			int count) {
		return vcd03DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD03Info registVCD03(VCD03Info instance)
		throws BLException {
		return vcd03DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD03Info updateVCD03(VCD03Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vcd03DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD03ByPK(Integer pk)
		throws BLException {
		vcd03DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD03(VCD03Info instance)
		throws BLException {
		vcd03DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VCD03Info checkExistInstance(Integer pk)
		throws BLException {
		VCD03Info instance = vcd03DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}