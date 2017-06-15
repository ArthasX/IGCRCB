/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;

/**
 * ���������ʵ��
 *
 *	@author lipeng@deliverik.com
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RiskAuditDef")
public class RiskAuditDefTB extends BaseEntity implements Serializable, Cloneable, RiskAuditDef {

	/** ���������ID */
	@Id
	@TableGenerator(
		    name="RISKAUDITDEF_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RISKAUDITDEF_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKAUDITDEF_TABLE_GENERATOR")
	protected Integer radid;
	
	/** �������ID */
	protected Integer raid;

	/** ������ư汾 */
	protected String raversion;
	
	/** ������������� */
	protected String radname;
	
	/** ������������� */
	protected String radcode;
	
	/** ����������ϼ������ */
	protected String radparcode;
	
	/** ������������� */
	protected String raddesc;
	
	/** �����������ճ̶� */
	protected String radrisklevel;
	
	/** ���������������ID */
	protected String raduserid;
	
	/** ������������������� */
	protected String radusername;
	
	/** ������������β��� */
	protected String radorg;
	
	/** ������������β��ű��� */
	protected String radorgcoding;
	
	/** �������������ֶ� */
	protected String radmode;
	
	/** ���������������� */
	protected String radtype;
	
	/** ������������Ƶ�� */
	protected String radfrequency;
	
	/** ���������״̬ */
	protected String radstatus;
	
	/** ���������� */
	protected String radlevel;
	

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getRadlevel() {
		return radlevel;
	}

	/**
	 * �����������趨
	 * @param radlevel ����������
	 */
	public void setRadlevel(String radlevel) {
		this.radlevel = radlevel;
	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return radid;
	}
	
	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * ���������ID�趨
	 * @param radid ���������ID
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
	}

	/**
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * �������ID�趨
	 * @param raid �������ID
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * ������ư汾ȡ��
	 * @return ������ư汾
	 */
	public String getRaversion() {
		return raversion;
	}

	/**
	 * ������ư汾�趨
	 * @param raversion ������ư汾
	 */
	public void setRaversion(String raversion) {
		this.raversion = raversion;
	}

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadname() {
		return radname;
	}

	/**
	 * ��������������趨
	 * @param radname �������������
	 */
	public void setRadname(String radname) {
		this.radname = radname;
	}

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * ��������������趨
	 * @param radcode �������������
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}

	/**
	 * ����������ϼ������ȡ��
	 * @return ����������ϼ������
	 */
	public String getRadparcode() {
		return radparcode;
	}

	/**
	 * ����������ϼ�������趨
	 * @param radparcode ����������ϼ������
	 */
	public void setRadparcode(String radparcode) {
		this.radparcode = radparcode;
	}

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRaddesc() {
		return raddesc;
	}

	/**
	 * ��������������趨
	 * @param raddesc �������������
	 */
	public void setRaddesc(String raddesc) {
		this.raddesc = raddesc;
	}

	/**
	 * �����������ճ̶�ȡ��
	 * @return �����������ճ̶�
	 */
	public String getRadrisklevel() {
		return radrisklevel;
	}

	/**
	 * �����������ճ̶��趨
	 * @param radrisklevel �����������ճ̶�
	 */
	public void setRadrisklevel(String radrisklevel) {
		this.radrisklevel = radrisklevel;
	}

	/**
	 * ���������������IDȡ��
	 * @return ���������������ID
	 */
	public String getRaduserid() {
		return raduserid;
	}

	/**
	 * ���������������ID�趨
	 * @param raduserid ���������������ID
	 */
	public void setRaduserid(String raduserid) {
		this.raduserid = raduserid;
	}

	/**
	 * �������������������ȡ��
	 * @return �������������������
	 */
	public String getRadusername() {
		return radusername;
	}

	/**
	 * ��������������������趨
	 * @param radusername �������������������
	 */
	public void setRadusername(String radusername) {
		this.radusername = radusername;
	}

	/**
	 * ������������β���ȡ��
	 * @return ������������β���
	 */
	public String getRadorg() {
		return radorg;
	}

	/**
	 * ������������β����趨
	 * @param radorg ������������β���
	 */
	public void setRadorg(String radorg) {
		this.radorg = radorg;
	}

	/**
	 * ������������β��ű���ȡ��
	 * @return ������������β��ű���
	 */
	public String getRadorgcoding() {
		return radorgcoding;
	}
	
	/**
	 * ������������β��ű����趨
	 * @param radorg ������������β��ű���
	 */
	public void setRadorgcoding(String radorgcoding) {
		this.radorgcoding = radorgcoding;
	}
	/**
	 * �������������ֶ�ȡ��
	 * @return �������������ֶ�
	 */
	public String getRadmode() {
		return radmode;
	}

	/**
	 * �������������ֶ��趨
	 * @param radmode �������������ֶ�
	 */
	public void setRadmode(String radmode) {
		this.radmode = radmode;
	}

	/**
	 * ����������������ȡ��
	 * @return ����������������
	 */
	public String getRadtype() {
		return radtype;
	}

	/**
	 * �����������������趨
	 * @param radtype ����������������
	 */
	public void setRadtype(String radtype) {
		this.radtype = radtype;
	}

	/**
	 * ������������Ƶ��ȡ��
	 * @return ������������Ƶ��
	 */
	public String getRadfrequency() {
		return radfrequency;
	}

	/**
	 * ������������Ƶ���趨
	 * @param radfrequency ������������Ƶ��
	 */
	public void setRadfrequency(String radfrequency) {
		this.radfrequency = radfrequency;
	}

	/**
	 * ���������״̬ȡ��
	 * @return ���������״̬
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * ���������״̬�趨
	 * @param radstatus ���������״̬
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
	}
}
