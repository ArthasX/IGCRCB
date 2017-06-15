package com.deliverik.infogovernor.soc.alarm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;

public class IGALM03021VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 该对象已经添加的规则模板列表 */
	protected List<CRM08Info> ruleTemps;
	
	/** 该对象尚未添加的规则模板列表 */
	protected List<CRM08Info> ruleTempsNeed;
	
	protected String flag;
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/** 对象规则模板关系实体 */
	protected CRM09Info crm09Info;

	public CRM09Info getCrm09Info() {
		return crm09Info;
	}

	public void setCrm09Info(CRM09Info crm09Info) {
		this.crm09Info = crm09Info;
	}

	public List<CRM08Info> getRuleTemps() {
		return ruleTemps;
	}

	public void setRuleTemps(List<CRM08Info> ruleTemps) {
		this.ruleTemps = ruleTemps;
	}

	public List<CRM08Info> getRuleTempsNeed() {
		return ruleTempsNeed;
	}

	public void setRuleTempsNeed(List<CRM08Info> ruleTempsNeed) {
		this.ruleTempsNeed = ruleTempsNeed;
	}
	
	
}
