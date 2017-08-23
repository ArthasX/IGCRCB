/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;

@SuppressWarnings("serial")
public class IGCRC4001VO extends BaseVO {
	/** 事件问题合并查询结果集合 */
	protected List<EventAndProblemVWInfo> listep ;
	
	/** 事件来源 */
	protected List<String> sourcelist;
	
	/** 事件影响范围 */
	protected List<String> affectlist;
	
	/** 事件状态 */
	protected List<String> eslist;
	
	/** 问题状态 */
	protected List<String> pslist;

	public List<EventAndProblemVWInfo> getListep() {
		return listep;
	}

	public void setListep(List<EventAndProblemVWInfo> listep) {
		this.listep = listep;
	}

	public List<String> getSourcelist() {
		return sourcelist;
	}

	public void setSourcelist(List<String> sourcelist) {
		this.sourcelist = sourcelist;
	}

	public List<String> getAffectlist() {
		return affectlist;
	}

	public void setAffectlist(List<String> affectlist) {
		this.affectlist = affectlist;
	}

	public List<String> getEslist() {
		return eslist;
	}

	public void setEslist(List<String> eslist) {
		this.eslist = eslist;
	}

	public List<String> getPslist() {
		return pslist;
	}

	public void setPslist(List<String> pslist) {
		this.pslist = pslist;
	}
	
	
	
}
