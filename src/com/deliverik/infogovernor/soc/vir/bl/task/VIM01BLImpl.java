/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM01SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM01DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM01TB;

/**
  * ����: vCenter ServiceInstanceҵ���߼�ʵ��
  * ��������: vCenter ServiceInstanceҵ���߼�ʵ��
  * ������¼: 2014/02/12
  * �޸ļ�¼: 
  */
public class VIM01BLImpl extends BaseBLImpl implements
		VIM01BL {

	/** vCenter ServiceInstanceDAO�ӿ� */
	protected VIM01DAO vim01DAO;
	
	/**
	 * vCenter ServiceInstanceDAO�ӿ��趨
	 *
	 * @param vIM01DAO vCenter ServiceInstanceDAO�ӿ�
	 */
	public void setVim01DAO(VIM01DAO vim01DAO) {
		this.vim01DAO = vim01DAO;
	}

	/**
	 * vCenter ServiceInstanceʵ��ȡ��
	 *
	 * @return vCenter ServiceInstanceʵ��
	 */
	public VIM01TB getVIM01TBInstance() {
		return new VIM01TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM01Info> searchVIM01() {
		return vim01DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM01Info searchVIM01ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM01SearchCond cond) {
		return vim01DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM01Info> searchVIM01(
			VIM01SearchCond cond) {
		return vim01DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM01Info> searchVIM01(
			VIM01SearchCond cond, int start,
			int count) {
		return vim01DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM01Info registVIM01(VIM01Info instance)
		throws BLException {
		return vim01DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM01Info updateVIM01(VIM01Info instance)
		throws BLException {
		checkExistInstance(instance.getVcid());
		return vim01DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVIM01ByPK(Integer pk)
		throws BLException {
		vim01DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVIM01(VIM01Info instance)
		throws BLException {
		vim01DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VIM01Info checkExistInstance(Integer pk)
		throws BLException {
		VIM01Info instance = vim01DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}