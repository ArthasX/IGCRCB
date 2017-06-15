package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;

/**
 * 设备配置详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11161VO extends BaseVO implements Serializable{
	
	/** 设备信息 */
	protected SOC0605Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0606Info>> configItemVWInfoMap;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGASM11161VO(SOC0605Info entityItemData,Map<String,List<SOC0606Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * 系统信息取得
	 * @return 系统信息
	 */
	public SOC0605Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0606Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	
	/**
	 * 权限标识取得
	 * @return 权限标识
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 权限标识设定
	 *
	 * @param flag 权限标识
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
}


