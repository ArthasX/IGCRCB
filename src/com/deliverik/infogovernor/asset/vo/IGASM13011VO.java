package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 设备存量统计分析结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM13011VO extends BaseVO implements Serializable{
	
	/** 设备统计分析信息接口*/
	private List<IG011Info> entityCountList;
	
	/** 总数*/
	private Integer total;
	
	/**
	 * 构造函数
	 */
	public IGASM13011VO(List<IG011Info> entityCountList,
			Integer total) {
		this.entityCountList = entityCountList;
		this.total = total;

	}
	
	public List<IG011Info> getEntityCountList() {
		return entityCountList;
	}

	public void setEntityCountList(List<IG011Info> entityCountList) {
		this.entityCountList = entityCountList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}


