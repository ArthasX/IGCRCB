package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * 流程参与用户信息检索条件实现
 */
public class IG337SearchCondImpl implements IG337SearchCond {
	
	/**
	 * 流程记录ID
	 */
	protected Integer prid;
	
	/**
	 * 流程参与用户角色ID
	 */
	protected Integer pproleid;
	
	/**
	 * 流程参与用户ID
	 */
	protected String ppuserid;
	
	/**
	 * 流程参与用户指定时间
	 */
	protected String ppinittime;
	
	/**
	 * 流程参与用户处理完成时间
	 */
	protected String ppproctime;
	
	/**
	 * 流程参与用户的参与状态（平台保留）
	 */
	protected String ppstatus;
	
	/**
	 * 流程参与用户的参与状态
	 */
	protected String ppstatus_q;
	
	/**
	 * 流程参与用户子状态
	 */
	protected String ppsubstatus;
	
	/**
	 * 流程参与用户信息
	 */
	protected String ppuserinfo;
	
	/**
	 * 流程参与用户判断标识（Y判断流程参与用户是否为空，N判断流程参与用户是否不为空）
	 */
	protected String ppuseridIsNull;
	
	/**
	 * 流程参与用户处理完成标识（Y判断流程参与用户处理完成时间是否为空，N判断流程参与用户处理完成时间是否不为空）
	 */
	protected String ppproctimeIsNull;
	
	/**
	 * 流程参与用户信息ID区间检索条件
	 */
	protected List<Integer> ppidInList;
	
	/**
	 * 流程的所有参与者是否都是指定用户检索条件
	 */
	protected String ppuserid_not;
	
	//====>130225Begin
	/**
	 * 参与人所属机构精确查询
	 */
	protected String pporgid_eq;

	/** 流程状态定义ID */
	protected String psdid;

	/** 动态分支编号 */
	protected Integer psdnum;
	
	/** 是否已经确认（1是null，0是有值）*/
	protected String ppbacktime_isNull;
	
	/**
	 * 参与人所属机构精确查询取得
	 *
	 * @return pporgid_eq 参与人所属机构精确查询
	 */
	public String getPporgid_eq() {
		return pporgid_eq;
	}

	/**
	 * 参与人所属机构精确查询设定
	 *
	 * @param pporgid_eq 参与人所属机构精确查询
	 */
	public void setPporgid_eq(String pporgid_eq) {
		this.pporgid_eq = pporgid_eq;
	}
	//====>130225End

	/**
	 * 流程参与用户的参与状态取得
	 * @return 流程参与用户的参与状态
	 */
	public String getPpstatus_q() {
		return ppstatus_q;
	}

	/**
	 * 流程参与用户的参与状态设定
	 * @param ppstatus_q 流程参与用户的参与状态
	 */
	public void setPpstatus_q(String ppstatus_q) {
		this.ppstatus_q = ppstatus_q;
	}

	/**
	 * 流程参与用户的参与状态取得
	 * @return 流程参与用户的参与状态
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**
	 * 流程参与用户的参与状态设定
	 * @param ppstatus 流程参与用户的参与状态
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程记录ID设定
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程参与用户角色ID取得
	 * @return 流程参与用户角色ID
	 */
	public Integer getPproleid() {
		return pproleid;
	}

	/**
	 * 流程参与用户角色ID设定
	 * @param pproleid 流程参与用户角色ID
	 */
	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * 流程参与用户ID取得
	 * @return 流程参与用户ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * 流程参与用户ID设定
	 * @param ppuserid 流程参与用户ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * 流程参与用户指定时间取得
	 * @return 流程参与用户指定时间
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * 流程参与用户指定时间设定
	 * @param ppinittime 流程参与用户指定时间
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	/**
	 * 流程参与用户处理完成时间取得
	 * @return 流程参与用户处理完成时间
	 */
	public String getPpproctime() {
		return ppproctime;
	}

	/**
	 * 流程参与用户处理完成时间设定
	 * @param ppproctime 流程参与用户处理完成时间
	 */
	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}


	/**
	 * 流程参与用户子状态取得
	 * @return 流程参与用户子状态
	 */
	public String getPpsubstatus() {
		return ppsubstatus;
	}

	/**
	 * 流程参与用户子状态设定
	 * @param ppsubstatus 流程参与用户子状态
	 */
	public void setPpsubstatus(String ppsubstatus) {
		this.ppsubstatus = ppsubstatus;
	}

	/**
	 * 流程参与用户信息取得
	 * @return 流程参与用户信息
	 */
	public String getPpuserinfo() {
		return ppuserinfo;
	}

	/**
	 * 流程参与用户信息设定
	 * @param ppuserinfo 流程参与用户信息
	 */
	public void setPpuserinfo(String ppuserinfo) {
		this.ppuserinfo = ppuserinfo;
	}
	
	/**
	 * 流程参与用户判断标识（Y判断流程参与用户是否为空，N判断流程参与用户是否不为空）取得
	 * @return 流程参与用户判断标识
	 */
	public String getPpuseridIsNull() {
		return ppuseridIsNull;
	}

	/**
	 * 流程参与用户处理完成标识（Y判断流程参与用户处理完成时间是否为空，N判断流程参与用户处理完成时间是否不为空）取得
	 * @return 流程参与用户处理完成标识
	 */
	public String getPpproctimeIsNull() {
		return ppproctimeIsNull;
	}

	/**
	 * 流程参与用户处理完成标识（Y判断流程参与用户处理完成时间是否为空，N判断流程参与用户处理完成时间是否不为空）设定
	 * @param ppproctimeIsNull 流程参与用户处理完成标识
	 */
	public void setPpproctimeIsNull(String ppproctimeIsNull) {
		this.ppproctimeIsNull = ppproctimeIsNull;
	}

	
	
	/**
	 * 流程参与用户判断标识（Y判断流程参与用户是否为空，N判断流程参与用户是否不为空）设定
	 * @param ppuseridIsNull 流程参与用户判断标识
	 */
	public void setPpuseridIsNull(String ppuseridIsNull) {
		this.ppuseridIsNull = ppuseridIsNull;
	}
	
	/**
	 * 流程参与用户信息ID区间检索条件取得
	 * @return 流程参与用户信息ID区间检索条件
	 */
	public List<Integer> getPpidInList() {
		return ppidInList;
	}

	/**
	 * 流程参与用户信息ID区间检索条件设定
	 * @param ppidInList 流程参与用户信息ID区间检索条件
	 */
	public void setPpidInList(List<Integer> ppidInList) {
		this.ppidInList = ppidInList;
	}

	/**
	 * 流程的所有参与者是否都是指定用户检索条件取得
	 * @return 流程的所有参与者是否都是指定用户检索条件
	 */
	public String getPpuserid_not() {
		return ppuserid_not;
	}

	/**
	 * 流程的所有参与者是否都是指定用户检索条件设定
	 * @param ppuserid_not 流程的所有参与者是否都是指定用户检索条件
	 */
	public void setPpuserid_not(String ppuserid_not) {
		this.ppuserid_not = ppuserid_not;
	}

	/**
	 * 流程状态定义ID取得
	 * @return 流程状态定义ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态定义ID设定
	 * @param psdid 流程状态定义ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 动态分支编号取得
	 * @return 动态分支编号
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * 动态分支编号设定
	 * @param psdnum 动态分支编号
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	/**
	 * 是否已经确认（1是null，0是有值）取得
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull() {
		return ppbacktime_isNull;
	}

	/**
	 * 是否已经确认（1是null，0是有值）设定
	 * @param ppbacktime_isNull the 是否已经确认（1是null，0是有值）
	 */
	public void setPpbacktime_isNull(String ppbacktime_isNull) {
		this.ppbacktime_isNull = ppbacktime_isNull;
	}
	
}
