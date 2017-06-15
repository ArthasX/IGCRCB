/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;

/**
  * ����: ��Դ���������Ϣ��ҵ���߼�ʵ��
  * ��������: ��Դ���������Ϣ��ҵ���߼�ʵ��
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public class VIM03BLImpl extends BaseBLImpl implements
		VIM03BL {

	/** ��Դ���������Ϣ��DAO�ӿ� */
	protected VIM03DAO vim03DAO;
	
	/**
	 * ��Դ���������Ϣ��DAO�ӿ��趨
	 *
	 * @param vim03DAO ��Դ���������Ϣ��DAO�ӿ�
	 */
	public void setVim03DAO(VIM03DAO vim03DAO) {
		this.vim03DAO = vim03DAO;
	}

	/**
	 * ��Դ���������Ϣ��ʵ��ȡ��
	 *
	 * @return ��Դ���������Ϣ��ʵ��
	 */
	public VIM03TB getVim03TBInstance() {
		return new VIM03TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VIM03Info> searchVim03() {
		return vim03DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VIM03Info searchVim03ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Vim03SearchCond cond) {
		return vim03DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03Info> searchVim03(
			Vim03SearchCond cond) {
		return vim03DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VIM03Info> searchVim03(
			Vim03SearchCond cond, int start,
			int count) {
		
		return vim03DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public VIM03Info registVim03(VIM03Info instance)
		throws BLException {
		return vim03DAO.save(instance);
	}
	
	/**
	 * ������������
	 * 
	 * @param vim03InfoList
	 * @throws BLException
	 */
	public void  registVim03All(List<VIM03Info> vim03InfoList) throws BLException {
	    vim03DAO.saveOrUpdateAll(vim03InfoList);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public VIM03Info updateVim03(VIM03Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim03DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteVim03ByPK(Integer pk)
		throws BLException {
		vim03DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteVim03(VIM03Info instance)
		throws BLException {
		vim03DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public VIM03Info checkExistInstance(Integer pk)
		throws BLException {
		VIM03Info instance = vim03DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * ��ȡ������ÿ������������
	 * @param sDate
	 * @return List<Object[]> Obj[0]>orgname;Obj[1]>Orgsyscoding;Obj[2]>count;Obj[3]>Month
	 */
	public List<Object[]> getOrgCountByMonth(String sDate)throws BLException{
		return vim03DAO.getOrgCountByMonth(sDate);
	}
	
	/**
     * ��ѯһ�������ڵ���Դ��������
     * 
     * @param sDate
     * @return
     */
    public List<Object[]> getOrgCount(String sDate) throws BLException {
        return vim03DAO.getOrgCount(sDate);
    }
    
    /**
     * ��������ȡ��
     *
     * @param cond ��������
     * @return ��������
     */
    public Integer  getVMCount4HostCountByCond(Vim03SearchCond cond) throws BLException {
        return vim03DAO.getVMCount4HostCountByCond(cond);
    }
    
    /**
     * ��ȡ����������ĸ���
     *
     * @param cond ��������
     * @return ��������б�
     */
    public List<Object[]> getVMCount4HostByCond(Vim03SearchCond cond, int start, int count) throws BLException {
        return vim03DAO.getVMCount4HostByCond(cond, start, count);
    }
}