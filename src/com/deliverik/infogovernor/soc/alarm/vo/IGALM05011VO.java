package com.deliverik.infogovernor.soc.alarm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.alarm.model.CRM10Info;
import com.deliverik.infogovernor.soc.alarm.model.CRMVW01Info;
//VO
public class IGALM05011VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<CRM10Info> igalm0501List;
	private List<CRMVW01Info>igalm0501VWList;

	public List<CRMVW01Info> getIgalm0501VWList() {
		return igalm0501VWList;
	}

	public void setIgalm0501VWList(List<CRMVW01Info> igalm0501vwList) {
		igalm0501VWList = igalm0501vwList;
	}

	/**
	 * igalm0102List取得
	 *
	 * @return igalm0501List igalm0102List
	 */
	public List<CRM10Info> getIgalm0501List() {
		return igalm0501List;
	}

	/**
	 * igalm0102List设定
	 *
	 * @param igalm0102List igalm0501List
	 */
	public void setIgalm0501List(List<CRM10Info> igalm0501List) {
		this.igalm0501List = igalm0501List;
	}
	
}
