/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;

/**	
 * ����:��ȹ�����ѯα��ͼ
 * ������¼��lianghongyang    2014-8-7 16:16:51	
 * �޸ļ�¼��null
 */	
@Entity
public class IGCRC2001VW implements IGCRC2001VWInfo{
	@Id
//	protected Integer id;
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
	
	/**��ѯ���*/
	protected String propentime;

	/** �¼�ͳ������ */
	protected Integer incidentnum;
	
	/** ����ͳ������ */
	protected Integer problemnum;
	
	/** ���ͳ������ */
	protected Integer changenum;
	
	/** ��������ͳ������ */
	protected Integer servicenum;
	
	/** ���񹤵�ͳ������ */
	protected Integer sfnum;

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public Integer getIncidentnum() {
		return incidentnum;
	}

	public void setIncidentnum(Integer incidentnum) {
		this.incidentnum = incidentnum;
	}

	public Integer getProblemnum() {
		return problemnum;
	}

	public void setProblemnum(Integer problemnum) {
		this.problemnum = problemnum;
	}

	public Integer getChangenum() {
		return changenum;
	}

	public void setChangenum(Integer changenum) {
		this.changenum = changenum;
	}

	public Integer getServicenum() {
		return servicenum;
	}

	public void setServicenum(Integer servicenum) {
		this.servicenum = servicenum;
	}

	public Integer getSfnum() {
		return sfnum;
	}

	public void setSfnum(Integer sfnum) {
		this.sfnum = sfnum;
	}
}
