/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险指标查询检索条件实现
  * 功能描述: 风险指标查询检索条件实现
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public class RiskIndexSearchVWSearchCondImpl implements
		RiskIndexSearchVWSearchCond {
	
	/**指标名称*/
	protected String einame;
	
	/**指标编号*/
	protected String eilabel;
	
	/**指标分类*/
	protected String syscoding;
	
	/**指标用途*/
	protected String indexused;
	
	/**阀值*/
	protected String zbfz;
	
	/**指标责任人*/
	protected String dutyuser;
	
	/**指标责任部门*/
	protected String dutydepartment;
	
	/**是否关键指标*/
	protected String keyindex;
	
	/**指标管理人*/
	protected String mguserid;
	
	/**登记日期 从时间*/
	protected String eiStartDate;
	
	/**登记日期 到时间*/
	protected String eiEndDate;
	
	/**更新时间 从时间*/
	protected String euStartDate;
	
	/**更新时间 到时间*/
	protected String euEndDate;
	
	/**指标主键EIID*/
	protected String eiid;
	
	/** eiid排除集合*/
	protected String eiid_NotIn;
	
	/** eiid集合*/
	protected String eiid_In;

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getEilabel() {
		return eilabel;
	}

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	public String getSyscoding() {
		return syscoding;
	}

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	public String getIndexused() {
		return indexused;
	}

	public void setIndexused(String indexused) {
		this.indexused = indexused;
	}

	public String getZbfz() {
		return zbfz;
	}

	public void setZbfz(String zbfz) {
		this.zbfz = zbfz;
	}

	public String getDutyuser() {
		return dutyuser;
	}

	public void setDutyuser(String dutyuser) {
		this.dutyuser = dutyuser;
	}

	public String getDutydepartment() {
		return dutydepartment;
	}

	public void setDutydepartment(String dutydepartment) {
		this.dutydepartment = dutydepartment;
	}

	public String getKeyindex() {
		return keyindex;
	}

	public void setKeyindex(String keyindex) {
		this.keyindex = keyindex;
	}

	public String getMguserid() {
		return mguserid;
	}

	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	public String getEiStartDate() {
		return eiStartDate;
	}

	public void setEiStartDate(String eiStartDate) {
		this.eiStartDate = eiStartDate;
	}

	public String getEiEndDate() {
		return eiEndDate;
	}

	public void setEiEndDate(String eiEndDate) {
		this.eiEndDate = eiEndDate;
	}

	public String getEuStartDate() {
		return euStartDate;
	}

	public void setEuStartDate(String euStartDate) {
		this.euStartDate = euStartDate;
	}

	public String getEuEndDate() {
		return euEndDate;
	}

	public void setEuEndDate(String euEndDate) {
		this.euEndDate = euEndDate;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	/**
	 *  eiid排除集合获取
	 * @return the eiid_NotIn
	 */
	public String getEiid_NotIn() {
		return eiid_NotIn;
	}

	/**
	 *  eiid排除集合设定
	 * @param eiid_NotIn the eiid_NotIn to set
	 */
	public void setEiid_NotIn(String eiid_NotIn) {
		this.eiid_NotIn = eiid_NotIn;
	}

	/**
	 * eiid集合获取
	 * @return eiid_In
	 */
	public String getEiid_In() {
		return eiid_In;
	}

	/**
	 * eiid集合设定
	 * @param eiid_In
	 */
	public void setEiid_In(String eiid_In) {
		this.eiid_In = eiid_In;
	}
}