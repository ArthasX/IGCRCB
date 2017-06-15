package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;

/**
 * 
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM32011VO extends BaseVO implements Serializable{
	
	protected SOC0118Info entityItemData;
	
	protected List<RiskcaseVWInfo> riskcaseVWList;
	
	/** 风险事件编号 */
	protected Integer eiid;
	/**
	 * 构造函数
	 * @param entityData　
	 */
	public IGASM32011VO(List<RiskcaseVWInfo> riskcaseVWList) {
		this.riskcaseVWList = riskcaseVWList;
	}
	
	public SOC0118Info getEntityData() {
		return entityItemData;
	}

	public SOC0118Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	public List<RiskcaseVWInfo> getRiskcaseVWList() {
		return riskcaseVWList;
	}

	public void setRiskcaseVWList(List<RiskcaseVWInfo> riskcaseVWList) {
		this.riskcaseVWList = riskcaseVWList;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
}


