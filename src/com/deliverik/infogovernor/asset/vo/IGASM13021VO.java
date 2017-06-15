package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0604Info;

/**
 * 机房机柜统计分析结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM13021VO extends BaseVO implements Serializable{
	
	/** 机房机柜统计分析信息接口*/
	private List<SOC0604Info> roomandcontainerList;
	
	/**
	 * 构造函数
	 */
	public IGASM13021VO() {

	}

	public List<SOC0604Info> getRoomandcontainerList() {
		return roomandcontainerList;
	}

	public void setRoomandcontainerList(
			List<SOC0604Info> roomandcontainerList) {
		this.roomandcontainerList = roomandcontainerList;
	}


	
	
}


