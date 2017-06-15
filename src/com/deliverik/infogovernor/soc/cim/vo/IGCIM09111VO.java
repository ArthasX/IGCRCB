package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;

/**
 * netdevice检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM09111VO extends BaseVO implements Serializable{
	
	protected List<NetDeviceInfo> netDeviceList;

	/**
	 * netDeviceList取得
	 *
	 * @return netDeviceList netDeviceList
	 */
	public List<NetDeviceInfo> getNetDeviceList() {
		return netDeviceList;
	}

	/**
	 * netDeviceList设定
	 *
	 * @param netDeviceList netDeviceList
	 */
	public void setNetDeviceList(List<NetDeviceInfo> netDeviceList) {
		this.netDeviceList = netDeviceList;
	}
}


