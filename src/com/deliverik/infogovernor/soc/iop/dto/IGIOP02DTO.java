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
import com.deliverik.infogovernor.soc.iop.form.IGIOP0201Form;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0202Form;
/**
 * 概述: IP管理业务用DTO
 * 功能描述: IP管理业务用DTO
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGIOP02DTO extends BaseDTO implements Serializable {

	private IGIOP0201Form igiop0201Form;
	private IGIOP0202Form igiop0202Form;
	private Locale locale;
	private List<SOC0118Info> soc0118List;
	private PagingDTO pagingDto;
	private int maxSearchCount;
	private SOC0118Info ipInfo;
	
	
	
	
	public SOC0118Info getIpInfo() {
		return ipInfo;
	}
	public void setIpInfo(SOC0118Info ipInfo) {
		this.ipInfo = ipInfo;
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
	public IGIOP0201Form getIgiop0201Form() {
		return igiop0201Form;
	}
	public void setIgiop0201Form(IGIOP0201Form igiop0201Form) {
		this.igiop0201Form = igiop0201Form;
	}
	public IGIOP0202Form getIgiop0202Form() {
		return igiop0202Form;
	}
	public void setIgiop0202Form(IGIOP0202Form igiop0202Form) {
		this.igiop0202Form = igiop0202Form;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public List<SOC0118Info> getSoc0118List() {
		return soc0118List;
	}
	public void setSoc0118List(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}
	
	
	
}
