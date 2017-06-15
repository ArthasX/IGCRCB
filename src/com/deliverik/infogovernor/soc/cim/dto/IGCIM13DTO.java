package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.Timer02Info;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0805Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0807Form;

public class IGCIM13DTO extends BaseDTO implements Serializable{
	
	protected IGCIM0805Form igcim0805Form;
	
	protected IGCIM0807Form igcim0807Form;
	
	protected List<CicollecttaskInfo> timerTaskList;
	
	protected int maxSearchCount;
	
	protected PagingDTO pagingDto;
	
	protected String uuid;
	
	protected List<Timer02Info> historyList;

	public List<Timer02Info> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List<Timer02Info> historyList) {
		this.historyList = historyList;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public IGCIM0805Form getIgcim0805Form() {
		return igcim0805Form;
	}

	public void setIgcim0805Form(IGCIM0805Form igcim0805Form) {
		this.igcim0805Form = igcim0805Form;
	}

	public List<CicollecttaskInfo> getTimerTaskList() {
		return timerTaskList;
	}

	public void setTimerTaskList(List<CicollecttaskInfo> timerTaskList) {
		this.timerTaskList = timerTaskList;
	}

	public IGCIM0807Form getIgcim0807Form() {
		return igcim0807Form;
	}

	public void setIgcim0807Form(IGCIM0807Form igcim0807Form) {
		this.igcim0807Form = igcim0807Form;
	}
	
	

}
