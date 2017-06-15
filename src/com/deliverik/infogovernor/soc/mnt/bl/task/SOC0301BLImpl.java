/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0301SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.SOC0301DAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0301TB;

/**
  * ����: DMXʵʱ������ܱ�ҵ���߼�ʵ��
  * ��������: DMXʵʱ������ܱ�ҵ���߼�ʵ��
  * ������¼: 2012/05/16
  * �޸ļ�¼: 
  */
public class SOC0301BLImpl extends BaseBLImpl implements
		SOC0301BL {

	/** DMXʵʱ������ܱ�DAO�ӿ� */
	protected SOC0301DAO soc0301DAO;
	

	/**
	 * DMXʵʱ������ܱ�DAO�ӿ��趨
	 *
	 * @param soc0301DAO DMXʵʱ������ܱ�DAO�ӿ�
	 */
	public void setSoc0301DAO(SOC0301DAO soc0301DAO) {
		this.soc0301DAO = soc0301DAO;
	}

	/**
	 * DMXʵʱ������ܱ�ʵ��ȡ��
	 *
	 * @return DMXʵʱ������ܱ�ʵ��
	 */
	public SOC0301TB getSoc0301Instance() {
		return new SOC0301TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0301Info> searchSoc0301() {
		return soc0301DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0301Info searchSoc0301ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0301SearchCond cond) {
		return soc0301DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0301Info> searchSoc0301(
			SOC0301SearchCond cond) {
		return soc0301DAO.findByCond(cond, 0, 0);
	}
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0301Info> searchSoc0301OrderByTimeAndName(
			SOC0301SearchCond cond) {
		return soc0301DAO.findByCondOrderByTimeAndName(cond, 0, 0);
	}
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0301Info> searchSoc0301(
			SOC0301SearchCond cond, int start,
			int count) {
		return soc0301DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0301Info registSoc0301(SOC0301Info instance)
		throws BLException {
		return soc0301DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0301Info updateSoc0301(SOC0301Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return soc0301DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSoc0301ByPK(Integer pk)
		throws BLException {
		soc0301DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSoc0301(SOC0301Info instance)
		throws BLException {
		soc0301DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0301Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0301Info instance = soc0301DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}



}