/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM07Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM07SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM07DAO;

/**
  * ����: ���������Ϣ��ҵ���߼�ʵ��
  * ��������: ���������Ϣ��ҵ���߼�ʵ��
  * ������¼: 2014/03/24
  * �޸ļ�¼: 
  */
public class VIM07BLImpl extends BaseBLImpl implements
		VIM07BL {

	/** ���������Ϣ��DAO�ӿ� */
	protected VIM07DAO vim07DAO;
	
	/**
	 * ���������Ϣ��DAO�ӿ��趨
	 *
	 * @param vim07DAO ���������Ϣ��DAO�ӿ�
	 */
	public void setVim07DAO(VIM07DAO vim07DAO) {
		this.vim07DAO = vim07DAO;
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM07Info searchVim07ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM07SearchCond cond) {
		return vim07DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM07Info> searchVim07(VIM07SearchCond cond) {
		return vim07DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM07Info> searchVim07(VIM07SearchCond cond, int start, int count) {
		return vim07DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM07Info registVim07(VIM07Info instance) throws BLException {
		return vim07DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM07Info updateVim07(VIM07Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return vim07DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVim07ByPK(Integer pk) throws BLException {
		vim07DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVim07(VIM07Info instance) throws BLException {
		vim07DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VIM07Info checkExistInstance(Integer pk) throws BLException {
		VIM07Info instance = vim07DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}