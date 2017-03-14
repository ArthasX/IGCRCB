package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;

/**
 * 历史纪录信息ＶＯ
 * 
 * @author
 * @updateDate 2014/04/17 LuJiayuan
 * (1)修正为SOC相应的表和视图
 */
@SuppressWarnings("serial")
public class IGCOM03081VO extends BaseVO implements Serializable{
	
	/** 资产项信息 */
//	protected IG688Info entityItemData;
	/** 资产项信息 */
	protected SOC0605Info entityItemData;
	
	/** 资产项配置信息检索结果 */
//	protected Map<String,List<IG800Info>> configItemMap;
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;	
	
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
	public IGCOM03081VO(SOC0605Info entityItemData,Map<String,List<SOC0107Info>> configItemMap) {
		this.entityItemData = entityItemData;
		this.configItemMap = configItemMap;
	}
	
	/**
	 * 资产项信息取得
	 * @return 资产项信息
	 */
	public SOC0605Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}
}