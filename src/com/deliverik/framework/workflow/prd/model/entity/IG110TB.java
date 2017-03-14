/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG110Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��ʾ�ж���ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG110")
public class IG110TB extends BaseEntity implements IG110Info{
	
	/** ���� */
	@Id
	protected String sid;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ��ʾ������ */
	protected String stype;
	
	/** ��ʾ�б�ʶ */
	protected String sflag;
	
	/** ��ʶ���� */
	protected String sname;
	
	/** ��� */
	protected Integer width;

	/**
	 * ����ȡ��
	 * @return sid ����
	 */
	public String getSid() {
		return sid;
	}

	/**
	 * �����趨
	 * @param sid ����
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��ʾ������ȡ��
	 * @return stype ��ʾ������
	 */
	public String getStype() {
		return stype;
	}

	/**
	 * ��ʾ�������趨
	 * @param stype ��ʾ������
	 */
	public void setStype(String stype) {
		this.stype = stype;
	}

	/**
	 * ��ʾ�б�ʶȡ��
	 * @return sflag ��ʾ�б�ʶ
	 */
	public String getSflag() {
		return sflag;
	}

	/**
	 * ��ʾ�б�ʶ�趨
	 * @param sflag ��ʾ�б�ʶ
	 */
	public void setSflag(String sflag) {
		this.sflag = sflag;
	}

	/**
	 * ��ʶ����ȡ��
	 * @return sname ��ʶ����
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * ��ʶ�����趨
	 * @param sname ��ʶ����
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * ���ȡ��
	 * @return width ���
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * ����趨
	 * @param width ���
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.sid;
	}

}
