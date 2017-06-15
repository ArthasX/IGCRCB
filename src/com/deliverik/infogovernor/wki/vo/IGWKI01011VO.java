package com.deliverik.infogovernor.wki.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;

@SuppressWarnings("serial")
public class IGWKI01011VO extends BaseVO implements Serializable{
	
	protected List<WorkinfoInfo> wkiList;

	public List<WorkinfoInfo> getWkiList() {
		return wkiList;
	}

	public void setWkiList(List<WorkinfoInfo> wkiList) {
		this.wkiList = wkiList;
	}
	
	
}
