package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 文档登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM50021VO extends BaseVO implements Serializable{
	
	/** 文档登录后信息 */
	protected SOC0118Info entityItemData;
	
	/**
	 * 构造函数
	 * @param entityData　文档登录后信息
	 */
	public IGASM50021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 文档登录后信息取得
	 * @return 文档登录后信息
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


