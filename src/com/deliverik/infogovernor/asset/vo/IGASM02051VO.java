package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 资产项历史纪录信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM02051VO extends BaseVO implements Serializable{
	
	/** 资产项信息 */
	protected IG688Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG800Info>> configItemMap;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产版本列表 */
	protected List<IG887Info> configItemVersionTime;
	
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
	public IGASM02051VO(IG688Info entityItemData,Map<String,List<IG800Info>> configItemMap) {
		this.entityItemData = entityItemData;
		this.configItemMap = configItemMap;
	}
	
	/**
	 * 资产项信息取得
	 * @return 资产项信息
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<IG800Info>> getConfigItemMap() {
		return configItemMap;
	}
	

	/**
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * 资产版本列表设定
	 *
	 * @param configItemVersionTime 资产版本列表
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}
	
}


