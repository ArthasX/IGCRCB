package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ����ѯHELP������FORM
 * IGCOM0302Form ActionForm
 */
public class IGCIM1633Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	protected Integer eiid;
	/** ��ϵID */
	protected Integer eirid;
	
	/** ��ϵID�����֣� */
	protected String eiridStr;

	/** �豸ID������ */
	protected Integer pareiid;
	
	/** �豸label������ */
	protected String pareilabel;

	/** �豸�ʲ�ID������ */
	protected String pareid;

	/** �ʲ���ID���ӣ� */
	protected Integer cldeiid;

	/** �ʲ�ID���ӣ� */
	protected String cldeid;

	/** ��ϵ����ʱ�� */
	protected String eirupdtime;
	
	/** ��ϵ״̬ */
	protected String eirstatus;
	
	/** ��ϵ˵�� */
	protected String eirdesc;
	
	/** ��ϵ */
	protected String eirrelation;

	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";

	/** �ʲ���ģ�ͱ��루�ӣ� */
	protected String elabel;

	/** �ʲ�����루�ӣ� */
	protected String eilabel;

	/** �ʲ������ƣ��ӣ� */
	protected String einame;

	/** �豸����(��) */
	protected String pareiname;
	
	/** �ʲ����ϵ���� */
	protected String eirrelationcode;
	
	/** �ʲ����ϵ */
	protected String tempeirrelation;
	
	protected String fingerPrint;
	
	/** �ʲ����������ڵ�ʵ���ʶ */
	protected Integer eirootmark;

	/**
	 * ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 * @return ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 */
	protected String eirinfo;
	
	/** �ʲ���ϵ���루ƽ̨������ */
	protected String eirsyscodeing;
	
	/** �����ʲ���汾 */
	protected Integer parversion;

	/** �����ʲ�С�汾 */
	protected Integer parsmallversion;

	/** �����ʲ���汾 */
	protected Integer cldversion;

	/** �����ʲ�С�汾 */
	protected Integer cldsmallversion;

	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/** ��ϵ����(��ͨ��ϵ��������ϵ) */
	protected String relationType;
	
	/** ��������(�����߼�) */
	protected String belongType;
	
	/** ����� */
	protected String esyscoding;
	
	protected String pidid;
	
	

	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	public Integer getEirid() {
		return eirid;
	}

	public void setEirid(Integer eirid) {
		this.eirid = eirid;
	}

	public String getEiridStr() {
		return eiridStr;
	}

	public void setEiridStr(String eiridStr) {
		this.eiridStr = eiridStr;
	}

	public Integer getPareiid() {
		return pareiid;
	}

	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	public String getPareilabel() {
		return pareilabel;
	}

	public void setPareilabel(String pareilabel) {
		this.pareilabel = pareilabel;
	}

	public String getPareid() {
		return pareid;
	}

	public void setPareid(String pareid) {
		this.pareid = pareid;
	}

	public Integer getCldeiid() {
		return cldeiid;
	}

	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}

	public String getCldeid() {
		return cldeid;
	}

	public void setCldeid(String cldeid) {
		this.cldeid = cldeid;
	}

	public String getEirupdtime() {
		return eirupdtime;
	}

	public void setEirupdtime(String eirupdtime) {
		this.eirupdtime = eirupdtime;
	}

	public String getEirstatus() {
		return eirstatus;
	}

	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}

	public String getEirdesc() {
		return eirdesc;
	}

	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
	}

	public String getEirrelation() {
		return eirrelation;
	}

	public void setEirrelation(String eirrelation) {
		this.eirrelation = eirrelation;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getElabel() {
		return elabel;
	}

	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	public String getEilabel() {
		return eilabel;
	}

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getPareiname() {
		return pareiname;
	}

	public void setPareiname(String pareiname) {
		this.pareiname = pareiname;
	}

	public String getEirrelationcode() {
		return eirrelationcode;
	}

	public void setEirrelationcode(String eirrelationcode) {
		this.eirrelationcode = eirrelationcode;
	}

	public String getTempeirrelation() {
		return tempeirrelation;
	}

	public void setTempeirrelation(String tempeirrelation) {
		this.tempeirrelation = tempeirrelation;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Integer getEirootmark() {
		return eirootmark;
	}

	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	public String getEirinfo() {
		return eirinfo;
	}

	public void setEirinfo(String eirinfo) {
		this.eirinfo = eirinfo;
	}

	public String getEirsyscodeing() {
		return eirsyscodeing;
	}

	public void setEirsyscodeing(String eirsyscodeing) {
		this.eirsyscodeing = eirsyscodeing;
	}

	public Integer getParversion() {
		return parversion;
	}

	public void setParversion(Integer parversion) {
		this.parversion = parversion;
	}

	public Integer getParsmallversion() {
		return parsmallversion;
	}

	public void setParsmallversion(Integer parsmallversion) {
		this.parsmallversion = parsmallversion;
	}

	public Integer getCldversion() {
		return cldversion;
	}

	public void setCldversion(Integer cldversion) {
		this.cldversion = cldversion;
	}

	public Integer getCldsmallversion() {
		return cldsmallversion;
	}

	public void setCldsmallversion(Integer cldsmallversion) {
		this.cldsmallversion = cldsmallversion;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	
	
	
	
	
	
}
