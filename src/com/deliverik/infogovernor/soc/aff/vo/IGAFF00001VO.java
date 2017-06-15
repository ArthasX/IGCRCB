package com.deliverik.infogovernor.soc.aff.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 设备影响分析信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGAFF00001VO extends BaseVO implements Serializable{
	
	public IGAFF00001VO(){
		
	}
	public IGAFF00001VO(List<SOC0118Info> soc0118List){
		this.soc0118List = soc0118List;
	}
	
	private List<SOC0118Info> soc0118List;

	public List<SOC0118Info> getSoc0118List() {
		return soc0118List;
	}

	public void setSoc0118List(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}
	
	
}


