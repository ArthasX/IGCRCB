/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: 签到表业务逻辑接口
  * 功能描述: 签到表业务逻辑接口
  * 创建记录: 2015/03/12
  * 修改记录: 
  */
public interface SigninBL extends BaseBL {

	/**
	 * 签到表实例取得
	 *
	 * @return 签到表实例
	 */
	public SigninTB getSigninTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SigninInfo> searchSignin();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SigninInfo searchSigninByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SigninSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SigninInfo> searchSignin(
			SigninSearchCond cond);

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
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SigninInfo registSignin(SigninInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SigninInfo updateSignin(SigninInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSigninByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSignin(SigninInfo instance)
		throws BLException;
	/**
	 * 获取签到参与人
	 *
	 * @return List<UserRoleInfo> 
	 */
	public List<UserRoleInfo> searchUserRoleVW(String pdid) ;
	
	/**
	 * 获取组合场景中的参与人员信息
	 * @param pgdid 流程组定义id
	 * @return
	 * @throws BLException
	 */
	public List<UserRoleInfo> searchPgUserRoleVW(String pgdid)throws BLException;
	/**
	 * 签到信息入库
	 * drillprid演练prid,ecprid指挥prid,sceneprid场景prid,wdc_wdp指挥和场景标识,
	 * List<UserRoleInfo> userroleInfoList 待入库人员集合
	 * 注意wdc_wdp 标识为大写“WDC”，“WDP”
	 */
	public void rigisterSignin(String drillprid,String ecprid,String sceneprid,String wdc_wdp, List<UserRoleInfo> userroleInfoList);
	/**
	 * 签到信息查询
	 * @param 用户id
	 * @param 流程prid
	 * @param 是否是演练 true 是
	 */
	public List<Map<String,Object>> searchSignInList(String userid,Integer prid,boolean isDrill) throws BLException;
	
	/**
	 * 根据演练流程prid 设置应急指挥流程prid 到签到表中
	 * @param drillPrid
	 * @param directPrid
	 * @throws BLException
	 */
	public boolean setDirectPrid(Integer drillPrid,Integer directPrid)throws BLException;
	/**
	 * 更新签到表中场景流程prid
	 * @param directPrid 指挥流程prid
	 * @param scenePrid 场景流程prid
	 * @return
	 */
	public int setScenePrid(Integer directPrid,Integer scenePrid)throws BLException;
	/**
	 * 指挥流程场景重选流程相关操作
	 */
	public void resetSenceUser(Integer ecprid)throws BLException;
	/**
	 * dashboard 人员信息初始化信息
	 */
	public List<Map<String,Object>> searchSigninInitData(Integer ecprid);
	
	/**
	 * @description 初始化签到人
	 * @param drillprid 演练prid
	 * @param ecprid    指挥prid
	 * @param sceneprid 场景prid
	 * @param wdc_wdp   wdc:指挥签到人  wdp:场景签到人
	 * @param userroleInfoList 参与人list
	 */
	public void registerSigninInfo(Integer drillprid,Integer ecprid,Integer sceneprid,String wdc_wdp,List<UserRoleInfo> userroleInfoList)throws BLException;
	
	/**
	 * @description 更新场景的参与人在关联的指挥流程中已存在的签到人
	 * @param sceneprid        场景prid
	 * @param signinInfoList   已存在的场景的签到人
	 */
	public void updateSigninInfo(Integer sceneprid,List<SigninInfo> signinInfoList);
	
	/**
	 * 获取参与人信息
	 *
	 * @return List<UserRoleInfo> 
	 */
	public List<UserRoleInfo> searchUserRoleInfoList(String pdid);
	
	/**
	 * 根据演练流程更新指挥流程的id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForEcp(Integer drillprid, Integer ecprid);
	
	/**
	 * 根据演练流程更新技术恢复流程的id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForRestore(Integer drillprid, Integer restorePrid);
	
	/**
	 * 根据指挥流程更新技术恢复流程的id
	 * 
	 * @param drillprid
	 * @param ecprid
	 */
	public void updateSigninForRestoreByDirectPrid(Integer directPrid, Integer restorePrid);

	/**
	 * 查询参与人
	 * 
	 * @param ecprid
	 * @return
	 */
	public List<Map<String,Object>> searchSigninPeopleDataByCond(Integer ecprid);
}