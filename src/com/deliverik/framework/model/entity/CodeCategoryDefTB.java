package com.deliverik.framework.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.CodeCategoryDefInfo;

/**
 * ���ݷ�����Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="CodeCategoryDef")
public class CodeCategoryDefTB extends BaseEntity implements Serializable, CodeCategoryDefInfo {

	/** ���ݷ���CD */
	@Id
	protected String ccid ;
	
	/** ���ݷ����� */
	protected String ccname;

	/** ���ݷ���˵�� */
	protected String ccinfo;

	/** ���ݷ���༭��ʶ */
	protected String cceditable;

	/** ���ݷ�����(��) */
	protected String pccid;

	/** �����������ݷ����ʶ */
	protected String pcflag;

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return ccid;
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
	 * ���ݷ�����ȡ��
	 * @return ���ݷ�����
	 */
	public String getCcname() {
		return ccname;
	}


	/**
	 * ���ݷ������趨
	 *
	 * @param ccname ���ݷ�����
	 */
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}


	/**
	 * ���ݷ���˵��ȡ��
	 * @return ���ݷ���˵��
	 */
	public String getCcinfo() {
		return ccinfo;
	}


	/**
	 * ���ݷ���˵���趨
	 *
	 * @param ccinfo ���ݷ���˵��
	 */
	public void setCcinfo(String ccinfo) {
		this.ccinfo = ccinfo;
	}


	/**
	 * ���ݷ���༭��ʶȡ��
	 * @return ���ݷ���༭��ʶ
	 */
	public String getCceditable() {
		return cceditable;
	}

	/**
	 * ���ݷ���༭��ʶ�趨
	 *
	 * @param cceditable ���ݷ���༭��ʶ
	 */
	public void setCceditable(String cceditable) {
		this.cceditable = cceditable;
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
	 * �����������ݷ����ʶȡ��
	 * @return �����������ݷ����ʶ
	 */
	public String getPcflag() {
		return pcflag;
	}


	/**
	 * �����������ݷ����ʶ�趨
	 *
	 * @param pcflag �����������ݷ����ʶ
	 */
	public void setPcflag(String pcflag) {
		this.pcflag = pcflag;
	}
}
