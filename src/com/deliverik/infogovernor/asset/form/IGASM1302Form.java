package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;

/**
 * �豸ͳ�Ʒ�����ϢFORM
 * 
 */
@SuppressWarnings("serial")
public class IGASM1302Form extends BaseForm implements SOC0604SearchCond{


	/** ����id*/
	protected Integer roomeiid_q;

	public Integer getRoomeiid_q() {
		return roomeiid_q;
	}

	public void setRoomeiid_q(Integer roomeiid_q) {
		this.roomeiid_q = roomeiid_q;
	}
	
	
}
