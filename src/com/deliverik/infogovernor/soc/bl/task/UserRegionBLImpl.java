/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.model.UserRegionInfo;
import com.deliverik.infogovernor.soc.model.condition.UserRegionSearchCond;
import com.deliverik.infogovernor.soc.model.dao.UserRegionDAO;
import com.deliverik.infogovernor.soc.model.entity.UserRegionTB;

/**
  * ����: UserRegionҵ���߼�ʵ��
  * ��������: UserRegionҵ���߼�ʵ��
  * ������¼: 2014/01/10
  * �޸ļ�¼: 
  */
public class UserRegionBLImpl extends BaseBLImpl implements
		UserRegionBL {

	/** UserRegionDAO�ӿ� */
	protected UserRegionDAO userRegionDAO;
	
	/**
	 * UserRegionDAO�ӿ��趨
	 *
	 * @param userRegionDAO UserRegionDAO�ӿ�
	 */
	public void setUserRegionDAO(UserRegionDAO userRegionDAO) {
		this.userRegionDAO = userRegionDAO;
	}

	/**
	 * UserRegionʵ��ȡ��
	 *
	 * @return UserRegionʵ��
	 */
	public UserRegionTB getUserRegionTBInstance() {
		return new UserRegionTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<UserRegionInfo> searchUserRegion() {
		return userRegionDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public UserRegionInfo searchUserRegionByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(UserRegionSearchCond cond) {
		return userRegionDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<UserRegionInfo> searchUserRegion(
			UserRegionSearchCond cond) {
		return userRegionDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<UserRegionInfo> searchUserRegion(
			UserRegionSearchCond cond, int start,
			int count) {
		return userRegionDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public UserRegionInfo registUserRegion(UserRegionInfo instance)
		throws BLException {
		return userRegionDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public UserRegionInfo updateUserRegion(UserRegionInfo instance)
		throws BLException {
		checkExistInstance(instance.getID());
		return userRegionDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteUserRegionByPK(Integer pk)
		throws BLException {
		userRegionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteUserRegion(UserRegionInfo instance)
		throws BLException {
		userRegionDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public UserRegionInfo checkExistInstance(Integer pk)
		throws BLException {
		UserRegionInfo instance = userRegionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}