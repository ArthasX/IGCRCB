/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;

@SuppressWarnings("serial")
public class IGCRC4001VO extends BaseVO {
	/** �¼�����ϲ���ѯ������� */
	protected List<EventAndProblemVWInfo> listep ;
	
	/** �¼���Դ */
	protected List<String> sourcelist;
	
	/** �¼�Ӱ�췶Χ */
	protected List<String> affectlist;
	
	/** �¼�״̬ */
	protected List<String> eslist;
	
	/** ����״̬ */
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
