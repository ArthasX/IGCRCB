package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;

@SuppressWarnings("serial")
public class IGDRM21051VO extends BaseVO {
	private List<SOC0118VWInfo> soc0118VWList;

	public IGDRM21051VO(List<SOC0118VWInfo> soc0118VWList) {
		this.soc0118VWList = soc0118VWList;
	}

	public List<SOC0118VWInfo> getSoc0118VWList() {
		return soc0118VWList;
	}

	public void setSoc0118VWList(List<SOC0118VWInfo> soc0118VWList) {
		this.soc0118VWList = soc0118VWList;
	}

}
