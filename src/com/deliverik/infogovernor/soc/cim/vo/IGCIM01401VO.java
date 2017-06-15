package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;

/**
 * FS关系信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01401VO extends BaseVO implements Serializable{
	
	private List<PlatformManagerInfo> platformManagerList;

	public List<PlatformManagerInfo> getPlatformManagerList() {
		return platformManagerList;
	}

	public void setPlatformManagerList(List<PlatformManagerInfo> platformManagerList) {
		this.platformManagerList = platformManagerList;
	} 
	
	
	
}


