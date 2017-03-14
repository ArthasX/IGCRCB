package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 合同登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM04021VO extends BaseVO implements Serializable{
	
	/** 合同登录后信息 */
	protected SOC0118Info entityItemData;
	
	/**
	 * 构造函数
	 * @param entityData　合同登录后信息
	 */
	public IGASM04021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 合同登录后信息取得
	 * @return 合同登录后信息
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


