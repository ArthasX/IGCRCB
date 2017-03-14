package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;

/**
 * 资产配置信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM15021VO extends BaseVO implements Serializable{
	
	/** 数据分类信息 */
	CodeCategoryDefInfo codeCategoryDefInfo;
	
	/** 数据详细信息集合 */
	protected List<CodeDetailDef> codeDetailList;
	
	/** 数据详细信息 */
	protected CodeDetailDef codeDetail;

	/**
	 * 构造函数
	 * @param codeCategoryDefInfo　数据分类信息
	 * @param codeDetailList　数据详细信息集合
	 * @param codeDetail　数据详细信息
	 */
	public IGSYM15021VO(CodeCategoryDefInfo codeCategoryDefInfo,
			List<CodeDetailDef> codeDetailList,CodeDetailDef codeDetail ) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
		this.codeDetailList = codeDetailList;
		this.codeDetail = codeDetail;
	}
	
	/**
	 * 数据分类信息取得
	 * @return 数据分类信息
	 */
//	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
//		return codeCategoryDefInfo;
//	}

	/**
	 * 数据详细信息集合取得
	 * @return 数据详细信息集合
	 */
	public List<CodeDetailDef> getCodeDetailList() {
		return codeDetailList;
	}
	
	/**
	 * 数据详细信息取得
	 * @return 数据详细信息
	 */
	public CodeDetailDef getCodeDetail() {
		return codeDetail;
	}

	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}

	public void setCodeCategoryDefInfo(CodeCategoryDefInfo codeCategoryDefInfo) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
	}

	public void setCodeDetailList(List<CodeDetailDef> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	public void setCodeDetail(CodeDetailDef codeDetail) {
		this.codeDetail = codeDetail;
	}
}


