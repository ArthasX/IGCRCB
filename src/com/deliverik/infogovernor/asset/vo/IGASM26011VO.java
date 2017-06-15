package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.asset.model.IG342Info;

/**
 * 服务商资源池统计结果VO
 * 
 * @author 赵敏
 *
 */
@SuppressWarnings("serial")
public class IGASM26011VO extends BaseVO implements Serializable{

	/** 服务商资源池统计结果 */
	protected List<IG342Info>  entityItemAndConfigItemVWInfoList;

	/**
	 * 获取entityItemAndConfigItemVWInfoList
	 * @return fentityItemAndConfigItemVWInfoList entityItemAndConfigItemVWInfoList
	 */
	public List<IG342Info> getEntityItemAndConfigItemVWInfoList() {
		return entityItemAndConfigItemVWInfoList;
	}

	/**
	 * 设置entityItemAndConfigItemVWInfoList
	 * @param entityItemAndConfigItemVWInfoList  entityItemAndConfigItemVWInfoList
	 */
	public void setEntityItemAndConfigItemVWInfoList(
			List<IG342Info> entityItemAndConfigItemVWInfoList) {
		this.entityItemAndConfigItemVWInfoList = entityItemAndConfigItemVWInfoList;
	}
	
}


