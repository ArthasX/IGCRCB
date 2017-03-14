package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.base.BaseForm;

/**
 * 资产项关系编辑画面FORM
 * IGASM0207Form ActionForm
 * 
 */
public class IGASM0207Form extends BaseForm implements IG313Info{

	private static final long serialVersionUID = 1L;

	/** 资产项关系ID */
	protected Integer eirid;
	
	/** 资产项关系ID（文字） */
	protected String eiridStr;

	/** 资产项ID（父） */
	protected Integer pareiid;
	
	/** 资产项label（父） */
	protected String pareilabel;

	/** 资产ID（父） */
	protected Integer pareid;

	/** 资产项ID（子） */
	protected Integer cldeiid;

	/** 资产ID（子） */
	protected Integer cldeid;

	/** 资产项关系更新时间 */
	protected String eirupdtime;
	
	/** 资产项关系状态 */
	protected String eirstatus;
	
	/** 资产项关系说明 */
	protected String eirdesc;
	
	/** 资产项关系 */
	protected String eirrelation;

	/** 编辑模式（登记/变更） */
	protected String mode = "0";

	/** 资产模型编码 */
	protected String elabel;

	/** 资产项编码 */
	protected String eilabel;

	/** 资产项名称 */
	protected String einame;

	/** 资产项(父)名称 */
	protected String pareiname;
	
	/** 资产项关系代码 */
	protected String eirrelationcode;
	
	/** 资产项关系 */
	protected String tempeirrelation;
	
	protected String fingerPrint;
	
	/**
	 * 通过资产属性增加自动生成的关系信息
	 * @return 通过资产属性增加自动生成的关系信息
	 */
	protected String eirinfo;
	
	/** 资产关系编码（平台保留） */
	protected String eirsyscodeing;
	
	/** 正向资产大版本 */
	protected Integer parversion;

	/** 正向资产小版本 */
	protected Integer parsmallversion;

	/** 反向资产大版本 */
	protected Integer cldversion;

	/** 反向资产小版本 */
	protected Integer cldsmallversion;

	/** 逻辑删除标识 */
	protected String deleteflag;

	/**
	 * 正向资产大版本取得
	 * @return 正向资产大版本
	 */
	public Integer getParversion() {
		return parversion;
	}

	public void setParversion(Integer parversion) {
		this.parversion = parversion;
	}

	/**
	 * 正向资产小版本取得
	 * @return 正向资产小版本
	 */
	public Integer getParsmallversion() {
		return parsmallversion;
	}

	public void setParsmallversion(Integer parsmallversion) {
		this.parsmallversion = parsmallversion;
	}

	/**
	 * 反向资产大版本取得
	 * @return 反向资产大版本
	 */
	public Integer getCldversion() {
		return cldversion;
	}

	public void setCldversion(Integer cldversion) {
		this.cldversion = cldversion;
	}

	/**
	 * 反向资产小版本取得
	 * @return 反向资产小版本
	 */
	public Integer getCldsmallversion() {
		return cldsmallversion;
	}

	public void setCldsmallversion(Integer cldsmallversion) {
		this.cldsmallversion = cldsmallversion;
	}

	/**
	 * 逻辑删除标识取得
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * 资产关系编码取得
	 * @return 资产关系编码
	 */
	public String getEirsyscodeing() {
		return eirsyscodeing;
	}

	/**
	 * 资产关系编码设定
	 *
	 * @param eirsyscodeing 资产关系编码
	 */
	public void setEirsyscodeing(String eirsyscodeing) {
		this.eirsyscodeing = eirsyscodeing;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getPareilabel() {
		return pareilabel;
	}

	public void setPareilabel(String pareilabel) {
		this.pareilabel = pareilabel;
	}

	/**
	 * 资产项关系ID取得
	 * @return 资产项关系ID
	 */
	public Integer getEirid() {
		if( (this.eiridStr == null) || (this.eiridStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiridStr);
		}
	}

	/**
	 * 资产项关系ID设定
	 *
	 * @param eirid 资产项关系ID
	 */
	public void setEirid(Integer eirid) {
		this.eirid = eirid;
	}

	/**
	 * 资产项关系ID（文字）取得
	 * @return 资产项关系ID（文字）
	 */
	public String getEiridStr() {
		return eiridStr;
	}

	/**
	 * 资产项关系ID（文字）设定
	 *
	 * @param eiridStr 资产项关系ID（文字）
	 */
	public void setEiridStr(String eiridStr) {
		this.eiridStr = eiridStr;
	}

	/**
	 * 资产项ID（父）取得
	 * @return 资产项ID（父）
	 */
	public Integer getPareiid() {
		return pareiid;
	}

	/**
	 * 资产项ID（父）设定
	 *
	 * @param pareiid 资产项ID（父）
	 */
	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	/**
	 * 资产ID（父）取得
	 * @return 资产ID（父）
	 */
	public Integer getPareid() {
		return pareid;
	}

	/**
	 * 资产ID（父）设定
	 *
	 * @param pareid 资产ID（父）
	 */
	public void setPareid(Integer pareid) {
		this.pareid = pareid;
	}

	/**
	 * 资产项ID（子）取得
	 * @return 资产项ID（子）
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}

	/**
	 * 资产项ID（子）设定
	 *
	 * @param cldeiid 资产项ID（子）
	 */
	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}

	/**
	 * 资产ID（子）取得
	 * @return 资产ID（子）
	 */
	public Integer getCldeid() {
		return cldeid;
	}

	/**
	 * 资产ID（子）设定
	 *
	 * @param cldeid 资产ID（子）
	 */
	public void setCldeid(Integer cldeid) {
		this.cldeid = cldeid;
	}

	/**
	 * 资产项关系更新时间取得
	 * @return 资产项关系更新时间
	 */
	public String getEirupdtime() {
		return eirupdtime;
	}

	/**
	 * 资产项关系更新时间设定
	 *
	 * @param eirupdtime 资产项关系更新时间
	 */
	public void setEirupdtime(String eirupdtime) {
		this.eirupdtime = eirupdtime;
	}

	/**
	 * 资产项关系状态取得
	 * @return 资产项关系状态
	 */
	public String getEirstatus() {
		return eirstatus;
	}

	/**
	 * 资产项关系设定
	 *
	 * @param eirstatus 资产项关系
	 */
	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}

	/**
	 * 资产项关系说明取得
	 * @return 资产项关系说明
	 */
	public String getEirdesc() {
		return eirdesc;
	}

	/**
	 * 资产项关系说明设定
	 *
	 * @param eirdesc 资产项关系说明
	 */
	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
	}

	/**
	 * 资产项关系取得
	 * @return 资产项关系
	 */
	public String getEirrelation() {
		return eirrelation;
	}

	/**
	 * 资产项关系设定
	 *
	 * @param eirelation 资产项关系
	 */
	public void setEirrelation(String eirrelation) {
		this.eirrelation = eirrelation;
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
	 * 资产项名（父）称取得
	 * @return 资产项名称（父）
	 */
	public String getPareiname() {
		return pareiname;
	}

	/**
	 * 资产项名（父）设定
	 *
	 * @param pareiname 资产项名（父）
	 */
	public void setPareiname(String pareiname) {
		this.pareiname = pareiname;
	}

	public IG749Info getCldEntityItemVW() {
		// TODO Auto-generated method stub
		return null;
	}

	public IG749Info getParEntityItemVW() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 资产项关系代码取得
	 * @return 资产项关系代码
	 */
	public String getEirrelationcode() {
		return eirrelationcode;
	}

	/**
	 * 资产项关系代码设定
	 *
	 * @param eirrelationcode 资产项关系代码
	 */
	public void setEirrelationcode(String eirrelationcode) {
		this.eirrelationcode = eirrelationcode;
	}

	public String getParflag() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 资产项关系取得
	 * @return 资产项关系
	 */
	public String getTempeirrelation() {
		return tempeirrelation;
	}

	/**
	 * 资产项关系设定
	 *
	 * @param tempeirrelation 资产项关系
	 */
	public void setTempeirrelation(String tempeirrelation) {
		this.tempeirrelation = tempeirrelation;
	}
	

	/**
	 * 通过资产属性增加自动生成的关系信息取得
	 * @return 通过资产属性增加自动生成的关系信息
	 */
	public String getEirinfo() {
		return eirinfo;
	}

	/**
	 * 通过资产属性增加自动生成的关系信息设定
	 *
	 * @param eirinfo 通过资产属性增加自动生成的关系信息
	 */
	public void setEirinfo(String eirinfo) {
		this.eirinfo = eirinfo;
	}
}
