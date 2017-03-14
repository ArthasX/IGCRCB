/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.drm.model.SigninInfo;
import com.deliverik.infogovernor.drm.model.condition.SigninSearchCond;
import com.deliverik.infogovernor.drm.model.entity.SigninTB;

/**
  * ����: ǩ����ҵ���߼��ӿ�
  * ��������: ǩ����ҵ���߼��ӿ�
  * ������¼: 2015/03/12
  * �޸ļ�¼: 
  */
public interface SigninBL extends BaseBL {

	/**
	 * ǩ����ʵ��ȡ��
	 *
	 * @return ǩ����ʵ��
	 */
	public SigninTB getSigninTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SigninInfo> searchSignin();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SigninInfo searchSigninByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SigninSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SigninInfo> searchSignin(
			SigninSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SigninInfo> searchSignin(
			SigninSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SigninInfo registSignin(SigninInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SigninInfo updateSignin(SigninInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSigninByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSignin(SigninInfo instance)
		throws BLException;
	/**
	 * ��ȡǩ��������
	 *
	 * @return List<UserRoleInfo> 
	 */
	public List<UserRoleInfo> searchUserRoleVW(String pdid) ;
	
	/**
	 * ��ȡ��ϳ����еĲ�����Ա��Ϣ
	 * @param pgdid �����鶨��id
	 * @return
	 * @throws BLException
	 */
	public List<UserRoleInfo> searchPgUserRoleVW(String pgdid)throws BLException;
	/**
	 * ǩ����Ϣ���
	 * drillprid����prid,ecpridָ��prid,sceneprid����prid,wdc_wdpָ�Ӻͳ�����ʶ,
	 * List<UserRoleInfo> userroleInfoList �������Ա����
	 * ע��wdc_wdp ��ʶΪ��д��WDC������WDP��
	 */
	public void rigisterSignin(String drillprid,String ecprid,String sceneprid,String wdc_wdp, List<UserRoleInfo> userroleInfoList);
	/**
	 * ǩ����Ϣ��ѯ
	 * @param �û�id
	 * @param ����prid
	 * @param �Ƿ������� true ��
	 */
	public List<Map<String,Object>> searchSignInList(String userid,Integer prid,boolean isDrill) throws BLException;
	
	/**
	 * ������������prid ����Ӧ��ָ������prid ��ǩ������
	 * @param drillPrid
	 * @param directPrid
	 * @throws BLException
	 */
	public boolean setDirectPrid(Integer drillPrid,Integer directPrid)throws BLException;
	/**
	 * ����ǩ�����г�������prid
	 * @param directPrid ָ������prid
	 * @param scenePrid ��������prid
	 * @return
	 */
	public int setScenePrid(Integer directPrid,Integer scenePrid)throws BLException;
	/**
	 * ָ�����̳�����ѡ������ز���
	 */
	public void resetSenceUser(Integer ecprid)throws BLException;
	/**
	 * dashboard ��Ա��Ϣ��ʼ����Ϣ
	 */
	public List<Map<String,Object>> searchSigninInitData(Integer ecprid);
	
	/**
	 * @description ��ʼ��ǩ����
	 * @param drillprid ����prid
	 * @param ecprid    ָ��prid
	 * @param sceneprid ����prid
	 * @param wdc_wdp   wdc:ָ��ǩ����  wdp:����ǩ����
	 * @param userroleInfoList ������list
	 */
	public void registerSigninInfo(Integer drillprid,Integer ecprid,Integer sceneprid,String wdc_wdp,List<UserRoleInfo> userroleInfoList)throws BLException;
	
	/**
	 * @description ���³����Ĳ������ڹ�����ָ���������Ѵ��ڵ�ǩ����
	 * @param sceneprid        ����prid
	 * @param signinInfoList   �Ѵ��ڵĳ�����ǩ����
	 */
	public void updateSigninInfo(Integer sceneprid,List<SigninInfo> signinInfoList);
	
	/**
	 * ��ȡ��������Ϣ
	 *
	 * @return List<UserRoleInfo> 
	 */
	public List<UserRoleInfo> searchUserRoleInfoList(String pdid);
	
	/**
	 * �����������̸���ָ�����̵�id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForEcp(Integer drillprid, Integer ecprid);
	
	/**
	 * �����������̸��¼����ָ����̵�id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForRestore(Integer drillprid, Integer restorePrid);
	
	/**
	 * ����ָ�����̸��¼����ָ����̵�id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForRestoreByDirectPrid(Integer directPrid, Integer restorePrid);

	/**
	 * ��ѯ������
	 * 
	 * @param ecprid
	 * @return
	 */
	public List<Map<String,Object>> searchSigninPeopleDataByCond(Integer ecprid);
}