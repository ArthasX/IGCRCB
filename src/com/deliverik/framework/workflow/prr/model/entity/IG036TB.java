package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.model.IG036Info;


/**
 * <p>
 * ��־��Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG036")
public class IG036TB extends BaseEntity implements Serializable, Cloneable, IG036Info {

	/** ��־ID */
	@Id
	@TableGenerator(
		    name="IG036_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG036_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG036_TABLE_GENERATOR")
	protected Integer rlid;
	
	/** ���̼�¼ID */
	protected Integer prid;
	
	/** ��־��¼ʱ�� */
	protected String rltime;
	
	/** ��־�����˽�ɫID */
	protected Integer roleid;

	/** ��־�����˽�ɫ���� */
	protected String rlrolename;

	/** ��־������ID */
	protected String rluserid;

	/** ��־���������� */
	protected String rlusername;

	/** ��־���� */
	protected String rldesc;

	/** ��־��������д����Ϣ */
	protected String rlcomment;

	/** �������� */
	protected String rlattkey;

	/** ��־���� */
	protected String rltype;

	/** ��־�����˻�������� */
	protected String rlorgid;

	/** ��־�����˻������� */
	protected String rlorgname;
	
	/** ����״̬���� */
	protected String psname;
	
	/** ����״̬���� */
	protected String psdcode;
	
	/** ��ɫ�����˱�ʶ */
	protected String rolemanger;
	
	/** ��ťID */
	protected String pbdid;

	/** ����״̬����ID */
	protected String psdid;

	/** ��̬��֧��� */
	protected Integer psdnum;
	
	/**
	 * ����
	 */
	@Transient
	protected List<Attachment> attachmentList;
	
	/**
	 * ��ɫ�����˱�ʶȡ��
	 * @return ��ɫ�����˱�ʶ
	 */
	public String getRolemanger() {
		return rolemanger;
	}

	/**
	 * ��ɫ�����˱�ʶ�趨
	 * @param rolemanger ��ɫ�����˱�ʶ
	 */
	public void setRolemanger(String rolemanger) {
		this.rolemanger = rolemanger;
	}

	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ����״̬�����趨
	 * @param psdcode ����״̬����
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	
	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsname() {
		return psname;
	}

	/**
	 * ����״̬�����趨
	 * @param psname ����״̬����
	 */
	public void setPsname(String psname) {
		this.psname = psname;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public List<Attachment> getAttachmentList() {
		if(this.attachmentList == null && StringUtils.isNotEmpty(this.rlattkey)){
			AttachmentBL bl = (AttachmentBL) WebApplicationSupport.getBean("attachmentBL");
			this.attachmentList = bl.searchAttachmentsByAttkey(this.rlattkey);
		}
		return attachmentList;
	}

	/**
	 * ����ȡ��
	 * @return rlid
	 */
	public Serializable getPK() {
		return rlid;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG036TB))
			return false;
		IG036Info target = (IG036Info) obj;
		if (!(getRlid()==target.getRlid()))
			return false;

		return true;
	}
	
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getRltype() {
		return rltype;
	}

	/**
	 * ���������趨
	 * @param rltype ��������
	 */
	public void setRltype(String rltype) {
		this.rltype = rltype;
	}

	

	/**
	 * ��־IDȡ��
	 * @return ��־ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * ��־ID�趨
	 * @param rlid ��־ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��־��¼ʱ��ȡ��
	 * @return ��־��¼ʱ��
	 */
	public String getRltime() {
		return rltime;
	}

	/**
	 * ��־��¼ʱ���趨
	 * @param rltime ��־��¼ʱ��
	 */
	public void setRltime(String rltime) {
		this.rltime = rltime;
	}

	/**
	 * ��־�����˽�ɫIDȡ��
	 * @return ��־�����˽�ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��־�����˽�ɫID�趨
	 * @param roleid ��־�����˽�ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��־�����˽�ɫ����ȡ��
	 * @return ��־�����˽�ɫ����
	 */
	public String getRlrolename() {
		return rlrolename;
	}

	/**
	 * ��־�����˽�ɫ�����趨
	 * @param rlrolename ��־�����˽�ɫ����
	 */
	public void setRlrolename(String rlrolename) {
		this.rlrolename = rlrolename;
	}

	/**
	 * ��־������IDȡ��
	 * @return ��־������ID
	 */
	public String getRluserid() {
		return rluserid;
	}

	/**
	 * ��־������ID�趨
	 * @param rluserid ��־������ID
	 */
	public void setRluserid(String rluserid) {
		this.rluserid = rluserid;
	}

	/**
	 * ��־����������ȡ��
	 * @return ��־����������
	 */
	public String getRlusername() {
		return rlusername;
	}

	/**
	 * ��־�����������趨
	 * @param rlusername ��־����������
	 */
	public void setRlusername(String rlusername) {
		this.rlusername = rlusername;
	}

	/**
	 * ��־����ȡ��
	 * @return ��־����
	 */
	public String getRldesc() {
		return rldesc;
	}

	/**
	 * ��־�����趨
	 * @param rldesc ��־����
	 */
	public void setRldesc(String rldesc) {
		this.rldesc = rldesc;
	}

	/**
	 * ��־��������д����Ϣȡ��
	 * @return ��־��������д����Ϣ
	 */
	public String getRlcomment() {
		return rlcomment;
	}

	/**
	 * ��־��������д����Ϣ�趨
	 * @param rlcomment ��־��������д����Ϣ
	 */
	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getRlattkey() {
		return rlattkey;
	}

	/**
	 * ���������趨
	 * @param rlattkey ��������
	 */
	public void setRlattkey(String rlattkey) {
		this.rlattkey = rlattkey;
	}

	/**
	 * ��־�����˻��������ȡ��
	 * @return ��־�����˻��������
	 */
	public String getRlorgid() {
		return rlorgid;
	}

	/**
	 * ��־�����˻���������趨
	 * @param rlorgid ��־�����˻��������
	 */
	public void setRlorgid(String rlorgid) {
		this.rlorgid = rlorgid;
	}

	/**
	 * ��־�����˻�������ȡ��
	 * @return ��־�����˻�������
	 */
	public String getRlorgname() {
		return rlorgname;
	}

	/**
	 * ��־�����˻��������趨
	 * @param rlorgname ��־�����˻�������
	 */
	public void setRlorgname(String rlorgname) {
		this.rlorgname = rlorgname;
	}

	/**
	 * ��ťID�趨
	 * 
	 * @return ��ťID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * ��ťIDȡ��
	 * 
	 * @param pbdid ��ťID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬����ID�趨
	 * @param psdid ����״̬����ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * ��̬��֧����趨
	 * @param psdnum ��̬��֧���
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	public int compareTo(IG036Info o) {
		return this.rltime.compareTo(o.getRltime());
	}
}
