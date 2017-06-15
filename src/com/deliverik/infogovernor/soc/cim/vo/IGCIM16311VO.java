package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0163Info;

/**
 * 
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM16311VO extends BaseVO implements Serializable{
	
	private List<SOC0118Info> soc0118List ;
	private List<SOC0124Info> soc0124List;
	private List<SOC0163Info> soc0163List;
	
	
	public List<SOC0163Info> getSoc0163List() {
		return soc0163List;
	}
	public void setSoc0163List(List<SOC0163Info> soc0163List) {
		this.soc0163List = soc0163List;
	}
	private SOC0118Info soc0118Info ;
	private List<SOC0119Info> soc0119List ;
	public List<SOC0118Info> getSoc0118List() {
		return soc0118List;
	}
	public void setSoc0118List(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}
	public SOC0118Info getSoc0118Info() {
		return soc0118Info;
	}
	public void setSoc0118Info(SOC0118Info soc0118Info) {
		this.soc0118Info = soc0118Info;
	}
	public List<SOC0119Info> getSoc0119List() {
		return soc0119List;
	}
	public void setSoc0119List(List<SOC0119Info> soc0119List) {
		this.soc0119List = soc0119List;
	}
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}
	
	
	
}


