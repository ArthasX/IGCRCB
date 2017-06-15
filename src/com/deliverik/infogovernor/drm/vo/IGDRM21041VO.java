package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.PlanInfo;

/**
 * 设备登录后信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM21041VO extends BaseVO implements Serializable{

	private List<PlanInfo> planList;

	public void setPlanList(List<PlanInfo> planList) {
		this.planList = planList;
	}

	public List<PlanInfo> getPlanList() {
		return planList;
	}

	
}


