package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;

/**
 * 历史纪录信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM12031VO extends BaseVO implements Serializable{
	
	/** 资产项信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
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
	 * @param configItemMap　资产项配置信息检索结果
	 */
	public IGCIM12031VO(SOC0124Info entityItemData,Map<String,List<SOC0107Info>> configItemMap) {
		this.entityItemData = entityItemData;
		this.configItemMap = configItemMap;
	}
	
	/**
	 * 资产项信息取得
	 * @return 资产项信息
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}

	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
}


