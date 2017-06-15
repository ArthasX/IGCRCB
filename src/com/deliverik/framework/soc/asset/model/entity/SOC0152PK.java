package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BasePK;

/**
 * </p>
 * �ʲ�������Ϣ��ͼ��������
 *</p>
 */
@SuppressWarnings("serial")
public class SOC0152PK extends BasePK implements Serializable{

	/** ��ʼģ��ID */
	@Id
	protected String fromModelEid;


	/** ��ģ��ID */
	@Id
	protected String toModelEid;

	/**
	 * ���캯��
	 * 
	 */
	public SOC0152PK(){}
	
	/**
	 * ���캯��
	 * 
	 */
	public SOC0152PK(String fromModelEid, String toModelEid) {
		super();
		this.fromModelEid = fromModelEid;
		this.toModelEid = toModelEid;
	}

	public String getFromModelEid() {
		return fromModelEid;
	}

	public void setFromModelEid(String fromModelEid) {
		this.fromModelEid = fromModelEid;
	}

	public String getToModelEid() {
		return toModelEid;
	}

	public void setToModelEid(String toModelEid) {
		this.toModelEid = toModelEid;
	}


}
