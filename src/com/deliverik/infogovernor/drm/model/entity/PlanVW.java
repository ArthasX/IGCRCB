/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.drm.model.PlanInfo;

/**
  * ����: ������ͼʵ��
  * ��������: ������ͼʵ��
  * ������¼: 2014/05/24
  * @author wym
  */
@SuppressWarnings("serial")
@Entity
public class PlanVW implements Serializable,Cloneable, PlanInfo {
	
	/**��������*/
	@Id
	private Integer eiid ;
	private String eid;
	/**��������*/
	private String einame;
	/**�������*/
	private String eilabel;
	/**��������*/
	private String eiinsdate;
	private String eiupdtime;
	/**������*/
	private String eiorgsyscoding;
	/**ģ�Ͳ����*/
	private String esyscoding;
	/**�����û�����*/
	private String eiusername;
	/**�����û�id*/
	private String eiuserid;
	/**Ԥ��С�汾*/
	private Integer eismallversion;
	/**�����汾*/
	private Integer eiversion;
	/**��ϳ����Ƿ���Ҫ����*/
	private String needrise;
	private String senceClassify;
	
	/**Ԥ��ģʽ(��һ,����)*/
	//private String  planmode;
	/**������������id*/
	//private String planprocessid;
	/**����������������*/
	//private String planprocessname;
	/**���յȼ�*/
	//private String  planlevel;
	/**�����Է�ɹ�*/
	//private String  plansuccess;
	/**Ԥ��״̬(��ִ��,����ִ��)*/
	//private String planstatus;
	/**��������*/
	private String orgname;
	/**Ԥ����������*/
	private String cdinfo;
	
	/**��������*/
	private String scename;
	/**��������*/
	private String scedes;
	/**����Ӧ�����ò���*/
	private String scepdid;
	/**�Ƿ�������*/
	private String isplan;
	/**���峡������ID*/
	private String sceprid;
	/**��������*/
	private String scetype;
	/** Ԥ�ƻָ�ʱ�� */
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
	 * ��ȡsenceClassify  
	 * @return senceClassify 
	 */
	public String getSenceClassify() {
		return senceClassify;
	}
	
}