package com.deliverik.infogovernor.soc.iop.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * 设备影响分析信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGIOP02021VO extends BaseVO implements Serializable{
	
	private String subnet;
	private String IPAddr;
	private Integer eiid;
	public String getSubnet() {
		return subnet;
	}
	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}
	public String getIPAddr() {
		return IPAddr;
	}
	public void setIPAddr(String iPAddr) {
		IPAddr = iPAddr;
	}
	public Integer getEiid() {
		return eiid;
	}
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	
	
}


