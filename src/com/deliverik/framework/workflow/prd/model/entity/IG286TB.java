/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG286Info;

/**
 * <p>����:������ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG286")
public class IG286TB extends BaseEntity implements Serializable, Cloneable, IG286Info {

	/** ����ID */
	@Id
	protected String plid;
	
	/** ����id */
	protected String initiativepidid;
	
	/** ���������� */
	protected String initiativepidname;
	
	/** ����id */
	protected String passivitypidid;
	
	/** ���������� */
	protected String passivitypidname;

	/** �������� */
	protected String pldesc;
	
	/** bl���� */
	protected String plblname;
	
	/** js�¼����� */
	protected String pljsevent;
	/** ���������� */
	protected String pljtype;

	@ManyToOne
	@JoinColumn(name="pldpdid", referencedColumnName="pdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG380TB processDefinitionTB;
	
	/** ���̶���id */
	protected String pldpdid;
	
	/**����ťid  */
	protected String pldactionid;

	/**
	 * ���ܣ�����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return plid;
	}
	
	/**
	 * ���ܣ�����IDȡ��
	 * @return ����ID
	 */
	public String getPlid() {
		return plid;
	}

	/**
	 * ���ܣ�����ID�趨
	 *
	 * @param srid ����ID
	 */
	public void setPlid(String plid) {
		this.plid = plid;
	}

	/**
	 * ���ܣ�����idȡ��
	 * @return ����id
	 */
	public String getInitiativepidid() {
		return initiativepidid;
	}

	/**
	 * ���ܣ�����id�趨
	 *
	 * @param initiativepidid ����id
	 */
	public void setInitiativepidid(String initiativepidid) {
		this.initiativepidid = initiativepidid;
	}

	/**
	 * ���ܣ�����idȡ��
	 * @return ����id
	 */
	public String getPassivitypidid() {
		return passivitypidid;
	}

	/**
	 * ���ܣ�����id�趨
	 *
	 * @param passivitypidid ����id
	 */
	public void setPassivitypidid(String passivitypidid) {
		this.passivitypidid = passivitypidid;
	}

	/**
	 * ���ܣ���������ȡ��
	 * @return ��������
	 */
	public String getPldesc() {
		return pldesc;
	}

	/**
	 * ���ܣ����������趨
	 *
	 * @param pldesc ��������
	 */
	public void setPldesc(String pldesc) {
		this.pldesc = pldesc;
	}

	/**
	 * ���ܣ�bl����
	 * @return bl����
	 */
	public String getPlblname() {
		return plblname;
	}

	/**
	 * ���ܣ�bl�����趨
	 *
	 * @param plblname bl����
	 */
	public void setPlblname(String plblname) {
		this.plblname = plblname;
	}

	/**
	 * ���ܣ�js�¼�����ȡ��
	 * @return js�¼�����
	 */
	public String getPljsevent() {
		return pljsevent;
	}

	/**
	 * ���ܣ�js�¼������趨
	 *
	 * @param pljsevent js�¼�����
	 */
	public void setPljsevent(String pljsevent) {
		this.pljsevent = pljsevent;
	}

	/**
	 * ���ܣ�����������ȡ��
	 * @return ����������
	 */
	public String getPljtype() {
		return pljtype;
	}

	/**
	 * ���ܣ������������趨
	 * @param  pljtype ����������
	 */
	public void setPljtype(String pljtype) {
		this.pljtype = pljtype;
	}

	/**
	 * ���ܣ����̶���idȡ��
	 * @return ���̶���id
	 */
	public String getPldpdid() {
		return pldpdid;
	}

	/**
	 * ���ܣ����̶���id�趨
	 * @param  pldpdid ���̶���id
	 */
	public void setPldpdid(String pldpdid) {
		this.pldpdid = pldpdid;
	}

	/**
	 * ���ܣ�����ťidȡ��
	 * @return ����ťid
	 */
	public String getPldactionid() {
		return pldactionid;
	}

	/**
	 * ���ܣ�����ťid�趨
	 * @param  pldactionid ����ťid
	 */
	public void setPldactionid(String pldactionid) {
		this.pldactionid = pldactionid;
	}
	
	/**
	 * ���ܣ����̶���ȡ��
	 * @return processDefinitionTB ���̶���
	 */
	public IG380TB getProcessDefinitionTB() {
		return processDefinitionTB;
	}

	/**
	 * ���ܣ����̶����趨
	 * @param  processDefinitionTB ���̶���
	 */
	public void setProcessDefinitionTB(IG380TB processDefinitionTB) {
		this.processDefinitionTB = processDefinitionTB;
	}

	/**
	 * ���ܣ�����������ȡ��
	 * @return ����������
	 */
	public String getInitiativepidname() {
		return initiativepidname;
	}

	/**
	 * ���ܣ������������趨
	 * @param  initiativepidname ����������
	 */
	public void setInitiativepidname(String initiativepidname) {
		this.initiativepidname = initiativepidname;
	}

	/**
	 * ���ܣ�����������ȡ��
	 * @return ����������
	 */
	public String getPassivitypidname() {
		return passivitypidname;
	}

	/**
	 * ���ܣ������������趨
	 * @param  passivitypidname ����������
	 */
	public void setPassivitypidname(String passivitypidname) {
		this.passivitypidname = passivitypidname;
	}


	
	
}
