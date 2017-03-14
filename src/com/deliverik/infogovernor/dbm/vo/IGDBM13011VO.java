/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;

/**
 * 全网IP地址过滤信息检索结果VO
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public class IGDBM13011VO extends BaseVO implements Serializable{

	//工作管理结果集
	protected List<WorkmanagerInfo> wmList;

	/**频率周星期集合*/
	protected List<IGDBM13012VO> weekList;
	
	/**频率月天数集合*/
	protected List<IGDBM13012VO> monthList;
	
	protected Map<String, List<WorkmanagerInfo>> workmanagermap;
	
	protected Map<Integer,String> mapType;

	/**
	 * @return the 频率周星期集合
	 */
	public List<IGDBM13012VO> getWeekList() {
		return weekList;
	}

	/**
	 * @param 频率周星期集合 the weekList to set
	 */
	public void setWeekList(List<IGDBM13012VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * @return the 频率月天数集合
	 */
	public List<IGDBM13012VO> getMonthList() {
		return monthList;
	}

	/**
	 * @param 频率月天数集合 the monthList to set
	 */
	public void setMonthList(List<IGDBM13012VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * @return the workmanagermap
	 */
	public Map<String, List<WorkmanagerInfo>> getWorkmanagermap() {
		return workmanagermap;
	}

	/**
	 * @param workmanagermap the workmanagermap to set
	 */
	public void setWorkmanagermap(Map<String, List<WorkmanagerInfo>> workmanagermap) {
		this.workmanagermap = workmanagermap;
	}

	/**
	 * @return the mapType
	 */
	public Map<Integer, String> getMapType() {
		return mapType;
	}

	/**
	 * @param mapType the mapType to set
	 */
	public void setMapType(Map<Integer, String> mapType) {
		this.mapType = mapType;
	}
	
	/**
	 * @return the wmList
	 */
	public List<WorkmanagerInfo> getWmList() {
		return wmList;
	}

	/**
	 * @param wmList the wmList to set
	 */
	public void setWmList(List<WorkmanagerInfo> wmList) {
		this.wmList = wmList;
	}
	
}


