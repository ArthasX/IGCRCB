/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;

/**
  * ����: �����˱�ʵ��
  * ��������: �����˱�ʵ��
  * ������¼: 2013/02/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CopyReadUser")
public class CopyReadUserTB extends BaseEntity implements Serializable,
		Cloneable, CopyReadUserInfo {

	/** �������������� */
	@Id
	@TableGenerator(
		name="COPYREADUSER_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="COPYREADUSER_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="COPYREADUSER_TABLE_GENERATOR")
	protected Integer cruid;

	/** ����id */
	protected Integer prid;

	/** ���̱�� */
	protected String prserialnum;

	/** �������� */
	protected String prtitle;

	/** �������� */
	protected String prpdname ;

	/** �����˽�ɫ */
	protected String prrolename;

	/** ���������� */
	protected String prusername ;

	/** ����״̬ */
	protected String crustatus ;

	/** ����ʱ�� */
	protected String prassigntime;

	/** �鿴ʱ�� */
	protected String prlooktime;

	/** �Ƿ�鿴��ʶ */
	protected String islook;

	/** ������id */
	protected String pruserid ;
	
	/** ���̿�ʼʱ�� */
	protected String prstarttime;

	/** ���̶���id */
	protected String prpdid ;
	
	/** ������״̬ */
	protected String prsubstatus;
	/**
	 * ��������������ȡ��
	 *
	 * @return ��������������
	 */
	public Integer getCruid() {
		return cruid;
	}

	/**
	 * ���������������趨
	 *
	 * @param cruid ��������������
	 */
	public void setCruid(Integer cruid) {
		this.cruid = cruid;
	}

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���̱��ȡ��
	 *
	 * @return ���̱��
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * ���̱���趨
	 *
	 * @param prserialnum ���̱��
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
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
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrpdname () {
		return prpdname ;
	}

	/**
	 * ���������趨
	 *
	 * @param prpdname  ��������
	 */
	public void setPrpdname (String prpdname ) {
		this.prpdname  = prpdname ;
	}

	/**
	 * �����˽�ɫȡ��
	 *
	 * @return �����˽�ɫ
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * �����˽�ɫ�趨
	 *
	 * @param prrolename �����˽�ɫ
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getPrusername () {
		return prusername ;
	}

	/**
	 * �����������趨
	 *
	 * @param prusername  ����������
	 */
	public void setPrusername (String prusername ) {
		this.prusername  = prusername ;
	}

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getCrustatus () {
		return crustatus ;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param crustatus  ����״̬
	 */
	public void setCrustatus (String crustatus ) {
		this.crustatus  = crustatus ;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getPrassigntime() {
		return prassigntime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param prassigntime ����ʱ��
	 */
	public void setPrassigntime(String prassigntime) {
		this.prassigntime = prassigntime;
	}

	/**
	 * �鿴ʱ��ȡ��
	 *
	 * @return �鿴ʱ��
	 */
	public String getPrlooktime() {
		return prlooktime;
	}

	/**
	 * �鿴ʱ���趨
	 *
	 * @param prlooktime �鿴ʱ��
	 */
	public void setPrlooktime(String prlooktime) {
		this.prlooktime = prlooktime;
	}

	/**
	 * �Ƿ�鿴��ʶȡ��
	 *
	 * @return �Ƿ�鿴��ʶ
	 */
	public String getIslook() {
		return islook;
	}

	/**
	 * �Ƿ�鿴��ʶ�趨
	 *
	 * @param islook �Ƿ�鿴��ʶ
	 */
	public void setIslook(String islook) {
		this.islook = islook;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPruserid () {
		return pruserid ;
	}

	/**
	 * ������id�趨
	 *
	 * @param pruserid  ������id
	 */
	public void setPruserid (String pruserid ) {
		this.pruserid  = pruserid ;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return cruid;
	}
	/**
	 * ���̿�ʼʱ��ȡ��
	 *
	 * @return ���̿�ʼʱ��
	 */
	public String getPrstarttime() {
		return prstarttime;
	}

	/**
	 * ���̿�ʼʱ���趨
	 *
	 * @param prstarttime  ���̿�ʼʱ��
	 */
	public void setPrstarttime(String prstarttime) {
		this.prstarttime = prstarttime;
	}
	/**
	 * ���̶���idȡ��
	 *
	 * @return ���̶���id
	 */
	public String getPrpdid() {
		return prpdid;
	}
	/**
	 * ���̶���id�趨
	 *
	 * @param prpdid  ���̶���id
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ������״̬ȡ��
	 *
	 * @return ������״̬
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * ������״̬�趨
	 *
	 * @param prsubstatus  ������״̬
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	
	
}