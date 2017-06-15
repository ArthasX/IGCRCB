package com.deliverik.framework.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.CodeDetailDef;

/**
 * ������ϸ��Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@Entity
@IdClass(CodeDetailDefTBPK.class)
@Table(name="CODEDETAILDEF")
public class CodeDetailDefTB extends BaseEntity implements Serializable, Cloneable, CodeDetailDef {

	/** ���ݷ���CD */
	@Id
	protected String ccid ;
	
	/** ����CD */
	@Id
	protected String cid;
	
	/** �������� */
	protected String cvalue;

	/** ���ݷ�����(��) */
	protected String pccid;

	/** ���ݱ��(��) */
	protected String pcid;

	/** ����ʱ�� */
	protected String updtime;
	
	/** ����� */
	public String syscoding;
	
	/** �ϼ������ */
	public String psyscoding;
	
	/** ״̬ 0-ͣ�ã�1-���� */
	public String cdstatus;
	
	/** ����ҵ���� */
	public String businesscode;
	
	/** ����˵�� */
	public String cdinfo;
	
	/** ���ݷ�����Ϣ */
	@ManyToOne
	@JoinColumn(name="ccid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected CodeCategoryDefTB codeCategoryDef;

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return new CodeDetailDefTBPK(ccid,cid);
	}

	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * ���ݷ���CD�趨
	 *
	 * @param ccid ���ݷ���CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * ����CDȡ��
	 * @return ����CD
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * ����CD�趨
	 *
	 * @param cid ����CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getCvalue() {
		return cvalue;
	}


	/**
	 * ���������趨
	 *
	 * @param cvalue ��������
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}


	/**
	 * ���ݷ�����(��)ȡ��
	 * @return ���ݷ�����(��)
	 */
	public String getPccid() {
		return pccid;
	}


	/**
	 * ���ݷ�����(��)�趨
	 *
	 * @param pccid ���ݷ�����(��)
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}


	/**
	 * ���ݱ��(��)ȡ��
	 * @return ���ݱ��(��)
	 */
	public String getPcid() {
		return pcid;
	}


	/**
	 * ���ݱ��(��)�趨
	 *
	 * @param pcid ���ݱ��(��)
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}


	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getUpdtime() {
		return updtime;
	}


	/**
	 * ����ʱ���趨
	 *
	 * @param updtime ����ʱ��
	 */
	public void setUpdtime(String updtime) {
		this.updtime = updtime;
	}

	/**
	 * ���ݷ�����Ϣȡ��
	 * @return ���ݷ�����Ϣ
	 */
	public CodeCategoryDefTB getCodeCategoryDef() {
		return codeCategoryDef;
	}

	/**
	 * �����
	 * @return �����
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * �����
	 *
	 * @param syscoding �����
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * �ϼ������
	 * @return �ϼ������
	 */
	public String getPsyscoding() {
		return psyscoding;
	}

	/**
	 * �����
	 *
	 * @param syscoding �����
	 */
	public void setPsyscoding(String psyscoding) {
		this.psyscoding = psyscoding;
	}

	/**
	 * ״̬ 0-ͣ�ã�1-����
	 * @return ״̬
	 */
	public String getCdstatus() {
		return cdstatus;
	}

	/**
	 * ״̬ 0-ͣ�ã�1-����
	 *
	 * @param cdstatus ״̬
	 */
	public void setCdstatus(String cdstatus) {
		this.cdstatus = cdstatus;
	}

	/**
	 * ����ҵ����
	 * @return ����ҵ����
	 */
	public String getBusinesscode() {
		return businesscode;
	}

	/**
	 * ����ҵ����
	 *
	 * @param businesscode ����ҵ����
	 */
	public void setBusinesscode(String businesscode) {
		this.businesscode = businesscode;
	}

	/**
	 * ����˵��
	 * @return ����˵��
	 */
	public String getCdinfo() {
		return cdinfo;
	}

	/**
	 * ����˵��
	 *
	 * @param cdinfo ����˵��
	 */
	public void setCdinfo(String cdinfo) {
		this.cdinfo = cdinfo;
	}
	
}
