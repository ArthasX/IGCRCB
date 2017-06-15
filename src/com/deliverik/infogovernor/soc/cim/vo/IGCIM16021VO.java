package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0501Info;
import com.deliverik.framework.soc.asset.model.SOC0502Info;

/**
 * 
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM16021VO extends BaseVO implements Serializable{
	
	private SOC0502Info soc0502Info;
	
	private SOC0501Info soc0501Info;
	
	
	private List<SOC0502Info> soc0502Infos;
	
	public SOC0501Info getSoc0501Info() {
		return soc0501Info;
	}

	public void setSoc0501Info(SOC0501Info soc0501Info) {
		this.soc0501Info = soc0501Info;
	}


	public SOC0502Info getSoc0502Info() {
		return soc0502Info;
	}

	public void setSoc0502Info(SOC0502Info soc0502Info) {
		this.soc0502Info = soc0502Info;
	}

	public List<SOC0502Info> getSoc0502Infos() {
		return soc0502Infos;
	}

	public void setSoc0502Infos(List<SOC0502Info> soc0502Infos) {
		this.soc0502Infos = soc0502Infos;
	}
	
	
	
}


