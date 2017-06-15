package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM32021VO extends BaseVO implements Serializable{
	
	protected SOC0118Info entityItemData;
	
	/** 风险事件编号 */
	protected Integer eiid;

	/** 流程id*/
	protected String riskjobid;
	
	/** 风险事件ID*/
	protected Integer riskid;
	/**
	 * 构造函数
	 * @param entityData　
	 */
	public IGASM32021VO(Integer eiid) {
		this.eiid = eiid;
	}
	
	public SOC0118Info getEntityData() {
		return entityItemData;
	}

	public SOC0118Info getEntityItemData() {
		return entityItemData;
	}

	public void setEntityItemData(SOC0118Info entityItemData) {
		this.entityItemData = entityItemData;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * @return the riskjobid
	 */
	public String getRiskjobid() {
		return riskjobid;
	}

	/**
	 * @param riskjobid the riskjobid to set
	 */
	public void setRiskjobid(String riskjobid) {
		this.riskjobid = riskjobid;
	}

	/**
	 * @return the riskid
	 */
	public Integer getRiskid() {
		return riskid;
	}

	/**
	 * @param riskid the riskid to set
	 */
	public void setRiskid(Integer riskid) {
		this.riskid = riskid;
	}
	
	
	
}


