/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.model.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
/**
 * ֵ��������ʱ���ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DutyAuditTime")
public class DutyAuditTimeTB extends BaseEntity implements Serializable, Cloneable, DutyAuditTime {
	
	/** ���ʱ��ID */
	@Id
	@TableGenerator(
		    name="DutyAuditTime_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DUTYAUDITTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DutyAuditTime_TABLE_GENERATOR")
  
	/**���ʱ��ID */
	protected Integer datid;
	
	/**�����ID */
	protected Integer dadid;
	
	/**�����ʱ�� */
	protected String dattime;
	
	/**����ʱ�� */
	protected String datlimtime;
    
	/**
	 * ����ȡ��
	 * @return datid
	 */
	public Serializable getPK() {
	
		return datid;
	}
    /**
     * 
	 *���ʱ��IDȡ��
	 * @return ���ʱ��ID
	 */
	public Integer getDatid() {
		return datid;
	}
    
	/**
	 * 
	 * ���ʱ��ID�趨
	 * @param datid ���ʱ��ID
	 */
	public void setDatid(Integer datid) {
		this.datid = datid;
	}
    
	/**
	 * 
	 * �����IDȡ��
	 * @return �����ID
	 */
	public Integer getDadid() {
		return dadid;
	}
    /**
     * �����ID����
     * @param dadid �����ID
     */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}
    
	/**
	 * ���ʱ��ȡ��
	 * @return ���ʱ��
	 */
	public String getDattime() {
		return dattime;
	}
	
    /**
     * ���ʱ������
     * @param dattime ���ʱ��
     */
	public void setDattime(String dattime) {
		this.dattime = dattime;
	}
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getDatlimtime() {
		return datlimtime;
	}
    
	/**
	 * ����ʱ������
	 * @param dadlimtime ����ʱ��
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}

	
}
