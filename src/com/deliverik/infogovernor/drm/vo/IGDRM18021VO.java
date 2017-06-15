/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

/**
 * <p>
 * Title : InfoGovernor 应急管理
 * </p>
 * <p>
 * Description: 预案统计
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM18021VO extends BaseVO{
	
	/**专项预案列表*/
	protected List<SOC0124Info> planList;

	public List<SOC0124Info> getPlanList() {
		return planList;
	}

	public void setPlanList(List<SOC0124Info> planList) {
		this.planList = planList;
	}
	
	
}
