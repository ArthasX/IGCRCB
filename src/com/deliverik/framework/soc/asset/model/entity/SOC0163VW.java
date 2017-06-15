package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * �û��ʲ���Ϣʵ��
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "SOC0163")
@SuppressWarnings("serial")
public class SOC0163VW implements Serializable, Cloneable, SOC0163Info {

	/** �ʲ�ID */
	@Id
	protected Integer eiid;
	
	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ����� */
	protected String einame;
	
	/** �ʲ���� */
	protected String eilabel;
	
	/**�û��ʲ����ڶ����ʲ�IP*/
	protected String ip;
	
	/** �ʲ����ʱ�� */
	protected String eiupdtime;
	
	/** �ʲ�ģ������ */
	protected String ename;
	
	/** �ʲ��汾�� */
	protected Integer eiversion;
	
	/** �ʲ���������*/
	protected String eiorgsyscoding;
	
	/** �ʲ�ģ��*/
	protected String esyscoding;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/** �ʲ����������ڵ�ʵ���ʶ */
	protected Integer eirootmark;
	
	
	
	/** �ʲ�����������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="eiorgsyscoding", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eiid;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ������趨
	 *
	 * @param einame �ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	


	/**
	 * �ʲ�����ʱ��ȡ��
	 * @return �ʲ�����ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �ʲ�����ʱ���趨
	 *
	 * @param eiupdtime �ʲ�����ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}



	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�����趨
	 *
	 * @param eilabel �ʲ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	
	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}


	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename �ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}







	/**
	 * �ʲ��汾��ȡ��
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ��汾���趨
	 *
	 * @param eiversion �ʲ��汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	
	/**
	 * �ʲ�����������Ϣʵ��ȡ��
	 * @return �ʲ�����������Ϣʵ��
	 */
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	/**
	 * �ʲ�����������Ϣʵ���趨
	 *
	 * @param organizationTB �ʲ�����������Ϣʵ��
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶ�趨
	 *
	 * @param eirootmark �ʲ����������ڵ�ʵ���ʶ
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
	
	
}
