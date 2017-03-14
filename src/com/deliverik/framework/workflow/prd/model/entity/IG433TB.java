/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

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

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.workflow.prd.model.IG433Info;

/**
 * ����:��������ʵ��TB�� ���������������������ʵ��
 * 
 * ������¼���κ��� 2010/11/26
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "IG433")
public class IG433TB extends BaseEntity implements Serializable,
		Cloneable, IG433Info {
	@Id
	@TableGenerator(name = "IG433_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "IG433_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "IG433_TABLE_GENERATOR")
	/*
	 * *����
	 */
	protected Integer paid;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getPaid() {
		return paid;
	}

	/**
	 *�����趨
	 * 
	 * @param paid����
	 */
	public void setPaid(Integer paid) {
		this.paid = paid;
	}

	/**
	 *����ID
	 */
	protected Integer paprid;

	/**
	 *����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPaprid() {
		return paprid;
	}

	/**
	 *����ID�趨
	 * 
	 * @param paprid����ID
	 */
	public void setPaprid(Integer paprid) {
		this.paprid = paprid;
	}

	/**
	 *������
	 */
	protected String paprname;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public String getPaprname() {
		return paprname;
	}

	/**
	 *�������趨
	 * 
	 * @param paprname������
	 */
	public void setPaprname(String paprname) {
		this.paprname = paprname;
	}

	/**
	 *������id
	 */
	protected String pauserid;

	/**
	 *������idȡ��
	 * 
	 * @return ������id
	 */
	public String getPauserid() {
		return pauserid;
	}

	/**
	 *������id�趨
	 * 
	 * @param pauserid������id
	 */
	public void setPauserid(String pauserid) {
		this.pauserid = pauserid;
	}

	/**
	 *����˵��1
	 */
	protected String paassessmentdes;

	/**
	 *����˵��1ȡ��
	 * 
	 * @return ����˵��1
	 */
	public String getPaassessmentdes() {
		return paassessmentdes;
	}

	/**
	 *����˵��1�趨
	 * 
	 * @param paassessmentdes����˵��1
	 */
	public void setPaassessmentdes(String paassessmentdes) {
		this.paassessmentdes = paassessmentdes;
	}

	/**
	 *����ʱ��
	 */
	protected String paassessmentdate;

	/**
	 *����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getPaassessmentdate() {
		return paassessmentdate;
	}

	/**
	 *����ʱ���趨
	 * 
	 * @param paassessmentdate����ʱ��
	 */
	public void setPaassessmentdate(String paassessmentdate) {
		this.paassessmentdate = paassessmentdate;
	}
	
	/**
	 * �¼����code
	 */
	protected String paeventtypecode;
	
	/**
	 *�¼����codeȡ��
	 * 
	 * @return �¼����code
	 */
	public String getPaeventtypecode() {
		return paeventtypecode;
	}

	/**
	 *�¼����code�趨
	 * 
	 * @param paeventtypecode�¼����code
	 */
	public void setPaeventtypecode(String paeventtypecode) {
		this.paeventtypecode = paeventtypecode;
	}

	/**
	 * �¼�����key
	 */
	protected String paattkey;
	
	/**
	 * �¼�����Keyȡ��
	 * @return �¼�����Key
	 */
	public String getPaattkey() {
		return paattkey;
	}

	/**
	 * �¼�����Key�趨
	 * @param paattkey �¼�����Key
	 */
	public void setPaattkey(String paattkey) {
		this.paattkey = paattkey;
	}

	@OneToMany(targetEntity=AttachmentTB.class)
	@JoinColumn(name="attkey", referencedColumnName="paattkey", updatable=false, insertable= false)
	@Basic(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<AttachmentTB> attachmentList;
	
	public List<AttachmentTB> getAttachmentList() {
		return attachmentList;
	}

	/**
	 * ����״̬
	 */
	protected String pastatus;
	
	/**
	 * ����״̬ȡ��
	 * @return ����״̬
	 */
	public String getPastatus() {
		return pastatus;
	}

	/**
	 * ����״̬�趨
	 * @param pastatus ����״̬
	 */
	public void setPastatus(String pastatus) {
		this.pastatus = pastatus;
	}

	public Serializable getPK() {
		return paid;
	}
}
