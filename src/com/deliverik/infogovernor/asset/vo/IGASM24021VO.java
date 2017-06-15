package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 发票登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM24021VO extends BaseVO implements Serializable{
	
	/** 发票登录后信息 */
	protected IG013Info entityItemData;
	
	/**
	 * 构造函数
	 * @param entityData　发票登录后信息
	 */
	public IGASM24021VO(IG013Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 发票登录后信息取得
	 * @return 发票登录后信息
	 */
	public IG013Info getEntityData() {
		return entityItemData;
	}
}


