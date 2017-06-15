/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.drm.model.PlanInfo;

/**
  * 概述: 场景视图实体
  * 功能描述: 场景视图实体
  * 创建记录: 2014/05/24
  * @author wym
  */
@SuppressWarnings("serial")
@Entity
public class PlanVW implements Serializable,Cloneable, PlanInfo {
	
	/**场景主键*/
	@Id
	private Integer eiid ;
	private String eid;
	/**场景名称*/
	private String einame;
	/**场景编号*/
	private String eilabel;
	/**创建日期*/
	private String eiinsdate;
	private String eiupdtime;
	/**机构码*/
	private String eiorgsyscoding;
	/**模型层次码*/
	private String esyscoding;
	/**创建用户姓名*/
	private String eiusername;
	/**创建用户id*/
	private String eiuserid;
	/**预案小版本*/
	private Integer eismallversion;
	/**场景版本*/
	private Integer eiversion;
	/**组合场景是否需要升版*/
	private String needrise;
	private String senceClassify;
	
	/**预案模式(单一,复合)*/
	//private String  planmode;
	/**关联处置流程id*/
	//private String planprocessid;
	/**关联处置流程名称*/
	//private String planprocessname;
	/**风险等级*/
	//private String  planlevel;
	/**演练吃否成功*/
	//private String  plansuccess;
	/**预案状态(可执行,不可执行)*/
	//private String planstatus;
	/**机构名称*/
	private String orgname;
	/**预案分类名称*/
	private String cdinfo;
	
	/**场景名称*/
	private String scename;
	/**场景描述*/
	private String scedes;
	/**场景应急处置步骤*/
	private String scepdid;
	/**是否已演练*/
	private String isplan;
	/**定义场景流程ID*/
	private String sceprid;
	/**场景类型*/
	private String scetype;
	/** 预计恢复时间 */
	private String times;


	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}
	public String getScename() {
		return scename;
	}
	public void setScename(String scename) {
		this.scename = scename;
	}
	public String getScedes() {
		return scedes;
	}
	public void setScedes(String scedes) {
		this.scedes = scedes;
	}
	public String getScepdid() {
		return scepdid;
	}
	public void setScepdid(String scepdid) {
		this.scepdid = scepdid;
	}
	public String getSceprid() {
		return sceprid;
	}
	public void setSceprid(String sceprid) {
		this.sceprid = sceprid;
	}
	public String getIsplan() {
		return isplan;
	}
	public void setIsplan(String isplan) {
		this.isplan = isplan;
	}
	public String getScetype() {
		return scetype;
	}
	public void setScetype(String scetype) {
		this.scetype = scetype;
	}
	
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public Integer getEiid() {
		return eiid;
	}
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	public String getEiname() {
		return einame;
	}
	public void setEiname(String einame) {
		this.einame = einame;
	}
	public String getEilabel() {
		return eilabel;
	}
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	public String getEiinsdate() {
		return eiinsdate;
	}
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getEiusername() {
		return eiusername;
	}
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}
	public String getEiuserid() {
		return eiuserid;
	}
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	public Integer getEiversion() {
		return eiversion;
	}
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	public Integer getEismallversion() {
		return eismallversion;
	}
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
//	public String getPlanmode() {
//		return planmode;
//	}
//	public void setPlanmode(String planmode) {
//		this.planmode = planmode;
//	}
//	public String getPlanprocessid() {
//		return planprocessid;
//	}
//	public void setPlanprocessid(String planprocessid) {
//		this.planprocessid = planprocessid;
//	}
//	public String getPlanprocessname() {
//		return planprocessname;
//	}
//	public void setPlanprocessname(String planprocessname) {
//		this.planprocessname = planprocessname;
//	}
//	public String getPlanlevel() {
//		return planlevel;
//	}
//	public void setPlanlevel(String planlevel) {
//		this.planlevel = planlevel;
//	}
//	public String getPlansuccess() {
//		return plansuccess;
//	}
//	public void setPlansuccess(String plansuccess) {
//		this.plansuccess = plansuccess;
//	}
//	public String getPlanstatus() {
//		return planstatus;
//	}
//	public void setPlanstatus(String planstatus) {
//		this.planstatus = planstatus;
//	}
	public String getCdinfo() {
		return cdinfo;
	}
	public void setCdinfo(String cdinfo) {
		this.cdinfo = cdinfo;
	}
	public String getEiupdtime() {
		return eiupdtime;
	}
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	/**
	 * @return the needrise
	 */
	public String getNeedrise() {
		return needrise;
	}
	/**
	 * @param needrise the needrise to set
	 */
	public void setNeedrise(String needrise) {
		this.needrise = needrise;
	}

	/**  
	 * 获取senceClassify  
	 * @return senceClassify 
	 */
	public String getSenceClassify() {
		return senceClassify;
	}
	
}