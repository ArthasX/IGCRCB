/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.form;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * ר��Ԥ��Form
 * 
 */
@SuppressWarnings("serial")
public class IGDRM0501Form extends BaseForm  {

	private String eid ; // �ʲ�ģ��ID
	private String eilabel ; // �ʲ����
	private String eidesc ; // �ʲ�˵��
	private String einame ; // �ʲ�����
	private String eiinsdate ;// �ʲ��Ǽ���
	private String eiorgsyscoding ; // �ʲ��������������
	private String eiorgname; // �ʲ�������������
	private String esyscoding ; // �ʲ�ģ�Ͳ����
	private String eiupdtime ; // �ʲ�����ʱ��
	private String eistatus ; // �ʲ�״̬
	private String estatus ; // ģ��״̬
	private Integer eiversion ; // �ʲ��汾��
	private String fingerprint ; // ʱ���
	private String eiuserid ; // �ʲ�������
	private String eiusername ; // �ʲ�����������
	private Integer eismallversion; // �ʲ�С�汾
	private Integer eirootmark ; // �ʲ����������ڵ�ʵ���ʶ
	private String ename;
	private String[] cids;
	private Integer eiid;
	protected String[] ciattach;
	private String[] civalues;
	private FormFile files;
	/**
	 * eid   ȡ��
	 * @return eid eid
	 */
	public String getEid() {
		return eid;
	}
	/**
	 * eid   �趨
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}
	/**
	 * eidesc   ȡ��
	 * @return eidesc eidesc
	 */
	public String getEidesc() {
		return eidesc;
	}
	/**
	 * eidesc   �趨
	 * @param eidesc eidesc
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}
	/**
	 * einame   ȡ��
	 * @return einame einame
	 */
	public String getEiname() {
		return einame;
	}
	/**
	 * einame   �趨
	 * @param einame einame
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**
	 * eilabel   ȡ��
	 * @return eilabel eilabel
	 */
	public String getEilabel() {
		return eilabel;
	}
	/**
	 * eilabel   �趨
	 * @param eilabel eilabel
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	/**
	 * eiinsdate   ȡ��
	 * @return eiinsdate eiinsdate
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}
	/**
	 * eiinsdate   �趨
	 * @param eiinsdate eiinsdate
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}
	/**
	 * eiorgsyscoding   ȡ��
	 * @return eiorgsyscoding eiorgsyscoding
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**
	 * eiorgsyscoding   �趨
	 * @param eiorgsyscoding eiorgsyscoding
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	/**
	 * eiorgname   ȡ��
	 * @return eiorgname eiorgname
	 */
	public String getEiorgname() {
		return eiorgname;
	}
	/**
	 * eiorgname   �趨
	 * @param eiorgname eiorgname
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	/**
	 * esyscoding   ȡ��
	 * @return esyscoding esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**
	 * esyscoding   �趨
	 * @param esyscoding esyscoding
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * eiupdtime   ȡ��
	 * @return eiupdtime eiupdtime
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}
	/**
	 * eiupdtime   �趨
	 * @param eiupdtime eiupdtime
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}
	/**
	 * eistatus   ȡ��
	 * @return eistatus eistatus
	 */
	public String getEistatus() {
		return eistatus;
	}
	/**
	 * eistatus   �趨
	 * @param eistatus eistatus
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}
	/**
	 * estatus   ȡ��
	 * @return estatus estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * estatus   �趨
	 * @param estatus estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	/**
	 * eiversion   ȡ��
	 * @return eiversion eiversion
	 */
	public Integer getEiversion() {
		return eiversion;
	}
	/**
	 * eiversion   �趨
	 * @param eiversion eiversion
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	/**
	 * fingerprint   ȡ��
	 * @return fingerprint fingerprint
	 */
	public String getFingerprint() {
		return fingerprint;
	}
	/**
	 * fingerprint   �趨
	 * @param fingerprint fingerprint
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	/**
	 * eiuserid   ȡ��
	 * @return eiuserid eiuserid
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	/**
	 * eiuserid   �趨
	 * @param eiuserid eiuserid
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	/**
	 * eiusername   ȡ��
	 * @return eiusername eiusername
	 */
	public String getEiusername() {
		return eiusername;
	}
	/**
	 * eiusername   �趨
	 * @param eiusername eiusername
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}
	/**
	 * eismallversion   ȡ��
	 * @return eismallversion eismallversion
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * eismallversion   �趨
	 * @param eismallversion eismallversion
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	/**
	 * eirootmark   ȡ��
	 * @return eirootmark eirootmark
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	/**
	 * eirootmark   �趨
	 * @param eirootmark eirootmark
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}
	/**
	 * ename   ȡ��
	 * @return ename ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * eiid   ȡ��
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}
	/**
	 * eiid   �趨
	 * @param eiid eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**
	 * ename   �趨
	 * @param ename ename
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * cids   ȡ��
	 * @return cids cids
	 */
	public String[] getCids() {
		return cids;
	}
	/**
	 * cids   �趨
	 * @param cids cids
	 */
	public void setCids(String[] cids) {
		this.cids = cids;
	}
	/**
	 * ciattach   ȡ��
	 * @return ciattach ciattach
	 */
	public String[] getCiattach() {
		return ciattach;
	}
	/**
	 * ciattach   �趨
	 * @param ciattach ciattach
	 */
	public void setCiattach(String[] ciattach) {
		this.ciattach = ciattach;
	}
	/**
	 * cvalues   ȡ��
	 * @return cvalues cvalues
	 */
	public String[] getCivalues() {
		return civalues;
	}
	/**
	 * cvalues   �趨
	 * @param cvalues cvalues
	 */
	public void setCivalues(String[] civalues) {
		this.civalues = civalues;
	}
	/**
	 * files   ȡ��
	 * @return files files
	 */
	public FormFile getFiles() {
		return files;
	}
	/**
	 * files   �趨
	 * @param files files
	 */
	public void setFiles(FormFile files) {
		this.files = files;
	}

	
}
