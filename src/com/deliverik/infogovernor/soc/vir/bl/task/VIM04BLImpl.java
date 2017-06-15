/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM04Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM04SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM04DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM04TB;

/**
  * ����: ��־��ҵ���߼�ʵ��
  * ��������: ��־��ҵ���߼�ʵ��
  * ������¼: 2014/02/19
  * �޸ļ�¼: 
  */
public class VIM04BLImpl extends BaseBLImpl implements
		VIM04BL {

	/** ��־��DAO�ӿ� */
	protected VIM04DAO vim04DAO;
	
	/**
     * ������־��DAO�ӿ�
     * @param vim04DAO ��־��DAO�ӿ�
     */
    public void setVim04DAO(VIM04DAO vim04dao) {
        vim04DAO = vim04dao;
    }

    /**
	 * ��־��ʵ��ȡ��
	 *
	 * @return ��־��ʵ��
	 */
	public VIM04TB getVIM04TBInstance() {
		return new VIM04TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM04Info> searchVIM04() {
		return vim04DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM04Info searchVIM04ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM04SearchCond cond) {
		return vim04DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM04Info> searchVIM04(
			VIM04SearchCond cond) {
		return vim04DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM04Info> searchVIM04(
			VIM04SearchCond cond, int start,
			int count) {
		return vim04DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM04Info registVIM04(VIM04Info instance)
		throws BLException {
		return vim04DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM04Info updateVIM04(VIM04Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim04DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVIM04ByPK(Integer pk)
		throws BLException {
		vim04DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVIM04(VIM04Info instance)
		throws BLException {
		vim04DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VIM04Info checkExistInstance(Integer pk)
		throws BLException {
		VIM04Info instance = vim04DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}