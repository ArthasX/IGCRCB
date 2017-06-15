/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;
import com.deliverik.infogovernor.prr.model.entity.CopyReadUserTB;

/**
  * ����: �����˱�ҵ���߼��ӿ�
  * ��������: �����˱�ҵ���߼��ӿ�
  * ������¼: 2013/02/25
  * �޸ļ�¼: 
  */
public interface CopyReadUserBL extends BaseBL {

	/**
	 * �����˱�ʵ��ȡ��
	 *
	 * @return �����˱�ʵ��
	 */
	public CopyReadUserTB getCopyReadUserTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CopyReadUserInfo> searchCopyReadUser();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CopyReadUserInfo searchCopyReadUserByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CopyReadUserSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CopyReadUserInfo> searchCopyReadUser(
			CopyReadUserSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CopyReadUserInfo registCopyReadUser(CopyReadUserInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CopyReadUserInfo updateCopyReadUser(CopyReadUserInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCopyReadUserByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCopyReadUser(CopyReadUserInfo instance)
		throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public List<CopyReadUserInfo> getCopyReadUserInfo(
			final CopyReadUserSearchCond cond, final int start,final int count);
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public int getCopyReadUserCount( final CopyReadUserSearchCond cond) ;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public List<CopyReadUserInfo> getCopyReadUserInfoDesc(final CopyReadUserSearchCond cond, final int start,final int count);
}