package com.deliverik.infogovernor.soc.iop.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * �豸Ӱ�������Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGIOP01031VO extends BaseVO implements Serializable{
	
	public IGIOP01031VO() {

	}

	public IGIOP01031VO(List<SOC0118Info> soc0118List) {
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


