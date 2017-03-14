/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.form;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * �����鶨���ѯ����Form
 * 
 */
@SuppressWarnings("serial")
public class IGDRM0402Form extends BaseForm  implements SOC0124SearchCond{

	private String eid ; // �ʲ�ģ��ID
	private String eidesc ; // �ʲ�˵��
	private String einame ; // �ʲ�����
	private String eilabel ; // �ʲ����
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
	private String[] deleteEiid;
	/**��ʼʱ��*/
	protected String propentime;
	
	/**����ʱ��*/
	protected String prclosetime;
	
	/**Ӧ����Դid*/
	protected Integer erid;
	
	/**Ӧ����Դ����*/
	protected String ercode;
	
	/**Ӧ����Դ����*/
	protected String ername;
	
	/** �����豸���� */
	protected String[] relationEiid;
	
	/** �ʲ����¿�ʼʱ�� */
	protected String eiupdtime_from;
	
	/** �ʲ����½�ֹʱ�� */
	protected String eiupdtime_to;
	
	/** ����ҳ��ʶ */
	protected String openFlag;
	
	/**��Ҫ���˵���eiid(Ӧ����Դר��)*/
	protected String eiidNotIn;
	
	/** ��Ӧ�ʲ�ģ����  */
	protected String esyscode;
	
	/** ��ѡ��ʶ  */
	protected String sign;
	
	/** ��ձ�ʶ  */
	protected String hasAClear;
	
	/**
	 * @return the hasAClear
	 */
	public String getHasAClear() {
		return hasAClear;
	}
	/**
	 * @param hasAClear the hasAClear to set
	 */
	public void setHasAClear(String hasAClear) {
		this.hasAClear = hasAClear;
	}
	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * @return the esyscode
	 */
	public String getEsyscode() {
		return esyscode;
	}
	/**
	 * @param esyscode the esyscode to set
	 */
	public void setEsyscode(String esyscode) {
		this.esyscode = esyscode;
	}
	/**
	 * @return the eiidNotIn
	 */
	public String getEiidNotIn() {
		return eiidNotIn;
	}
	/**
	 * @param eiidNotIn the eiidNotIn to set
	 */
	public void setEiidNotIn(String eiidNotIn) {
		this.eiidNotIn = eiidNotIn;
	}
	/**
	 * @return the openFlag
	 */
	public String getOpenFlag() {
		return openFlag;
	}
	/**
	 * @param openFlag the openFlag to set
	 */
	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}
	/**
	 * @return the ername
	 */
	public String getErname() {
		return ername;
	}
	/**
	 * @param ername the ername to set
	 */
	public void setErname(String ername) {
		this.ername = ername;
	}
	/**
	 * @return the eiupdtime_from
	 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}
	/**
	 * @param eiupdtime_from the eiupdtime_from to set
	 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}
	/**
	 * @return the eiupdtime_to
	 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}
	/**
	 * @param eiupdtime_to the eiupdtime_to to set
	 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}
	/**
	 * @return the erid
	 */
	public Integer getErid() {
		return erid;
	}
	/**
	 * @return the ercode
	 */
	public String getErcode() {
		return ercode;
	}
	/**
	 * @param ercode the ercode to set
	 */
	public void setErcode(String ercode) {
		this.ercode = ercode;
	}
	/**
	 * @param erid the erid to set
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}
	/**
	 * @return the relationEiid
	 */
	public String[] getRelationEiid() {
		return relationEiid;
	}
	/**
	 * @param relationEiid the relationEiid to set
	 */
	public void setRelationEiid(String[] relationEiid) {
		this.relationEiid = relationEiid;
	}
	
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
	/**
	 * deleteEiid   ȡ��
	 * @return deleteEiid deleteEiid
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}
	/**
	 * deleteEiid   �趨
	 * @param deleteEiid deleteEiid
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}
	/**  
	 * ��ȡ��ʼʱ��  
	 * @return propentime ��ʼʱ��  
	 */
	
	public String getPropentime() {
		return propentime;
	}
	/**  
	 * ���ÿ�ʼʱ��  
	 * @param propentime ��ʼʱ��  
	 */
	
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	/**  
	 * ��ȡ����ʱ��  
	 * @return prclosetime ����ʱ��  
	 */
	
	public String getPrclosetime() {
		return prclosetime;
	}
	/**  
	 * ���ý���ʱ��  
	 * @param prclosetime ����ʱ��  
	 */
	
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
	public String getElabel() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEcategory() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEkey1() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiupdtime_from2() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiupdtime_to2() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getCname() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getCclabel() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getCcivalue() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getEiidList() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUsesyscoding() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getWbdate_from() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getWbdate_to() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getEirootmark_eq() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isTopCiFlag() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAssetNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getIpAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAote() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDeviceType() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getLifeCycle() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getEiidNotInList() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPayee() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAmount() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isUpgrade() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getEiinsdate_gt() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiinsdate_lt() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
