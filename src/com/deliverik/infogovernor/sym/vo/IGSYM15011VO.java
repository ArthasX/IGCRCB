package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryDefInfo;

/**
 * 数据分类列表信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM15011VO extends BaseVO implements Serializable{
	
	/** 数据分类列表信息检索结果 */
	protected List<CodeCategoryDefInfo> codeCategoryDefInfoList;

	/**
	 * 构造函数
	 * @param entityData　数据分类列表信息检索结果
	 */
	public IGSYM15011VO(List<CodeCategoryDefInfo> codeCategoryDefInfoList) {
		this.codeCategoryDefInfoList = codeCategoryDefInfoList;
	}
	
	/**
	 * 数据分类列表信息检索结果取得
	 * @return 数据分类列表信息检索结果
	 */
	public List<CodeCategoryDefInfo> getCodeCategoryDefInfoList() {
		return codeCategoryDefInfoList;
	}

}


