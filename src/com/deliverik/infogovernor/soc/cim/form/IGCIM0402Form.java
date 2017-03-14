package com.deliverik.infogovernor.soc.cim.form;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0117Info;

/**
 * 资产模型基本信息编辑画面FORM
 * 
 */
public class IGCIM0402Form extends BaseForm implements SOC0117Info{

	private static final long serialVersionUID = 1L;

	/** 资产模型ID */
	protected String eid;
	
	/** 资产模型ID（文字） */
	protected String eidStr;
	
	/** 资产模型名 */
	protected String ename;
	
	/** 资产模型编号 */
	protected String elabel;

	/** 资产模型说明 */
	protected String edesc;

	/** 资产模型状态 */
	protected String estatus;

	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类 */
	protected String ekey1;
	
	/** 是否继承父类属性 */
	protected String ekey2;
	
	/** 资产模型三级子类 */
	protected String ekey3;

	/** 编辑模式（登记/变更） */
	protected String mode = "0";

	protected String esyscoding;
	
	protected String eparcoding;
	
	protected String eparname;
	
	protected String fingerPrint;
	
	/** 资产大分类 */
	protected String type1;
	
	/** 资产小分类 */
	protected String type2;
	
	protected String eno;
	
	/**
	 * 资产模型类别（0：一般资产模型 1：配置资产模型）
	 */
	protected String emodeltype;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEparcoding() {
		return eparcoding;
	}

	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	public String getEparname() {
		return eparname;
	}

	public void setEparname(String eparname) {
		this.eparname = eparname;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		if(StringUtils.isEmpty(eid)) return eidStr;
		else return this.eid;
		
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
	 * 资产模型名取得
	 * @return 资产模型名
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名设定
	 *
	 * @param ename 资产模型名
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory() {
		return ecategory;
	}


	/**
	 * 资产模型分类设定
	 *
	 * @param ecategory 资产模型分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}


	/**
	 * 资产模型一级子类取得
	 * @return 资产模型一级子类
	 */
	public String getEkey1() {
		return ekey1;
	}


	/**
	 * 资产模型一级子类设定
	 *
	 * @param ekey1 资产模型一级子类
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * 资产模型二级子类取得
	 * @return 资产模型二级子类
	 */
	public String getEkey2() {
		return ekey2;
	}


	/**
	 * 资产模型二级子类设定
	 *
	 * @param ekey2 资产模型二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}


	/**
	 * 资产模型三级子类取得
	 * @return 资产模型三级子类
	 */
	public String getEkey3() {
		return ekey3;
	}


	/**
	 * 资产模型三级子类设定
	 *
	 * @param ekey3 资产模型三级子类
	 */
	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
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
	 * 资产模型说明取得
	 * @return 资产模型说明
	 */
	public String getEdesc() {
		return edesc;
	}


	/**
	 * 资产模型说明设定
	 *
	 * @param edesc 资产模型说明
	 */
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}


	/**
	 * 资产模型状态取得
	 * @return 资产模型状态
	 */
	public String getEstatus() {
		return estatus;
	}


	/**
	 * 资产模型状态设定
	 *
	 * @param estatus 资产模型状态
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
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
	 * 资产模型类别取得
	 * @return 资产模型类别
	 */
	public String getEmodeltype() {
		return emodeltype;
	}
	
	/**
	 * 资产模型类别设定
	 *
	 * @param eparcoding 资产模型类别
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	
}
