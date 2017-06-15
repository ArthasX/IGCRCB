/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;

/**
  * ����: ��������ͳ��ʵ��
  * ��������: ��������ͳ��ʵ��
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class DispatchStatisticsVW implements Serializable, Cloneable, DispatchStatisticsVWInfo {

	/** �����û�ID */
	@Id
	protected String dsuserid;

	/** �û��� */
	protected String dsusername;

	/** ����������� */
	protected Integer sumzc;

	/** ��ʱ������� */
	protected Integer sumys;

	/** δ������� */
	protected Integer sumwwc;

	/** �ϼ����� */
	protected Integer sumnum;

	/**
	 * �����û�IDȡ��
	 *
	 * @return �����û�ID
	 */
	public String getDsuserid() {
		return dsuserid;
	}

	/**
	 * �����û�ID�趨
	 *
	 * @param dsuserid �����û�ID
	 */
	public void setDsuserid(String dsuserid) {
		this.dsuserid = dsuserid;
	}

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getDsusername() {
		return dsusername;
	}

	/**
	 * �û����趨
	 *
	 * @param dsusername �û���
	 */
	public void setDsusername(String dsusername) {
		this.dsusername = dsusername;
	}

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public Integer getSumzc() {
		return sumzc;
	}

	/**
	 * ������������趨
	 *
	 * @param sumzc �����������
	 */
	public void setSumzc(Integer sumzc) {
		this.sumzc = sumzc;
	}

	/**
	 * ��ʱ�������ȡ��
	 *
	 * @return ��ʱ�������
	 */
	public Integer getSumys() {
		return sumys;
	}

	/**
	 * ��ʱ��������趨
	 *
	 * @param sumys ��ʱ�������
	 */
	public void setSumys(Integer sumys) {
		this.sumys = sumys;
	}

	/**
	 * δ�������ȡ��
	 *
	 * @return δ�������
	 */
	public Integer getSumwwc() {
		return sumwwc;
	}

	/**
	 * δ��������趨
	 *
	 * @param sumwwc δ�������
	 */
	public void setSumwwc(Integer sumwwc) {
		this.sumwwc = sumwwc;
	}

	/**
	 * �ϼ�����ȡ��
	 *
	 * @return �ϼ�����
	 */
	public Integer getSumnum() {
		return sumnum;
	}

	/**
	 * �ϼ������趨
	 *
	 * @param sumnum �ϼ�����
	 */
	public void setSumnum(Integer sumnum) {
		this.sumnum = sumnum;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return dsuserid;
	}

}