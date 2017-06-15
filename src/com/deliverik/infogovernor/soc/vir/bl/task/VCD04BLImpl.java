/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD04DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD04TB;

/**
  * ����: vCloud������־ҵ���߼�ʵ��
  * ��������: vCloud������־ҵ���߼�ʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD04BLImpl extends BaseBLImpl implements
		VCD04BL {

	/** vCloud������־DAO�ӿ� */
	protected VCD04DAO vcd04DAO;

	/**
	 * vCloud������־DAO�ӿ��趨
	 * @param vcd04DAO vCloud������־DAO�ӿ�
	 */
	public void setVcd04DAO(VCD04DAO vcd04dao) {
		vcd04DAO = vcd04dao;
	}

	/**
	 * vCloud������־ʵ��ȡ��
	 *
	 * @return vCloud������־ʵ��
	 */
	public VCD04TB getVCD04TBInstance() {
		return new VCD04TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD04Info> searchVCD04() {
		return vcd04DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD04Info searchVCD04ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD04SearchCond cond) {
		return vcd04DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD04Info> searchVCD04(
			VCD04SearchCond cond) {
		return vcd04DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD04Info> searchVCD04(
			VCD04SearchCond cond, int start,
			int count) {
		return vcd04DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD04Info registVCD04(VCD04Info instance)
		throws BLException {
		return vcd04DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD04Info updateVCD04(VCD04Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vcd04DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD04ByPK(Integer pk)
		throws BLException {
		vcd04DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD04(VCD04Info instance)
		throws BLException {
		vcd04DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VCD04Info checkExistInstance(Integer pk)
		throws BLException {
		VCD04Info instance = vcd04DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}