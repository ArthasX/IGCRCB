package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 机柜登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM12021VO extends BaseVO implements Serializable{
	
	/** 机柜登录后信息 */
	protected IG013Info entityItemData;
	
	/**
	 * 构造函数
	 * @param entityData　机柜登录后信息
	 */
	public IGASM12021VO(IG013Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 机柜登录后信息取得
	 * @return 机柜登录后信息
	 */
	public IG013Info getEntityData() {
		return entityItemData;
	}
}


