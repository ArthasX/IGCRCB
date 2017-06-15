package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseForm;

/**
 * 组件编辑画面FORM
 * 
 */
public class IGASM1702Form extends BaseForm implements IG013Info{

	private static final long serialVersionUID = 1L;

	/** 组件ID */
	protected Integer eiid;
	
	/** 组件ID（文字） */
	protected String eiidStr;

	/** 资产模型ID */
	protected Integer eid;
	
	/** 资产模型ID（文字） */
	protected String eidStr;
	
	/** 资产模型编码 */
	protected String elabel;

	/** 资产模型名称 */
	protected String ename;

	/** 组件名称 */
	protected String einame;
	
	/** 组件编码 */
	protected String eilabel;

	/** 组件说明 */
	protected String eidesc;

	/** 组件状态 */
	protected String eistatus;

	/** 组件变更时间 */
	protected String eiupdtime;
	
	/** 组件版本号 */
	protected Integer eiversion;

	/** 组件登记日 */
	protected String eiinsdate;
	
	/** 编辑模式（登记/变更） */
	protected String mode = "0";

	/** 所属机构 */
	protected String eiorgname;

	/** 资产项所属模型*/
	protected String esyscoding;
	
	/** 组件所属设备模型id*/
	protected String deviceEid;
	
	/** 组件所属设备id*/
	protected String deviceEiid;
	
	/** 组件所属设备名称*/
	protected String deviceEiname;
	
	/** 组件所属组件模型id*/
	protected String moduleEid;
	
	/** 组件所属组件id*/
	protected String moduleEiid;
	
	/** 组件所属组件名称*/
	protected String moduleEiname;
	
	/** 资产管理人*/
	protected String eiuserid;
	
	/** 资产管理人姓名*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** 资产小版本*/
	protected Integer eismallversion;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	
	protected String eiorgsyscoding;

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	/**
	 * 组件ID取得
	 * @return 组件ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * 组件ID设定
	 *
	 * @param eiid 组件ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * 组件ID（文字）取得
	 * @return 组件ID（文字）
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * 组件ID（文字）设定
	 *
	 * @param eiidStr 组件ID（文字）
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * 资产模型ID（文字）取得
	 * @return 资产模型ID（文字）
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * 资产模型ID（文字）设定
	 *
	 * @param eidStr 资产模型ID（文字）
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
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
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param ename 资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 组件名称取得
	 * @return 组件名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 组件名称设定
	 *
	 * @param einame 组件名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 组件编码取得
	 * @return 组件编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 组件编码设定
	 *
	 * @param eilabel 组件编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 组件说明取得
	 * @return 组件说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 组件说明设定
	 *
	 * @param eidesc 组件说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 组件更新时间取得
	 * @return 组件更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 组件更新时间设定
	 *
	 * @param eiupdtime 组件更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 组件状态取得
	 * @return 组件状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 组件状态设定
	 *
	 * @param eistatus 组件状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 组件版本号取得
	 * @return 组件版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 组件版本号设定
	 *
	 * @param eiversion 组件版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 组件登记日取得
	 * @return 组件登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 组件登记日设定
	 *
	 * @param eiinsdate 组件登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 编辑模式取得
	 * @return 编辑模式
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * 编辑模式设定
	 *
	 * @param mode 编辑模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * 组件所属设备模型id取得
	 * @return 组件所属设备模型id
	 */
	public String getDeviceEid() {
		return deviceEid;
	}

	/**
	 * 组件所属设备模型id设定
	 *
	 * @param deviceEid 组件所属设备模型id
	 */
	public void setDeviceEid(String deviceEid) {
		this.deviceEid = deviceEid;
	}

	/**
	 * 组件所属设备id取得
	 * @return 组件所属设备id
	 */
	public String getDeviceEiid() {
		return deviceEiid;
	}
	
	/**
	 * 组件所属设备id设定
	 *
	 * @param deviceEiid 组件所属设备id
	 */
	public void setDeviceEiid(String deviceEiid) {
		this.deviceEiid = deviceEiid;
	}
	
	/**
	 * 组件所属设备取得
	 * @return 组件所属设备
	 */
	public String getDeviceEiname() {
		return deviceEiname;
	}

	/**
	 * 组件所属设备设定
	 *
	 * @param deviceEiname 组件所属设备
	 */
	public void setDeviceEiname(String deviceEiname) {
		this.deviceEiname = deviceEiname;
	}

	public String getModuleEid() {
		return moduleEid;
	}

	public void setModuleEid(String moduleEid) {
		this.moduleEid = moduleEid;
	}

	public String getModuleEiid() {
		return moduleEiid;
	}

	public void setModuleEiid(String moduleEiid) {
		this.moduleEiid = moduleEiid;
	}

	public String getModuleEiname() {
		return moduleEiname;
	}

	public void setModuleEiname(String moduleEiname) {
		this.moduleEiname = moduleEiname;
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

}
