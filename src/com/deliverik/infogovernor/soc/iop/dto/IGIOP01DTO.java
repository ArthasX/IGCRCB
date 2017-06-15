/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.iop.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0101Form;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0102Form;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0103Form;
/**
 * 概述: IP段管理业务用DTO
 * 功能描述: IP段管理业务用DTO
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGIOP01DTO extends BaseDTO implements Serializable {

	private IGIOP0101Form igiop0101Form;
	private IGIOP0102Form igiop0102Form;
	private IGIOP0103Form igiop0103Form;
	private int maxSearchCount = 100000;
	private SOC0118Info ipsInfo;
	private PagingDTO pagingDto;
	
	private User user;
	
	private List<SOC0118Info> soc0118List;
	private List<SOC0118Info> ipSList;
	private List<SOC0118TB> tempIPList;
	
	
	private Locale locale;
	
	
	

	
	
	public List<SOC0118TB> getTempIPList() {
		return tempIPList;
	}

	public void setTempIPList(List<SOC0118TB> tempIPList) {
		this.tempIPList = tempIPList;
	}

	public SOC0118Info getIpsInfo() {
		return ipsInfo;
	}

	public void setIpsInfo(SOC0118Info ipsInfo) {
		this.ipsInfo = ipsInfo;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public IGIOP0101Form getIgiop0101Form() {
		return igiop0101Form;
	}

	public void setIgiop0101Form(IGIOP0101Form igiop0101Form) {
		this.igiop0101Form = igiop0101Form;
	}

	public List<SOC0118Info> getSoc0118List() {
		return soc0118List;
	}

	public void setSoc0118List(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}

	public IGIOP0102Form getIgiop0102Form() {
		return igiop0102Form;
	}

	public void setIgiop0102Form(IGIOP0102Form igiop0102Form) {
		this.igiop0102Form = igiop0102Form;
	}

	public IGIOP0103Form getIgiop0103Form() {
		return igiop0103Form;
	}

	public void setIgiop0103Form(IGIOP0103Form igiop0103Form) {
		this.igiop0103Form = igiop0103Form;
	}

	public List<SOC0118Info> getIpSList() {
		return ipSList;
	}

	public void setIpSList(List<SOC0118Info> ipSList) {
		this.ipSList = ipSList;
	}
	
	
	
	
}
