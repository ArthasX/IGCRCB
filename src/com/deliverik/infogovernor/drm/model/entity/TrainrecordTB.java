/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.infogovernor.drm.model.TrainrecordInfo;

/**
  * ����: ��ѵ��¼ʵ��
  * ��������: ��ѵ��¼ʵ��
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="trainrecord")
public class TrainrecordTB implements Serializable,
		Cloneable, TrainrecordInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="TRAINRECORD_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="TRAINRECORD_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="TRAINRECORD_TABLE_GENERATOR")
	protected Integer trid;

	/** ��ѵ���� */
	protected String trname;

	/** ��ѵ�ƻ�id */
	protected Integer tpid;

	/** ��ѵ�ƻ����� */
	protected String tpname;

	/** ��ѵ���� */
	protected String tpcontent;

	/** ��ѵ��ʼʱ�� */
	protected String trstime;

	/** ��ѵ����ʱ�� */
	protected String tretime;

	/** ��ѵ�ص� */
	protected String trside;

	/** ��ʦ */
	protected String trlecturer;

	/** ���� */
	protected String tratt;
	
	/**
	 * ����
	 */
	@OneToMany(targetEntity=AttachmentTB.class)
	@JoinColumn(name="attkey", referencedColumnName="tratt")
	@Basic(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<AttachmentTB> attachmentList;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getTrid() {
		return trid;
	}

	/**
	 * �����趨
	 *
	 * @param trid ����
	 */
	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTrname() {
		return trname;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param trname ��ѵ����
	 */
	public void setTrname(String trname) {
		this.trname = trname;
	}

	/**
	 * ��ѵ�ƻ�idȡ��
	 *
	 * @return ��ѵ�ƻ�id
	 */
	public Integer getTpid() {
		return tpid;
	}

	/**
	 * ��ѵ�ƻ�id�趨
	 *
	 * @param tpid ��ѵ�ƻ�id
	 */
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**
	 * ��ѵ�ƻ�����ȡ��
	 *
	 * @return ��ѵ�ƻ�����
	 */
	public String getTpname() {
		return tpname;
	}

	/**
	 * ��ѵ�ƻ������趨
	 *
	 * @param tpname ��ѵ�ƻ�����
	 */
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**
	 * ��ѵ����ȡ��
	 *
	 * @return ��ѵ����
	 */
	public String getTpcontent() {
		return tpcontent;
	}

	/**
	 * ��ѵ�����趨
	 *
	 * @param tpcontent ��ѵ����
	 */
	public void setTpcontent(String tpcontent) {
		this.tpcontent = tpcontent;
	}

	/**
	 * ��ѵ��ʼʱ��ȡ��
	 *
	 * @return ��ѵ��ʼʱ��
	 */
	public String getTrstime() {
		return trstime;
	}

	/**
	 * ��ѵ��ʼʱ���趨
	 *
	 * @param trstime ��ѵ��ʼʱ��
	 */
	public void setTrstime(String trstime) {
		this.trstime = trstime;
	}

	/**
	 * ��ѵ����ʱ��ȡ��
	 *
	 * @return ��ѵ����ʱ��
	 */
	public String getTretime() {
		return tretime;
	}

	/**
	 * ��ѵ����ʱ���趨
	 *
	 * @param tretime ��ѵ����ʱ��
	 */
	public void setTretime(String tretime) {
		this.tretime = tretime;
	}

	/**
	 * ��ѵ�ص�ȡ��
	 *
	 * @return ��ѵ�ص�
	 */
	public String getTrside() {
		return trside;
	}

	/**
	 * ��ѵ�ص��趨
	 *
	 * @param trside ��ѵ�ص�
	 */
	public void setTrside(String trside) {
		this.trside = trside;
	}

	/**
	 * ��ʦȡ��
	 *
	 * @return ��ʦ
	 */
	public String getTrlecturer() {
		return trlecturer;
	}

	/**
	 * ��ʦ�趨
	 *
	 * @param trlecturer ��ʦ
	 */
	public void setTrlecturer(String trlecturer) {
		this.trlecturer = trlecturer;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getTratt() {
		return tratt;
	}

	/**
	 * �����趨
	 *
	 * @param tratt ����
	 */
	public void setTratt(String tratt) {
		this.tratt = tratt;
	}

	/**  
	 * ��ȡ����  
	 * @return attachmentList ����  
	 */
	public List<AttachmentTB> getAttachmentList() {
		return attachmentList;
	}

	/**  
	 * ���ø���  
	 * @param attachmentList ����  
	 */
	public void setAttachmentList(List<AttachmentTB> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return trid;
	}
}