/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;

/**
  * ����: ����״̬��˽�б�Ĭ��ֵ��ʵ��
  * ��������: ����״̬��˽�б�Ĭ��ֵ��ʵ��
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class IG560VW extends BaseEntity implements Serializable,
		Cloneable, IG560VWInfo {

	@Id
	protected Integer dvid;

	/** ��id */
	protected String pidid;

	/** ״̬id */
	protected String psdid;

	/** Ĭ��ֵ */
	protected String dfvalue;

	/** �Ƿ�Ӧ�õ���������T/F */
	protected String usedtoall;
	
	protected String pidname;
	
	protected String pidoption;
	
	protected String pidtype;
	
	public String getPidoption() {
		return pidoption;
	}

	public void setPidoption(String pidoption) {
		this.pidoption = pidoption;
	}

	public String getPidtype() {
		return pidtype;
	}

	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	public String getPidname() {
		return pidname;
	}

	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * dvidȡ��
	 *
	 * @return dvid
	 */
	public Integer getDvid() {
		return dvid;
	}

	/**
	 * dvid�趨
	 *
	 * @param dvid dvid
	 */
	public void setDvid(Integer dvid) {
		this.dvid = dvid;
	}

	/**
	 * ��idȡ��
	 *
	 * @return ��id
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ��id�趨
	 *
	 * @param pidid ��id
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ״̬idȡ��
	 *
	 * @return ״̬id
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬id�趨
	 *
	 * @param psdid ״̬id
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * Ĭ��ֵȡ��
	 *
	 * @return Ĭ��ֵ
	 */
	public String getDfvalue() {
		return dfvalue;
	}

	/**
	 * Ĭ��ֵ�趨
	 *
	 * @param dfvalue Ĭ��ֵ
	 */
	public void setDfvalue(String dfvalue) {
		this.dfvalue = dfvalue;
	}

	/**
	 * �Ƿ�Ӧ�õ���������T/Fȡ��
	 *
	 * @return �Ƿ�Ӧ�õ���������T/F
	 */
	public String getUsedtoall() {
		return usedtoall;
	}

	/**
	 * �Ƿ�Ӧ�õ���������T/F�趨
	 *
	 * @param usedtoall �Ƿ�Ӧ�õ���������T/F
	 */
	public void setUsedtoall(String usedtoall) {
		this.usedtoall = usedtoall;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return dvid;
	}

}