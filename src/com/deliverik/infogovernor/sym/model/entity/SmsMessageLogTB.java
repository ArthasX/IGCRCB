/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.sym.model.SmsMessageLogInfo;

/**
  * ����: ������־��Ϣ��ʵ��
  * ��������: ������־��Ϣ��ʵ��
  * ������¼: 2012/02/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SmsMessageLog")
public class SmsMessageLogTB extends BaseEntity implements Serializable,
		Cloneable, SmsMessageLogInfo {

	/** ���������� */
	@Id
	@TableGenerator(
		name="SMSMESSAGELOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SMSMESSAGELOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SMSMESSAGELOG_TABLE_GENERATOR")
	protected Integer mid;

	/** �ֻ����� */
	protected String telephone;

	/** �������� */
	protected String message;

	/** ҵ��ϵͳ���� */
	protected String platformInfo;

	/** ����ʱ�� */
	protected String sendtime;

	/** ���Ͷ���IP��ַ */
	protected String sendIP;

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public Integer getMid() {
		return mid;
	}

	/**
	 * �����������趨
	 *
	 * @param mid ����������
	 */
	public void setMid(Integer mid) {
		this.mid = mid;
	}

	/**
	 * �ֻ�����ȡ��
	 *
	 * @return �ֻ�����
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * �ֻ������趨
	 *
	 * @param telephone �ֻ�����
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * ���������趨
	 *
	 * @param message ��������
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return ҵ��ϵͳ����
	 */
	public String getPlatformInfo() {
		return platformInfo;
	}

	/**
	 * ҵ��ϵͳ�����趨
	 *
	 * @param platformInfo ҵ��ϵͳ����
	 */
	public void setPlatformInfo(String platformInfo) {
		this.platformInfo = platformInfo;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getSendtime() {
		return sendtime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param sendtime ����ʱ��
	 */
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	/**
	 * ���Ͷ���IP��ַȡ��
	 *
	 * @return ���Ͷ���IP��ַ
	 */
	public String getSendIP() {
		return sendIP;
	}

	/**
	 * ���Ͷ���IP��ַ�趨
	 *
	 * @param sendIP ���Ͷ���IP��ַ
	 */
	public void setSendIP(String sendIP) {
		this.sendIP = sendIP;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return mid;
	}

}