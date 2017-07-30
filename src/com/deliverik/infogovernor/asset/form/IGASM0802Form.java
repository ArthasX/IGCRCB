package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * Ӧ�ñ༭����FORM
 * 
 */
public class IGASM0802Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;

	/** Ӧ��ID */
	protected Integer eiid;
	
	/** Ӧ��ID�����֣� */
	protected String eiidStr;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �ʲ�ģ�ͱ��� */
	protected String elabel;

	/** �ʲ�ģ������ */
	protected String ename;

	/** Ӧ������ */
	protected String einame;
	
	/** Ӧ�ñ��� */
	protected String eilabel;

	/** Ӧ��˵�� */
	protected String eidesc;

	/** Ӧ��״̬ */
	protected String eistatus;

	/** Ӧ�ñ��ʱ�� */
	protected String eiupdtime;
	
	/** Ӧ�ð汾�� */
	protected Integer eiversion;

	/** Ӧ�õǼ��� */
	protected String eiinsdate;
	
	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** �ʲ�����������*/
	protected String eiorgsyscoding;
	
	/** �ʲ���������������*/
	protected String eiorgname;
	
	/** �ʲ�������*/
	protected String eiuserid;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/** �ʲ�������ģ��*/
	public String esyscoding;
	
	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * Ӧ��IDȡ��
	 * @return Ӧ��ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * Ӧ��ID�趨
	 *
	 * @param eiid Ӧ��ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * Ӧ��ID�����֣�ȡ��
	 * @return Ӧ��ID�����֣�
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * Ӧ��ID�����֣��趨
	 *
	 * @param eiidStr Ӧ��ID�����֣�
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�ģ��ID�����֣�ȡ��
	 * @return �ʲ�ģ��ID�����֣�
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * �ʲ�ģ��ID�����֣��趨
	 *
	 * @param eidStr �ʲ�ģ��ID�����֣�
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	/**
	 * �ʲ�ģ�ͱ���ȡ��
	 * @return �ʲ�ģ�ͱ���
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ����趨
	 *
	 * @param elabel �ʲ�ģ�ͱ���
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename �ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * Ӧ������ȡ��
	 * @return Ӧ������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * Ӧ�������趨
	 *
	 * @param einame Ӧ������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * Ӧ�ñ���ȡ��
	 * @return Ӧ�ñ���
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * Ӧ�ñ����趨
	 *
	 * @param eilabel Ӧ�ñ���
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * Ӧ��˵��ȡ��
	 * @return Ӧ��˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * Ӧ��˵���趨
	 *
	 * @param eidesc Ӧ��˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * Ӧ�ø���ʱ��ȡ��
	 * @return Ӧ�ø���ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * Ӧ�ø���ʱ���趨
	 *
	 * @param eiupdtime Ӧ�ø���ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * Ӧ��״̬ȡ��
	 * @return Ӧ��״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * Ӧ��״̬�趨
	 *
	 * @param eistatus Ӧ��״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * Ӧ�ð汾��ȡ��
	 * @return Ӧ�ð汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * Ӧ�ð汾���趨
	 *
	 * @param eiversion Ӧ�ð汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * Ӧ�õǼ���ȡ��
	 * @return Ӧ�õǼ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * Ӧ�õǼ����趨
	 *
	 * @param eiinsdate Ӧ�õǼ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * �༭ģʽ�趨
	 *
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * �ʲ��������趨
	 *
	 * @param eiuserid �ʲ�������
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiusername() {
		return eiusername;
	}
	
	/**
	 * �ʲ������������趨
	 *
	 * @param eiusername �ʲ�����������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	public Integer getEirootmark() {
		return null;
	}

	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}

}