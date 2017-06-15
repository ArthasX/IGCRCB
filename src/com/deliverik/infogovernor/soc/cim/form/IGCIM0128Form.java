package com.deliverik.infogovernor.soc.cim.form;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * 应用查询画面FORM 原0812
 * 
 */
public class IGCIM0128Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** 资产模型编号 */
	protected String elabel;
	
	/** 资产模型名 */
	protected String ename;
	
	/** 应用编号 */
	protected String eilabel;
	
	/** 应用名称 */
	protected String einame;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类 */
	protected String ekey1;
	
	/** 资产模型二级子类 */
	protected String ekey2;
	
	/** 应用更新时间FROM */
	protected String eiupdtime_from;
	
	/** 应用更新时间TO */
	protected String eiupdtime_to;
	
	/** 删除应用对象 */
	protected String[] deleteEiid;
	
	/** 应用配置名检索条件数组 */
	protected String[] cname = new String[4];
	
	/** 应用配置值检索条件数组 */
	protected String[] civalue = new String[4];
	
	/** 应用共通配置编号检索条件数组 */
	protected String[] cclabel = new String[2];
	
	/** 应用共通配置值检索条件数组 */
	protected String[] ccivalue = new String[2];
	
	/** 资产项所属机构*/
	protected String eiorgsyscoding;
	
	/** 资产项所属机构名称*/
	protected String eiorgname;
	
	/** 资产项所属模型*/
	protected String esyscoding;
	
	/** 资产项的状态 */
	protected String eistatus;//下发存N|R  上缴存U  报废存N|R  
	/** 应用id */
	protected Integer eiid;
	
	/** 应用登记日 */
	protected String eiinsdate;
	
	/** 模型id */
	protected String eid;

	/** 应用更新时间*/
	protected String eiupdtime;
	/** 应用版本*/
	protected Integer eiversion;
	
	/** 应用说明*/
	protected String eidesc;
	
	/** 应用编号 */
	protected String eilabelbak;
	
	/** 资产管理人*/
	protected String eiuserid;
	
	protected String fingerPrint;
	
	/** 权限*/
	protected boolean permission;
	
	/** 资产管理人姓名*/
	protected String eiusername;
	
	/** 是否角色负责人 */
	protected boolean roleManager;
	
	/** 资产小版本*/
	protected Integer eismallversion;
	
	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	public String getEidesc() {
		return eidesc;
	}

	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	public Integer getEiversion() {
		return eiversion;
	}

	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
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

	public String getEiinsdate() {
		return eiinsdate;
	}

	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getEistatus() {
		return eistatus;
	}

	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * 资产模型编码取得
	 * @return 资产模型编码
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产模型编码设定
	 *
	 * @param elabel 资产模型编码
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产模型名取得
	 * @return 资产模型名
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名设定
	 *
	 * @param ename 资产模型名
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 应用编码取得
	 * @return 应用编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 应用编码设定
	 *
	 * @param eilabel 应用编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 应用名称取得
	 * @return 应用名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 应用名称设定
	 *
	 * @param einame 应用名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * 资产模型分类设定
	 *
	 * @param ecategory 资产模型分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * 资产模型一级子类取得
	 * @return 资产模型一级子类
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * 资产模型一级子类设定
	 *
	 * @param ekey1 资产模型一级子类
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * 资产模型二级子类取得
	 * @return 资产模型二级子类
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * 资产模型二级子类设定
	 *
	 * @param ekey1 资产模型二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * 应用更新时间FROM取得
	 * @return 应用更新时间FROM
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	/**
	 * 应用更新时间FROM设定
	 *
	 * @param eiupdtime_from 应用更新时间FROM
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	/**
	 * 应用更新时间TO取得
	 * @return 应用更新时间TO
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	/**
	 * 应用更新时间TO设定
	 *
	 * @param eiupdtime_to 应用更新时间TO
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}


	/**
	 * 删除应用对象取得
	 * @return 删除应用对象
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}


	/**
	 * 删除应用对象设定
	 *
	 * @param deleteEiid 删除应用对象
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * 应用配置名检索条件数组取得
	 * @return 应用配置名检索条件数组
	 */
	public String[] getCname() {
		return cname;
	}

	/**
	 * 应用配置名检索条件数组设定
	 *
	 * @param cname 应用配置名检索条件数组
	 */
	public void setCname(String[] cname) {
		this.cname = cname;
	}

	/**
	 * 应用配置值检索条件数组取得
	 * @return 应用配置值检索条件数组
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * 应用配置值检索条件数组设定
	 *
	 * @param civalue 应用配置值检索条件数组
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	/**
	 * 应用共通配置编号检索条件数组取得
	 * @return 应用共通配置编号检索条件数组
	 */
	public String[] getCclabel() {
		return cclabel;
	}

	/**
	 * 应用共通配置编号检索条件数组设定
	 *
	 * @param cclabel 应用共通配置编号检索条件数组
	 */
	public void setCclabel(String[] cclabel) {
		this.cclabel = cclabel;
	}

	/**
	 * 应用共通配置值检索条件数组取得
	 * @return 应用共通配置值检索条件数组
	 */
	public String[] getCcivalue() {
		return ccivalue;
	}

	/**
	 * 应用共通配置值检索条件数组设定
	 *
	 * @param ccivalue 应用共通配置值检索条件数组
	 */
	public void setCcivalue(String[] ccivalue) {
		this.ccivalue = ccivalue;
	}
	
	/**
	 * 应用编号取得
	 * @return 应用编号
	 */
	public String getEilabelbak() {
		return eilabelbak;
	}

	/**
	 * 应用编号设定
	 *
	 * @param eilabelbak 应用编号
	 */
	public void setEilabelbak(String eilabelbak) {
		this.eilabelbak = eilabelbak;
	}

	/**
	 * 初始化处理
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.deleteEiid = null;
	}
	
	/**
	 * 资产管理人取得
	 * @return 资产管理人
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * 资产管理人设定
	 *
	 * @param eiuserid 资产管理人
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * 权限取得
	 * @return 权限
	 */
	public boolean isPermission() {
		return permission;
	}

	/**
	 * 权限设定
	 *
	 * @param permission 权限
	 */
	public void setPermission(boolean permission) {
		this.permission = permission;
	}
	
	/**
	 * 资产管理人姓名取得
	 * @return 资产管理人姓名
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * 资产管理人姓名设定
	 *
	 * @param eiusername 资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}
	/**
	 * 是否角色负责人取得
	 * @return 是否角色负责人
	 */
	public boolean isRoleManager() {
		return roleManager;
	}

	/**
	 * 是否角色负责人设定
	 *
	 * @param roleManager 是否角色负责人
	 */
	public void setRoleManager(boolean roleManager) {
		this.roleManager = roleManager;
	}

	public Integer getEirootmark() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * 资产小版本设定
	 *
	 * @param eismallversion 资产小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}

}
