package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;

/**
 * 资产类型登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM20011VO extends BaseVO implements Serializable{
	
	/** 资产类型登录后信息 */
	protected SOC0117Info entityData;
	
	/**
	 * 构造函数
	 * @param entityData　资产类型登录后信息
	 */
	public IGDRM20011VO(SOC0117Info entityData) {
		this.entityData = entityData;
	}
	
	/**
	 * 资产类型登录后信息取得
	 * @return 资产类型登录后信息
	 */
	public SOC0117Info getEntityData() {
		return entityData;
	}

}


