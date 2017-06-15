package com.deliverik.infogovernor.soc.alarm.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;
//VO
public class IGALM01021VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<CRM05Info> igalm0102List;

	/**
	 * igalm0102Listȡ��
	 *
	 * @return igalm0102List igalm0102List
	 */
	public List<CRM05Info> getIgalm0102List() {
		return igalm0102List;
	}

	/**
	 * igalm0102List�趨
	 *
	 * @param igalm0102List igalm0102List
	 */
	public void setIgalm0102List(List<CRM05Info> igalm0102List) {
		this.igalm0102List = igalm0102List;
	}
	
}
