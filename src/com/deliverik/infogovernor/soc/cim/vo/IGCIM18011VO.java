package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.alarm.model.entity.HQServerTB;

public class IGCIM18011VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 979882481280691415L;
	private List<HQServerTB> hqServerTBList;

	public List<HQServerTB> getHqServerTBList() {
		return hqServerTBList;
	}
	public void setHqServerTBList(List<HQServerTB> hqServerTBList) {
		this.hqServerTBList = hqServerTBList;
	}
}
