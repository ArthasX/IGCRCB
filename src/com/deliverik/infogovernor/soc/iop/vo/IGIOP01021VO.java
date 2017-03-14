package com.deliverik.infogovernor.soc.iop.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;

/**
 * 设备影响分析信息ＶＯ
 * 
 * @author
 * 
 */
@SuppressWarnings("serial")
public class IGIOP01021VO extends BaseVO implements Serializable {

	public IGIOP01021VO() {

	}

	public IGIOP01021VO(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}

	private List<SOC0118Info> soc0118List;
	
	/**IP段的集合*/
	private List<SOC0118Info> ipsList;
	/**IP的集合*/
	private List<SOC0118Info> ipList;
	
	

	/**
	 * 获取IP集合
	 * @return
	 */
	public List<SOC0118Info> getIpList() {
		return ipList;
	}

	/**
	 * 设置IP集合
	 * @param ipList
	 */
	public void setIpList(List<SOC0118Info> ipList) {
		this.ipList = ipList;
	}

	/**
	 * 获取IP段的集合
	 * @return
	 */
	public List<SOC0118Info> getIpsList() {
		return ipsList;
	}

	/**
	 * 获取IP段的集合
	 * @param ipsList
	 */
	public void setIpsList(List<SOC0118Info> ipsList) {
		this.ipsList = ipsList;
	}

	public List<SOC0118Info> getSoc0118List() {
		return soc0118List;
	}

	public void setSoc0118List(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}
}
