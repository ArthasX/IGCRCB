package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;

/**
 * netdevice��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM09111VO extends BaseVO implements Serializable{
	
	protected List<NetDeviceInfo> netDeviceList;

	/**
	 * netDeviceListȡ��
	 *
	 * @return netDeviceList netDeviceList
	 */
	public List<NetDeviceInfo> getNetDeviceList() {
		return netDeviceList;
	}

	/**
	 * netDeviceList�趨
	 *
	 * @param netDeviceList netDeviceList
	 */
	public void setNetDeviceList(List<NetDeviceInfo> netDeviceList) {
		this.netDeviceList = netDeviceList;
	}
}


