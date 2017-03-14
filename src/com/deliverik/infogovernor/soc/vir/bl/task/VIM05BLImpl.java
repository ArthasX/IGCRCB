/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM05SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM05DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM05TB;

/**
  * ����: vim05ҵ���߼�ʵ��
  * ��������: vim05ҵ���߼�ʵ��
  * ������¼: 2014/02/21
  * �޸ļ�¼: 
  */
public class VIM05BLImpl extends BaseBLImpl implements
		VIM05BL {

	/** vim05DAO�ӿ� */
	protected VIM05DAO vim05DAO;
	
	/**
	 * vim05DAO�ӿ��趨
	 *
	 * @param vim05DAO vim05DAO�ӿ�
	 */
	public void setVim05DAO(VIM05DAO vim05DAO) {
		this.vim05DAO = vim05DAO;
	}

	/**
	 * vim05ʵ��ȡ��
	 *
	 * @return vim05ʵ��
	 */
	public VIM05TB getVim05TBInstance() {
		return new VIM05TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM05Info> searchVim05() {
		return vim05DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM05Info searchVim05ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM05SearchCond cond) {
		return vim05DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM05Info> searchVim05(
			VIM05SearchCond cond) {
		return vim05DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM05Info> searchVim05(
			VIM05SearchCond cond, int start,
			int count) {
		return vim05DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM05Info registVim05(VIM05Info instance)
		throws BLException {
		return vim05DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM05Info updateVim05(VIM05Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim05DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVim05ByPK(Integer pk)
		throws BLException {
		vim05DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVim05(VIM05Info instance)
		throws BLException {
		vim05DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VIM05Info checkExistInstance(Integer pk)
		throws BLException {
		VIM05Info instance = vim05DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}