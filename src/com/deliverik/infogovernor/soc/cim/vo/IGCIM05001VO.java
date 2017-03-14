package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 全域拓扑图ＶＯ
 * 功能描述: 全域拓扑图ＶＯ
 * 创建记录: yanglongquan 2013/05/22
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM05001VO extends BaseVO implements Serializable{
	
	/**是否弹出拓扑全域图 1为是*/
	protected String isGoTopology;

	/**域更新时间*/
	protected String updatetime;
	
	/**域版本*/
	protected Integer version;
	
	/**域ID*/
	protected Integer eiddid;
	/**
	 * @return the 是否弹出拓扑全域图
	 */
	public String getIsGoTopology() {
		return isGoTopology;
	}

	/**
	 * @param 是否弹出拓扑全域图 the isGoTopology to set
	 */
	public void setIsGoTopology(String isGoTopology) {
		this.isGoTopology = isGoTopology;
	}

	/**
	 * @return the 域更新时间
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * @param 域更新时间 the updatetime to set
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * @return the 域版本
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param 域版本 the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the 域ID
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * @param 域ID the eiddid to set
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	
}


