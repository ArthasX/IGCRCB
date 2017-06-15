/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * ����: ��ƶԱȽ����Ϣ��ʵ��
 * ��������: ��ƶԱȽ����Ϣ��ʵ��
 * ������¼: 2012/03/05
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0137PK.class)
public class SOC0137TB implements Serializable,Cloneable,SOC0137Info{
	
	/** �������ID */
	@Id
	protected Integer autid;
	
	/** �ʲ�ID */
	@Id
	protected Integer eiid;

	/** ��汾 */
	@Id
	protected Integer eiversion;

	/** С�汾 */
	@Id
	protected Integer eismallversion;
	
	/** ���ʱ��� */
	protected String autime;

	/** �ʲ����� */
	protected String einame;
	
	/** �ԱȽ������ */
	protected String aucmptype;
	
	/** �����ʶ */
	protected String auflag;
	
	/** �ʲ������ */
	protected String esyscoding;
	
	/** ģ��ʵ�� */
	@ManyToOne
	@JoinColumn(name="esyscoding", referencedColumnName="esyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0117TB entityTB;
	

	/**
	 * ���ʱ���ȡ��
	 *
	 * @return ���ʱ���
	 */
	public String getAutime() {
		return autime;
	}

	/**
	 * ���ʱ����趨
	 *
	 * @param autime ���ʱ���
	 */
	public void setAutime(String autime) {
		this.autime = autime;
	}
	
	/**
	 * �������IDȡ��
	 *
	 * @return �������ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * �������ID�趨
	 *
	 * @param autid �������ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}


	/**
	 * �ԱȽ������ȡ��
	 *
	 * @return �ԱȽ������
	 */
	public String getAucmptype() {
		return aucmptype;
	}

	/**
	 * �ԱȽ�������趨
	 *
	 * @param aucmptype �ԱȽ������
	 */
	public void setAucmptype(String aucmptype) {
		this.aucmptype = aucmptype;
	}

	/**
	 * �ʲ�IDȡ��
	 *
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
	 * ��汾ȡ��
	 *
	 * @return ��汾
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * ��汾�趨
	 *
	 * @param eiversion ��汾
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * С�汾ȡ��
	 *
	 * @return С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * С�汾�趨
	 *
	 * @param eismallversion С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * �ʲ�����ȡ��
	 *
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
	 * �����ʶȡ��
	 *
	 * @return �����ʶ
	 */
	public String getAuflag() {
		return auflag;
	}

	/**
	 * �����ʶ�趨
	 *
	 * @param auflag �����ʶ
	 */
	public void setAuflag(String auflag) {
		this.auflag = auflag;
	}

	/**
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�������趨
	 * @param esyscoding �ʲ������
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ģ��ʵ��ȡ��
	 * @return ģ��ʵ��
	 */
	public SOC0117TB getEntityTB() {
		return entityTB;
	}

}
