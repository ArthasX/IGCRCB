/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.orl.model.OrealPMVWInfo;

/**
 * ������ŷ���ż��ָ����ͼʵ��
 * ���������� ŷ���ż��ָ����ͼʵ��
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "oreal_p_m_view")
public class OrealPMVW implements Serializable, Cloneable, OrealPMVWInfo {
	@Id
	/**���ָ��ID(����)*/
	protected Integer id;
	/**Agent��ID*/
	protected Integer agent_id;
	/**IP*/
	protected String ip;
	/**ƽ̨ID*/
	protected Integer platform_id;
	/**ƽ̨����*/
	protected String platform_name;
	/**ָ�굥λ*/
	protected String units;
	/**�������*/
	protected String typename;
	/**��ԴID*/
	protected Integer resource_id;
	/**�Ƿ���(��ʶ)*/
	protected Integer enabled;
	/**���ָ��ֵ*/
	protected Double value;
	
	/**
	 * Getter and Setter
	 */
	/**
	 * ���ָ��ID(����)ȡ��
	 * @return id ���ָ��ID(����)
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * ���ָ��ID(����)�趨
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Agent��IDȡ��
	 * @return agent_id Agent��ID
	 */
	public Integer getAgent_id() {
		return agent_id;
	}
	/**
	 * Agent��ID�趨
	 * @param agent_id Agent��ID
	 */
	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
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
	 * ָ�굥λȡ��
	 * @return units ָ�굥λ
	 */
	public String getUnits() {
		return units;
	}
	/**
	 * ָ�굥λ�趨
	 * @param units
	 */
	public void setUnits(String units) {
		this.units = units;
	}
	
	/**
	 * �������ȡ��
	 * @return typename �������
	 */
	public String getTypename() {
		return typename;
	}
	/**
	 * ��������趨
	 * @param typename
	 */
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	/**
	 * ��ԴIDȡ��
	 * @return resource_id ��ԴID
	 */
	public Integer getResource_id() {
		return resource_id;
	}
	/**
	 * ��ԴID�趨
	 * @param resource_id
	 */
	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}
	
	/**
	 * �Ƿ���(��ʶ)ȡ��
	 * @return enabled �Ƿ���(��ʶ)
	 */
	public Integer getEnabled() {
		return enabled;
	}
	/**
	 * �Ƿ���(��ʶ)�趨
	 * @param enabled
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * ���ָ��ֵȡ��
	 * @return value ���ָ��ֵ
	 */
	public Double getValue() {
		return value;
	}
	/**
	 * ���ָ��ֵ�趨
	 * @param value
	 */
	public void setValue(Double value) {
		this.value = value;
	}
}
