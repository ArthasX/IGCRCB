/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
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
 * 值班检查项检查时间表实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DutyAuditTime")
public class DutyAuditTimeTB extends BaseEntity implements Serializable, Cloneable, DutyAuditTime {
	
	/** 检查时间ID */
	@Id
	@TableGenerator(
		    name="DutyAuditTime_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DUTYAUDITTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DutyAuditTime_TABLE_GENERATOR")
  
	/**检查时间ID */
	protected Integer datid;
	
	/**检查项ID */
	protected Integer dadid;
	
	/**检查项时间 */
	protected String dattime;
	
	/**限制时间 */
	protected String datlimtime;
    
	/**
	 * 主键取得
	 * @return datid
	 */
	public Serializable getPK() {
	
		return datid;
	}
    /**
     * 
	 *检查时间ID取得
	 * @return 检查时间ID
	 */
	public Integer getDatid() {
		return datid;
	}
    
	/**
	 * 
	 * 检查时间ID设定
	 * @param datid 检查时间ID
	 */
	public void setDatid(Integer datid) {
		this.datid = datid;
	}
    
	/**
	 * 
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public Integer getDadid() {
		return dadid;
	}
    /**
     * 检查项ID设置
     * @param dadid 检查项ID
     */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}
    
	/**
	 * 检查时间取得
	 * @return 检查时间
	 */
	public String getDattime() {
		return dattime;
	}
	
    /**
     * 检查时间设置
     * @param dattime 检查时间
     */
	public void setDattime(String dattime) {
		this.dattime = dattime;
	}
	
	/**
	 * 限制时间取得
	 * @return 限制时间
	 */
	public String getDatlimtime() {
		return datlimtime;
	}
    
	/**
	 * 限制时间设置
	 * @param dadlimtime 限制时间
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}

	
}
