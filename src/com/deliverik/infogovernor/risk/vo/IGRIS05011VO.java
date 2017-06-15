/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-9新建 
 * 			
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGRIS05011VO extends BaseVO implements Serializable{
	
	
	/**检查结果map返回*/
	Map<String, Map<String, List<CheckWorkConutVWInfo>>>  checkWorkMap;
	
	
	/**检查结果集合*/
	protected List<CheckWorkConutVWInfo> CheckWorkConutList;

	/**
	 * checkWorkConutList取得
	 * @return checkWorkConutList checkWorkConutList
	 */
	public List<CheckWorkConutVWInfo> getCheckWorkConutList() {
		return CheckWorkConutList;
	}

	/**
	 * checkWorkConutList设定
	 * @param checkWorkConutList checkWorkConutList
	 */
	public void setCheckWorkConutList(List<CheckWorkConutVWInfo> checkWorkConutList) {
		CheckWorkConutList = checkWorkConutList;
	}

	/**
	 * 检查结果map返回取得
	 * @return the checkWorkMap
	 */
	public Map<String, Map<String, List<CheckWorkConutVWInfo>>> getCheckWorkMap() {
		return checkWorkMap;
	}

	/**
	 * 检查结果map返回设定
	 * @param checkWorkMap the 检查结果map返回
	 */
	public void setCheckWorkMap(
			Map<String, Map<String, List<CheckWorkConutVWInfo>>> checkWorkMap) {
		this.checkWorkMap = checkWorkMap;
	}


}
