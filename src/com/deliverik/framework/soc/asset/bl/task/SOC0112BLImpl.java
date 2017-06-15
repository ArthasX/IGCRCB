/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0112DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;

/**
  * ����: �ʲ�����ϸ��ҵ���߼�ʵ��
  * ��������: �ʲ�����ϸ��ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class SOC0112BLImpl extends BaseBLImpl implements
		SOC0112BL {

	/** �ʲ�����ϸ��DAO�ӿ� */
	protected SOC0112DAO soc0112DAO;
	


	/**
	 * �ʲ�����ϸ��DAO�ӿ��趨
	 *
	 * @param soc0112DAO �ʲ�����ϸ��DAO�ӿ�
	 */
	public void setSoc0112DAO(SOC0112DAO soc0112DAO) {
		this.soc0112DAO = soc0112DAO;
	}

	/**
	 * �ʲ�����ϸ��ʵ��ȡ��
	 *
	 * @return �ʲ�����ϸ��ʵ��
	 */
	public SOC0112TB getEiDomainDetailTBInstance() {
		return new SOC0112TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0112Info> searchEiDomainDetail() {
		return soc0112DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0112Info searchEiDomainDetailByPK(SOC0112PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0112SearchCond cond) {
		return soc0112DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0112Info> searchEiDomainDetail(
			SOC0112SearchCond cond) {
		return soc0112DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0112Info> searchEiDomainDetail(
			SOC0112SearchCond cond, int start,
			int count) {
		return soc0112DAO.findBySQL(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0112Info registEiDomainDetail(SOC0112Info instance)
		throws BLException {
		return soc0112DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0112Info updateEiDomainDetail(SOC0112Info instance)
		throws BLException {
		checkExistInstance(new SOC0112PK(instance.getEiddid(), instance.getEiddversion(), instance.getEiname(),instance.getEiImportversion()));
		return soc0112DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiDomainDetailByPK(SOC0112PK pk)
		throws BLException {
		soc0112DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiDomainDetail(SOC0112Info instance)
		throws BLException {
		soc0112DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SOC0112Info checkExistInstance(SOC0112PK pk)
		throws BLException {
		SOC0112Info instance = soc0112DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}