/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM06SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM06DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM06TB;

/**
  * ����: vim06ҵ���߼�ʵ��
  * ��������: vim06ҵ���߼�ʵ��
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
public class VIM06BLImpl extends BaseBLImpl implements
		VIM06BL {

	/** vim06DAO�ӿ� */
	protected VIM06DAO vim06DAO;
	
	/**
	 * vim06DAO�ӿ��趨
	 *
	 * @param vim06DAO vim06DAO�ӿ�
	 */
	public void setVim06DAO(VIM06DAO vim06DAO) {
		this.vim06DAO = vim06DAO;
	}

	/**
	 * vim06ʵ��ȡ��
	 *
	 * @return vim06ʵ��
	 */
	public VIM06TB getVim06TBInstance() {
		return new VIM06TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM06Info> searchVim06() {
		return vim06DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM06Info searchVim06ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM06SearchCond cond) {
		return vim06DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM06Info> searchVim06(
			VIM06SearchCond cond) {
		return vim06DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM06Info> searchVim06(
			VIM06SearchCond cond, int start,
			int count) {
		return vim06DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM06Info registVim06(VIM06Info instance)
		throws BLException {
		return vim06DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM06Info updateVim06(VIM06Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim06DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVim06ByPK(Integer pk)
		throws BLException {
		vim06DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVim06(VIM06Info instance)
		throws BLException {
		vim06DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VIM06Info checkExistInstance(Integer pk)
		throws BLException {
		VIM06Info instance = vim06DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}



}