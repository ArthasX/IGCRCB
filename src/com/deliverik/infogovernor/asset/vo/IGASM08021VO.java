package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 应用登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM08021VO extends BaseVO implements Serializable{
	
	/** 应用登录后信息 */
	protected SOC0118Info entityItemData;
	
	/**
	 * 构造函数
	 * @param entityData　应用登录后信息
	 */
	public IGASM08021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 应用登录后信息取得
	 * @return 应用登录后信息
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


