/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
/**
 * ����:��������Ϣ��ͼʵ��
 * ��������: ��������Ϣ��ͼʵ��
 * �����ˣ�����
 * ������¼: 2013/05/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class EntityItemFacilitatorVW implements Serializable, Cloneable,
		EntityItemFacilitatorVWInfo {

	/**������id  */
	@Id
	protected Integer eiid;
	/**��˾����  */
	protected String einame;
	/**��ַ  */
	protected String address;
	/**��ϵ��  */
	protected String linkman;
	/**�绰  */
	protected String tel;
	/**������  */
	protected String accountbk;
	/**�����ʺ�  */
	protected String accountno;
	/**��������  */
	protected String accountname;
	/**������  */
	protected String eiorgsyscoding;
	/**ģ����  */
	protected String esyscoding;
	/**�Ǽ���  */
	protected String eiinsdate;
	
	
	/**������id ȡ�� */
	public Integer getEiid() {
		return eiid;
	}
	/**��˾����  ȡ�� */
	public String getEiname() {
		return einame;
	}
	/**��ַ  ȡ�� */
	public String getAddress() {
		return address;
	}
	/**��ϵ��  ȡ�� */
	public String getLinkman() {
		return linkman;
	}
	/**�绰 ȡ��  */
	public String getTel() {
		return tel;
	}
	/**������  ȡ�� */
	public String getAccountbk() {
		return accountbk;
	}
	/**�����ʺ�  ȡ�� */
	public String getAccountno() {
		return accountno;
	}
	/**��������  ȡ�� */
	public String getAccountname() {
		return accountname;
	}
	/**������  ȡ�� */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**ģ����  ȡ�� */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**�Ǽ���  ȡ�� */
	public String getEiinsdate() {
		return eiinsdate;
	}
	
	
	/**������id �趨 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**��˾����  �趨 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**��ַ  �趨 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**��ϵ��  �趨 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	/**�绰  �趨 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**������  �趨 */
	public void setAccountbk(String accountbk) {
		this.accountbk = accountbk;
	}
	/**�����ʺ�  �趨 */
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	/**��������  �趨 */
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	/**������  �趨 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	/**ģ����  �趨 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**�Ǽ���  �趨 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}
	
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return eiid;
	}
}
