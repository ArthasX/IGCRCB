package com.deliverik.infogovernor.wki.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wki.form.IGWKI0101Form;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;

@SuppressWarnings("serial")
public class IGWKI01DTO extends BaseDTO {

	protected Integer workinfoid;

	//工作信息form
	protected IGWKI0101Form igwki0101Form;
	//工作信息form 集
	protected List<WorkinfoInfo> wkiList;

	// 当前用户
	protected User user;

	protected int maxSearchCount;

	protected PagingDTO pagingDto;

	 

	public Integer getWorkinfoid() {
		return workinfoid;
	}

	public void setWorkinfoid(Integer workinfoid) {
		this.workinfoid = workinfoid;
	}

	public void setIgwki0101Form(IGWKI0101Form igwki0101Form) {
		this.igwki0101Form = igwki0101Form;
	}

	public IGWKI0101Form getIgwki0101Form() {
		return igwki0101Form;
	}

	public void setIgwki01Form(IGWKI0101Form igwki01Form) {
		this.igwki0101Form = igwki01Form;
	}

	public List<WorkinfoInfo> getWkiList() {
		return wkiList;
	}

	public void setWkiList(List<WorkinfoInfo> wkiList) {
		this.wkiList = wkiList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	
	
}
