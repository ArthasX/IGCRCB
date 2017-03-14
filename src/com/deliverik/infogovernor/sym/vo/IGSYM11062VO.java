package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;

/**
 * 资产配置信息检索结果ＶＯ
 * 
 * @author
 *
 */
public class IGSYM11062VO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 3346185553296597230L;

	/** 数据分类信息 */
	CodeCategoryInfo codeCategoryInfo;
	
	/** 数据详细信息 */
	protected CodeDetail codeDetail;

	/**
	 * 构造函数
	 * @param codeCategoryInfo　数据分类信息
	 * @param codeDetail　数据详细信息
	 */
	public IGSYM11062VO(CodeCategoryInfo codeCategoryInfo,CodeDetail codeDetail ) {
		this.codeCategoryInfo = codeCategoryInfo;
		this.codeDetail = codeDetail;
	}
	
	/**
	 * 数据分类信息取得
	 * @return 数据分类信息
	 */
	public CodeCategoryInfo getCodeCategoryInfo() {
		return codeCategoryInfo;
	}
	
	/**
	 * 数据详细信息取得
	 * @return 数据详细信息
	 */
	public CodeDetail getCodeDetail() {
		return codeDetail;
	}
}


