package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0602Info;

/**
 * 设备信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11151VO extends BaseVO implements Serializable{
	
	/** 设备信息检索结果 */
	protected List<SOC0602Info> entityDataList;

	/**
	 * 构造函数
	 * @param entityData　设备信息检索结果
	 */
	public IGASM11151VO(List<SOC0602Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 设备信息检索结果取得
	 * @return 设备信息检索结果
	 */
	public List<SOC0602Info> getEntityDataList() {
		return entityDataList;
	}

}


