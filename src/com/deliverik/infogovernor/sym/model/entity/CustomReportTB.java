/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.CustomReport;

/**
 * 
 * @Description:���Ʊ���ʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CUSTOMREPORT")
public class CustomReportTB extends BaseEntity implements Serializable,
		Cloneable, CustomReport {
	/** ����ID */
	@Id
	@TableGenerator(name = "CUSTOMREPORT_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "CUSTOMREPORT_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CUSTOMREPORT_TABLE_GENERATOR")
	protected Integer crid;

	/**
	 *����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getCrid() {
		return crid;
	}

	/**
	 *����ID�趨
	 * 
	 * @param crid����ID
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	/**
	 *�û���ID
	 */
	protected String userid;

	/**
	 *�û���IDȡ��
	 * 
	 * @return �û���ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 *�û���ID�趨
	 * 
	 * @param userid�û���ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 *����ID
	 */
	protected Integer rfdid;

	/**
	 *����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 *����ID�趨
	 * 
	 * @param rfdid����ID
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 *������
	 */
	protected Integer ordernum;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public Integer getOrdernum() {
		return ordernum;
	}

	/**
	 *�������趨
	 * 
	 * @param ordernum������
	 */
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return crid;
	}
}
