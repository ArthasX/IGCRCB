package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.sym.form.IGSYM1101Form;
import com.deliverik.infogovernor.sym.form.IGSYM1102Form;
import com.deliverik.infogovernor.sym.form.IGSYM1104Form;
import com.deliverik.infogovernor.sym.form.IGSYM1106Form;
import com.deliverik.infogovernor.sym.form.IGSYM1109Form;
import com.deliverik.infogovernor.sym.model.Priority;


/**
 * 基础数据管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSYM11DTO extends BaseDTO implements Serializable {
	
	/** 数据分类信息检索结果 */
	protected List<CodeCategoryInfo> codeCategoryInfoList;
	
	/** 数据分类列表画面Form */
	protected IGSYM1101Form igsym1101Form;

	/** 数据分类信息编辑画面Form */
	protected IGSYM1102Form igsym1102Form;

	/** 数据详细信息画面Form */
	protected IGSYM1106Form igsym1106Form;
	
	/** 数据分类信息 */
	protected CodeCategoryInfo codeCategoryInfo;

	/** 数据详细信息检索结果集 */
	protected List<CodeDetail> codeDetailList;
	
	/** 数据详细信息 */
	protected CodeDetail codeDetail;
	
	/** 优先级List */
	protected List<Priority> prioritieList;
	
	/** 流程类别 */
	protected String pprtype;
	
	public List<Priority> getPrioritieList() {
		return prioritieList;
	}

	public void setPrioritieList(List<Priority> prioritieList) {
		this.prioritieList = prioritieList;
	}

	public String getPprtype() {
		return pprtype;
	}

	public void setPprtype(String pprtype) {
		this.pprtype = pprtype;
	}

	public String getIvalue() {
		return ivalue;
	}

	public void setIvalue(String ivalue) {
		this.ivalue = ivalue;
	}

	public String getUvalue() {
		return uvalue;
	}

	public void setUvalue(String uvalue) {
		this.uvalue = uvalue;
	}

	/** 影响度 */
	protected String ivalue;
	
	/** 紧急度 */
	protected String uvalue;
	
	//	
	/** 数据详细信息编辑画面FORM */
	protected IGSYM1104Form igsym1104Form;
	
	/** 流程优先级配置画面Form */
	protected IGSYM1109Form igsym1109Form;
	
	/** 紧急程度 */
	protected List<CodeDetail> prurgencyList;
	
	/** 影响程度 */
	protected List<CodeDetail> primpactList;
	
	
	
	
	
	public IGSYM1101Form getIgsym1101Form() {
		return igsym1101Form;
	}

	public void setIgsym1101Form(IGSYM1101Form igsym1101Form) {
		this.igsym1101Form = igsym1101Form;
	}

	/**
	 * 数据分类信息检索结果取得
	 * @return 代码分类信息检索结果
	 */
	public List<CodeCategoryInfo> getCodeCategoryInfoList() {
		return codeCategoryInfoList;
	}

	/**
	 * 数据分类信息检索结果设定
	 *
	 * @param codeCategoryInfoList 数据分类信息检索结果
	 */
	public void setCodeCategoryInfoList(
			List<CodeCategoryInfo> codeCategoryInfoList) {
		this.codeCategoryInfoList = codeCategoryInfoList;
	}
	/**
	 * 数据分类信息编辑画面Form取得
	 * @return 数据分类信息编辑画面Form
	 */
	public IGSYM1102Form getIgsym1102Form() {
		return igsym1102Form;
	}

	/**
	 * 数据分类信息编辑画面Form设定
	 *
	 * @param igsym1102Form 数据分类信息编辑画面Form
	 */
	public void setIgsym1102Form(IGSYM1102Form igsym1102Form) {
		this.igsym1102Form = igsym1102Form;
	}

	/**
	 * 数据详细信息画面Form取得
	 * @return 数据详细信息画面Form
	 */
	public IGSYM1106Form getIgsym1106Form() {
		return igsym1106Form;
	}

	/**
	 * 数据详细信息画面Form设定
	 *
	 * @param igsym1106Form 数据详细信息画面Form
	 */
	public void setIgsym1106Form(IGSYM1106Form igsym1106Form) {
		this.igsym1106Form = igsym1106Form;
	}

	/**
	 * 数据分类信息取得
	 * @return 数据分类信息
	 */
	public CodeCategoryInfo getCodeCategoryInfo() {
		return codeCategoryInfo;
	}

	/**
	 * 数据分类信息设定
	 *
	 * @param codeCategoryInfo 数据分类信息
	 */
	public void setCodeCategoryInfo(CodeCategoryInfo codeCategoryInfo) {
		this.codeCategoryInfo = codeCategoryInfo;
	}

	/**
	 * 数据详细信息检索结果集取得
	 * @return 数据详细信息检索结果集
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}
	
	/**
	 * 数据详细信息检索结果集设定
	 *
	 * @param codeDetailList 数据详细信息检索结果集
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}
	
	/**
	 * 数据详细信息取得
	 * @return 数据详细信息
	 */
	public CodeDetail getCodeDetail() {
		return codeDetail;
	}

	/**
	 * 数据详细信息设定
	 *
	 * @param codeDetail 数据详细信息
	 */
	public void setCodeDetail(CodeDetail codeDetail) {
		this.codeDetail = codeDetail;
	}

	/**
	 * 数据详细信息编辑画面FORM取得
	 * @return 数据详细信息编辑画面FORM
	 */
	public IGSYM1104Form getIgsym1104Form() {
		return igsym1104Form;
	}

	/**
	 * 数据详细信息编辑画面FORM设定
	 *
	 * @param igsym1104Form 数据详细信息编辑画面FORM
	 */
	public void setIgsym1104Form(IGSYM1104Form igsym1104Form) {
		this.igsym1104Form = igsym1104Form;
	}
	
	/**
	 * 允许查询的最大记录数
	 */
	
	private int maxSearchCount;

	/**
	 * 分页Bean
	 */
	
	private PagingDTO pagingDto;

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public IGSYM1109Form getIgsym1109Form() {
		return igsym1109Form;
	}

	public void setIgsym1109Form(IGSYM1109Form igsym1109Form) {
		this.igsym1109Form = igsym1109Form;
	}
	
	public List<CodeDetail> getPrurgencyList() {
		return prurgencyList;
	}

	public void setPrurgencyList(List<CodeDetail> prurgencyList) {
		this.prurgencyList = prurgencyList;
	}

	public List<CodeDetail> getPrimpactList() {
		return primpactList;
	}

	public void setPrimpactList(List<CodeDetail> primpactList) {
		this.primpactList = primpactList;
	}


}
