package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.infogovernor.drm.model.SOC0509Info;

@SuppressWarnings("serial")
public class IGDRM20041VO extends BaseVO {
	private List<SOC0117Info> soc0117List;

	public IGDRM20041VO(List<SOC0117Info> soc0509list) {
		this.soc0117List = soc0509list;
	}

	public List<SOC0117Info> getSoc0117List() {
		return soc0117List;
	}

	public void setSoc0117List(List<SOC0117Info> soc0117List) {
		this.soc0117List = soc0117List;
	}

}
