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
public class IGSYM10021VO extends BaseVO implements Serializable{
	
	/** 数据分类信息 */
	protected CodeCategoryInfo entityData;

	/**
	 * 构造函数
	 * @param entityData　数据分类信息
	 */
	public IGSYM10021VO(CodeCategoryInfo entityData) {
		this.entityData = entityData;
	}
	
	/**
	 * 数据分类信息取得
	 * @return 数据分类信息
	 */
	public CodeCategoryInfo getEntityData() {
		return entityData;
	}

}


