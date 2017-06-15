package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 服务记录信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM14141VO extends BaseVO implements Serializable{
	
	/** 服务记录信息检索结果 */
	protected List<SOC0118Info> entityDataList;

	/**
	 * 构造函数
	 * @param entityData　服务记录信息检索结果
	 */
	public IGASM14141VO(List<SOC0118Info> entityDataList) {
		this.entityDataList = entityDataList;
	}
	
	/**
	 * 服务记录信息检索结果取得
	 * @return 资产项信息检索结果
	 */
	public List<SOC0118Info> getEntityDataList() {
		return entityDataList;
	}

}


