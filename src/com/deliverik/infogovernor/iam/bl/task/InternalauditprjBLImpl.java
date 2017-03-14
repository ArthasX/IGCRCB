/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditprjSearchCond;
import com.deliverik.infogovernor.iam.model.dao.InternalauditprjDAO;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
  * ����: ������Ŀҵ���߼�ʵ��
  * ��������: ������Ŀҵ���߼�ʵ��
  * ������¼: 2012/07/19
  * �޸ļ�¼: 
  */
public class InternalauditprjBLImpl extends BaseBLImpl implements
		InternalauditprjBL {

	/** ������ĿDAO�ӿ� */
	protected InternalauditprjDAO internalauditprjDAO;
	
	/**
	 * ������ĿDAO�ӿ��趨
	 *
	 * @param internalauditprjDAO ������ĿDAO�ӿ�
	 */
	public void setInternalauditprjDAO(InternalauditprjDAO internalauditprjDAO) {
		this.internalauditprjDAO = internalauditprjDAO;
	}

	/**
	 * ������Ŀʵ��ȡ��
	 *
	 * @return ������Ŀʵ��
	 */
	public InternalauditprjTB getInternalauditprjTBInstance() {
		return new InternalauditprjTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InternalauditprjInfo> searchInternalauditprj() {
		return internalauditprjDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InternalauditprjInfo searchInternalauditprjByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(InternalauditprjSearchCond cond) {
		return internalauditprjDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<InternalauditprjInfo> searchInternalauditprj(
			InternalauditprjSearchCond cond) {
		return internalauditprjDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InternalauditprjInfo> searchInternalauditprj(
			InternalauditprjSearchCond cond, int start,
			int count) {
		return internalauditprjDAO.findByCond(cond, start, count);
	}
	
	public List<InternalauditprjInfo> auditProjectHelpSearch(
			InternalauditprjSearchCond cond, int start,
			int count) {
		return internalauditprjDAO.auditProjectHelpSearch(cond, start, count);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int auditProjectHelpSearchConut(final InternalauditprjSearchCond cond){
		return internalauditprjDAO.auditProjectHelpSearchConut(cond);
	}
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public InternalauditprjInfo registInternalauditprj(InternalauditprjInfo instance)
		throws BLException {
		return internalauditprjDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public InternalauditprjInfo updateInternalauditprj(InternalauditprjInfo instance)
		throws BLException {
		checkExistInstance(instance.getIapId());
		return internalauditprjDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteInternalauditprjByPK(Integer pk)
		throws BLException {
		internalauditprjDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteInternalauditprj(InternalauditprjInfo instance)
		throws BLException {
		internalauditprjDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public InternalauditprjInfo checkExistInstance(Integer pk)
		throws BLException {
		InternalauditprjInfo instance = internalauditprjDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}