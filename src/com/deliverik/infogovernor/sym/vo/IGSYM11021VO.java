package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;

/**
 * 数据分类登记处理ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM11021VO extends BaseVO implements Serializable{
	
	/** 数据分类信息 */
	protected CodeCategoryInfo codeCategoryInfo;

	/**
	 * 构造函数
	 * @param codeCategoryInfo　数据分类信息
	 */
	public IGSYM11021VO(CodeCategoryInfo codeCategoryInfo) {
		this.codeCategoryInfo = codeCategoryInfo;
	}
	
	/**
	 * 数据分类信息取得
	 * @return 数据分类信息
	 */
	public CodeCategoryInfo getCodeCategoryInfo() {
		return codeCategoryInfo;
	}

}


