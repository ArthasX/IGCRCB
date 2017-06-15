package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * ֵ���ձ���ͼʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class DutyResultVWPK extends BasePK implements Serializable {

	/** �����ID */
	protected Integer dadid;

	/** ���ʱ�� */
	protected String dattime;
	
	/**
	 * ���캯��
	 */
	public DutyResultVWPK(){}
	
	/**
	 * ���캯��
	 */
	public DutyResultVWPK(Integer dadid, String dattime) {
		this.dadid = dadid;
		this.dattime = dattime;
	}
}
