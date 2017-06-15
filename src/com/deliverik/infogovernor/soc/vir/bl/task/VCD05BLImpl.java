/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD05Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD05SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD05DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD05TB;

/**
  * ����: vCloud����ģ��ҵ���߼�ʵ��
  * ��������: vCloud����ģ��ҵ���߼�ʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD05BLImpl extends BaseBLImpl implements
		VCD05BL {

	/** vCloud����ģ��DAO�ӿ� */
	protected VCD05DAO vcd05DAO;

	/**
	 * vCloud����ģ��DAO�ӿ��趨
	 * @param vcd05DAO vCloud����ģ��DAO�ӿ�
	 */
	public void setVcd05DAO(VCD05DAO vcd05dao) {
		vcd05DAO = vcd05dao;
	}

	/**
	 * vCloud����ģ��ʵ��ȡ��
	 *
	 * @return vCloud����ģ��ʵ��
	 */
	public VCD05TB getVCD05TBInstance() {
		return new VCD05TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD05Info> searchVCD05() {
		return vcd05DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD05Info searchVCD05ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD05SearchCond cond) {
		return vcd05DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD05Info> searchVCD05(
			VCD05SearchCond cond) {
		return vcd05DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD05Info> searchVCD05(
			VCD05SearchCond cond, int start,
			int count) {
		return vcd05DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD05Info registVCD05(VCD05Info instance)
		throws BLException {
		return vcd05DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD05Info updateVCD05(VCD05Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vcd05DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD05ByPK(Integer pk)
		throws BLException {
		vcd05DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD05(VCD05Info instance)
		throws BLException {
		vcd05DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VCD05Info checkExistInstance(Integer pk)
		throws BLException {
		VCD05Info instance = vcd05DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}