/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:������ 
 * ����������������
 * �����ˣ�����͢
 * ������¼�� 2013-02-25
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGPRR0114Form extends BaseForm {

	
	protected Integer cruid;
	/** ����id */
	protected String prid;

	/** ���̱�� */
	protected String prserialnum;

	/** �������� */
	protected String prtitle;

	/** �������� */
	protected String prpdname ;

	/** ��ʼʱ�� */
	protected String propentime ;

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
    
	/**��ӳ����˼���*/
	protected String[] userid;

	/**������ѯ����*/
	protected String username_q;
	
	/**�������ѯ����*/
	protected String orgid_q;
	
	/**�������ѯ����*/
	protected String orgname_q;
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
	public String getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(String prid) {
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
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getPropentime () {
		return propentime ;
	}

	/**
	 * ��ʼʱ���趨
	 *
	 * @param propentime  ��ʼʱ��
	 */
	public void setPropentime (String propentime ) {
		this.propentime  = propentime ;
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
	 * ��ӳ����˼���ȡ��
	 *
	 * @return ��ӳ����˼���
	 */
	public String[] getUserid() {
		return userid;
	}
	/**
	 * ��ӳ����˼����趨
	 *
	 * @param userid  ��ӳ����˼���
	 */
	public void setUserid(String[] userid) {
		this.userid = userid;
	}

	public String getUsername_q() {
		return username_q;
	}

	public void setUsername_q(String username_q) {
		this.username_q = username_q;
	}

	public String getOrgid_q() {
		return orgid_q;
	}

	public void setOrgid_q(String orgid_q) {
		this.orgid_q = orgid_q;
	}

	public String getOrgname_q() {
		return orgname_q;
	}

	public void setOrgname_q(String orgname_q) {
		this.orgname_q = orgname_q;
	}

	
}
