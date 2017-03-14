/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;

/**
  * ����: PDF����XML�б��ʽ���ڵ㶨���ʵ��
  * ��������: PDF����XML�б��ʽ���ڵ㶨���ʵ��
  * ������¼: 2013/08/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(PdfTableNodePK.class)
@Table(name="PdfTableNode")
public class PdfTableNodeTB extends BaseEntity implements Serializable,
		Cloneable, PdfTableNodeInfo {

	/** ���̶���ID */
	@Id
	protected String pdid;

	/** ������ */
	@Id
	protected String databinding;

	/** �������� */
	protected String pdatabinding;
	
	/**  ����ڵ����ͣ�0�̶���1�ɱ�*/
	protected String nodetype;

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 *
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getDatabinding() {
		return databinding;
	}

	/**
	 * �������趨
	 *
	 * @param databinding ������
	 */
	public void setDatabinding(String databinding) {
		this.databinding = databinding;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPdatabinding() {
		return pdatabinding;
	}

	/**
	 * ���������趨
	 *
	 * @param pdatabinding ��������
	 */
	public void setPdatabinding(String pdatabinding) {
		this.pdatabinding = pdatabinding;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new PdfTableNodePK(pdid, databinding);
	}

    /**
     * @return the ����ڵ����ͣ�0�̶���1�ɱ�
     */
    public String getNodetype() {
        return nodetype;
    }

    /**
     * @param ����ڵ����ͣ�0�̶���1�ɱ� the nodetype to set
     */
    public void setNodetype(String nodetype) {
        this.nodetype = nodetype;
    }

}