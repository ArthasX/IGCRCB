package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.alarm.model.entity.HQServerTB;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0808Form;

public class IGCIM18DTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = -8497423952699232847L;

	private PagingDTO pagingDto;
	private IGCIM0808Form igcim0808Form;
	private List<HQServerTB> hqServerTBList;
	private List<String> serverUuid;

	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	public IGCIM0808Form getIgcim0808Form() {
		return igcim0808Form;
	}
	public void setIgcim0808Form(IGCIM0808Form igcim0808Form) {
		this.igcim0808Form = igcim0808Form;
	}
	public List<HQServerTB> getHqServerTBList() {
		return hqServerTBList;
	}
	public void setHqServerTBList(List<HQServerTB> hqServerTBList) {
		this.hqServerTBList = hqServerTBList;
	}
	public List<String> getServerUuid() {
		return serverUuid;
	}
	public void setServerUuid(List<String> serverUuid) {
		this.serverUuid = serverUuid;
	}
}
