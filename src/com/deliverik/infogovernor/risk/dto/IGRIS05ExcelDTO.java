/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-11新建 
 * 			
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGRIS05ExcelDTO extends ExcelDTO {

	/**检查结果map返回*/
	protected Map<String, Map<String,List<CheckWorkConutVWInfo>>> map;
	
	/**类别*/
	protected Map<String,Map<Integer,String>> mapType;

	/**
	 * 检查结果map返回取得
	 * @return the 检查结果map返回
	 */
	public Map<String, Map<String, List<CheckWorkConutVWInfo>>> getMap() {
		return map;
	}

	/**
	 * 检查结果map返回设定
	 * @param map the 检查结果map返回
	 */
	public void setMap(Map<String, Map<String, List<CheckWorkConutVWInfo>>> map) {
		this.map = map;
	}

	/**
	 * 类别取得
	 * @return the mapType
	 */
	public Map<String, Map<Integer, String>> getMapType() {
		return mapType;
	}

	/**
	 * 类别设定
	 * @param mapType the 类别
	 */
	public void setMapType(Map<String, Map<Integer, String>> mapType) {
		this.mapType = mapType;
	}

}
