/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;

/**
  * ����: ��鹤��ͳ�Ʊ���ʵ��
  * ��������: ��鹤��ͳ�Ʊ���ʵ��
  * ������¼: 2014/07/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckWorkConutVW")
public class CheckWorkConutVW extends BaseEntity implements Serializable,
		Cloneable, CheckWorkConutVWInfo {

	/** ���� */
	@Id
	protected Integer id;
	
	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	protected Integer rcid;

	/** ��������� */
	protected String rcname;
	
	/** �����˵��*/
	protected String rcdesc;

	/** ���Ƶ�� */
	protected String rcfrequency;

	/** ������ */
	protected String rcusername;

	/** �������� */
	protected String rccategoryname;

	/** �������� */
	protected String prtitle;

	/** ��鷽ʽ */
	protected String rcrtestmode;

	/** ����� */
	protected String rcstatus;

	/** ʵ�ʼ��ʱ�� */
	protected String rccreatetime;

	/** ���˵�� */
	protected String rcrcomment;

	/** ���̶� */
	protected String rcrresult;

	/** ���� */
	protected String rcrattch;

	/** ���ƻ�ʱ�� */
	protected String rcrplandate;
	
	/**��鿪ʼʱ��*/
	protected String rcstartdate;
	
	/** ���ռ������ */
	protected String rcclass;
	/**����id*/
	protected String attachid;

	/**
	 * ��鿪ʼʱ��ȡ��
	 * @return rcstartdate ��鿪ʼʱ��
	 */
	public String getRcstartdate() {
		return rcstartdate;
	}

	/**
	 * ��鿪ʼʱ���趨
	 * @param rcstartdate ��鿪ʼʱ��
	 */
	public void setRcstartdate(String rcstartdate) {
		this.rcstartdate = rcstartdate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * �����趨
	 *
	 * @param rcid ����
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * ����������趨
	 *
	 * @param rcname ���������
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * ���Ƶ��ȡ��
	 *
	 * @return ���Ƶ��
	 */
	public String getRcfrequency() {
		return rcfrequency;
	}

	/**
	 * ���Ƶ���趨
	 *
	 * @param rcfrequency ���Ƶ��
	 */
	public void setRcfrequency(String rcfrequency) {
		this.rcfrequency = rcfrequency;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRcusername() {
		return rcusername;
	}

	/**
	 * �������趨
	 *
	 * @param rcusername ������
	 */
	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}

	/**
	 * ���������趨
	 *
	 * @param rccategoryname ��������
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���������趨
	 *
	 * @param prtitle ��������
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��鷽ʽȡ��
	 *
	 * @return ��鷽ʽ
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * ��鷽ʽ�趨
	 *
	 * @param rcrtestmode ��鷽ʽ
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public String getRcstatus() {
		return rcstatus;
	}

	/**
	 * ������趨
	 *
	 * @param rcstatus �����
	 */
	public void setRcstatus(String rcstatus) {
		this.rcstatus = rcstatus;
	}

	/**
	 * ʵ�ʼ��ʱ��ȡ��
	 *
	 * @return ʵ�ʼ��ʱ��
	 */
	public String getRccreatetime() {
		return rccreatetime;
	}

	/**
	 * ʵ�ʼ��ʱ���趨
	 *
	 * @param rccreatetime ʵ�ʼ��ʱ��
	 */
	public void setRccreatetime(String rccreatetime) {
		this.rccreatetime = rccreatetime;
	}

	/**
	 * ���˵��ȡ��
	 *
	 * @return ���˵��
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * ���˵���趨
	 *
	 * @param rcrcomment ���˵��
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}

	/**
	 * ���̶�ȡ��
	 *
	 * @return ���̶�
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * ���̶��趨
	 *
	 * @param rcrresult ���̶�
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRcrattch() {
		return rcrattch;
	}

	/**
	 * �����趨
	 *
	 * @param rcrattch ����
	 */
	public void setRcrattch(String rcrattch) {
		this.rcrattch = rcrattch;
	}

	/**
	 * ���ƻ�ʱ��ȡ��
	 *
	 * @return ���ƻ�ʱ��
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}

	/**
	 * ���ƻ�ʱ���趨
	 *
	 * @param rcrplandate ���ƻ�ʱ��
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rcid;
	}

	/**
	 * ���ռ������ȡ��
	 * @return rcclass ���ռ������
	 */
	public String getRcclass() {
		return rcclass;
	}

	/**
	 * ���ռ�������趨
	 * @param rcclass ���ռ������
	 */
	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	/**
	 * ����idȡ��
	 * @return attachid ����id
	 */
	public String getAttachid() {
		return attachid;
	}

	/**
	 * ����id�趨
	 * @param attachid ����id
	 */
	public void setAttachid(String attachid) {
		this.attachid = attachid;
	}

	/**
	 * �����˵��ȡ��
	 * @return the rcdesc
	 */
	public String getRcdesc() {
		return rcdesc;
	}

	/**
	 * �����˵���趨
	 * @param rcdesc the �����˵��
	 */
	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}
}