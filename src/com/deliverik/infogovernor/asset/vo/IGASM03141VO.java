package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

public class IGASM03141VO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/** 设备信息检索结果 */
	protected SOC0124Info entityItemVWInfo;
	
	/** 权限 */
	protected Boolean flag;

	/**
	 * 构造函数
	 * @param entityData　设备信息检索结果
	 * @param flag　权限
	 */
	public IGASM03141VO(SOC0124Info entityItemVWInfo,Boolean flag) {
		this.entityItemVWInfo = entityItemVWInfo;
		this.flag = flag;
	}

	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}
	
	public Boolean getFlag() {
		return flag;
	}
}