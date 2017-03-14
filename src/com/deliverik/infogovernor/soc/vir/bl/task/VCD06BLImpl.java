/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD06SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD06DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: vCloud��֯��ƽ̨��������ʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class VCD06BLImpl extends BaseBLImpl implements VCD06BL {

	/** vCloud��֯��ƽ̨��������ʵ��DAO�ӿ� */
	protected VCD06DAO vcd06DAO;

	/**
	 * vCloud��֯��ƽ̨��������ʵ��DAO�ӿ��趨
	 * @param vcd05DAO vCloud��֯��ƽ̨��������ʵ��DAO�ӿ�
	 */
	public void setVcd06DAO(VCD06DAO vcd06dao) {
		vcd06DAO = vcd06dao;
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD06Info searchVCD06ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD06SearchCond cond) {
		return vcd06DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VCD06Info> searchVCD06(VCD06SearchCond cond) {
		return vcd06DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD06Info> searchVCD06(VCD06SearchCond cond, int start,int count) {
		return vcd06DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VCD06Info registVCD06(VCD06Info instance) throws BLException {
		return vcd06DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VCD06Info updateVCD06(VCD06Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return vcd06DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVCD06ByPK(Integer pk) throws BLException {
		vcd06DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVCD06(VCD06Info instance) throws BLException {
		vcd06DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VCD06Info checkExistInstance(Integer pk)
		throws BLException {
		VCD06Info instance = vcd06DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}