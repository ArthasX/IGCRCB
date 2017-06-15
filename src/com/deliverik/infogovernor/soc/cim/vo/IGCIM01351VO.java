package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;

/**
 * 人员信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01351VO extends BaseVO implements Serializable{
	
	/** 人员信息检索结果 */
	protected List<SOC0119Info> soc0119InfoList;

	public List<SOC0119Info> getSoc0119InfoList() {
		return soc0119InfoList;
	}

	public void setSoc0119InfoList(List<SOC0119Info> soc0119InfoList) {
		this.soc0119InfoList = soc0119InfoList;
	}
	

}


