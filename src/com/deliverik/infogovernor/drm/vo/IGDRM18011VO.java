/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

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
public class IGDRM18011VO extends BaseVO{
	
	/** 预案统计列表 */
	protected List<Map<String,Object>> planRateList;

	/**
	 * 预案统计列表取得
	 * @return planRateList 预案统计列表
	 */
	public List<Map<String, Object>> getPlanRateList() {
		return planRateList;
	}

	/**
	 * 预案统计列表设定
	 * @param planRateList 预案统计列表
	 */
	public void setPlanRateList(List<Map<String, Object>> planRateList) {
		this.planRateList = planRateList;
	}
}
