package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.asset.model.condition.IG445SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0604Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;

/**
 * 设备统计分析信息DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM13DTO extends BaseDTO implements Serializable{
	
	/** 设备统计分析信息查询条件接口*/
	protected IG011SearchCond entityCountSearchCond;
	
	/** 设备统计分析信息接口*/
	protected List<IG011Info> ecList;
	
	/** 总数*/
	protected Integer total;
	
	/**
	 * 分页Bean
	 */
	
	protected PagingDTO pagingDto;
	
	/** 允许查询的最大条数*/
	protected int maxSearchCount;
	
	/** 机房下拉列表*/
	List<LabelValueBean> roomlist;
	
	protected SOC0604SearchCond computerRoomAndContainerVWSearchCond;
	
	protected List<SOC0604Info> crcList;
	
	/** 设备分布式统计分析信息查询条件接口*/
	protected IG445SearchCond equDistributingCountSearchCond;
	
	/** 设备分布式统计分析信息接口集合*/
	protected List<IG445Info> edList;
	
	
	public List<IG445Info> getEdList() {
		return edList;
	}

	public void setEdList(List<IG445Info> edList) {
		this.edList = edList;
	}

	public IG445SearchCond getEquDistributingCountSearchCond() {
		return equDistributingCountSearchCond;
	}

	public void setEquDistributingCountSearchCond(
			IG445SearchCond equDistributingCountSearchCond) {
		this.equDistributingCountSearchCond = equDistributingCountSearchCond;
	}

	public List<SOC0604Info> getCrcList() {
		return crcList;
	}

	public void setCrcList(List<SOC0604Info> crcList) {
		this.crcList = crcList;
	}

	public SOC0604SearchCond getComputerRoomAndContainerVWSearchCond() {
		return computerRoomAndContainerVWSearchCond;
	}

	public void setComputerRoomAndContainerVWSearchCond(
			SOC0604SearchCond computerRoomAndContainerVWSearchCond) {
		this.computerRoomAndContainerVWSearchCond = computerRoomAndContainerVWSearchCond;
	}

	public List<LabelValueBean> getRoomlist() {
		return roomlist;
	}

	public void setRoomlist(List<LabelValueBean> roomlist) {
		this.roomlist = roomlist;
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

	public List<IG011Info> getEcList() {
		return ecList;
	}

	public void setEcList(List<IG011Info> ecList) {
		this.ecList = ecList;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public IG011SearchCond getEntityCountSearchCond() {
		return entityCountSearchCond;
	}

	public void setEntityCountSearchCond(
			IG011SearchCond entityCountSearchCond) {
		this.entityCountSearchCond = entityCountSearchCond;
	}
	
}


