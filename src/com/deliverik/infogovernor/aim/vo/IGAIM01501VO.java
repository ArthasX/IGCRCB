package com.deliverik.infogovernor.aim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
public class IGAIM01501VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 业务系统可用性 */
	protected List<BussinessAvailval> lst_BussinessAvailval;
	
	/** Oracle告警 */
	protected List<CRM06Info> lst_CRM06Info;

	/**
	 * 业务系统可用性取得
	 * @return 业务系统可用性
	 */
	public List<BussinessAvailval> getLst_BussinessAvailval() {
		return lst_BussinessAvailval;
	}

	/**
	 * 业务系统可用性设定
	 * @param lst_BussinessAvailval 业务系统可用性
	 */
	public void setLst_BussinessAvailval(
			List<BussinessAvailval> lst_BussinessAvailval) {
		this.lst_BussinessAvailval = lst_BussinessAvailval;
	}

	/**
	 * Oracle告警取得
	 * @return Oracle告警
	 */
	public List<CRM06Info> getLst_CRM06Info() {
		return lst_CRM06Info;
	}

	/**
	 * Oracle告警设定
	 * @param lst_CRM06Info Oracle告警
	 */
	public void setLst_CRM06Info(List<CRM06Info> lst_CRM06Info) {
		this.lst_CRM06Info = lst_CRM06Info;
	}
}
