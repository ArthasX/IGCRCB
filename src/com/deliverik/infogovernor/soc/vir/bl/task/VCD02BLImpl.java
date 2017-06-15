/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD02DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD02TB;

/**
  * ����: ������Դ��Ŀ��Ϣҵ���߼�ʵ��
  * ��������: ������Դ��Ŀ��Ϣҵ���߼�ʵ��
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public class VCD02BLImpl extends BaseBLImpl implements
		VCD02BL {

	/** ������Դ��Ŀ��ϢDAO�ӿ� */
	protected VCD02DAO vcd02DAO;

	/**
	 * ������Դ��Ŀ��ϢDAO�ӿ��趨
	 * @param vcd02DAO ������Դ��Ŀ��ϢDAO�ӿ�
	 */
	public void setVcd02DAO(VCD02DAO vcd02dao) {
		vcd02DAO = vcd02dao;
	}

	/**
	 * ������Դ��Ŀ��Ϣʵ��ȡ��
	 *
	 * @return ������Դ��Ŀ��Ϣʵ��
	 */
	public VCD02TB getVCD02TBInstance() {
		return new VCD02TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD02Info> searchVCD02() {
		return vcd02DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD02Info searchVCD02ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD02SearchCond cond) {
		return vcd02DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD02Info> searchVCD02(
			VCD02SearchCond cond) {
		return vcd02DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD02Info> searchVCD02(
			VCD02SearchCond cond, int start,
			int count) {
		return vcd02DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD02Info registVCD02(VCD02Info instance)
		throws BLException {
		return vcd02DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD02Info updateVCD02(VCD02Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vcd02DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD02ByPK(Integer pk)
		throws BLException {
		vcd02DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD02(VCD02Info instance)
		throws BLException {
		vcd02DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VCD02Info checkExistInstance(Integer pk)
		throws BLException {
		VCD02Info instance = vcd02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}