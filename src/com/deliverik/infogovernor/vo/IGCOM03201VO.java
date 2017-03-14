package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.SOC0139VW;

/**
 * 配置项配置详细信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03201VO extends BaseVO implements Serializable{
	
	/**交换机属性*/
	private SOC0139VW switchConfigItem;
	
	/**端口属性*/
	private List<SOC0132VW> portList;
	
	/**Zone属性*/
    private List<SOC0133VW> zoneList;

	public SOC0139VW getSwitchConfigItem() {
		return switchConfigItem;
	}

	public void setSwitchConfigItem(SOC0139VW switchConfigItem) {
		this.switchConfigItem = switchConfigItem;
	}

	public List<SOC0132VW> getPortList() {
		return portList;
	}

	public void setPortList(List<SOC0132VW> portList) {
		this.portList = portList;
	}

	public List<SOC0133VW> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<SOC0133VW> zoneList) {
		this.zoneList = zoneList;
	}		
}


