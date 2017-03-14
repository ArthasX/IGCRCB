package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;

/**
 * @Description: 机房信息ＶＯ
 * @History 2010-5-07     0000428: 增加机房属性管理
 * 
 */
@SuppressWarnings("serial")
public class IGASM11021VO extends BaseVO implements Serializable {
	
	protected List<SOC0109Info> configurationList;
	
	protected List<SOC0606Info> configItemVWInfoList;
	
	/** 机房信息 */
	protected SOC0605Info entityItemData;
	

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGASM11021VO(SOC0605Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	/**
	 * 机房信息取得
	 * @return 机房信息
	 */
	public SOC0605Info getEntityItemData() {
		return entityItemData;
	}


	public List<SOC0109Info> getConfigurationList() {
		return configurationList;
	}

	public void setConfigurationList(List<SOC0109Info> configurationList) {
		this.configurationList = configurationList;
	}

	public List<SOC0606Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	public void setConfigItemVWInfoList(List<SOC0606Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

}
