/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;


/**
  * 概述: 场景视图接口
  * 功能描述: 场景视图接口
  * 创建记录: 2014/05/21 wym
  * 修改记录: 
  */
public interface PlanInfo{
	
	public String getEid();
	public Integer getEiid();
	public String getEiname();
	public String getEilabel();
	public String getEiinsdate();
	public String getEiorgsyscoding();
	public String getEsyscoding();
	public Integer getEiversion();
	public String getEiuserid();
	public Integer getEismallversion();
	public String getEiusername();
	public String getEiupdtime();
	public String getSenceClassify();
	
//	public String getPlanlevel();
//	public String getPlanmode();
//	public String getPlanprocessid();
//	public String getPlanprocessname();
//	public String getPlanstatus();
//	public String getPlansuccess();
	public String getOrgname();
	public String getCdinfo();
	
	//场景资产属性
	public String getScename();
	public String getScedes();
	public String getTimes();
	public String getScepdid();
	public String getSceprid();
	public String getIsplan();
	public String getScetype();
	public String getNeedrise();
}