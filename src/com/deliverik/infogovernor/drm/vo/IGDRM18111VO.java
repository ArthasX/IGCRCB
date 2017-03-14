/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor 应急管理
 * </p>
 * <p>
 * Description: 演练统计
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM18111VO extends BaseVO{
	
	/** 演练统计 */
	protected List<Map<String,Object>> drillRateList;
	
	/** 演练类型统计 */
	protected List<Map<String,Object>> drillTypeRateList;

	/**
	 * 演练统计取得
	 * @return drillRateList 演练统计
	 */
	public List<Map<String, Object>> getDrillRateList() {
		return drillRateList;
	}

	/**
	 * 演练统计设定
	 * @param drillRateList 演练统计
	 */
	public void setDrillRateList(List<Map<String, Object>> drillRateList) {
		this.drillRateList = drillRateList;
	}

	/**
	 * 演练类型统计取得
	 * @return drillTypeRateList 演练类型统计
	 */
	public String getDrillTypeRateList() {
		Gson g = new Gson();
		return g.toJson(this.drillTypeRateList);
	}

	/**
	 * 演练类型统计设定
	 * @param drillTypeRateList 演练类型统计
	 */
	public void setDrillTypeRateList(List<Map<String, Object>> drillTypeRateList) {
		this.drillTypeRateList = drillTypeRateList;
	}
}
