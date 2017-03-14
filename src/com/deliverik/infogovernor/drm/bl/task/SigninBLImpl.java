/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: 签到表业务逻辑实现
  * 功能描述: 签到表业务逻辑实现
  * 创建记录: 2015/03/12
  * zyl 
  */
public class SigninBLImpl extends BaseBLImpl implements
		SigninBL {

	/** 签到表DAO接口 */
	protected SigninDAO signinDAO;
	/** ig222DAO接口 */
	protected IG222DAO ig222DAO;
	/** userrolevwDAO接口 */
	protected UserRoleVWDAO userRoleVWDAO;
	/***流程组成员*/
	protected IG481DAO ig481DAO;
	
	
	
	public void setIg481DAO(IG481DAO ig481dao) {
		ig481DAO = ig481dao;
	}

	/**
	 * 签到表DAO接口设定
	 *
	 * @param signinDAO 签到表DAO接口
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
	 * 签到表实例取得
	 *
	 * @return 签到表实例
	 */
	public SigninTB getSigninTBInstance() {
		return new SigninTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SigninInfo> searchSignin() {
		return signinDAO.findAll();
	}
	/**
	 * 获取签到参与人
	 *
	 * @return List<UserRoleInfo> 
	 */
	public List<UserRoleInfo> searchUserRoleVW(String pdid) {
		//定义签到参与人集合
		 Set<UserRoleInfo> userRoleVWSet = new HashSet<UserRoleInfo>();
			//获取所有场景流程的参与人
			IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
			ig222cond.setPpdid_like(pdid);
			List<IG222Info> ig222InfoList = ig222DAO.findByCond(ig222cond,0,0);
			//获取所有角色id
			for(IG222Info ig222info:ig222InfoList){//for1
				//角色指定到人的情况
				if(ig222info.getUserid()!=null&&!"".equals(ig222info.getUserid().trim())){//if1
				UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
				urcond.setUserid(ig222info.getUserid());
				urcond.setRoleid(ig222info.getRoleid());
				urcond.setRoletype(IGDRMCONSTANTS.SP_ROLE_TYPE);
				List<UserRoleInfo> userRoleInfoList =  userRoleVWDAO.findByCond(urcond, 0, 0);
				//添加此人的角色
				if(userRoleInfoList.size()>0){//if2
					userRoleVWSet.add(userRoleInfoList.get(0));
				}//end if2
				}//end if1
				else{//if1的else,指定到角色的情况
					UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
					urcond.setRoleid(ig222info.getRoleid());
					List<UserRoleInfo> userRoleList =  userRoleVWDAO.findByCond(urcond, 0, 0);
					//添加角色下所有用户
					for(UserRoleInfo userrole:userRoleList){
						userRoleVWSet.add(userrole);
					}
				}	
			}
		//获取去重后的所有用户
		List<UserRoleInfo> userRoleVWList = new ArrayList<UserRoleInfo>(userRoleVWSet);

		return userRoleVWList;
	}
	
	/**
	 * 获取组合场景中的参与人员信息
	 * @param pgdid 流程组定义id
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
		 
		 //获取去重后的所有用户
		 List<UserRoleInfo> userRoleVWList = new ArrayList<UserRoleInfo>(userRoleVWSet);

		return userRoleVWList;
		
	}
	
	
	
	/**
	 * 根据演练流程prid 设置应急指挥流程prid 到签到表中
	 * @param drillPrid
	 * @param directPrid
	 * @throws BLException
	 */
	public boolean setDirectPrid(Integer drillPrid,Integer directPrid)throws BLException{
		
		return signinDAO.setDirectPrid(drillPrid, directPrid)>0;
	}
	
	
	
	
	/**
	 * 签到信息入库
	 * drillprid演练prid,ecprid指挥prid,sceneprid场景prid,wdc_wdp指挥和场景标识,
	 * List<UserRoleInfo> userroleInfoList 待入库人员集合
	 * 注意wdc_wdp 标识为大写“WDC”，“WDP”
	 */
	public void rigisterSignin(String drillprid,String ecprid,String sceneprid,String wdc_wdp, List<UserRoleInfo> userroleInfoList){
		
		if(StringUtils.isNotEmpty(sceneprid)){//if1
			//场景prid不空，代表？
			if(ecprid!=null&&!"".equals(ecprid)){//if1-if2
				//场景prid不空，指挥不空，代表指挥流程场景人员入库
				SigninSearchCondImpl sicond = new SigninSearchCondImpl();
				sicond.setEcprid(Integer.parseInt(ecprid));
				List<SigninInfo> signinInfoList =  signinDAO.findByCond(sicond, 0, 0);
				//更新场景prid操作
				for(SigninInfo signin : signinInfoList){
					SigninTB signinTB = (SigninTB) SerializationUtils.clone((Serializable) signin);
		
					signinTB.setSceneprid(Integer.parseInt(sceneprid));
					signinDAO.save(signinTB);
					}
				}
		}else{//else1
			if(StringUtils.isNotEmpty(ecprid)){//else1-if2
				//场景prid空，指挥非空，wdc，代表指挥人员入库
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
				//场景prid空，指挥非空，wdp，代表场景人员入库
				if(StringUtils.isNotEmpty(wdc_wdp)&&"WDP".equals(wdc_wdp)){
					
					SigninSearchCondImpl sicond = new SigninSearchCondImpl();
					sicond.setEcprid(Integer.parseInt(ecprid));
					List<SigninInfo> signinInfoList =  signinDAO.findByCond(sicond, 0, 0);
					//入库
					checkUserRoleVWList(signinInfoList, userroleInfoList,drillprid ,ecprid, "WDP");
				}
			}else{//else1-else2
				if(StringUtils.isNotEmpty(drillprid)){//else1-if2
					//场景prid空，指挥prid空，演练prid不为空
					if(wdc_wdp!=null&&"WDP".equals(wdc_wdp)){//wdp代表场景人员入库

						//场景人员入库	
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
						//入库
						checkUserRoleVWList(signinInfoList, userroleInfoList, drillprid,null,"WDC");
					}
				}
			}
		}
	}
	/**
	 * 过滤签到人员信息并更新wdc_wdp
	 */
	public void checkUserRoleVWList(List<SigninInfo> signinInfoList,List<UserRoleInfo> userRoleInfoList,String drillprid,String ecprid,String wdc_wdp){
		List<UserRoleInfo> removeList = new ArrayList<UserRoleInfo>();
		for(UserRoleInfo userroleInfo : userRoleInfoList){//for
			for(SigninInfo signin : signinInfoList){
				if(userroleInfo.getUserid().equals(signin.getSiuserid())&&signin.getSiroleid().intValue()==userroleInfo.getRoleid().intValue()){
					//已存在的同角色id同userid的数据，更新wdc
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
		//插入库中不存在的人员	
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
	 * 指挥流程场景重选流程
	 */
	public void resetSenceUser(Integer ecprid)throws BLException {
		
		this.delWDP(ecprid);
		this.updWDP(ecprid);
	}
	/**
	 * 签到信息查询
	 * @param 用户id
	 * @param 流程prid
	 * @param 是否是演练 true 是
	 */
	public List<Map<String,Object>> searchSignInList(String userid,Integer prid,boolean isDrill) throws BLException {
		
		return signinDAO.searchSignInList(userid,prid,isDrill);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SigninInfo searchSigninByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SigninSearchCond cond) {
		return signinDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SigninInfo> searchSignin(
			SigninSearchCond cond) {
		return signinDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SigninInfo> searchSignin(
			SigninSearchCond cond, int start,
			int count) {
		return signinDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SigninInfo registSignin(SigninInfo instance)
		throws BLException {
		return signinDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SigninInfo updateSignin(SigninInfo instance)
		throws BLException {
		checkExistInstance(instance.getSiid());
		return signinDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSigninByPK(Integer pk)
		throws BLException {
		signinDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSignin(SigninInfo instance)
		throws BLException {
		signinDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SigninInfo checkExistInstance(Integer pk)
		throws BLException {
		SigninInfo instance = signinDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	/**
	 * 更新签到表中场景流程prid
	 * @param directPrid 指挥流程prid
	 * @param scenePrid 场景流程prid
	 * @return
	 */
	public int setScenePrid(Integer directPrid,Integer scenePrid)throws BLException{
		return signinDAO.setScenePrid(directPrid, scenePrid);
	}
	/**
	 * dashboard 人员信息初始化信息
	 */
	public List<Map<String,Object>> searchSigninInitData(Integer ecprid) {
		return signinDAO.searchSigninInitData(ecprid);
		
	}
	
	/**
	 * 还原场景人员信息  删除
	 * @param ecprid
	 */
	private void delWDP (Integer ecprid){
		signinDAO.delWDP(ecprid);
	}
	/**
	 * 还原场景人员信息  修改
	 * @param ecprid
	 */
	private void updWDP (Integer ecprid){
		signinDAO.updWDP(ecprid);
	}
	
	/**
	 * @param drillprid 演练prid
	 * @param ecprid    指挥prid
	 * @param sceneprid 场景prid
	 * @param wdc_wdp   wdc:指挥签到人  wdp:场景签到人
	 * @param userroleInfoList 参与人list
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
	 * 根据演练流程更新指挥流程的id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForEcp(Integer drillprid,Integer ecprid){
		signinDAO.setDirectPrid(drillprid, ecprid);
	}

	/**
	 * 根据演练流程更新技术恢复流程的id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForRestore(Integer drillprid, Integer restorePrid) {
		signinDAO.setScenePridFormDrill(drillprid, restorePrid);
	}
	
	/**
	 * 根据指挥流程更新技术恢复流程的id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForRestoreByDirectPrid(Integer directPrid, Integer restorePrid) {
		signinDAO.setScenePrid(directPrid, restorePrid);
	}

	/**
	 * @description 更新场景的参与人在关联的指挥流程中已存在的签到人
	 * @param sceneprid
	 *            场景prid
	 * @param signinInfoList
	 *            已存在的场景的签到人
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
	 * 查询参与人
	 * @param ecprid
	 * @return
	 */
	public List<Map<String,Object>> searchSigninPeopleDataByCond(Integer ecprid){
		return signinDAO.searchSigninPeopleDataByCond(ecprid);
	}
	
	/**
	 * 获取参与人信息
	 *
	 * @return List<UserRoleInfo> 
	 */
	public List<UserRoleInfo> searchUserRoleInfoList(String pdid) {
		//定义签到参与人集合
		 List<UserRoleInfo> resultList = new ArrayList<UserRoleInfo>();
		 //key 为 userid, 去重
		 Map<String,UserRoleInfo> resultMap = new HashMap<String,UserRoleInfo>();
		//获取所有场景流程的参与人
		IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
		ig222cond.setPpdid_like(pdid);
		List<IG222Info> ig222InfoList = ig222DAO.findByCond(ig222cond,0,0);
		
		//获取所有角色id
		for(IG222Info ig222info:ig222InfoList){
			//角色指定到人的情况
			if(ig222info.getUserid()!=null && StringUtils.isNotBlank(ig222info.getUserid())){
				UserRoleInfo info = resultMap.get(ig222info.getUserid());
				if(info == null){
					UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
					urcond.setUserid(ig222info.getUserid());
					urcond.setRoleid(ig222info.getRoleid());
					urcond.setRoletype(IGDRMCONSTANTS.SP_ROLE_TYPE);
					List<UserRoleInfo> userRoleInfoList =  userRoleVWDAO.findByCond(urcond, 0, 0);
					//添加此人的角色
					if(userRoleInfoList.size()>0){
						resultMap.put(ig222info.getUserid(), userRoleInfoList.get(0));
					}
				}
				
			}
			//指定到角色的情况
			else{
				
				UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
				urcond.setRoleid(ig222info.getRoleid());
				List<UserRoleInfo> userRoleList =  userRoleVWDAO.findByCond(urcond, 0, 0);
				//添加角色下所有用户
				for(UserRoleInfo userrole:userRoleList){
					resultMap.put(userrole.getUserid(), userrole);
				}
			}	
		}
		//获取去重后的所有用户
		if(resultMap != null && !resultMap.isEmpty()){
			for(Entry<String, UserRoleInfo> entry : resultMap.entrySet()){
				resultList.add(entry.getValue());
			}
		}
		return resultList;
	}
}