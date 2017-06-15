/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;
import com.deliverik.infogovernor.prr.model.dao.CopyReadUserDAO;
import com.deliverik.infogovernor.prr.model.entity.CopyReadUserTB;

/**
  * ����: �����˱�ҵ���߼�ʵ��
  * ��������: �����˱�ҵ���߼�ʵ��
  * ������¼: 2013/02/25
  * �޸ļ�¼: 
  */
public class CopyReadUserBLImpl extends BaseBLImpl implements
		CopyReadUserBL {

	/** �����˱�DAO�ӿ� */
	protected CopyReadUserDAO copyReadUserDAO;
	
	/**
	 * �����˱�DAO�ӿ��趨
	 *
	 * @param copyReadUserDAO �����˱�DAO�ӿ�
	 */
	public void setCopyReadUserDAO(CopyReadUserDAO copyReadUserDAO) {
		this.copyReadUserDAO = copyReadUserDAO;
	}

	/**
	 * �����˱�ʵ��ȡ��
	 *
	 * @return �����˱�ʵ��
	 */
	public CopyReadUserTB getCopyReadUserTBInstance() {
		return new CopyReadUserTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CopyReadUserInfo> searchCopyReadUser() {
		return copyReadUserDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CopyReadUserInfo searchCopyReadUserByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CopyReadUserSearchCond cond) {
		return copyReadUserDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CopyReadUserInfo> searchCopyReadUser(
			CopyReadUserSearchCond cond) {
		return copyReadUserDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CopyReadUserInfo> searchCopyReadUser(
			CopyReadUserSearchCond cond, int start,
			int count) {
		return copyReadUserDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CopyReadUserInfo registCopyReadUser(CopyReadUserInfo instance)
		throws BLException {
		return copyReadUserDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CopyReadUserInfo updateCopyReadUser(CopyReadUserInfo instance)
		throws BLException {
		checkExistInstance(instance.getCruid());
		return copyReadUserDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCopyReadUserByPK(Integer pk)
		throws BLException {
		copyReadUserDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCopyReadUser(CopyReadUserInfo instance)
		throws BLException {
		copyReadUserDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CopyReadUserInfo checkExistInstance(Integer pk)
		throws BLException {
		CopyReadUserInfo instance = copyReadUserDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public int getCopyReadUserCount(CopyReadUserSearchCond cond) {
		
		return copyReadUserDAO.getCopyReadUserCount(cond);
	}

	public List<CopyReadUserInfo> getCopyReadUserInfo(
			CopyReadUserSearchCond cond, int start, int count) {
		
		return copyReadUserDAO.getCopyReadUserInfo(cond, start, count);
	}

	public List<CopyReadUserInfo> getCopyReadUserInfoDesc(
			CopyReadUserSearchCond cond, int start, int count) {
		
		return copyReadUserDAO.getCopyReadUserInfoDesc(cond, start, count);
	}

}