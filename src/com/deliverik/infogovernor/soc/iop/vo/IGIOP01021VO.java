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
public class IGIOP01021VO extends BaseVO implements Serializable {

	public IGIOP01021VO() {

	}

	public IGIOP01021VO(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}

	private List<SOC0118Info> soc0118List;
	
	/**IP�εļ���*/
	private List<SOC0118Info> ipsList;
	/**IP�ļ���*/
	private List<SOC0118Info> ipList;
	
	

	/**
	 * ��ȡIP����
	 * @return
	 */
	public List<SOC0118Info> getIpList() {
		return ipList;
	}

	/**
	 * ����IP����
	 * @param ipList
	 */
	public void setIpList(List<SOC0118Info> ipList) {
		this.ipList = ipList;
	}

	/**
	 * ��ȡIP�εļ���
	 * @return
	 */
	public List<SOC0118Info> getIpsList() {
		return ipsList;
	}

	/**
	 * ��ȡIP�εļ���
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
