package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;

@SuppressWarnings("serial")
public class IGDRM21012VO extends BaseVO {
	private List<SOC0119Info> soc0119List;
	private List<String> soc0119ListNames;
	
	public IGDRM21012VO(IGDRM21DTO dto) {
		this.soc0119List = dto.getSoc0119List();
		this.soc0119ListNames = dto.getSoc0119ListNames();
	}

	public List<SOC0119Info> getSoc0119List() {
		return soc0119List;
	}

	public void setSoc0119List(List<SOC0119Info> soc0119List) {
		this.soc0119List = soc0119List;
	}

	public List<String> getSoc0119ListNames() {
		return soc0119ListNames;
	}

	public void setSoc0119ListNames(List<String> soc0119ListNames) {
		this.soc0119ListNames = soc0119ListNames;
	}

}
