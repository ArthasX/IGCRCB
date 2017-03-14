package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 设备存量统计分析结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM13031VO extends BaseVO implements Serializable{
	
	/** 设备分布式统计分析信息接口*/
	private List<IG445Info> equDistributingCountList;
	
	/** 总数*/
	private Integer total;
	
	

	public List<IG445Info> getEquDistributingCountList() {
		return equDistributingCountList;
	}

	public void setEquDistributingCountList(
			List<IG445Info> equDistributingCountList) {
		this.equDistributingCountList = equDistributingCountList;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public int getTotal() {
		return total;
	}
}


