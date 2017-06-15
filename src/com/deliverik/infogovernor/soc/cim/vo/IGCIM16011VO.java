package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0501Info;

/**
 * 人员关系信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM16011VO extends BaseVO implements Serializable{
	
	private SOC0501Info soc0501Info;
	
	private List<SOC0501Info> soc0501Infos;

	public SOC0501Info getSoc0501Info() {
		return soc0501Info;
	}

	public void setSoc0501Info(SOC0501Info soc0501Info) {
		this.soc0501Info = soc0501Info;
	}

	public List<SOC0501Info> getSoc0501Infos() {
		return soc0501Infos;
	}

	public void setSoc0501Infos(List<SOC0501Info> soc0501infos) {
		this.soc0501Infos = soc0501infos;
	}
	
	
	
	
}


