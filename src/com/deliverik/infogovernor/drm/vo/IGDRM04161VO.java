package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;

/**
 * 资产配置信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM04161VO extends BaseVO implements Serializable{
	
	/** 资产配置信息检索结果集 */
	Map<String,List<SOC0109Info>> configurationMap;

	/**
	 * 构造函数
	 * @param configurationMap　资产配置信息检索结果
	 */
	public IGDRM04161VO(Map<String, List<SOC0109Info>> configurationMap) {
		this.configurationMap = configurationMap;
	}
	
	/**
	 * 资产配置信息检索结果集取得
	 * @return 资产配置信息检索结果集
	 */
	public Map<String, List<SOC0109Info>> getConfigurationMap() {
		return configurationMap;
	}
}


