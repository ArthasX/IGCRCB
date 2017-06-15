package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseForm;

/**
 * 设备批量入库编辑画面FORM
 * 
 */
public class IGASM0317Form extends BaseForm implements IG013Info{

	private static final long serialVersionUID = 1L;

	/** 设备ID */
	protected Integer eiid;
	
	/** 设备ID（文字） */
	protected String eiidStr;

	/** 资产模型ID */
	protected Integer eid;
	
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
	
	/** 设备批量入库模版设备ID */
	protected String pareiid;
	
	/** 设备批量入库设备label*/
	protected String[] eilabels;
	
	/** 设备批量入库设备name */
	protected String[] einames;
	
	/** 资产管理人*/
	protected String eiuserid;
	
	/** 资产管理人姓名*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** 设备批量入库每次允许的最大条数*/
	protected String maxcount;
	
	/** 设备批量入库的入库条数*/
	protected String addcount;
	
	/** 设备批量入库每条记录的ID*/
	protected String[] ids;
	
	/** 设备批量入库提交的每条记录的ID*/
	protected String[] ids_default;
	
	/** 设备批量入库提交的每个设备的序列号*/
	protected String[] serials;

	/** 资产小版本*/
	protected Integer eismallversion;
	
	/**
	 * @return the serials
	 */
	public String[] getSerials() {
		return serials;
	}
	
	/**
	 * @param serials the serials to set
	 */
	public void setSerials(String[] serials) {
		this.serials = serials;
	}

	/**
	 * @return the ids_default
	 */
	public String[] getIds_default() {
		return ids_default;
	}

	/**
	 * @param ids_default the ids_default to set
	 */
	public void setIds_default(String[] ids_default) {
		this.ids_default = ids_default;
	}

	/**
	 * @return the ids
	 */
	public String[] getIds() {
		return ids;
	}

	/**
	 * @param ids the ids to set
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * @return the maxcount
	 */
	public String getMaxcount() {
		return maxcount;
	}

	/**
	 * @return the addcount
	 */
	public String getAddcount() {
		return addcount;
	}

	/**
	 * @param maxcount the maxcount to set
	 */
	public void setMaxcount(String maxcount) {
		this.maxcount = maxcount;
	}

	/**
	 * @param addcount the addcount to set
	 */
	public void setAddcount(String addcount) {
		this.addcount = addcount;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/** 设备批量入库设备type */
	protected String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getEilabels() {
		return eilabels;
	}

	public void setEilabels(String[] eilabels) {
		this.eilabels = eilabels;
	}

	public String[] getEinames() {
		return einames;
	}

	public void setEinames(String[] einames) {
		this.einames = einames;
	}

	public String getPareiid() {
		return pareiid;
	}

	public void setPareiid(String pareiid) {
		this.pareiid = pareiid;
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
	 * 设备ID取得
	 * @return 设备ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
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


}
