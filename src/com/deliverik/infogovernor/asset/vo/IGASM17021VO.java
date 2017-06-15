package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 组件登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM17021VO extends BaseVO implements Serializable{
	
	/** 组件登录后信息 */
	protected IG013Info entityItemData;
	
	/**
	 * 构造函数
	 * @param entityData　组件登录后信息
	 */
	public IGASM17021VO(IG013Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 组件登录后信息取得
	 * @return 组件登录后信息
	 */
	public IG013Info getEntityData() {
		return entityItemData;
	}
}


