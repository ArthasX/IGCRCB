package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.sym.form.IGSYM1001Form;
import com.deliverik.infogovernor.sym.form.IGSYM1004Form;
import com.deliverik.infogovernor.sym.form.IGSYM1006Form;

/**
 * 基础数据管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSYM10DTO extends BaseDTO implements Serializable {
	
	/** 数据分类信息检索结果 */
	protected List<CodeCategoryInfo> codeCategoryList;
	
	/** 数据分类列表画面Form */
	protected IGSYM1001Form igsym1001Form;

	/** 数据详细信息画面Form */
	protected IGSYM1006Form igsym1006Form;

	/** 数据分类信息 */
	protected CodeCategoryInfo codeCategoryInfo;

	/** 数据详细信息检索结果集 */
	protected List<CodeDetail> codeDetailList;
	
	/** 数据详细信息编辑画面FORM */
	protected IGSYM1004Form igsym1004Form;

	/** 数据详细信息错误信息 */
	protected boolean error = false;
	
	protected String flag; 
	/**
	 * 数据分类列表画面Form取得
	 * @return 数据分类列表画面Form
	 */
	public IGSYM1001Form getIgsym1001Form() {
		return igsym1001Form;
	}

	/**
	 * 数据分类列表画面Form设定
	 *
	 * @param igsym1001Form 数据分类列表画面
	 */
	public void setIgsym1001Form(IGSYM1001Form igsym1001Form) {
		this.igsym1001Form = igsym1001Form;
	}
	
	/**
	 * 数据详细信息画面Form取得
	 * @return 数据详细信息画面Form
	 */
	public IGSYM1006Form getIgsym1006Form() {
		return igsym1006Form;
	}

	/**
	 * 数据详细信息画面Form设定
	 *
	 * @param igsym1006Form 数据详细信息画面Form
	 */
	public void setIgsym1006Form(IGSYM1006Form igsym1006Form) {
		this.igsym1006Form = igsym1006Form;
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
	 * 数据详细信息编辑画面FORM取得
	 * @return 数据详细信息编辑画面FORM
	 */
	public IGSYM1004Form getIgsym1004Form() {
		return igsym1004Form;
	}

	/**
	 * 数据详细信息编辑画面FORM设定
	 *
	 * @param igsym1004Form 数据详细信息编辑画面FORM
	 */
	public void setIgsym1004Form(IGSYM1004Form igsym1004Form) {
		this.igsym1004Form = igsym1004Form;
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

	public List<CodeCategoryInfo> getCodeCategoryList() {
		return codeCategoryList;
	}

	public void setCodeCategoryList(List<CodeCategoryInfo> codeCategoryList) {
		this.codeCategoryList = codeCategoryList;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}


	
}
