package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;


/**
 * �����ƶȹ��� IGCOM0101Form ActionForm
 */
public class IGDRM0105Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String  einame ; // �ʲ�����
	private String  ename ; // �ʲ����
	private String  eilabel ; // �ʲ����
	private String  eiinsdate_ge ;// �ʲ��Ǽ��մ��ڵ���
	private String  eiinsdate_le ;// �ʲ��Ǽ��� С�ڵ���
	private String  eiorgsyscoding ; // �ʲ��������������
	private String orgname;
	private String  esyscoding ; // �ʲ�ģ�Ͳ����
	private String  eiuserid ; // �ʲ�������
	private String  eiusername ; // �ʲ�����������
	private String eparcoding; // ���������


	public String getEparcoding() {
		return eparcoding;
	}

	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}
	/** �豸ID */
	protected String eiid;
	/** Ԥ���޸��������� */
	protected String cycleTime;
	
	/**ģ��ƥ��Ԥ�����ı���������*/
	private String planContent;
	/** �洢����like*/
	protected String esyscoding_like;
	
	public String getEsyscoding_like() {
		return esyscoding_like;
	}
	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
	}
	public String getEiname() {
		return einame;
	}
	public void setEiname(String einame) {
		this.einame = einame;
	}
	public String getEilabel() {
		return eilabel;
	}
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	public String getEiinsdate_ge() {
		return eiinsdate_ge;
	}
	public void setEiinsdate_ge(String eiinsdate_ge) {
		this.eiinsdate_ge = eiinsdate_ge;
	}
	public String getEiinsdate_le() {
		return eiinsdate_le;
	}
	public void setEiinsdate_le(String eiinsdate_le) {
		this.eiinsdate_le = eiinsdate_le;
	}
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getEiuserid() {
		return eiuserid;
	}
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	public String getEiusername() {
		return eiusername;
	}
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	public String getEiid() {
		return eiid;
	}
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	public String getCycleTime() {
		return cycleTime;
	}
	public void setCycleTime(String cycleTime) {
		this.cycleTime = cycleTime;
	}
	
}
