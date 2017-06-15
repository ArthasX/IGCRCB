package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.CodeDetailDef;

/**
 * 数据详细信息编辑画面FORM
 * 
 */
public class IGSYM1503Form extends BaseForm implements CodeDetailDef{

	private static final long serialVersionUID = 1L;

	/** 数据分类CD */
	protected String ccid ;
	
	/** 数据分类CD */
	protected String ccname ;
	
	/** 数据CD */
	protected String cid;
	
	/** 数据内容 */
	protected String cvalue;

	/** 数据分类编号(父) */
	protected String pccid;

	/** 数据分类名称(父) */
	protected String pccname;

	/** 数据编号(父) */
	protected String pcid;

	/** 数据说明(父) */
	protected String pcvalue;

	/** 更新时间 */
	protected String updtime;

	/** 编辑模式（登记/变更）  */
	protected String mode = "0";
	
	/** 画面迁移标识 */
	protected String route = "0";
	
	/** 层次码 */
	public String syscoding;
	
	/** 上级层次码 */
	public String psyscoding;
	
	/** 状态 0-停用，1-启用 */
	public String cdstatus;
	
	/** 数据业务码 */
	public String businesscode;
	
	/** 级次 */
	public String clevel;

	/**
	 * 数据分类CD取得
	 * @return 数据分类CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * 数据分类CD设定
	 *
	 * @param ccid 数据分类CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 数据CD取得
	 * @return 数据CD
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * 数据CD设定
	 *
	 * @param cid 数据CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * 数据内容取得
	 * @return 数据内容
	 */
	public String getCvalue() {
		return cvalue;
	}


	/**
	 * 数据内容设定
	 *
	 * @param cvalue 数据内容
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}


	/**
	 * 数据分类编号(父)取得
	 * @return 数据分类编号(父)
	 */
	public String getPccid() {
		return pccid;
	}


	/**
	 * 数据分类编号(父)设定
	 *
	 * @param pccid 数据分类编号(父)
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}


	/**
	 * 数据编号(父)取得
	 * @return 数据编号(父)
	 */
	public String getPcid() {
		return pcid;
	}


	/**
	 * 数据编号(父)设定
	 *
	 * @param pcid 数据编号(父)
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}


	/**
	 * 更新时间取得
	 * @return 更新时间
	 */
	public String getUpdtime() {
		return updtime;
	}


	/**
	 * 更新时间设定
	 *
	 * @param updtime 更新时间
	 */
	public void setUpdtime(String updtime) {
		this.updtime = updtime;
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
	 * 画面迁移标识取得
	 * @return 画面迁移标识
	 */
	public String getRoute() {
		return route;
	}


	/**
	 * 画面迁移标识设定
	 *
	 * @param route 画面迁移标识
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	public String getPccname() {
		return pccname;
	}

	public void setPccname(String pccname) {
		this.pccname = pccname;
	}

	public String getPcvalue() {
		return pcvalue;
	}

	public void setPcvalue(String pcvalue) {
		this.pcvalue = pcvalue;
	}

	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	
	/**
	 * 层次码
	 * @return 层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * 层次码
	 *
	 * @param syscoding 层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * 上级层次码
	 * @return 上级层次码
	 */
	public String getPsyscoding() {
		return psyscoding;
	}

	/**
	 * 层次码
	 *
	 * @param syscoding 层次码
	 */
	public void setPsyscoding(String psyscoding) {
		this.psyscoding = psyscoding;
	}

	/**
	 * 状态 0-停用，1-启用
	 * @return 状态
	 */
	public String getCdstatus() {
		return cdstatus;
	}

	/**
	 * 状态 0-停用，1-启用
	 *
	 * @param cdstatus 状态
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}

	/**
	 * 数据业务码
	 * @return 数据业务码
	 */
	public String getBusinesscode() {
		return businesscode;
	}

	/**
	 * 数据业务码
	 *
	 * @param businesscode 数据业务码
	 */
	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}
	
	/**
	 * 级次
	 * @return 级次
	 */
	public String getClevel() {
		return clevel;
	}

	/**
	 * 级次
	 *
	 * @param clevel 级次
	 */
	public void setClevel(String clevel) {
		this.clevel = clevel;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getCdinfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
