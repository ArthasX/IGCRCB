package com.deliverik.infogovernor.aim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
public class IGAIM01501VO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** ҵ��ϵͳ������ */
	protected List<BussinessAvailval> lst_BussinessAvailval;
	
	/** Oracle�澯 */
	protected List<CRM06Info> lst_CRM06Info;

	/**
	 * ҵ��ϵͳ������ȡ��
	 * @return ҵ��ϵͳ������
	 */
	public List<BussinessAvailval> getLst_BussinessAvailval() {
		return lst_BussinessAvailval;
	}

	/**
	 * ҵ��ϵͳ�������趨
	 * @param lst_BussinessAvailval ҵ��ϵͳ������
	 */
	public void setLst_BussinessAvailval(
			List<BussinessAvailval> lst_BussinessAvailval) {
		this.lst_BussinessAvailval = lst_BussinessAvailval;
	}

	/**
	 * Oracle�澯ȡ��
	 * @return Oracle�澯
	 */
	public List<CRM06Info> getLst_CRM06Info() {
		return lst_CRM06Info;
	}

	/**
	 * Oracle�澯�趨
	 * @param lst_CRM06Info Oracle�澯
	 */
	public void setLst_CRM06Info(List<CRM06Info> lst_CRM06Info) {
		this.lst_CRM06Info = lst_CRM06Info;
	}
}
