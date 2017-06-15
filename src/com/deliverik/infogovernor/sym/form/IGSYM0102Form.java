/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.Organization;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_�����޸�FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0102Form extends BaseForm implements Organization{
	
	/**
	 * ��������
	 */
	
	protected Integer orgid;
	
	/**
	 * ��������
	 */
	
	protected String orgidstr;
	
	/**
	 * ��������
	 */
	
	protected String orgname;
	
	/**
	 * ��������
	 */
	
	protected String orgnamebak;
	
	/**
	 * �ϼ�������ID
	 */
	
	protected String orgpar;
	
	/**
	 * �ϼ�����������
	 */
	
	protected String orgparname;
	
	/**
	 * ����˵��
	 */
	
	protected String orgdesc;

	/**
	 * �������ͣ������ֶΣ�
	 */
	
	protected String orgtype;

	/**
	 * ������ַ
	 */
	
	protected String orgaddr;

	/**
	 * �����绰
	 */
	
	protected String orgphone;

	/**
	 * ��������
	 */
	
	protected String orgfax;

	/**
	 * ������ϵ��
	 */
	
	protected String orgcontact;

	/**
	 * ����״̬���Ƿ�ͣ�� 0ͣ�� 1���ã�
	 */
	
	protected String orgstatus;

	/**
	 * ������Ϣ�������ֶΣ�
	 */
	
	protected String orginfo;
	
	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	
	protected String mode = "0";
	
	/**
	 * ϵͳ����
	 */
	protected String orgsyscoding;
	
	/**
	 * �û�����
	 */
	protected String orgusercoding;
	
	

	
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	public String getOrgusercoding() {
		return orgusercoding;
	}

	public void setOrgusercoding(String orgusercoding) {
		this.orgusercoding = orgusercoding;
	}

	/**
	 * ��ȡ��������
	 * @return String
	 */
	
	public Integer getOrgid() {
		if( (this.orgidstr == null) || ("".equals(this.orgidstr))){
			return null;
		} else {
			return Integer.valueOf(this.orgidstr);
		}
	}
	
	/**
	 * ���û�������
	 * @param orgid String
	 */
	
	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}
	
	/**
	 * ��ȡ��������
	 * @return String
	 */
	
	public String getOrgidstr() {
		return orgidstr;
	}

	/**
	 * ���û�������
	 * @param orgid String
	 */
	
	public void setOrgidstr(String orgidstr) {
		this.orgidstr = orgidstr;
	}

	/**
	 * ��ȡ��������
	 * @return String
	 */
	
	public String getOrgname() {
		return orgname;
	}
	
	/**
	 * ���û�������
	 * @param orgname String
	 */
	
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	

	
	public String getOrgpar() {
		return orgpar;
	}

	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}

	/**
	 * ��ȡ�ϼ�����������
	 * @return String
	 */
	
	
	public String getOrgparname() {
		return orgparname;
	}
	
	/**
	 * �����ϼ�����������
	 * @param orgparname String
	 */
	
	public void setOrgparname(String orgparname) {
		this.orgparname = orgparname;
	}

	/**
	 * ��ȡ����˵��
	 * @return String
	 */
	
	public String getOrgdesc() {
		return orgdesc;
	}

	/**
	 * ���û���˵��
	 * @param orgdesc String
	 */
	
	public void setOrgdesc(String orgdesc) {
		this.orgdesc = orgdesc;
	}

	/**
	 * ��ȡ�������ͣ������ֶΣ�
	 * @return String
	 */
	
	public String getOrgtype() {
		return orgtype;
	}

	/**
	 * ���û������ͣ������ֶΣ�
	 * @param orgtype String
	 */
	
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	/**
	 * ��ȡ������ַ
	 * @return String
	 */
	
	public String getOrgaddr() {
		return orgaddr;
	}

	/**
	 * ���û�����ַ
	 * @param orgaddr String
	 */
	
	public void setOrgaddr(String orgaddr) {
		this.orgaddr = orgaddr;
	}

	/**
	 * ��ȡ�����绰
	 * @return String
	 */
		
	public String getOrgphone() {
		return orgphone;
	}

	/**
	 * ���û����绰
	 * @param orgphone String
	 */
	
	public void setOrgphone(String orgphone) {
		this.orgphone = orgphone;
	}

	/**
	 * ��ȡ��������
	 * @return String
	 */
	
	public String getOrgfax() {
		return orgfax;
	}

	/**
	 * ���û�������
	 * @param orgfax String
	 */
	
	public void setOrgfax(String orgfax) {
		this.orgfax = orgfax;
	}

	/**
	 * ��ȡ������ϵ��
	 * @return String
	 */
	
	public String getOrgcontact() {
		return orgcontact;
	}

	/**
	 * ���û�����ϵ��
	 * @param orgcontact String
	 */
	
	public void setOrgcontact(String orgcontact) {
		this.orgcontact = orgcontact;
	}

	/**
	 * ��ȡ����״̬�������ֶΣ�
	 * @return String
	 */
	
	public String getOrgstatus() {
		return orgstatus;
	}

	/**
	 * ���û���״̬�������ֶΣ�
	 * @param orgstatus String
	 */
	
	public void setOrgstatus(String orgstatus) {
		this.orgstatus = orgstatus;
	}

	/**
	 * ��ȡ������Ϣ�������ֶΣ�
	 * @return String
	 */
	
	public String getOrginfo() {
		return orginfo;
	}

	/**
	 * ���û�����Ϣ�������ֶΣ�
	 * @param orginfo String
	 */
	
	public void setOrginfo(String orginfo) {
		this.orginfo = orginfo;
	}

	/**
	 * ��ȡҳ�������ʾ��־
	 * @return String
	 */
	
	public String getMode() {
		return mode;
	}

	/**
	 * ����ҳ�������ʾ��־
	 * @param mode String
	 */
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * ����Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
	}

	/**
	 * ��ȡ��������
	 * @return String
	 */
	
	public String getOrgnamebak() {
		return orgnamebak;
	}

	/**
	 * ���û�������
	 * @param orgnamebak String
	 */
	
	public void setOrgnamebak(String orgnamebak) {
		this.orgnamebak = orgnamebak;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
}
