package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;

/**
 * 数据分类列表信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM10011VO extends BaseVO implements Serializable{
	
	/** 数据分类信息检索结果 */
	protected List<CodeCategoryInfo> entityDataList;

	/**
	 * 构造函数
	 * @param entityData　数据分类列表信息检索结果
	 */
	public IGSYM10011VO(List<CodeCategoryInfo> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 数据分类列表信息检索结果取得
	 * @return 数据分类列表信息检索结果
	 */
	public List<CodeCategoryInfo> getEntityDataList() {
		return entityDataList;
	}

}


