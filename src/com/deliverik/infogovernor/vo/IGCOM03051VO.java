package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 资产项关系信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03051VO extends BaseVO implements Serializable{
	

	/** 设备信息 */
	protected IG688Info entityItemData;
	
	/** 资产项关系管理信息检索结果1 */
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	
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
	 * @param entityItemData　设备信息
	 * @param parEntityItemRelationMap　资产项关系信息1
	 * @param cldEntityItemRelationList　资产项关系信息2
	 * @param parCount　资产项关系信息1件数
	 * @param cldCount　资产项关系信息2件数
	 */
	public IGCOM03051VO(IG688Info entityItemData,
			Map<String,List<IG313Info>> parEntityItemRelationMap) {
		this.entityItemData = entityItemData;
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}
	
	/**
	 * 设备信息取得
	 * @return 设备信息
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}

	/**
	 * 资产项关系管理信息检索结果1取得
	 * @return 资产项关系管理信息检索结果1
	 */
	public Map<String, List<IG313Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	/**
	 * 资产项关系管理信息检索结果1设定
	 *
	 * @param username 资产项关系管理信息检索结果1
	 */
	public void setParEntityItemRelationMap(
			Map<String, List<IG313Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

}


