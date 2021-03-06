package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * 数据编辑画面FORM
 * 
 */
public class IGASM1602Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** 数据ID */
	protected Integer eiid;
	
	/** 数据ID（文字） */
	protected String eiidStr;

	/** 资产模型ID */
	protected String eid;
	
	/** 资产模型ID（文字） */
	protected String eidStr;
	
	/** 资产模型编码 */
	protected String elabel;

	/** 资产模型名称 */
	protected String ename;

	/** 数据名称 */
	protected String einame;
	
	/** 数据编码 */
	protected String eilabel;

	/** 数据说明 */
	protected String eidesc;

	/** 数据状态 */
	protected String eistatus;

	/** 数据变更时间 */
	protected String eiupdtime;
	
	/** 数据版本号 */
	protected Integer eiversion;

	/** 数据登记日 */
	protected String eiinsdate;
	
	/** 编辑模式（登记/变更） */
	protected String mode = "0";
	
	/** 资产项所属机构*/
	protected String eiorgsyscoding;
	
	/** 资产项所属机构名称*/
	protected String eiorgname;
	
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
	
	/** 资产项所属模型*/
	public String esyscoding;
	
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
	 * 数据ID取得
	 * @return 数据ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * 数据ID设定
	 *
	 * @param eiid 数据ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * 数据ID（文字）取得
	 * @return 数据ID（文字）
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * 数据ID（文字）设定
	 *
	 * @param eiidStr 数据ID（文字）
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
	 * 数据名称取得
	 * @return 数据名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 数据名称设定
	 *
	 * @param einame 数据名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 数据编码取得
	 * @return 数据编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 数据编码设定
	 *
	 * @param eilabel 数据编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 数据说明取得
	 * @return 数据说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 数据说明设定
	 *
	 * @param eidesc 数据说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 数据更新时间取得
	 * @return 数据更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 数据更新时间设定
	 *
	 * @param eiupdtime 数据更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 数据状态取得
	 * @return 数据状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 数据状态设定
	 *
	 * @param eistatus 数据状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 数据版本号取得
	 * @return 数据版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 数据版本号设定
	 *
	 * @param eiversion 数据版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 数据登记日取得
	 * @return 数据登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 数据登记日设定
	 *
	 * @param eiinsdate 数据登记日
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

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}
}
