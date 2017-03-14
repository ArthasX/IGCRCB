/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;


import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.entity.EiImportProgrammeTB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseForm;

/**
 * ����: �������Form 
 * ��������: �������Form
 * ������¼: 2011/05/03 
 * �޸ļ�¼:
 */
public class IGASM2006Form extends BaseForm implements ImportVersionInfo {
	private static final long serialVersionUID = 1L;

	/** �������ʵ���� */
	protected String impeiname;

	/** ����CI���� */
	protected Integer impcitype;
	
	/** ����ʵ��ID */
	protected Integer impeiid;

	/** ����汾 */
	protected Integer impversion;

	/** �����ļ��� */
	protected String impfilename;

	/** ����ʱ�� */
	protected String impcreatetime;

	/** �ʲ�ģ�Ͳ���� */
	protected String esyscoding;

	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** ����CI���� */
	protected EiImportProgrammeTB eiImportProgrammeTB;
	
	/**
	 * ʱ���
	 */
	protected String fingerPrint;
	
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/** ip */
	protected String impip;
	
	/** �û��� */
	protected String impuserid;
	
	/** ���� */
	protected String imppassword;
	
	/** ״̬ */
	protected String impstatus;

	/**
	 * �༭ģʽ���Ǽ�/�����
	 * @return �༭ģʽ���Ǽ�/�����
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * �༭ģʽ���Ǽ�/�����
	 * @param mode�༭ģʽ���Ǽ�/�����
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * �������ʵ����
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * �������ʵ����
	 * @param impeiname�������ʵ����
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

	/**
	 * ����CI����
	 * @return ����CI����
	 */
	public Integer getImpcitype() {
		return impcitype;
	}

	/**
	 * ����CI����
	 * @param impcitype����CI����
	 */
	public void setImpcitype(Integer impcitype) {
		this.impcitype = impcitype;
	}

	/**
	 * ����ʵ��ID
	 */
	public Integer getImpeiid() {
		return impeiid;
	}

	/**
	 * ����ʵ��ID
	 * @param impeiid����ʵ��ID
	 */
	public void setImpeiid(Integer impeiid) {
		this.impeiid = impeiid;
	}

	/**
	 * ����汾
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * ����汾
	 * @param impversion����汾
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	/**
	 * �����ļ���
	 */
	public String getImpfilename() {
		return impfilename;
	}

	/**
	 * �����ļ���
	 * @param impfilename�����ļ���
	 */
	public void setImpfilename(String impfilename) {
		this.impfilename = impfilename;
	}

	/**
	 * ����ʱ��
	 */
	public String getImpcreatetime() {
		return impcreatetime;
	}

	/**
	 * ����ʱ��
	 * @param impcreatetime����ʱ��
	 */
	public void setImpcreatetime(String impcreatetime) {
		this.impcreatetime = impcreatetime;
	}

	/**
	 * �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ�Ͳ����
	 * @param esyscoding�ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ʱ���ȡ��
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ʱ����趨
	 * @param fingerPrintʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * �߼�ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �߼�ɾ����ʶ
	 * @param deleteflag�߼�ɾ����ʶ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}



	/**
	 * ����CI����ȡ��
	 * @return ����CI����
	 */
	public EiImportProgrammeTB getEiImportProgrammeTB() {
		return eiImportProgrammeTB;
	}

	/**
	 * ����CI�����趨
	 * @param eiImportProgrammeTB����CI����
	 */
	public void setEiImportProgrammeTB(EiImportProgrammeTB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
	}

	/**
	 * IPȡ��
	 * 
	 * @return IP
	 */
	public String getImpip() {
		return impip;
	}

	/**
	 * IP�趨
	 * 
	 * @param impip IP
	 */
	public void setImpip(String impip) {
		this.impip = impip;
	}

	/**
	 * �û���ȡ��
	 * 
	 * @return �û���
	 */
	public String getImpuserid() {
		return impuserid;
	}

	/**
	 * �û����趨
	 * 
	 * @param impuserid �û���
	 */
	public void setImpuserid(String impuserid) {
		this.impuserid = impuserid;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getImppassword() {
		return imppassword;
	}

	/**
	 * �����趨
	 * 
	 * @param imppassword ����
	 */
	public void setImppassword(String imppassword) {
		this.imppassword = imppassword;
	}

	/**
	 * ״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getImpstatus() {
		return impstatus;
	}

	/**
	 * ״̬�趨
	 * 
	 * @param impstatus ״̬
	 */
	public void setImpstatus(String impstatus) {
		this.impstatus = impstatus;
	}

	public IG013TB getEntityItemTB() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getEircount() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getBelongcount() {
		// TODO Auto-generated method stub
		return null;
	}

}
