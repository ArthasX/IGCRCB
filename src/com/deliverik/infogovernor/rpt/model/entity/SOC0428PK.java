/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * ����: 
 * ��������: 
 * ������¼: 2012-08-09
 * �޸ļ�¼: ��BusinessCapacityRealTimeVWPK�����ĳ�SOC0428PK
 */
@SuppressWarnings("serial")
public class SOC0428PK extends BasePK implements Serializable{
	/** ҵ��ϵͳID */

	protected Integer bcid;
	/**ҵ��ϵͳ����*/

	protected String bcName;

	/**
	 * 
	 */
	public SOC0428PK(){}
	
	/**
	 * ������Ϣ�������幹�캯��
	 */
	public SOC0428PK(Integer bcid, String bcName) {
		super();
		this.bcid = bcid;
		this.bcName = bcName;
	}

	/**
	 * ҵ��ϵͳIDȡ��
	 *
	 * @return bcid ҵ��ϵͳID
	 */
	public Integer getBcid() {
		return bcid;
	}

	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return bcName ҵ��ϵͳ����
	 */
	public String getBcName() {
		return bcName;
	}

	/**
	 * ҵ��ϵͳID�趨
	 *
	 * @param bcid ҵ��ϵͳID
	 */
	public void setBcid(Integer bcid) {
		this.bcid = bcid;
	}

	/**
	 * ҵ��ϵͳ�����趨
	 *
	 * @param bcName ҵ��ϵͳ����
	 */
	public void setBcName(String bcName) {
		this.bcName = bcName;
	}
}
