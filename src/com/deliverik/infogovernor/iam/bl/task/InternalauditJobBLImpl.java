/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditJobSearchCond;
import com.deliverik.infogovernor.iam.model.dao.InternalauditJobDAO;
import com.deliverik.infogovernor.iam.model.entity.InternalauditJobTB;

/**
  * ����: ���ù�����ҵ���߼�ʵ��
  * ��������: ���ù�����ҵ���߼�ʵ��
  * ������¼: 2012/07/25
  * �޸ļ�¼: 
  */
public class InternalauditJobBLImpl extends BaseBLImpl implements
		InternalauditJobBL {

	/** ���ù�����DAO�ӿ� */
	protected InternalauditJobDAO internalauditJobDAO;
	
	/**
	 * ���ù�����DAO�ӿ��趨
	 *
	 * @param internalauditJobDAO ���ù�����DAO�ӿ�
	 */
	public void setInternalauditJobDAO(InternalauditJobDAO internalauditJobDAO) {
		this.internalauditJobDAO = internalauditJobDAO;
	}

	/**
	 * ���ù�����ʵ��ȡ��
	 *
	 * @return ���ù�����ʵ��
	 */
	public InternalauditJobTB getInternalauditJobTBInstance() {
		return new InternalauditJobTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InternalauditJobInfo> searchInternalauditJob() {
		return internalauditJobDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InternalauditJobInfo searchInternalauditJobByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(InternalauditJobSearchCond cond) {
		return internalauditJobDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<InternalauditJobInfo> searchInternalauditJob(
			InternalauditJobSearchCond cond) {
		return internalauditJobDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InternalauditJobInfo> searchInternalauditJob(
			InternalauditJobSearchCond cond, int start,
			int count) {
		return internalauditJobDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public InternalauditJobInfo registInternalauditJob(InternalauditJobInfo instance)
		throws BLException {
		return internalauditJobDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public InternalauditJobInfo updateInternalauditJob(InternalauditJobInfo instance)
		throws BLException {
		checkExistInstance(instance.getIajid());
		return internalauditJobDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteInternalauditJobByPK(Integer pk)
		throws BLException {
		internalauditJobDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteInternalauditJob(InternalauditJobInfo instance)
		throws BLException {
		internalauditJobDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public InternalauditJobInfo checkExistInstance(Integer pk)
		throws BLException {
		InternalauditJobInfo instance = internalauditJobDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}