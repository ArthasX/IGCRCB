package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;

/**
 * 资产配置信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM11061VO extends BaseVO implements Serializable{
	
	/** 数据分类信息 */
	CodeCategoryInfo codeCategoryInfo;
	
	/** 数据详细信息集合 */
	protected List<CodeDetail> codeDetailList;
	
	/** 数据详细信息 */
	protected CodeDetail codeDetail;

	/**
	 * 构造函数
	 * @param codeCategoryInfo　数据分类信息
	 * @param codeDetailList　数据详细信息集合
	 * @param codeDetail　数据详细信息
	 */
	public IGSYM11061VO(CodeCategoryInfo codeCategoryInfo,
			List<CodeDetail> codeDetailList,CodeDetail codeDetail ) {
		this.codeCategoryInfo = codeCategoryInfo;
		this.codeDetailList = codeDetailList;
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
	 * 数据详细信息集合取得
	 * @return 数据详细信息集合
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}
	
	/**
	 * 数据详细信息取得
	 * @return 数据详细信息
	 */
	public CodeDetail getCodeDetail() {
		return codeDetail;
	}
}


