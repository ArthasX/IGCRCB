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
 * �豸ͳ�Ʒ�����ϢDTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM13DTO extends BaseDTO implements Serializable{
	
	/** �豸ͳ�Ʒ�����Ϣ��ѯ�����ӿ�*/
	protected IG011SearchCond entityCountSearchCond;
	
	/** �豸ͳ�Ʒ�����Ϣ�ӿ�*/
	protected List<IG011Info> ecList;
	
	/** ����*/
	protected Integer total;
	
	/**
	 * ��ҳBean
	 */
	
	protected PagingDTO pagingDto;
	
	/** �����ѯ���������*/
	protected int maxSearchCount;
	
	/** ���������б�*/
	List<LabelValueBean> roomlist;
	
	protected SOC0604SearchCond computerRoomAndContainerVWSearchCond;
	
	protected List<SOC0604Info> crcList;
	
	/** �豸�ֲ�ʽͳ�Ʒ�����Ϣ��ѯ�����ӿ�*/
	protected IG445SearchCond equDistributingCountSearchCond;
	
	/** �豸�ֲ�ʽͳ�Ʒ�����Ϣ�ӿڼ���*/
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


