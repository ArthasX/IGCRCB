package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * 服务记录详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM14041VO extends BaseVO implements Serializable{
	
	/** 服务记录信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** 权限标识 */
	protected Boolean flag;
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemVWInfoMap　资产项配置信息检索结果
	 */
	public IGASM14041VO(SOC0124Info entityItemData,Map<String,List<SOC0129Info>> configItemVWInfoMap) {
		this.entityItemData = entityItemData;
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * 服务记录信息取得
	 * @return 服务记录信息
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
}


