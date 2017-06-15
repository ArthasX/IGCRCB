package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.infogovernor.sym.form.IGSYM1501Form;
import com.deliverik.infogovernor.sym.form.IGSYM1502Form;
import com.deliverik.infogovernor.sym.form.IGSYM1503Form;
import com.deliverik.infogovernor.sym.form.IGSYM1507Form;
import com.deliverik.infogovernor.sym.form.IGSYM1508Form;

/**
 * 基础数据管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSYM15DTO extends BaseDTO implements Serializable {
	
	/** 数据分类信息检索结果 */
	protected List<CodeCategoryDefInfo> codeCategoryDefInfoList;
	
	/** 数据分类列表画面Form */
	protected IGSYM1508Form igsym1508Form;

	/** 数据分类信息编辑画面Form */
	protected IGSYM1507Form igsym1507Form;

	/** 数据详细信息画面Form */
	protected IGSYM1502Form igsym1502Form;

	/** 数据分类信息 */
	protected CodeCategoryDefInfo codeCategoryDefInfo;

	/** 数据详细信息检索结果集 */
	protected List<CodeDetailDef> codeDetailDefList;
	
	/** 数据详细信息 */
	protected CodeDetailDef codeDetailDef;
//	
	/** 数据详细信息编辑画面FORM */
	protected IGSYM1503Form igsym1503Form;
	
	/** 数据定义列表画面Form */
	protected IGSYM1501Form igsym1501Form;
	
//	public IGSYM1101Form getIgsym1101Form() {
//		return igsym1101Form;
//	}
//
//	public void setIgsym1101Form(IGSYM1101Form igsym1101Form) {
//		this.igsym1101Form = igsym1101Form;
//	}

	/**
	 * 数据分类信息检索结果取得
	 * @return 代码分类信息检索结果
	 */
	public List<CodeCategoryDefInfo> getCodeCategoryDefInfoList() {
		return codeCategoryDefInfoList;
	}

	/**
	 * 数据分类信息检索结果设定
	 *
	 * @param codeCategoryDefInfoList 数据分类信息检索结果
	 */
	public void setCodeCategoryDefInfoList(
			List<CodeCategoryDefInfo> codeCategoryDefInfoList) {
		this.codeCategoryDefInfoList = codeCategoryDefInfoList;
	}
	/**
	 * 数据分类信息编辑画面Form取得
	 * @return 数据分类信息编辑画面Form
	 */
	public IGSYM1507Form getIgsym1507Form() {
		return igsym1507Form;
	}

	/**
	 * 数据分类信息编辑画面Form设定
	 *
	 * @param igsym1507Form 数据分类信息编辑画面Form
	 */
	public void setIgsym1507Form(IGSYM1507Form igsym1507Form) {
		this.igsym1507Form = igsym1507Form;
	}

	/**
	 * 数据分类信息取得
	 * @return 数据分类信息
	 */
	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}

	/**
	 * 数据分类信息设定
	 *
	 * @param codeCategoryDefInfo 数据分类信息
	 */
	public void setCodeCategoryDefInfo(CodeCategoryDefInfo codeCategoryDefInfo) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
	}

	/**
	 * 数据详细信息检索结果集取得
	 * @return 数据详细信息检索结果集
	 */
	public List<CodeDetailDef> getCodeDetailDefList() {
		return codeDetailDefList;
	}
	
	/**
	 * 数据详细信息检索结果集设定
	 *
	 * @param codeDetailDefList 数据详细信息检索结果集
	 */
	public void setCodeDetailDefList(List<CodeDetailDef> codeDetailDefList) {
		this.codeDetailDefList = codeDetailDefList;
	}
	
	/**
	 * 数据详细信息取得
	 * @return 数据详细信息
	 */
	public CodeDetailDef getCodeDetailDef() {
		return codeDetailDef;
	}

	/**
	 * 数据详细信息设定
	 *
	 * @param codeDetailDef 数据详细信息
	 */
	public void setCodeDetailDef(CodeDetailDef codeDetailDef) {
		this.codeDetailDef = codeDetailDef;
	}

//	/**
//	 * 数据详细信息编辑画面FORM取得
//	 * @return 数据详细信息编辑画面FORM
//	 */
//	public IGSYM1503Form getIgsym1104Form() {
//		return igsym1104Form;
//	}
//
//	/**
//	 * 数据详细信息编辑画面FORM设定
//	 *
//	 * @param igsym1104Form 数据详细信息编辑画面FORM
//	 */
//	public void setIGSYM1503Form(IGSYM1503Form igsym1104Form) {
//		this.igsym1104Form = igsym1104Form;
//	}
	
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

	public IGSYM1501Form getIgsym1501Form() {
		return igsym1501Form;
	}

	public void setIgsym1501Form(IGSYM1501Form igsym1501Form) {
		this.igsym1501Form = igsym1501Form;
	}

	public IGSYM1502Form getIgsym1106Form() {
		return igsym1502Form;
	}

	public void setIgsym1502Form(IGSYM1502Form igsym1502Form) {
		this.igsym1502Form = igsym1502Form;
	}

	public IGSYM1503Form getIgsym1503Form() {
		return igsym1503Form;
	}

	public void setIgsym1503Form(IGSYM1503Form igsym1503Form) {
		this.igsym1503Form = igsym1503Form;
	}

	/**
	 * @return the igsym1508Form
	 */
	public IGSYM1508Form getIgsym1508Form() {
		return igsym1508Form;
	}

	/**
	 * @param igsym1508Form the igsym1508Form to set
	 */
	public void setIgsym1508Form(IGSYM1508Form igsym1508Form) {
		this.igsym1508Form = igsym1508Form;
	}

	/**
	 * @return the igsym1502Form
	 */
	public IGSYM1502Form getIgsym1502Form() {
		return igsym1502Form;
	}
	
}
