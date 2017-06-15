package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;

/**
 * 设备统计分析信息FORM
 * 
 */
@SuppressWarnings("serial")
public class IGASM1302Form extends BaseForm implements SOC0604SearchCond{


	/** 机房id*/
	protected Integer roomeiid_q;

	public Integer getRoomeiid_q() {
		return roomeiid_q;
	}

	public void setRoomeiid_q(Integer roomeiid_q) {
		this.roomeiid_q = roomeiid_q;
	}
	
	
}
