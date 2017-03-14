package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 机房关系信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM07061VO extends BaseVO implements Serializable{
	
	/** 机房信息 */
	protected IG688Info entityItemData;
	
	/** 资产项关系信息1 */
	protected List<IG313Info> parEntityItemRelationList;

	/** 资产项关系信息2 */
	protected List<IG313Info> cldEntityItemRelationList;

	/**
	 * 构造函数
	 * @param entityItemData　机房信息
	 * @param parEntityItemRelationList　资产项关系信息1
	 * @param cldEntityItemRelationList　资产项关系信息2
	 */
	public IGASM07061VO(IG688Info entityItemData,
			List<IG313Info> parEntityItemRelationList,
			List<IG313Info> cldEntityItemRelationList) {
		this.entityItemData = entityItemData;
		this.parEntityItemRelationList = parEntityItemRelationList;
		this.cldEntityItemRelationList = cldEntityItemRelationList;
		
	}
	
	/**
	 * 机房信息取得
	 * @return 机房信息
	 */
	public IG688Info getEntityData() {
		return entityItemData;
	}

	/**
	 * 资产项关系信息1取得
	 * @return 资产项关系信息1
	 */
	public List<IG313Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * 资产项关系信息1件数取得
	 * @return 资产项关系信息1件数
	 */
	public int getParCount() {
		if (parEntityItemRelationList == null) {
			return 0;
		}
		return parEntityItemRelationList.size();
	}

	/**
	 * 资产项关系信息2取得
	 * @return 资产项关系信息2
	 */
	public List<IG313Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}
	
	/**
	 * 资产项关系信息2件数取得
	 * @return 资产项关系信息2件数
	 */
	public int getCldCount() {
		if (cldEntityItemRelationList == null) {
			return 0;
		}
		return cldEntityItemRelationList.size();
	}
}


