package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0153Info;

/**
 * 
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM01611VO extends BaseVO implements Serializable{
	
	public IGCIM01611VO(){
		
	}
	public IGCIM01611VO(List<SOC0153Info> soc0153List){
		this.soc0153List = soc0153List;
	}
	
	private List<SOC0153Info> soc0153List;
	private SOC0153Info soc0153Info;
	private List<SOC0113Info> ciTypes;
	
	
	public List<SOC0113Info> getCiTypes() {
		return ciTypes;
	}
	public void setCiTypes(List<SOC0113Info> ciTypes) {
		this.ciTypes = ciTypes;
	}
	public List<SOC0153Info> getSoc0153List() {
		return soc0153List;
	}
	public void setSoc0153List(List<SOC0153Info> soc0153List) {
		this.soc0153List = soc0153List;
	}
	public SOC0153Info getSoc0153Info() {
		return soc0153Info;
	}
	public void setSoc0153Info(SOC0153Info soc0153Info) {
		this.soc0153Info = soc0153Info;
	}
	
	
	
	
}


