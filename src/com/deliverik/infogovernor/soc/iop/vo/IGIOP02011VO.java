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
public class IGIOP02011VO extends BaseVO implements Serializable{
	
	private List<SOC0118Info> ipList;

	public List<SOC0118Info> getIpList() {
		return ipList;
	}

	public void setIpList(List<SOC0118Info> ipList) {
		this.ipList = ipList;
	}
	
	
	
}


