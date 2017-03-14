package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备编辑画面FORM
 * 
 */
public class IGDRM2101Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** 设备ID */
	protected Integer eiid;
	
	/** 设备ID（文字） */
	protected String eiidStr;

	/** 资产模型ID */
	protected String eid;
	
	/** 资产模型ID（文字） */
	protected String eidStr;
	
	/** 资产模型编码 */
	protected String elabel;

	/** 资产模型名称 */
	protected String ename;

	/** 设备名称 */
	protected String einame;
	
	/** 设备编码 */
	protected String eilabel;

	/** 设备说明 */
	protected String eidesc;

	/** 设备状态 */
	protected String eistatus;

	/** 设备变更时间 */
	protected String eiupdtime;
	
	/** 设备版本号 */
	protected Integer eiversion;

	/** 设备登记日 */
	protected String eiinsdate;
	
	/** 编辑模式（登记/变更） */
	protected String mode = "0";
	
	/** 资产项所属机构*/
	protected String eiorgsyscoding;
	
	/** 资产项所属机构名称*/
	protected String eiorgname;
	
	/** 资产项所属模型*/
	protected String esyscoding;
	
	/** 资产管理人*/
	protected String eiuserid;
	
	/** 资产管理人姓名*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** 资产小版本*/
	protected Integer eismallversion;
	
	private String pidid;

	/**开始时间*/
	protected String propentime;
	
	/**结束时间*/
	protected String prclosetime;
	
	/**应急资源id*/
	protected Integer erid;
	
	/**应急资源编码*/
	protected String ercode;
	
	/**应急资源名称*/
	protected String ername;
	
	/** 关联设备对象 */
	protected String[] relationEiid;
	
	/** 资产更新开始时间 */
	protected String eiupdtime_from;
	
	/** 资产更新截止时间 */
	protected String eiupdtime_to;
	
	/** 弹出页标识 */
	protected String openFlag;
	
	/**需要过滤掉的eiid(应急资源专用)*/
	protected String eiidNotIn;
	
	/** 对应资产模型码  */
	protected String esyscode;
	
	/** 单选标识  */
	protected String sign;
	
	protected String[] einames;
	protected String[] eids;
	protected String[] eiids;
	protected String[] eiversions;

	private String[] ids;

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
	 * 设备ID设定
	 *
	 * @param eiid 设备ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 设备ID取得
	 * @return 设备ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设备ID（文字）取得
	 * @return 设备ID（文字）
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * 设备ID（文字）设定
	 *
	 * @param eiidStr 设备ID（文字）
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
			return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
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
	 * 设备名称取得
	 * @return 设备名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设备名称设定
	 *
	 * @param einame 设备名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 设备编码取得
	 * @return 设备编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 设备编码设定
	 *
	 * @param eilabel 设备编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 设备说明取得
	 * @return 设备说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 设备说明设定
	 *
	 * @param eidesc 设备说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 设备更新时间取得
	 * @return 设备更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 设备更新时间设定
	 *
	 * @param eiupdtime 设备更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 设备状态取得
	 * @return 设备状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 设备状态设定
	 *
	 * @param eistatus 设备状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 设备版本号取得
	 * @return 设备版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 设备版本号设定
	 *
	 * @param eiversion 设备版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 编辑模式取得
	 * @return 编辑模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 设备登记日取得
	 * @return 设备登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 设备登记日设定
	 *
	 * @param eiinsdate 设备登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
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

	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getErname() {
		return ername;
	}

	public void setErname(String ername) {
		this.ername = ername;
	}

	public String[] getRelationEiid() {
		return relationEiid;
	}

	public void setRelationEiid(String[] relationEiid) {
		this.relationEiid = relationEiid;
	}

	public String getEiupdtime_from() {
		return eiupdtime_from;
	}

	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}

	public String getEiupdtime_to() {
		return eiupdtime_to;
	}

	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}

	public String getOpenFlag() {
		return openFlag;
	}

	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}

	public String getEiidNotIn() {
		return eiidNotIn;
	}

	public void setEiidNotIn(String eiidNotIn) {
		this.eiidNotIn = eiidNotIn;
	}

	public String getEsyscode() {
		return esyscode;
	}

	public void setEsyscode(String esyscode) {
		this.esyscode = esyscode;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String[] getEinames() {
		return einames;
	}

	public void setEinames(String[] einames) {
		this.einames = einames;
	}

	public String[] getEids() {
		return eids;
	}

	public void setEids(String[] eids) {
		this.eids = eids;
	}

	public String[] getEiids() {
		return eiids;
	}

	public void setEiids(String[] eiids) {
		this.eiids = eiids;
	}

	public String[] getEiversions() {
		return eiversions;
	}

	public void setEiversions(String[] eiversions) {
		this.eiversions = eiversions;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

}
