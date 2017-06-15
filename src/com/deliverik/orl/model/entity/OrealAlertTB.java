/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.orl.model.OrealAlertInfo;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * ������ŷ���Ÿ澯��ʵ��
 * ���������� ŷ���Ÿ澯��ʵ��
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "oreal_alert")
public class OrealAlertTB extends BaseEntity implements Serializable, Cloneable, OrealAlertInfo {
	/**�澯ID(����)*/
	@Id
	protected Integer id;
	/**IP*/
	protected String ip;
	/**ƽ̨ID*/
	protected Integer platform_id;
	/**ƽ̨����*/
	protected String platform_name;
	/**�澯����*/
	protected String defname;
	/**�澯����ʱ��*/
	protected Long ctime;
	/**�澯ָ����ֵ*/
	protected String value;
	/**�Ƿ��޸�(��ʶ)*/
	protected Integer fixed;
	/**�澯���ȼ�(��ʶ)*/
	protected Integer priority;
	/**ҵ��ϵͳID*/
	protected Integer bid;
	/**ҵ��ϵͳ����*/
	protected String bname;
	
	/**
	 * getter and setter
	 */
	/**
	 * �澯ID(����)ȡ��
	 * @return id �澯ID(����)
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * �澯ID(����)�趨
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * IPȡ��
	 * @return ip IP
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * IP�趨
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * ƽ̨IDȡ��
	 * @return platform_id ƽ̨ID
	 */
	public Integer getPlatform_id() {
		return platform_id;
	}
	/**
	 * ƽ̨ID�趨
	 * @param platform_id
	 */
	public void setPlatform_id(Integer platform_id) {
		this.platform_id = platform_id;
	}
	
	/**
	 * ƽ̨����ȡ��
	 * @return platform_name ƽ̨����
	 */
	public String getPlatform_name() {
		return platform_name;
	}
	/**
	 * ƽ̨�����趨
	 * @param platform_name
	 */
	public void setPlatform_name(String platform_name) {
		this.platform_name = platform_name;
	}
	
	/**
	 * �澯����ȡ��
	 * @return defname �澯����
	 */
	public String getDefname() {
		return defname;
	}
	/**
	 * �澯�����趨
	 * @param defname
	 */
	public void setDefname(String defname) {
		this.defname = defname;
	}
	
	/**
	 * �澯����ʱ��ȡ��
	 * @return ctime �澯����ʱ��
	 */
	public Long getCtime() {
		return ctime;
	}
	/**
	 * �澯����ʱ���趨
	 * @param ctime
	 */
	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}
	
	/**
	 * �澯ָ����ֵȡ��
	 * @return value �澯ָ����ֵ
	 */
	public String getValue() {
		return value;
	}
	/**
	 * �澯ָ����ֵ�趨
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * �Ƿ��޸�(��ʶ)ȡ��
	 * @return fixed �Ƿ��޸�(��ʶ)
	 */
	public Integer getFixed() {
		return fixed;
	}
	/**
	 * �Ƿ��޸�(��ʶ)�趨
	 * @param fixed
	 */
	public void setFixed(Integer fixed) {
		this.fixed = fixed;
	}
	
	/**
	 * �澯���ȼ�(��ʶ)ȡ��
	 * @return priority �澯���ȼ�(��ʶ)
	 */
	public Integer getPriority() {
		return priority;
	}
	/**
	 * �澯���ȼ�(��ʶ)�趨
	 * @param priority
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	/**
	 * ҵ��ϵͳIDȡ��
	 * @return bid ҵ��ϵͳID
	 */
	public Integer getBid() {
		return bid;
	}
	/**
	 * ҵ��ϵͳID�趨
	 * @param bid
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
	/**
	 * ҵ��ϵͳ����ȡ��
	 * @return bname ҵ��ϵͳ����
	 */
	public String getBname() {
		return bname;
	}
	/**
	 * ҵ��ϵͳ�����趨
	 * @param bname
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}
	/**
	 * ������ȡ
	 */
	@Override
	public Serializable getPK() {
		return id;
	}	
	
	/**
	 * Tools������
	 */
	/**
	 * Long����ʱ��ת��Ϊyyyy/mm/dd hh:mi��ʽ
	 */
	public String getLong2SDF() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		date.setTime(ctime);
		return sdf.format(date);
	}
}
