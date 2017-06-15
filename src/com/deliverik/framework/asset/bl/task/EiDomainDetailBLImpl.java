/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.EiDomainDetailInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailSearchCond;
import com.deliverik.framework.asset.model.dao.EiDomainDetailDAO;
import com.deliverik.framework.asset.model.entity.EiDomainDetailPK;
import com.deliverik.framework.asset.model.entity.EiDomainDetailTB;

/**
  * ����: �ʲ�����ϸ��ҵ���߼�ʵ��
  * ��������: �ʲ�����ϸ��ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class EiDomainDetailBLImpl extends BaseBLImpl implements
		EiDomainDetailBL {

	/** �ʲ�����ϸ��DAO�ӿ� */
	protected EiDomainDetailDAO eiDomainDetailDAO;
	
	/**
	 * �ʲ�����ϸ��DAO�ӿ��趨
	 *
	 * @param eiDomainDetailDAO�ʲ�����ϸ��DAO�ӿ�
	 */
	public void setEiDomainDetailDAO(EiDomainDetailDAO eiDomainDetailDAO) {
		this.eiDomainDetailDAO = eiDomainDetailDAO;
	}

	/**
	 * �ʲ�����ϸ��ʵ��ȡ��
	 *
	 * @return �ʲ�����ϸ��ʵ��
	 */
	public EiDomainDetailTB getEiDomainDetailTBInstance() {
		return new EiDomainDetailTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetail() {
		return eiDomainDetailDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public EiDomainDetailInfo searchEiDomainDetailByPK(EiDomainDetailPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiDomainDetailSearchCond cond) {
		return eiDomainDetailDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetail(
			EiDomainDetailSearchCond cond) {
		return eiDomainDetailDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetail(
			EiDomainDetailSearchCond cond, int start,
			int count) {
		return eiDomainDetailDAO.findBySQL(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public EiDomainDetailInfo registEiDomainDetail(EiDomainDetailInfo instance)
		throws BLException {
		return eiDomainDetailDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiDomainDetailInfo updateEiDomainDetail(EiDomainDetailInfo instance)
		throws BLException {
		checkExistInstance(new EiDomainDetailPK(instance.getEiddid(), instance.getEiddversion(), instance.getEiname(),instance.getEiImportversion()));
		return eiDomainDetailDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiDomainDetailByPK(EiDomainDetailPK pk)
		throws BLException {
		eiDomainDetailDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiDomainDetail(EiDomainDetailInfo instance)
		throws BLException {
		eiDomainDetailDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public EiDomainDetailInfo checkExistInstance(EiDomainDetailPK pk)
		throws BLException {
		EiDomainDetailInfo instance = eiDomainDetailDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}