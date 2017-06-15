/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM02SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM02DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM02TB;

/**
  * ����: ������Դ��Ŀ��Ϣ��ҵ���߼�ʵ��
  * ��������: ������Դ��Ŀ��Ϣ��ҵ���߼�ʵ��
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public class VIM02BLImpl extends BaseBLImpl implements
		VIM02BL {

	/** ������Դ��Ŀ��Ϣ��DAO�ӿ� */
	protected VIM02DAO vim02DAO;
	
	/**
     * ����������Դ��Ŀ��Ϣ��DAO�ӿ�
     * @param vim02DAO ������Դ��Ŀ��Ϣ��DAO�ӿ�
     */
    public void setVim02DAO(VIM02DAO vim02dao) {
        vim02DAO = vim02dao;
    }

    /**
	 * ������Դ��Ŀ��Ϣ��ʵ��ȡ��
	 *
	 * @return ������Դ��Ŀ��Ϣ��ʵ��
	 */
	public VIM02TB getVIM02TBInstance() {
		return new VIM02TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM02Info> searchVIM02() {
		return vim02DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM02Info searchVIM02ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VIM02SearchCond cond) {
		return vim02DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM02Info> searchVIM02(
			VIM02SearchCond cond) {
		return vim02DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM02Info> searchVIM02(
			VIM02SearchCond cond, int start,
			int count) {
		return vim02DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM02Info registVIM02(VIM02Info instance)
		throws BLException {
		return vim02DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM02Info updateVIM02(VIM02Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim02DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVIM02ByPK(Integer pk)
		throws BLException {
		vim02DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVIM02(VIM02Info instance)
		throws BLException {
		vim02DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VIM02Info checkExistInstance(Integer pk)
		throws BLException {
		VIM02Info instance = vim02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}