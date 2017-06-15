package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;

/**
 * 设备关系编辑画面FORM
 * 
 */
public class IGCIM0107Form extends BaseForm implements SOC0119Info{

	private static final long serialVersionUID = 1L;

	/** 关系ID */
	protected Integer eirid;
	
	/** 关系ID（文字） */
	protected String eiridStr;

	/** 设备ID（父） */
	protected Integer pareiid;
	
	/** 设备label（父） */
	protected String pareilabel;

	/** 设备资产ID（父） */
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

	/** 设备名称(父) */
	protected String pareiname;
	
	/** 资产项关系代码 */
	protected String eirrelationcode;
	
	/** 资产项关系 */
	protected String tempeirrelation;
	
	protected String fingerPrint;
	
	/** 资产所属树根节点实体标识 */
	protected Integer eirootmark;

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
	
	/** 关系类型(普通关系、依赖关系) */
	protected String relationType;
	
	/** 依赖类型(物理、逻辑) */
	protected String belongType;
	
	/** 层次码 */
	protected String esyscoding;
	
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * 依赖类型(物理、逻辑) 取得
	 * @return 依赖类型(物理、逻辑) 
	 */
	public String getBelongType() {
		return belongType;
	}
	/**
	 * 依赖类型(物理、逻辑) 设定
	 *
	 * @param belongType 依赖类型(物理、逻辑) 
	 */
	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}
	/**
	 * 关系类型取得
	 * @return 关系类型
	 */
	public String getRelationType() {
		return relationType;
	}
	/**
	 * 关系类型设定
	 *
	 * @param relationType 关系类型
	 */
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
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
	 * 设备ID（父）取得
	 * @return 设备ID（父）
	 */
	public Integer getPareiid() {
		return pareiid;
	}

	/**
	 * 设备ID（父）设定
	 *
	 * @param pareiid 设备ID（父）
	 */
	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	/**
	 * 设备资产ID（父）取得
	 * @return 设备资产ID（父）
	 */
	public String getPareid() {
		return pareid;
	}

	/**
	 * 设备资产ID（父）设定
	 *
	 * @param pareid 设备资产ID（父）
	 */
	public void setPareid(String pareid) {
		this.pareid = pareid;
	}

	/**
	 * 资产项ID（子）取得
	 * @return 设备ID（子）
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}

	/**
	 * 资产项ID（子）设定
	 *
	 * @param cldeiid 设备ID（子）
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
	 * 设备名称取得
	 * @return 设备名称
	 */
	public String getPareiname() {
		return pareiname;
	}

	/**
	 * 设备名称设定
	 *
	 * @param pareiname 设备名称
	 */
	public void setPareiname(String pareiname) {
		this.pareiname = pareiname;
	}

	public SOC0123Info getCldEntityItemVW() {
		// TODO Auto-generated method stub
		return null;
	}

	public SOC0123Info getParEntityItemVW() {
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

	public String getParflag() {
		// TODO Auto-generated method stub
		return null;
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
	
	/**
	 * 资产所属树根节点实体标识取得
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * 资产所属树根节点实体标识设定
	 *
	 * @param eirootmark 资产所属树根节点实体标识
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}
	
}
