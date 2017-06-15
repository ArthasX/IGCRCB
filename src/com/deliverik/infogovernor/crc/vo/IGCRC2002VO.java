/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2001VW;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:����¼��ͺϼ�VO 
 * </p>
 * 
 * @version 1.0
 */

public class IGCRC2002VO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public IGCRC2002VO(){
		
	}

	/**���췽��*/
	public IGCRC2002VO(IGCRC2001VW igcrc2001vw,Integer sum){
		this.propentime = igcrc2001vw.getPropentime();
		this.incidentnum = igcrc2001vw.getIncidentnum();
		this.problemnum = igcrc2001vw.getProblemnum();
		this.changenum=igcrc2001vw.getChangenum();
		this.servicenum=igcrc2001vw.getServicenum();
		this.sfnum=igcrc2001vw.getSfnum();
		this.sum=sum;
	}
	/**���췽��*/
	public IGCRC2002VO(String propentime, Integer incidentnum,
			Integer problemnum, Integer changenum, Integer servicenum,
			Integer sfnum, Integer sum) {
		super();
		this.propentime = propentime;
		this.incidentnum = incidentnum;
		this.problemnum = problemnum;
		this.changenum = changenum;
		this.servicenum = servicenum;
		this.sfnum = sfnum;
		this.sum = sum;
	}
	/** �·� */
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
	
	/**�ϼ�*/
	protected Integer sum;

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

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
}
