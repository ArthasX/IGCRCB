package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseForm;

/**
 * 资产项编辑画面FORM
 * 
 */
public class IGASM0202Form extends BaseForm implements IG013Info{

	private static final long serialVersionUID = 1L;

	/** 资产项ID */
	protected Integer eiid;
	
	/** 资产项ID（文字） */
	protected String eiidStr;

	/** 资产模型ID */
	protected Integer eid;
	
	/** 资产模型ID（文字） */
	protected String eidStr;
	
	/** 资产模型编码 */
	protected String elabel;

	/** 资产模型名称 */
	protected String ename;

	/** 资产项名称 */
	protected String einame;
	
	/** 资产项编码 */
	protected String eilabel;

	/** 资产项说明 */
	protected String eidesc;

	/** 资产项状态 */
	protected String eistatus;

	/** 资产项变更时间 */
	protected String eiupdtime;
	
	/** 资产项版本号 */
	protected Integer eiversion;

	/** 资产项登记日 */
	protected String eiinsdate;
	
	/** 编辑模式（登记/变更） */
	protected String mode = "0";

	/** 资产项所属机构*/
	protected String eiorgsyscoding;
	
	/** 资产项所属机构名称*/
	protected String eiorgname;
	
	protected String fingerPrint;
	
	/** 资产管理人*/
	protected String eiuserid;
	
	/** 资产管理人姓名*/
	protected String eiusername;
	
	/** 资产小版本*/
	protected Integer eismallversion;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/** 资产项所属模型*/
	public String esyscoding;

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

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 资产项ID取得
	 * @return 资产项ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * 资产项ID设定
	 *
	 * @param eiid 资产项ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * 资产项ID（文字）取得
	 * @return 资产项ID（文字）
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * 资产项ID（文字）设定
	 *
	 * @param eiidStr 资产项ID（文字）
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
	 * 资产项名称取得
	 * @return 资产项名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 资产项名称设定
	 *
	 * @param einame 资产项名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资产项编码取得
	 * @return 资产项编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产项编码设定
	 *
	 * @param eilabel 资产项编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产项说明取得
	 * @return 资产项说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 资产项说明设定
	 *
	 * @param eidesc 资产项说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 资产项更新时间取得
	 * @return 资产项更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 资产项更新时间设定
	 *
	 * @param eiupdtime 资产项更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 资产项状态取得
	 * @return 资产项状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 资产项状态设定
	 *
	 * @param eistatus 资产项状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 资产项版本号取得
	 * @return 资产项版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产项版本号设定
	 *
	 * @param eiversion 资产项版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 资产项登记日取得
	 * @return 资产项登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 资产项登记日设定
	 *
	 * @param eiinsdate 资产项登记日
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
