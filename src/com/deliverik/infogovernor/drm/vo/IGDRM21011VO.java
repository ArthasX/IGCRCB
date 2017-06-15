package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;

/**
 * 设备登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM21011VO extends BaseVO implements Serializable{
	
	/** 设备登录后信息 */
	protected SOC0118Info entityItemData;
	
	protected String eiorgname;

	private List<SOC0118VWInfo> entityItemVWInfoList;
	

	public SOC0118Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public void setEntityVWItemList(List<SOC0118VWInfo> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	public List<SOC0118VWInfo> getEntityVWItemList() {
		return entityItemVWInfoList;
	}
	
}


