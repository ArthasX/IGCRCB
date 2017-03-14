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
public class IGSYM10061VO extends BaseVO implements Serializable{
	
	/** 数据分类信息 */
	CodeCategoryInfo codeCategoryInfo;
	
	/** 数据详细信息 */
	protected List<CodeDetail> codeDetailList;

	protected String flag;
	/**
	 * 构造函数
	 * @param codeCategoryInfo　数据分类信息
	 * @param codeDetailList　数据详细信息
	 */
	public IGSYM10061VO(CodeCategoryInfo codeCategoryInfo,
			List<CodeDetail> codeDetailList) {
		this.codeCategoryInfo = codeCategoryInfo;
		this.codeDetailList = codeDetailList;
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
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
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


