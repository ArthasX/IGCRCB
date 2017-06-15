package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;

/**
 * 资产配置信息检索结果ＶＯ
 * 
 * @author
 *
 */
public class IGDRM10012VO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 3346185553296597230L;

	/** 数据分类信息 */
	CodeCategoryDefInfo codeCategoryDefInfo;
	
	/** 数据详细信息 */
	protected CodeDetailDef codeDetailDef;

	/**
	 * 构造函数
	 * @param codeCategoryInfo　数据分类信息
	 * @param codeDetail　数据详细信息
	 */
	public IGDRM10012VO(CodeCategoryDefInfo codeCategoryDefInfo,CodeDetailDef codeDetailDef ) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
		this.codeDetailDef = codeDetailDef;
	}
	
	/**
	 * 数据分类信息取得
	 * @return 数据分类信息
	 */
	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}
	
	/**
	 * 数据详细信息取得
	 * @return 数据详细信息
	 */
	public CodeDetailDef getCodeDetailDef() {
		return codeDetailDef;
	}
}


