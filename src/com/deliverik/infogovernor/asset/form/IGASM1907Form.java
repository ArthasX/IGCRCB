package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0123Info;

/**
 * 设备关系编辑画面FORM
 * 
 */
public class IGASM1907Form extends BaseForm implements SOC0119Info{

	private static final long serialVersionUID = 1L;

	/** 关系ID */
	protected Integer eirid;
	
	/** 关系ID（文字） */
	protected String eiridStr;

	/** 人员ID（父） */
	protected Integer pareiid;
	
	/** 人员label（父） */
	protected String pareilabel;

	/** 人员资产ID（父） */
	protected String pareid;

	/** 资产项ID（子） */
	protected Integer cldeiid;

	/** 资产ID（子） */
	protected String cldeid;

	/** 关系更新时间 */
	protected String eirupdtime;
	
	/** 关系状态 */
	protected String eirstatus;
	
	/** 关系说明 */
	protected String eirdesc;
	
	/** 关系 */
	protected String eirrelation;

	/** 编辑模式（登记/变更） */
	protected String mode = "0";

	/** 资产项模型编码（子） */
	protected String elabel;

	/** 资产项编码（子） */
	protected String eilabel;

	/** 资产项名称（子） */
	protected String einame;

	/** 人员名称(父) */
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
	 * 关系ID取得
	 * @return 关系ID
	 */
	public Integer getEirid() {
		if( (this.eiridStr == null) || (this.eiridStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiridStr);
		}
	}

	/**
	 * 关系ID设定
	 *
	 * @param eirid 关系ID
	 */
	public void setEirid(Integer eirid) {
		this.eirid = eirid;
	}

	/**
	 * 关系ID（文字）取得
	 * @return 关系ID（文字）
	 */
	public String getEiridStr() {
		return eiridStr;
	}

	/**
	 * 关系ID（文字）设定
	 *
	 * @param eiridStr 关系ID（文字）
	 */
	public void setEiridStr(String eiridStr) {
		this.eiridStr = eiridStr;
	}

	/**
	 * 人员ID（父）取得
	 * @return 人员ID（父）
	 */
	public Integer getPareiid() {
		return pareiid;
	}

	/**
	 * 人员ID（父）设定
	 *
	 * @param pareiid 人员ID（父）
	 */
	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	/**
	 * 人员资产ID（父）取得
	 * @return 人员资产ID（父）
	 */
	public String getPareid() {
		return pareid;
	}

	/**
	 * 人员资产ID（父）设定
	 *
	 * @param pareid 人员资产ID（父）
	 */
	public void setPareid(String pareid) {
		this.pareid = pareid;
	}

	/**
	 * 资产项ID（子）取得
	 * @return 人员ID（子）
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}

	/**
	 * 资产项ID（子）设定
	 *
	 * @param cldeiid 人员ID（子）
	 */
	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}

	/**
	 * 资产项资产ID（子）取得
	 * @return 资产项资产ID（子）
	 */
	public String getCldeid() {
		return cldeid;
	}

	/**
	 * 资产项资产ID（子）设定
	 *
	 * @param cldeid 资产项资产ID（子）
	 */
	public void setCldeid(String cldeid) {
		this.cldeid = cldeid;
	}

	/**
	 * 关系更新时间取得
	 * @return 关系更新时间
	 */
	public String getEirupdtime() {
		return eirupdtime;
	}

	/**
	 * 关系更新时间设定
	 *
	 * @param eirupdtime 关系更新时间
	 */
	public void setEirupdtime(String eirupdtime) {
		this.eirupdtime = eirupdtime;
	}

	/**
	 * 关系状态取得
	 * @return 关系状态
	 */
	public String getEirstatus() {
		return eirstatus;
	}

	/**
	 * 关系设定
	 *
	 * @param eirstatus 关系
	 */
	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}

	/**
	 * 关系说明取得
	 * @return 关系说明
	 */
	public String getEirdesc() {
		return eirdesc;
	}

	/**
	 * 关系说明设定
	 *
	 * @param eirdesc 关系说明
	 */
	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
	}

	/**
	 * 关系取得
	 * @return 关系
	 */
	public String getEirrelation() {
		return eirrelation;
	}

	/**
	 * 关系设定
	 *
	 * @param eirelation 关系
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
	 * 资产项模型编码（子）取得
	 * @return 资产项模型编码（子）
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产项模型编码（子）设定
	 *
	 * @param elabel 资产项模型编码（子）
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产项编码（子）取得
	 * @return 才产项编码（子）
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产项编码（子）设定
	 *
	 * @param eilabel 资产项编码（子）
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产项名称（子）取得
	 * @return 资产项名称（子）
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 资产项名称（子）设定
	 *
	 * @param einame 资产项名称（子）
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
	/**
	 * 人员名称取得
	 * @return 人员名称
	 */
	public String getPareiname() {
		return pareiname;
	}

	/**
	 * 人员名称设定
	 *
	 * @param pareiname 人员名称
	 */
	public void setPareiname(String pareiname) {
		this.pareiname = pareiname;
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

	public SOC0123Info getCldEntityItemVW() {
		// TODO Auto-generated method stub
		return null;
	}

	public SOC0123Info getParEntityItemVW() {
		// TODO Auto-generated method stub
		return null;
	}
}
