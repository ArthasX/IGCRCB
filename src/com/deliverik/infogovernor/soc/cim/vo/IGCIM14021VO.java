package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 人员登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM14021VO extends BaseVO implements Serializable{
	
	/** 人员登录后信息 */
	protected SOC0118Info entityItemData;
	
	/**
	 * 构造函数
	 * @param entityData　人员登录后信息
	 */
	public IGCIM14021VO(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}
	
	/**
	 * 人员登录后信息取得
	 * @return 人员登录后信息
	 */
	public SOC0118Info getEntityData() {
		return entityItemData;
	}
}


