/*
 * 北京递蓝科信息技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;

/**
 * 值班日报VO
 */
public class IGDUT02031VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 值班日报检索结果 */
	protected Map<String,List<DutyResultVWInfo>> typeMap;	
	
	/** 值班人信息*/
	protected String usersinfo;
	
	/** 值班时间*/
	protected String dptype;

	/** 值班计划*/
	protected DutyPlan dutyPlan;
	
	/** 值班日报ID集合 */
	protected List<Integer> dridList;

	/** 值班日报检查结果选择标识 0不可选 1可选 */
	protected List<String> showList;
	
	/** 值班日报备注 */
	protected String dpremarks;
	
	/** 结果说明是否可编辑 */
	protected List<String> showResultList;
	
	
	public List<String> getShowResultList() {
		return showResultList;
	}

	public void setShowResultList(List<String> showResultList) {
		this.showResultList = showResultList;
	}

	/**
	 * 值班日报检查结果选择标识取得
	 * @return the showList
	 */
	public List<String> getShowList() {
		return showList;
	}

	/**
	 *  值班日报检查结果选择标识设定
	 */
	public void setShowList(List<String> showList) {
		this.showList = showList;
	}
	
	/**
	 * 值班日报ID集合取得
	 * @return the dridList
	 */
	public List<Integer> getDridList() {
		return dridList;
	}

	/**
	 *  值班日报ID集合设定
	 */
	public void setDridList(List<Integer> dridList) {
		this.dridList = dridList;
	}
	
	
	/**
	 *  值班日报检索结果取得
	 * @return the typeMap
	 */
	public DutyPlan getDutyPlan() {
		return dutyPlan;
	}


	/**
	 *  值班日报检索结果设定
	 */
	public void setDutyPlan(DutyPlan dutyPlan) {
		this.dutyPlan = dutyPlan;
	}


	/**
	 *  值班日报检索结果取得
	 * @return the typeMap
	 */
	public Map<String, List<DutyResultVWInfo>> getTypeMap() {
		return typeMap;
	}


	/**
	 *  值班人信息取得
	 * @return the usersinfo
	 */
	public String getUsersinfo() {
		return usersinfo;
	}


	/**
	 *  值班时间取得
	 * @return the dptype
	 */
	public String getDptype() {
		return dptype;
	}


	/**
	 *  值班日报检索结果设定
	 */
	public void setTypeMap(Map<String, List<DutyResultVWInfo>> typeMap) {
		this.typeMap = typeMap;
	}


	/**
	 *  值班人信息设定
	 */
	public void setUsersinfo(String usersinfo) {
		this.usersinfo = usersinfo;
	}


	/**
	 *  值班时间设定
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}


	/**
	 * 值班计划备注取得
	 *
	 * @return dpremarks 值班计划备注
	 */
	public String getDpremarks() {
		return dpremarks;
	}

	/**
	 * 值班计划备注设定
	 *
	 * @param dpremarks 值班计划备注
	 */
	public void setDpremarks(String dpremarks) {
		this.dpremarks = dpremarks;
	}
	
}
