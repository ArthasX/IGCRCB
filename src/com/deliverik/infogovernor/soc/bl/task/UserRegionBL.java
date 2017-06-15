/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.UserRegionInfo;
import com.deliverik.infogovernor.soc.model.condition.UserRegionSearchCond;
import com.deliverik.infogovernor.soc.model.entity.UserRegionTB;

/**
  * ����: UserRegionҵ���߼��ӿ�
  * ��������: UserRegionҵ���߼��ӿ�
  * ������¼: 2014/01/10
  * �޸ļ�¼: 
  */
public interface UserRegionBL extends BaseBL {

	/**
	 * UserRegionʵ��ȡ��
	 *
	 * @return UserRegionʵ��
	 */
	public UserRegionTB getUserRegionTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<UserRegionInfo> searchUserRegion();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public UserRegionInfo searchUserRegionByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(UserRegionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<UserRegionInfo> searchUserRegion(
			UserRegionSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public UserRegionInfo registUserRegion(UserRegionInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public UserRegionInfo updateUserRegion(UserRegionInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteUserRegionByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteUserRegion(UserRegionInfo instance)
		throws BLException;

}