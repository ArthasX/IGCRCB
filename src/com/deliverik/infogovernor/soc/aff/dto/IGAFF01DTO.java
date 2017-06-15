/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.aff.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0101Form;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0102Form;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0103Form;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0104Form;
/**
 * ����: �豸Ӱ�����ҵ����DTO
 * ��������: �豸Ӱ�����ҵ����DTO
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGAFF01DTO extends BaseDTO implements Serializable {

	private User user;
	
	private boolean flag;
	
	private IGAFF0101Form igaff0101Form;
	private IGAFF0102Form igaff0102Form;
	private IGAFF0103Form igaff0103Form;
	private IGAFF0104Form igaff0104Form;

	private Integer maxSearchCount;
	
	private PagingDTO pagingDto;
	
	private Locale locale;
	
	private List<SOC0118Info> soc0118List;
	
	
	
	
	

	public IGAFF0104Form getIgaff0104Form() {
		return igaff0104Form;
	}

	public void setIgaff0104Form(IGAFF0104Form igaff0104Form) {
		this.igaff0104Form = igaff0104Form;
	}

	public List<SOC0118Info> getSoc0118List() {
		return soc0118List;
	}

	public void setSoc0118List(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public IGAFF0101Form getIgaff0101Form() {
		return igaff0101Form;
	}

	public void setIgaff0101Form(IGAFF0101Form igaff0101Form) {
		this.igaff0101Form = igaff0101Form;
	}

	public IGAFF0102Form getIgaff0102Form() {
		return igaff0102Form;
	}

	public void setIgaff0102Form(IGAFF0102Form igaff0102Form) {
		this.igaff0102Form = igaff0102Form;
	}

	public IGAFF0103Form getIgaff0103Form() {
		return igaff0103Form;
	}

	public void setIgaff0103Form(IGAFF0103Form igaff0103Form) {
		this.igaff0103Form = igaff0103Form;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Integer getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(Integer maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	
	
	
	
	
	
}
