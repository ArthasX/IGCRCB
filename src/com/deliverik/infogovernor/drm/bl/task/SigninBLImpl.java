/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.dao.UserRoleVWDAO;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG222DAO;
import com.deliverik.framework.workflow.prd.model.dao.IG481DAO;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.model.SigninInfo;
import com.deliverik.infogovernor.drm.model.condition.SigninSearchCond;
import com.deliverik.infogovernor.drm.model.condition.SigninSearchCondImpl;
import com.deliverik.infogovernor.drm.model.dao.SigninDAO;
import com.deliverik.infogovernor.drm.model.entity.SigninTB;

/**
  * ����: ǩ����ҵ���߼�ʵ��
  * ��������: ǩ����ҵ���߼�ʵ��
  * ������¼: 2015/03/12
  * zyl 
  */
public class SigninBLImpl extends BaseBLImpl implements
		SigninBL {

	/** ǩ����DAO�ӿ� */
	protected SigninDAO signinDAO;
	/** ig222DAO�ӿ� */
	protected IG222DAO ig222DAO;
	/** userrolevwDAO�ӿ� */
	protected UserRoleVWDAO userRoleVWDAO;
	/***�������Ա*/
	protected IG481DAO ig481DAO;
	
	
	
	public void setIg481DAO(IG481DAO ig481dao) {
		ig481DAO = ig481dao;
	}

	/**
	 * ǩ����DAO�ӿ��趨
	 *
	 * @param signinDAO ǩ����DAO�ӿ�
	 */
	public void setSigninDAO(SigninDAO signinDAO) {
		this.signinDAO = signinDAO;
	}

	public void setIg222DAO(IG222DAO ig222dao) {
		ig222DAO = ig222dao;
	}


	public void setUserRoleVWDAO(UserRoleVWDAO userRoleVWDAO) {
		this.userRoleVWDAO = userRoleVWDAO;
	}

	/**
	 * ǩ����ʵ��ȡ��
	 *
	 * @return ǩ����ʵ��
	 */
	public SigninTB getSigninTBInstance() {
		return new SigninTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SigninInfo> searchSignin() {
		return signinDAO.findAll();
	}
	/**
	 * ��ȡǩ��������
	 *
	 * @return List<UserRoleInfo> 
	 */
	public List<UserRoleInfo> searchUserRoleVW(String pdid) {
		//����ǩ�������˼���
		 Set<UserRoleInfo> userRoleVWSet = new HashSet<UserRoleInfo>();
			//��ȡ���г������̵Ĳ�����
			IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
			ig222cond.setPpdid_like(pdid);
			List<IG222Info> ig222InfoList = ig222DAO.findByCond(ig222cond,0,0);
			//��ȡ���н�ɫid
			for(IG222Info ig222info:ig222InfoList){//for1
				//��ɫָ�����˵����
				if(ig222info.getUserid()!=null&&!"".equals(ig222info.getUserid().trim())){//if1
				UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
				urcond.setUserid(ig222info.getUserid());
				urcond.setRoleid(ig222info.getRoleid());
				urcond.setRoletype(IGDRMCONSTANTS.SP_ROLE_TYPE);
				List<UserRoleInfo> userRoleInfoList =  userRoleVWDAO.findByCond(urcond, 0, 0);
				//��Ӵ��˵Ľ�ɫ
				if(userRoleInfoList.size()>0){//if2
					userRoleVWSet.add(userRoleInfoList.get(0));
				}//end if2
				}//end if1
				else{//if1��else,ָ������ɫ�����
					UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
					urcond.setRoleid(ig222info.getRoleid());
					List<UserRoleInfo> userRoleList =  userRoleVWDAO.findByCond(urcond, 0, 0);
					//��ӽ�ɫ�������û�
					for(UserRoleInfo userrole:userRoleList){
						userRoleVWSet.add(userrole);
					}
				}	
			}
		//��ȡȥ�غ�������û�
		List<UserRoleInfo> userRoleVWList = new ArrayList<UserRoleInfo>(userRoleVWSet);

		return userRoleVWList;
	}
	
	/**
	 * ��ȡ��ϳ����еĲ�����Ա��Ϣ
	 * @param pgdid �����鶨��id
	 * @return
	 * @throws BLException
	 */
	public List<UserRoleInfo> searchPgUserRoleVW(String pgdid)throws BLException{
		 Set<UserRoleInfo> userRoleVWSet = new HashSet<UserRoleInfo>();
		IG481SearchCondImpl cond = new IG481SearchCondImpl();
		
		cond.setPgdid(pgdid);
		
		 List<IG481Info> ig481List = ig481DAO.findByCond(cond, 0, 0);
		 
		 for (IG481Info ig481Info : ig481List) {
			 userRoleVWSet.addAll(searchUserRoleVW(ig481Info.getPdid()));
		}
		 
		 //��ȡȥ�غ�������û�
		 List<UserRoleInfo> userRoleVWList = new ArrayList<UserRoleInfo>(userRoleVWSet);

		return userRoleVWList;
		
	}
	
	
	
	/**
	 * ������������prid ����Ӧ��ָ������prid ��ǩ������
	 * @param drillPrid
	 * @param directPrid
	 * @throws BLException
	 */
	public boolean setDirectPrid(Integer drillPrid,Integer directPrid)throws BLException{
		
		return signinDAO.setDirectPrid(drillPrid, directPrid)>0;
	}
	
	
	
	
	/**
	 * ǩ����Ϣ���
	 * drillprid����prid,ecpridָ��prid,sceneprid����prid,wdc_wdpָ�Ӻͳ�����ʶ,
	 * List<UserRoleInfo> userroleInfoList �������Ա����
	 * ע��wdc_wdp ��ʶΪ��д��WDC������WDP��
	 */
	public void rigisterSignin(String drillprid,String ecprid,String sceneprid,String wdc_wdp, List<UserRoleInfo> userroleInfoList){
		
		if(StringUtils.isNotEmpty(sceneprid)){//if1
			//����prid���գ�����
			if(ecprid!=null&&!"".equals(ecprid)){//if1-if2
				//����prid���գ�ָ�Ӳ��գ�����ָ�����̳�����Ա���
				SigninSearchCondImpl sicond = new SigninSearchCondImpl();
				sicond.setEcprid(Integer.parseInt(ecprid));
				List<SigninInfo> signinInfoList =  signinDAO.findByCond(sicond, 0, 0);
				//���³���prid����
				for(SigninInfo signin : signinInfoList){
					SigninTB signinTB = (SigninTB) SerializationUtils.clone((Serializable) signin);
		
					signinTB.setSceneprid(Integer.parseInt(sceneprid));
					signinDAO.save(signinTB);
					}
				}
		}else{//else1
			if(StringUtils.isNotEmpty(ecprid)){//else1-if2
				//����prid�գ�ָ�ӷǿգ�wdc������ָ����Ա���
				if(StringUtils.isNotEmpty(wdc_wdp)&&"WDC".equals(wdc_wdp)){
					for(UserRoleInfo userroleInfo:userroleInfoList){
						SigninTB signinTB = new SigninTB();
						signinTB.setEcprid(Integer.parseInt(ecprid));
						signinTB.setSiuserid(userroleInfo.getUserid());
						signinTB.setSiusername(userroleInfo.getUsername());
						signinTB.setSiroleid(userroleInfo.getRoleid());
						signinTB.setWdc(1);
						signinDAO.save(signinTB);
					}
				}
				//����prid�գ�ָ�ӷǿգ�wdp����������Ա���
				if(StringUtils.isNotEmpty(wdc_wdp)&&"WDP".equals(wdc_wdp)){
					
					SigninSearchCondImpl sicond = new SigninSearchCondImpl();
					sicond.setEcprid(Integer.parseInt(ecprid));
					List<SigninInfo> signinInfoList =  signinDAO.findByCond(sicond, 0, 0);
					//���
					checkUserRoleVWList(signinInfoList, userroleInfoList,drillprid ,ecprid, "WDP");
				}
			}else{//else1-else2
				if(StringUtils.isNotEmpty(drillprid)){//else1-if2
					//����prid�գ�ָ��prid�գ�����prid��Ϊ��
					if(wdc_wdp!=null&&"WDP".equals(wdc_wdp)){//wdp��������Ա���

						//������Ա���	
						for(UserRoleInfo userroleInfo:userroleInfoList){
							SigninTB signinTB = new SigninTB();
							signinTB.setDrillprid(Integer.parseInt(drillprid));
							signinTB.setSiuserid(userroleInfo.getUserid());
							signinTB.setSiusername(userroleInfo.getUsername());
							signinTB.setSiroleid(userroleInfo.getRoleid());
							signinTB.setWdp(1);
							signinDAO.save(signinTB);
						}
					}
					if(StringUtils.isNotEmpty(wdc_wdp)&&"WDC".equals(wdc_wdp)){
						SigninSearchCondImpl sicond = new SigninSearchCondImpl();
						sicond.setDrillprid(Integer.parseInt(drillprid));
						List<SigninInfo> signinInfoList =  signinDAO.findByCond(sicond, 0, 0);
						//���
						checkUserRoleVWList(signinInfoList, userroleInfoList, drillprid,null,"WDC");
					}
				}
			}
		}
	}
	/**
	 * ����ǩ����Ա��Ϣ������wdc_wdp
	 */
	public void checkUserRoleVWList(List<SigninInfo> signinInfoList,List<UserRoleInfo> userRoleInfoList,String drillprid,String ecprid,String wdc_wdp){
		List<UserRoleInfo> removeList = new ArrayList<UserRoleInfo>();
		for(UserRoleInfo userroleInfo : userRoleInfoList){//for
			for(SigninInfo signin : signinInfoList){
				if(userroleInfo.getUserid().equals(signin.getSiuserid())&&signin.getSiroleid().intValue()==userroleInfo.getRoleid().intValue()){
					//�Ѵ��ڵ�ͬ��ɫidͬuserid�����ݣ�����wdc
					SigninTB signinTB = (SigninTB) SerializationUtils.clone((Serializable) signin);
					if("WDC".equals(wdc_wdp)){
						
						signinTB.setWdc(1);
					}else{
						
						signinTB.setWdp(1);
					}
					signinDAO.save(signinTB);
					removeList.add(userroleInfo);
				}
			}
		}//end for
		userRoleInfoList.removeAll(removeList);
		//������в����ڵ���Ա	
		for(UserRoleInfo userroleInfo:userRoleInfoList){
			SigninTB signinTB = new SigninTB();
			if(StringUtils.isNotEmpty(drillprid)){
				
				signinTB.setDrillprid(Integer.parseInt(drillprid));
			}
			if(StringUtils.isNotEmpty(ecprid)){
				
				signinTB.setEcprid(Integer.parseInt(ecprid));
			}
			signinTB.setSiuserid(userroleInfo.getUserid());
			signinTB.setSiusername(userroleInfo.getUsername());
			signinTB.setSiroleid(userroleInfo.getRoleid());
			if("WDC".equals(wdc_wdp)){
				signinTB.setWdc(1);
			}else{
				signinTB.setWdp(1);
			}
			signinDAO.save(signinTB);
		}
	}
	/**
	 * ָ�����̳�����ѡ����
	 */
	public void resetSenceUser(Integer ecprid)throws BLException {
		
		this.delWDP(ecprid);
		this.updWDP(ecprid);
	}
	/**
	 * ǩ����Ϣ��ѯ
	 * @param �û�id
	 * @param ����prid
	 * @param �Ƿ������� true ��
	 */
	public List<Map<String,Object>> searchSignInList(String userid,Integer prid,boolean isDrill) throws BLException {
		
		return signinDAO.searchSignInList(userid,prid,isDrill);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SigninInfo searchSigninByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SigninSearchCond cond) {
		return signinDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SigninInfo> searchSignin(
			SigninSearchCond cond) {
		return signinDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return signinDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SigninInfo registSignin(SigninInfo instance)
		throws BLException {
		return signinDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SigninInfo updateSignin(SigninInfo instance)
		throws BLException {
		checkExistInstance(instance.getSiid());
		return signinDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSigninByPK(Integer pk)
		throws BLException {
		signinDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSignin(SigninInfo instance)
		throws BLException {
		signinDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SigninInfo checkExistInstance(Integer pk)
		throws BLException {
		SigninInfo instance = signinDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * ����ǩ�����г�������prid
	 * @param directPrid ָ������prid
	 * @param scenePrid ��������prid
	 * @return
	 */
	public int setScenePrid(Integer directPrid,Integer scenePrid)throws BLException{
		return signinDAO.setScenePrid(directPrid, scenePrid);
	}
	/**
	 * dashboard ��Ա��Ϣ��ʼ����Ϣ
	 */
	public List<Map<String,Object>> searchSigninInitData(Integer ecprid) {
		return signinDAO.searchSigninInitData(ecprid);
		
	}
	
	/**
	 * ��ԭ������Ա��Ϣ  ɾ��
	 * @param ecprid
	 */
	private void delWDP (Integer ecprid){
		signinDAO.delWDP(ecprid);
	}
	/**
	 * ��ԭ������Ա��Ϣ  �޸�
	 * @param ecprid
	 */
	private void updWDP (Integer ecprid){
		signinDAO.updWDP(ecprid);
	}
	
	/**
	 * @param drillprid ����prid
	 * @param ecprid    ָ��prid
	 * @param sceneprid ����prid
	 * @param wdc_wdp   wdc:ָ��ǩ����  wdp:����ǩ����
	 * @param userroleInfoList ������list
	 */
	public void registerSigninInfo(Integer drillprid, Integer ecprid, Integer sceneprid, String wdc_wdp,
			List<UserRoleInfo> userroleInfoList) {
		if(userroleInfoList != null && userroleInfoList.size() > 0){
			for(UserRoleInfo userroleInfo : userroleInfoList){
				SigninTB tb = new SigninTB();
				tb.setDrillprid(drillprid);
				tb.setEcprid(ecprid);
				tb.setSceneprid(sceneprid);
				if("WDC".equals(wdc_wdp)){
					tb.setWdc(1);
				}else if("WDP".equals(wdc_wdp)){
					tb.setWdp(1);
				}
				tb.setSiuserid(userroleInfo.getUserid());
				tb.setSiusername(userroleInfo.getUsername());
				tb.setSiroleid(userroleInfo.getRoleid());
				signinDAO.save(tb);
			}
		}
	}

	/**
	 * �����������̸���ָ�����̵�id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForEcp(Integer drillprid,Integer ecprid){
		signinDAO.setDirectPrid(drillprid, ecprid);
	}

	/**
	 * �����������̸��¼����ָ����̵�id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForRestore(Integer drillprid, Integer restorePrid) {
		signinDAO.setScenePridFormDrill(drillprid, restorePrid);
	}
	
	/**
	 * ����ָ�����̸��¼����ָ����̵�id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForRestoreByDirectPrid(Integer directPrid, Integer restorePrid) {
		signinDAO.setScenePrid(directPrid, restorePrid);
	}

	/**
	 * @description ���³����Ĳ������ڹ�����ָ���������Ѵ��ڵ�ǩ����
	 * @param sceneprid
	 *            ����prid
	 * @param signinInfoList
	 *            �Ѵ��ڵĳ�����ǩ����
	 */
	public void updateSigninInfo(Integer sceneprid,List<SigninInfo> signinInfoList){
		if(signinInfoList != null && signinInfoList.size() > 0){
			for(SigninInfo signinInfo : signinInfoList){
				SigninTB tb = (SigninTB) SerializationUtils.clone((Serializable) signinInfo);
				tb.setSceneprid(sceneprid);
				tb.setWdp(1);
				signinDAO.save(tb);
			}
		}
	}
	/**
	 * ��ѯ������
	 * @param ecprid
	 * @return
	 */
	public List<Map<String,Object>> searchSigninPeopleDataByCond(Integer ecprid){
		return signinDAO.searchSigninPeopleDataByCond(ecprid);
	}
	
	/**
	 * ��ȡ��������Ϣ
	 *
	 * @return List<UserRoleInfo> 
	 */
	public List<UserRoleInfo> searchUserRoleInfoList(String pdid) {
		//����ǩ�������˼���
		 List<UserRoleInfo> resultList = new ArrayList<UserRoleInfo>();
		 //key Ϊ userid, ȥ��
		 Map<String,UserRoleInfo> resultMap = new HashMap<String,UserRoleInfo>();
		//��ȡ���г������̵Ĳ�����
		IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
		ig222cond.setPpdid_like(pdid);
		List<IG222Info> ig222InfoList = ig222DAO.findByCond(ig222cond,0,0);
		
		//��ȡ���н�ɫid
		for(IG222Info ig222info:ig222InfoList){
			//��ɫָ�����˵����
			if(ig222info.getUserid()!=null && StringUtils.isNotBlank(ig222info.getUserid())){
				UserRoleInfo info = resultMap.get(ig222info.getUserid());
				if(info == null){
					UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
					urcond.setUserid(ig222info.getUserid());
					urcond.setRoleid(ig222info.getRoleid());
					urcond.setRoletype(IGDRMCONSTANTS.SP_ROLE_TYPE);
					List<UserRoleInfo> userRoleInfoList =  userRoleVWDAO.findByCond(urcond, 0, 0);
					//��Ӵ��˵Ľ�ɫ
					if(userRoleInfoList.size()>0){
						resultMap.put(ig222info.getUserid(), userRoleInfoList.get(0));
					}
				}
				
			}
			//ָ������ɫ�����
			else{
				
				UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
				urcond.setRoleid(ig222info.getRoleid());
				List<UserRoleInfo> userRoleList =  userRoleVWDAO.findByCond(urcond, 0, 0);
				//��ӽ�ɫ�������û�
				for(UserRoleInfo userrole:userRoleList){
					resultMap.put(userrole.getUserid(), userrole);
				}
			}	
		}
		//��ȡȥ�غ�������û�
		if(resultMap != null && !resultMap.isEmpty()){
			for(Entry<String, UserRoleInfo> entry : resultMap.entrySet()){
				resultList.add(entry.getValue());
			}
		}
		return resultList;
	}
}