package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.CodeCategoryInfo;

/**
 * 数据分类信息编辑画面FORM
 * 
 */
@SuppressWarnings("serial")
public class IGSYM1102Form extends BaseForm implements CodeCategoryInfo{

	/** 数据分类CD */
	protected String ccid ;
	
	/** 数据分类名 */
	protected String ccname;

	/** 数据分类说明 */
	protected String ccinfo;

	/** 数据分类编辑标识 */
	protected String cceditable;

	/** 数据分类编号(父) */
	protected String pccid;

	/** 数据分类名称(父) */
	protected String pccname;

	/** 父子类型数据分类标识 */
	protected String pcflag;

	/** 编辑模式（登记/变更 */
	protected String mode = "0";
	
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
	 * 数据分类名取得
	 * @return 数据分类名
	 */
	public String getCcname() {
		return ccname;
	}


	/**
	 * 数据分类名设定
	 *
	 * @param ccname 数据分类名
	 */
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}


	/**
	 * 数据分类说明取得
	 * @return 数据分类说明
	 */
	public String getCcinfo() {
		return ccinfo;
	}


	/**
	 * 数据分类说明设定
	 *
	 * @param ccinfo 数据分类说明
	 */
	public void setCcinfo(String ccinfo) {
		this.ccinfo = ccinfo;
	}


	/**
	 * 数据分类编辑标识取得
	 * @return 数据分类编辑标识
	 */
	public String getCceditable () {
		return cceditable;
	}

	/**
	 * 数据分类编辑标识设定
	 *
	 * @param cceditable 数据分类编辑标识
	 */
	public void setCceditable(String cceditable) {
		this.cceditable = cceditable;
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
	 * 数据分类名称(父)取得
	 * @return 数据分类名称(父)
	 */
	public String getPccname() {
		return pccname;
	}

	/**
	 * 数据分类名称(父)设定
	 *
	 * @param pccname 数据分类名称(父)
	 */
	public void setPccname(String pccname) {
		this.pccname = pccname;
	}

	/**
	 * 父子类型数据分类标识取得
	 * @return 父子类型数据分类标识
	 */
	public String getPcflag() {
		return pcflag;
	}


	/**
	 * 父子类型数据分类标识设定
	 *
	 * @param pcflag 父子类型数据分类标识
	 */
	public void setPcflag(String pcflag) {
		this.pcflag = pcflag;
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
	 * 初始化处理
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
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
	public void setCcevel(String clevel) {
		this.clevel = clevel;
	}
}
