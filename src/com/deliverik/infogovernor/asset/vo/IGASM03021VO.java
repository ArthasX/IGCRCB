package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 设备登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM03021VO extends BaseVO implements Serializable{
	
	/** 设备登录后信息 */
	protected SOC0118Info entityItemData;
	
	/**
	 * 构造函数
	 * @param entityData　设备登录后信息
	 */
	public IGASM03021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 设备登录后信息取得
	 * @return 设备登录后信息
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


