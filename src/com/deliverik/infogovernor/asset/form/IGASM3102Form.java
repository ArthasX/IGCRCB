package com.deliverik.infogovernor.asset.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * 检查项编辑画面FORM
 * 
 */
public class IGASM3102Form extends BaseForm implements SOC0118Info {

	private static final long serialVersionUID = 1L;

	/** 检查项ID */
	protected Integer eiid;

	/** 检查项ID（文字） */
	protected String eiidStr;

	/** 资产模型ID */
	protected String eid;

	/** 资产模型ID（文字） */
	protected String eidStr;

	/** 资产模型编码 */
	protected String elabel;

	/** 资产模型名称 */
	protected String ename;

	/** 检查项名称 */
	protected String einame;

	/** 检查项编码 */
	protected String eilabel;

	/** 检查项说明 */
	protected String eidesc;

	/** 检查项状态 */
	protected String eistatus;

	/** 检查项变更时间 */
	protected String eiupdtime;

	/** 检查项版本号 */
	protected Integer eiversion;

	/** 检查项登记日 */
	protected String eiinsdate;

	/** 编辑模式（登记/变更） */
	protected String mode = "0";

	/** 资产项所属机构 */
	protected String eiorgsyscoding;

	/** 资产项所属机构名称 */
	protected String eiorgname;

	/** 资产管理人 */
	protected String eiuserid;

	/** 资产管理人姓名 */
	protected String eiusername;

	protected String fingerPrint;

	/** 资产小版本 */
	protected Integer eismallversion;

	/** 风险指标--管理人ID */
	protected String mguserid;
	/** 风险指标--管理人名字 */
	protected String mgusername;
	/** 风险指标属性值 */
	protected String[] civalue;
	/** 风险指标附件*/
	protected FormFile attachFile;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/** 资产项所属模型 */
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
	 * 检查项ID取得
	 * 
	 * @return 检查项ID
	 */
	public Integer getEiid() {
		if ((this.eiidStr == null) || (this.eiidStr.equals(""))) {
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * 检查项ID设定
	 * 
	 * @param eiid
	 *            检查项ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 检查项ID（文字）取得
	 * 
	 * @return 检查项ID（文字）
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * 检查项ID（文字）设定
	 * 
	 * @param eiidStr
	 *            检查项ID（文字）
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * 资产模型ID取得
	 * 
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 * 
	 * @param eid
	 *            资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产模型ID（文字）取得
	 * 
	 * @return 资产模型ID（文字）
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * 资产模型ID（文字）设定
	 * 
	 * @param eidStr
	 *            资产模型ID（文字）
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	/**
	 * 资产模型编码取得
	 * 
	 * @return 资产模型编码
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产模型编码设定
	 * 
	 * @param elabel
	 *            资产模型编码
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产模型名称取得
	 * 
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 * 
	 * @param ename
	 *            资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 检查项名称取得
	 * 
	 * @return 检查项名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 检查项名称设定
	 * 
	 * @param einame
	 *            检查项名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 检查项编码取得
	 * 
	 * @return 检查项编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 检查项编码设定
	 * 
	 * @param eilabel
	 *            检查项编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 检查项说明取得
	 * 
	 * @return 检查项说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 检查项说明设定
	 * 
	 * @param eidesc
	 *            检查项说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 检查项更新时间取得
	 * 
	 * @return 检查项更新时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 检查项更新时间设定
	 * 
	 * @param eiupdtime
	 *            检查项更新时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 检查项状态取得
	 * 
	 * @return 检查项状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 检查项状态设定
	 * 
	 * @param eistatus
	 *            检查项状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 检查项版本号取得
	 * 
	 * @return 检查项版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 检查项版本号设定
	 * 
	 * @param eiversion
	 *            检查项版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 检查项登记日取得
	 * 
	 * @return 检查项登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 检查项登记日设定
	 * 
	 * @param eiinsdate
	 *            检查项登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 编辑模式取得
	 * 
	 * @return 编辑模式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 编辑模式设定
	 * 
	 * @param mode
	 *            编辑模式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 资产管理人取得
	 * 
	 * @return 资产管理人
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * 资产管理人设定
	 * 
	 * @param eiuserid
	 *            资产管理人
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * 资产管理人姓名取得
	 * 
	 * @return 资产管理人姓名
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * 资产管理人姓名设定
	 * 
	 * @param eiusername
	 *            资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	public Integer getEirootmark() {
		return null;
	}

	/**
	 * 资产小版本取得
	 * 
	 * @return 资产小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * 资产小版本设定
	 * 
	 * @param eismallversion
	 *            资产小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	public String getMguserid() {
		return mguserid;
	}

	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	public String getMgusername() {
		return mgusername;
	}

	public void setMgusername(String mgusername) {
		this.mgusername = mgusername;
	}

	public String[] getCivalue() {
		return civalue;
	}

	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

	public FormFile getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(FormFile attachFile) {
		this.attachFile = attachFile;
	}

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}

}
