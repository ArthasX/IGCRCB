/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.asset.model.entity.IG688VW;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG933Info;

/**
 * <p>����:���񹤵�ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG933")
public class IG933TB extends BaseEntity implements Serializable, Cloneable, IG933Info {
	/** ���񹤵�ID */
	@Id
	@TableGenerator(
		    name="IG933_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG933_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG933_TABLE_GENERATOR")
	protected Integer sfid;
	
	/** ���񹤵�����*/
	protected String sfcode;

	/** ���񹤵�������*/
	protected String sfreportname;

	/** ���񹤵������˵绰*/
	protected String sfreportphone;

	/** ���񹤵������˲���*/
	protected String sfreportorgid;

	/** ���񹤵���Ŀ*/
	protected String sftitle;

	/** ���񹤵�����*/
	protected String sfdesc;
	
	/** ���񹤵�����*/
	protected String sfattkey;

	/** ���񹤵�״̬*/
	protected String sfstatus;

	/** ���񹤵�����ID*/
	protected String sforgid;

	/** ���񹤵���¼��ID*/
	protected String sfregisterid;

	/** ���񹤵���¼ʱ��*/
	protected String sfinstime;

	/** ���񹤵���¼����*/
	protected String sftype;
	
	/** ���񹤵�����ʲ�*/
	protected Integer sfeiid;
	
	/** ���񹤵���Դ*/
	protected String sfsource;
	
	/** ���񹤵��칫�绰*/
	protected String sfworkphone;
	
	/** ���񹤵�����*/
	protected String sfemail;
	
	/** ��������ʵ�� */
	@OneToOne
	@JoinColumn(name="sftype", referencedColumnName="syscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected CodeDetailTB codeDetailTB;
	
	/** �ʲ�ʵ�� */
	@OneToOne
	@JoinColumn(name="sfeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG688VW entityItemVW;
	
	/** �û�ʵ�� */
	@OneToOne
	@JoinColumn(name="sfregisterid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB userTB;
	
	/** ����ʵ�� */
	@OneToOne
	@JoinColumn(name="sforgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	/** �����˻���ʵ�� */
	@OneToOne
	@JoinColumn(name="sfreportorgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB reportorganizationTB;
	
	/**
	 * ���ܣ�����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return sfid;
	}
	
	/**
	 * ���ܣ����񹤵�IDȡ��
	 * 
	 * @return ���񹤵�ID
	 */
	public Integer getSfid() {
		return sfid;
	}
	
	/**
	 * ���ܣ����񹤵�ID����
	 * @param sfid
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}
	
	/**
	 * ���ܣ����񹤵�����ȡ��
	 * 
	 * @return ���񹤵�����
	 */
	public String getSfcode() {
		return sfcode;
	}
	
	/**
	 * ���ܣ����񹤵���������
	 * @param sfcode
	 */
	public void setSfcode(String sfcode) {
		this.sfcode = sfcode;
	}
	
	/**
	 * ���ܣ����񹤵�������ȡ��
	 * 
	 * @return ���񹤵�������
	 */
	public String getSfreportname() {
		return sfreportname;
	}
	/**
	 * ���ܣ����񹤵�����������
	 * @param sfreportname
	 */
	public void setSfreportname(String sfreportname) {
		this.sfreportname = sfreportname;
	}
	
	/**
	 * ���ܣ����񹤵������˵绰ȡ��
	 * 
	 * @return ���񹤵������˵绰
	 */
	public String getSfreportphone() {
		return sfreportphone;
	}
	
	/**
	 * ���ܣ����񹤵������˵绰����
	 * @param sfreportphone
	 */
	public void setSfreportphone(String sfreportphone) {
		this.sfreportphone = sfreportphone;
	}
	
	/**
	 * ���ܣ����񹤵������˲���ȡ��
	 * 
	 * @return ���񹤵������˲���
	 */
	public String getSfreportorgid() {
		return sfreportorgid;
	}
	
	/**
	 * ���ܣ����񹤵������˲�������
	 * @param sfreportorgid
	 */
	public void setSfreportorgid(String sfreportorgid) {
		this.sfreportorgid = sfreportorgid;
	}
	
	/**
	 * ���ܣ����񹤵���Ŀȡ��
	 * 
	 * @return ���񹤵���Ŀ
	 */
	public String getSftitle() {
		return sftitle;
	}
	
	/**
	 * ���ܣ����񹤵���Ŀ����
	 * @param sftitle
	 */
	public void setSftitle(String sftitle) {
		this.sftitle = sftitle;
	}

	/**
	 * ���ܣ����񹤵�����ȡ��
	 * 
	 * @return ���񹤵�����
	 */
	public String getSfdesc() {
		return sfdesc;
	}
	/**
	 * ���ܣ����񹤵���������
	 * @param sfdesc
	 */
	public void setSfdesc(String sfdesc) {
		this.sfdesc = sfdesc;
	}


	/**
	 * ���ܣ����񹤵�����ȡ��
	 * 
	 * @return ���񹤵�����
	 */
	public String getSfattkey() {
		return sfattkey;
	}
	
	/**
	 * ���ܣ����񹤵���������
	 * @param sfattkey
	 */
	public void setSfattkey(String sfattkey) {
		this.sfattkey = sfattkey;
	}
	
	/**
	 * ���ܣ����񹤵�״̬ȡ��
	 * 
	 * @return ���񹤵�״̬
	 */
	public String getSfstatus() {
		return sfstatus;
	}
	
	/**
	 * ���ܣ����񹤵�״̬����
	 * @param sfstatus
	 */
	public void setSfstatus(String sfstatus) {
		this.sfstatus = sfstatus;
	}

	/**
	 * ���ܣ����񹤵�����IDȡ��
	 * 
	 * @return ���񹤵�����ID
	 */
	public String getSforgid() {
		return sforgid;
	}
	
	/**
	 * ���ܣ����񹤵�����ID����
	 * @param sforgid
	 */
	public void setSforgid(String sforgid) {
		this.sforgid = sforgid;
	}

	/**
	 * ���ܣ����񹤵���¼��IDȡ��
	 * 
	 * @return ���񹤵���¼��ID
	 */
	public String getSfregisterid() {
		return sfregisterid;
	}
	
	/**
	 * ���ܣ����񹤵���¼��ID����
	 * @param sfregisterid
	 */
	public void setSfregisterid(String sfregisterid) {
		this.sfregisterid = sfregisterid;
	}

	/**
	 * ���ܣ����񹤵���¼ʱ��ȡ��
	 * 
	 * @return ���񹤵���¼ʱ��
	 */
	public String getSfinstime() {
		return sfinstime;
	}
	
	/**
	 * ���ܣ����񹤵���¼ʱ������
	 * @param sfinstime
	 */
	public void setSfinstime(String sfinstime) {
		this.sfinstime = sfinstime;
	}
	
	
	/** 
	 * ���ܣ����񹤵���¼����ȡ��
	 * 
	 * @return ���񹤵���¼����
	 */
	public String getSftype() {
		return sftype;
	}

	/**
	 * ���ܣ����񹤵���¼��������
	 * @param sftype
	 */
	public void setSftype(String sftype) {
		this.sftype = sftype;
	}

	/** 
	 * ���ܣ����񹤵�����ʲ�ȡ��
	 * 
	 * @return ���񹤵�����ʲ�
	 */
	public Integer getSfeiid() {
		return sfeiid;
	}

	/**
	 * ���ܣ����񹤵�����ʲ�����
	 * @param sfeiid
	 */
	public void setSfeiid(Integer sfeiid) {
		this.sfeiid = sfeiid;
	}
	
	/**
	 * ���ܣ������������Ͷ���ȡ��
	 * 
	 * @return codeDetailTB �����������Ͷ���
	 */
	public CodeDetailTB getCodeDetailTB() {
		return codeDetailTB;
	}

	/**
	 * ���ܣ������������Ͷ�������
	 * @param codeDetailTB
	 */
	public void setCodeDetailTB(CodeDetailTB codeDetailTB) {
		this.codeDetailTB = codeDetailTB;
	}
	
	/**
	 * ���ܣ��ʲ�ʵ�����ȡ��
	 * 
	 * @return entityItemVW �ʲ�ʵ�����
	 */
	public IG688VW getEntityItemVW() {
		return entityItemVW;
	}

	/**
	 * ���ܣ��ʲ�ʵ���������
	 * @param entityItemVW
	 */
	public void setEntityItemVW(IG688VW entityItemVW) {
		this.entityItemVW = entityItemVW;
	}

	/**
	 * ���ܣ��û�ʵ�����ȡ��
	 * 
	 * @return userTB �û�ʵ�����
	 */
	public UserTB getUserTB() {
		return userTB;
	}

	/**
	 * ���ܣ��û�ʵ���������
	 * @param userTB
	 */
	public void setUserTB(UserTB userTB) {
		this.userTB = userTB;
	}
	
	/**
	 * ���ܣ�����ʵ�����ȡ��
	 * 
	 * @return organizationTB ����ʵ�����
	 */
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	/**
	 * ���ܣ�����ʵ���������
	 * @param organizationTB
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

	/**
	 * ���ܣ������˻���ʵ�����ȡ��
	 * 
	 * @return organizationTB �����˻���ʵ�����
	 */
	public OrganizationTB getReportOrganizationTB() {
		return reportorganizationTB;
	}

	/**
	 * ���ܣ������˻���ʵ���������
	 * @param reportorganizationTB
	 */
	public void setReportOrganizationTB(OrganizationTB reportorganizationTB) {
		this.reportorganizationTB = reportorganizationTB;
	}

	/**
	 * ���ܣ����񹤵���Դȡ��
	 * 
	 * @return ���񹤵���Դ
	 */
	public String getSfsource() {
		return sfsource;
	}

	/**
	 * ���ܣ����񹤵���Դ����
	 * @param sfsource ���񹤵���Դ
	 */
	public void setSfsource(String sfsource) {
		this.sfsource = sfsource;
	}

	/**
	 * ���ܣ����񹤵��칫�绰ȡ��
	 * 
	 * @return ���񹤵��칫�绰
	 */
	public String getSfworkphone() {
		return sfworkphone;
	}

	/**
	 * ���ܣ����񹤵��칫�绰����
	 * @param sfworkphone ���񹤵��칫�绰
	 */
	public void setSfworkphone(String sfworkphone) {
		this.sfworkphone = sfworkphone;
	}

	/**
	 * ���ܣ�����ȡ��
	 * 
	 * @return ����
	 */
	public String getSfemail() {
		return sfemail;
	}

	/**
	 * ���ܣ���������
	 * @param sfemail ����
	 */
	public void setSfemail(String sfemail) {
		this.sfemail = sfemail;
	}



}
