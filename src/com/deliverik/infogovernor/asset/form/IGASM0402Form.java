package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * 合同编辑画面FORM
 * 
 */
public class IGASM0402Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** 合同ID */
	protected Integer eiid;
	
	/** 合同ID（文字） */
	protected String eiidStr;

	/** 资产模型ID */
	protected String eid;
	
	/** 资产模型ID（文字） */
	protected String eidStr;
	
	/** 资产模型编码 */
	protected String elabel;

	/** 资产模型名称 */
	protected String ename;

	/** 合同名称 */
	protected String einame;
	
	/** 合同编码 */
	protected String eilabel;

	/** 合同说明 */
	protected String eidesc;

	/** 合同状态 */
	protected String eistatus;

	/** 合同变更时间 */
	protected String eiupdtime;
	
	/** 合同版本号 */
	protected Integer eiversion;

	/** 合同登记日 */
	protected String eiinsdate;
	
	/** 编辑模式（登记/变更） */
	protected String mode = "0";

	/** 所属机构 */
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
	 * 合同ID取得
	 * @return 合同ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * 合同ID设定
	 *
	 * @param eiid 合同ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * 合同ID（文字）取得
	 * @return 合同ID（文字）
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * 合同ID（文字）设定
	 *
	 * @param eiidStr 合同ID（文字）
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
	 * 合同名称取得
	 * @return 合同名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 合同名称设定
	 *
	 * @param einame 合同名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 合同编码取得
	 * @return 合同编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 合同编码设定
	 *
	 * @param eilabel 合同编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 合同说明取得
	 * @return 合同说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 合同说明设定
	 *
	 * @param eidesc 合同说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 合同更新时间取得
	 * @return 合同更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 合同更新时间设定
	 *
	 * @param eiupdtime 合同更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 合同状态取得
	 * @return 合同状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 合同状态设定
	 *
	 * @param eistatus 合同状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 合同版本号取得
	 * @return 合同版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 合同版本号设定
	 *
	 * @param eiversion 合同版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 合同登记日取得
	 * @return 合同登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 合同登记日设定
	 *
	 * @param eiinsdate 合同登记日
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
	 * 资产属性小版本号取得
	 * @return 资产属性小版本号
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * 资产属性小版本号设定
	 *
	 * @param eismallversion 资产属性小版本号
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}

}
