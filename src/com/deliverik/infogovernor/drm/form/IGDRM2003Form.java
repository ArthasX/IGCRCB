package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM2003Form extends BaseForm {
	

	/** 资产配置ID */
	protected String cid;
	
	/** 资产配置ID */
	protected String pcid;
	
	/** 资产配置ID（文字） */
	protected String cidStr;
	
	/** 资产模型ID */
	protected String eid;
	
	/** 资产配置名 */
	protected String cname;
	
	/** 资产配置名 */
	protected String pcname;

	/** 资产配置说明 */
	protected String cdesc;
	
	/** 资产配置单位 */
	protected String cunit;

	/** 资产配置状态 */
	protected String cstatus;
	
	/** 资产配置顺序 */
	protected Integer cseq = 2;
	
	/** 资产配置模型 */
	protected String ccategory;
	
	/** 资产配置取值范围 */
	protected String coption;
	
	/** 资产配置编号 */
	protected String clabel;

	/** 资产模型编号 */
	protected String elabel;
	
	/** 编辑模式（登记/变更）  */
	protected String mode = "0";
	
	/** 画面迁移标识 */
	protected String route = "0";

	/** 资产配置附件标识 */
	protected String cattach;
	
	/** 资产模型层次码 */
	protected String esyscoding;
	
	/** 资产取值范围名称 */
	protected String rangename;
	
	/** 资产属性值关联模型名称 */
	protected String cename;
	
	/** 资产属性值关联模型层次码 */
	protected String cesyscoding;
	
	/** 资产配置必填项 */
	protected String crequired;
	
	protected String btn_save;
	
	protected String[] parent_cids;
	protected String[] node_names;
	protected String[] node_attaches;
	protected String[] node_cseq;
	
	protected String[] sort_cids;
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型层次码设定
	 *
	 * @param esyscoding 资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}


	/**
	 * 资产配置ID取得
	 * @return 资产配置ID
	 */
	public String getCid() {
		if( (this.cidStr == null) || (this.cidStr.equals(""))){
			return null;
		} else {
			return this.cidStr;
		}
	}


	/**
	 * 资产配置ID设定
	 *
	 * @param cid 资产配置ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * 资产配置ID（文字）取得
	 * @return 资产配置ID（文字）
	 */
	public String getCidStr() {
		return cidStr;
	}


	/**
	 * 资产配置ID（文字）设定
	 *
	 * @param cidStr 资产配置ID（文字）
	 */
	public void setCidStr(String cidStr) {
		this.cidStr = cidStr;
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
	 * 资产配置名取得
	 * @return 资产配置名
	 */
	public String getCname() {
		return cname;
	}


	/**
	 * 资产配置名设定
	 *
	 * @param cname 资产配置名
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}


	/**
	 * 资产配置说明取得
	 * @return 资产配置说明
	 */
	public String getCdesc() {
		return cdesc;
	}


	/**
	 * 资产配置说明设定
	 *
	 * @param cdesc 资产配置说明
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}


	/**
	 * 资产配置单位取得
	 * @return 资产配置单位
	 */
	public String getCunit() {
		return cunit;
	}


	/**
	 * 资产配置单位设定
	 *
	 * @param cunit 资产配置单位
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}


	/**
	 * 资产配置状态取得
	 * @return 资产配置状态
	 */
	public String getCstatus() {
		return cstatus;
	}


	/**
	 * 资产配置状态设定
	 *
	 * @param cstatus 资产配置状态
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}


	/**
	 * 资产配置顺序取得
	 * @return 资产配置顺序
	 */
	public Integer getCseq() {
		return cseq;
	}


	/**
	 * 资产配置顺序设定
	 *
	 * @param cseq 资产配置顺序
	 */
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}


	/**
	 * 资产配置模型取得
	 * @return 资产配置模型
	 */
	public String getCcategory() {
		return ccategory;
	}


	/**
	 * 资产配置模型设定
	 *
	 * @param ccategory 资产配置模型
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}


	/**
	 * 资产配置取值范围取得
	 * @return 资产配置取值范围
	 */
	public String getCoption() {
		return coption;
	}


	/**
	 * 资产配置取值范围设定
	 *
	 * @param coption 资产配置取值范围
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}


	/**
	 * 资产配置编号取得
	 * @return 资产配置编号
	 */
	public String getClabel() {
		return clabel;
	}


	/**
	 * 资产配置编号设定
	 *
	 * @param clabel 资产配置编号
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}


	/**
	 * 资产模型编号取得
	 * @return 资产模型编号
	 */
	public String getElabel() {
		return elabel;
	}


	/**
	 * 资产模型编号设定
	 *
	 * @param elabel 资产模型编号
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
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

	/**
	 * 资产配置附件标识取得
	 * @return 资产配置附件标识
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * 资产配置附件标识设定
	 *
	 * @param cattach 资产配置附件标识
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}

	/**
	 * 资产取值范围名称取得
	 * @return 资产取值范围名称
	 */
	public String getRangename() {
		return rangename;
	}

	/**
	 * 资产取值范围名称设定
	 *
	 * @param rangename 资产取值范围名称
	 */
	public void setRangename(String rangename) {
		this.rangename = rangename;
	}

	/**
	 * 资产属性值关联模型名称
	 * @return 资产取值范围名称
	 */
	public String getCename() {
		return cename;
	}

	/**
	 * 资产属性值关联模型名称设定
	 *
	 * @param rangename 资产属性值关联模型名称
	 */
	public void setCename(String cename) {
		this.cename = cename;
	}

	/**
	 * 资产属性值关联模型层次码
	 * @return 资产属性值关联模型层次码
	 */
	public String getCesyscoding() {
		return cesyscoding;
	}

	/**
	 * 资产属性值关联模型层次码设定
	 *
	 * @param rangename 资产属性值关联模型层次码
	 */
	public void setCesyscoding(String cesyscoding) {
		this.cesyscoding = cesyscoding;
	}

	public String getCrequired() {
		return crequired;
	}

	public void setCrequired(String crequired) {
		this.crequired = crequired;
	}

	public Integer getCorder() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPcid() {
		return pcid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public String getBtn_save() {
		return btn_save;
	}

	public void setBtn_save(String btn_save) {
		this.btn_save = btn_save;
	}

	public String[] getParent_cids() {
		return parent_cids;
	}

	public void setParent_cids(String[] parent_cids) {
		this.parent_cids = parent_cids;
	}

	public String[] getNode_names() {
		return node_names;
	}

	public void setNode_names(String[] node_names) {
		this.node_names = node_names;
	}

	public String[] getNode_attaches() {
		return node_attaches;
	}

	public void setNode_attaches(String[] node_attaches) {
		this.node_attaches = node_attaches;
	}

	public String[] getSort_cids() {
		return sort_cids;
	}

	public void setSort_cids(String[] sort_cids) {
		this.sort_cids = sort_cids;
	}

	public String[] getNode_cseq() {
		return node_cseq;
	}

	public void setNode_cseq(String[] node_cseq) {
		this.node_cseq = node_cseq;
	}

}
